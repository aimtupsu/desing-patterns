package com.aimtupsu.bankclient;

import com.aimtupsu.bankclient.model.BankInfo;
import com.aimtupsu.bankclient.model.Response;
import com.aimtupsu.model.Receipt;

public interface BankClient {

    /**
     * Оплачивает чек в банке.
     *
     * @param receipt чек покупки.
     * @return ответ банка об оплате.
     */
    Response pay(Receipt receipt);

    /**
     * Возвращает оплату чека в банке.
     *
     * @param receipt чек покупки.
     * @return ответ банка о возврате оплаты.
     */
    Response refund(Receipt receipt);

    /**
     * Получает информацию о банке.
     *
     * @return информация о банке.
     */
    BankInfo getBankInfo();

}
