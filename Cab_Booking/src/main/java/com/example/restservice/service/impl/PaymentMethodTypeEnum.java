package com.example.restservice.service.impl;

import com.example.restservice.service.PaymentMethodType;
import java.util.UUID;

public enum PaymentMethodTypeEnum implements PaymentMethodType {

    CREDIT_CARD{
        @Override
        public String makePayment(float amount) {
            System.out.println("CC Payment Done for amount " + amount);
            return UUID.randomUUID().toString();
        }
    }, DEBIT_CARD{
        @Override
        public String makePayment(float amount) {
            System.out.println("DC Payment Done for amount " + amount);
            return UUID.randomUUID().toString();
        }
    }, INTERNET_BANK{
        @Override
        public String makePayment(float amount) {
            System.out.println("Internet Banking Payment Done for amount " + amount);
            return UUID.randomUUID().toString();
        }
    };

    @Override
    public String makePayment(float amount) {
        return null;
    }
}
