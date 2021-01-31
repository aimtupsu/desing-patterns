package com.aimtupsu.payment;

import com.aimtupsu.model.Sale;

public interface PaymentService {

    void paySale(Sale sale);

    void refundSale(Sale sale);

}
