package com.example.restservice.service.impl;

import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class Payment {

    /**
     *
     * @param selectedOption
     * @return
     */
    public PaymentMethodTypeEnum selectPaymentMethod(String selectedOption){
        if (selectedOption.equalsIgnoreCase("CC"))
            return PaymentMethodTypeEnum.CREDIT_CARD;
        else if (selectedOption.equalsIgnoreCase("IB"))
            return PaymentMethodTypeEnum.INTERNET_BANK;
        else return PaymentMethodTypeEnum.DEBIT_CARD;
    }

    /**
     *
     * @param paymentMethod
     * @param amount
     * @return
     */
    public String makePayment(PaymentMethodTypeEnum paymentMethod, float amount){
        return paymentMethod.makePayment(amount);
    }
}
