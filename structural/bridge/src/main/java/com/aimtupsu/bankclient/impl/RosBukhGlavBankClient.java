package com.aimtupsu.bankclient.impl;

import com.aimtupsu.bankclient.BankClient;
import com.aimtupsu.bankclient.mapper.RequestMapper;
import com.aimtupsu.bankclient.model.BankInfo;
import com.aimtupsu.bankclient.model.Request;
import com.aimtupsu.bankclient.model.Response;
import com.aimtupsu.model.Receipt;
import java.util.Random;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

/**
 * Надеюсь такого банка никогда не будет...
 */
@Log4j2
@Data
public class RosBukhGlavBankClient implements BankClient {

    private final static Random RANDOMIZER = new Random();

    @Override
    public Response pay(final Receipt receipt) {
        final Request request = RequestMapper.convertToPay(receipt);
        log.info("Запрос на оплату: {} отправлен в РосБухГлавБанк.", request.toString());
        final int i = RANDOMIZER.nextInt();
        if (i % 7 == 0) {
            return new Response(Response.ResponseStatus.ERROR);
        }
        return new Response(Response.ResponseStatus.SUCCESSFUL);
    }

    @Override
    public Response refund(final Receipt receipt) {
        final Request request = RequestMapper.convertToRefund(receipt);
        log.info("Запрос на возврат оплаты: {} отправлен в РосБухГлавБанк.", request.toString());
        final int i = RANDOMIZER.nextInt();
        if (i % 7 == 0) {
            return new Response(Response.ResponseStatus.ERROR);
        }
        return new Response(Response.ResponseStatus.SUCCESSFUL);
    }

    @Override
    public BankInfo getBankInfo() {
        log.info("Выполняется запрос информации о банке - РосБухГлавБанк.");
        return BankInfo.builder()
                .name("Российский бухгалтерский главный банк")
                .address("Россия! Россия! Россия!")
                .inn("41324324234324")
                .kpp("312412412")
                .bik("867875672")
                .build();
    }

}
