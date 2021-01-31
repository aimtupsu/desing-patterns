package com.aimtupsu.payment;

import com.aimtupsu.bankclient.BankClient;
import com.aimtupsu.bankclient.mapper.RequestMapper;
import com.aimtupsu.bankclient.model.Request;
import com.aimtupsu.bankclient.model.Response;
import com.aimtupsu.model.Sale;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Data
public class PaymentServiceImpl implements PaymentService {

    private final BankClient bankClient;

    @Override
    public void paySale(Sale sale) {
        log.info("Выполняем оплату покупки.");
        final Request request = RequestMapper.convertToPay(sale);
        final Response response = bankClient.sendRequest(request);
        if (response.getStatus() == Response.ResponseStatus.SUCCESSFUL) {
            log.info("Оплата выполнена успешно.");
        } else {
            log.error("Ошибка оплаты.");
        }
    }

    @Override
    public void refundSale(Sale sale) {
        log.info("Выполняем возврат денежных средств покупки.");
        final Request request = RequestMapper.convertToRefund(sale);
        final Response response = bankClient.sendRequest(request);
        if (response.getStatus() == Response.ResponseStatus.SUCCESSFUL) {
            log.info("Возврат денежных средств выполнен успешно.");
        } else {
            log.error("Ошибка возврата.");
        }
    }

}
