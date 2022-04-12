package com.somercelik.codekata.model;

import java.util.List;

/**
 * Bank
 *
 * @author s84240320
 * @since 2022-04-11
 */
public class Bank {
    private String name;
    private List<Card.Type> allowedCardTypes;

    public Bank(String name, List<Card.Type> allowedCardTypes) {
        this.name = name;
        this.allowedCardTypes = allowedCardTypes;
    }

    public List<Card.Type> getAllowedCardTypes() {
        return allowedCardTypes;
    }

    public void setAllowedCardTypes(List<Card.Type> allowedCardTypes) {
        this.allowedCardTypes = allowedCardTypes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
