package com.somercelik.codekata.service;

import com.somercelik.codekata.model.Transaction;

/**
 * TransactionValidationService
 *
 * @author s84240320
 * @since 2022-04-12
 */
public abstract class TransactionValidationService {

    public boolean validateTransaction(Transaction transaction) {
        if (!transaction.getStatus().equals(Transaction.Status.PENDING)) {
            return false;
        }
        return true;
    }

}
