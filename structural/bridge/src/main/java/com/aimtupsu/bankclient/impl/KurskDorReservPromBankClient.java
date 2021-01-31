package com.aimtupsu.bankclient.impl;

import com.aimtupsu.bankclient.BankClient;
import com.aimtupsu.bankclient.model.BankInfo;
import com.aimtupsu.bankclient.model.Request;
import com.aimtupsu.bankclient.model.Response;
import java.util.Random;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

/**
 * Надеюсь такого банка никогда не будет...
 */
@Log4j2
@Data
public class KurskDorReservPromBankClient implements BankClient {

    private final static Random RANDOMIZER = new Random();

    @Override
    public Response sendRequest(Request request) {
        log.info("Запрос: {} отправлен в КурскДорРезервПромБанк.", request.toString());
        final int i = RANDOMIZER.nextInt();
        if (i % 7 == 0) {
            return new Response(Response.ResponseStatus.ERROR);
        }
        return new Response(Response.ResponseStatus.SUCCESSFUL);
    }

    @Override
    public BankInfo getBankInfo() {
        log.info("Выполняется запрос информации о банке - КурскДорРезервПромБанк.");
        return BankInfo.builder()
                .name("Курский дорожный резервный промышленный банк")
                .address("Курск, ул. Ленина, д.8М")
                .inn("1234567895678")
                .kpp("456788909")
                .bik("987654332")
                .build();
    }

}
