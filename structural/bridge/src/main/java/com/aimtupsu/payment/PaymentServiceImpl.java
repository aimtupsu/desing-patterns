package com.aimtupsu.payment;

import com.aimtupsu.bankclient.BankClient;
import com.aimtupsu.bankclient.model.Response;
import com.aimtupsu.model.Receipt;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Data
public class PaymentServiceImpl implements PaymentService {

    private final BankClient bankClient;

    @Override
    public void pay(final Receipt receipt) {
        log.info("Выполняем оплату покупки.");
        final Response response = bankClient.pay(receipt);
        if (response.getStatus() == Response.ResponseStatus.SUCCESSFUL) {
            log.info("Оплата выполнена успешно.");
        } else {
            log.error("Ошибка оплаты.");
        }
    }

    @Override
    public void refund(final Receipt receipt) {
        log.info("Выполняем возврат денежных средств покупки.");
        final Response response = bankClient.refund(receipt);
        if (response.getStatus() == Response.ResponseStatus.SUCCESSFUL) {
            log.info("Возврат денежных средств выполнен успешно.");
        } else {
            log.error("Ошибка возврата.");
        }
    }

}
