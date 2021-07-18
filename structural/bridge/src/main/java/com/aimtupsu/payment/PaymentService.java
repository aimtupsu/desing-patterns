package com.aimtupsu.payment;

import com.aimtupsu.model.Receipt;

/**
 * Сервис оплат/возвратов.
 */
public interface PaymentService {

    /**
     * Оплата чека.
     *
     * @param receipt чек покупки.
     */
    void pay(Receipt receipt);

    /**
     * Возврат оплаты чека.
     *
     * @param receipt чек покупки.
     */
    void refund(Receipt receipt);

}
