package com.somercelik.codekata.service;

import com.iyzipay.Options;
import com.iyzipay.model.InstallmentDetail;
import com.iyzipay.model.InstallmentInfo;
import com.iyzipay.model.Locale;
import com.iyzipay.request.RetrieveInstallmentInfoRequest;
import com.somercelik.codekata.model.Bank;
import com.somercelik.codekata.model.Card;
import com.somercelik.codekata.model.data.BankDataStore;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * IyzicoTransactionValidationService
 *
 * @author s84240320
 * @since 2022-04-12
 */
public class IyzicoTransactionValidationService extends TransactionValidationService {

    public static final String API_KEY = "sandbox-afXhZPW0MQlE4dCUUlHcEopnMBgXnAZI";
    public static final String SECRET_KEY = "sandbox-wbwpzKIiplZxI3hh5ALI4FJyAcZKL6kq";
    public static final String API_BASE_URL = "https://sandbox-api.iyzipay.com";
    private String requestId;

    public Card getCreditCardDetailsFromIyzico(String cardNumber, String cvv) {
        if(cardNumber == null) {
            return null;
        }
        String binNumber = cardNumber.substring(0, 6);
        requestId = UUID.randomUUID().toString();

        RetrieveInstallmentInfoRequest retrieveInstallmentInfoRequest = new RetrieveInstallmentInfoRequest();
        retrieveInstallmentInfoRequest.setBinNumber(binNumber);
        retrieveInstallmentInfoRequest.setLocale(Locale.TR.getValue());
        retrieveInstallmentInfoRequest.setConversationId(requestId);
        retrieveInstallmentInfoRequest.setPrice(BigDecimal.ONE);

        Options options = new Options();
        options.setApiKey(API_KEY);
        options.setSecretKey(SECRET_KEY);
        options.setBaseUrl(API_BASE_URL);

        InstallmentInfo installmentInfo = InstallmentInfo.retrieve(retrieveInstallmentInfoRequest, options);
        if(!requestId.equals(installmentInfo.getConversationId())) {
            throw new RuntimeException("Request ids don't match");
        }
        InstallmentDetail detail = installmentInfo.getInstallmentDetails().get(0);
        Bank bank = BankDataStore.BANKS.stream()
                .filter(bankItem -> bankItem.getName().equals(detail.getBankName()))
                .findFirst()
                .get();
        Card.CardProvider cardProvider = Card.CardProvider.valueOf(detail.getCardAssociation());
        Card.Type cardType = Card.Type.valueOf(detail.getCardType());

        return new Card(cardNumber, cvv, bank, cardProvider, cardType);
    }
}
