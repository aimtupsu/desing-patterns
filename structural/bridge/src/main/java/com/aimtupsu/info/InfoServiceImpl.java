package com.aimtupsu.info;

import com.aimtupsu.bankclient.BankClient;
import com.aimtupsu.bankclient.model.BankInfo;
import com.aimtupsu.model.Info;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Data
@AllArgsConstructor
public class InfoServiceImpl implements InfoService {

    private List<BankClient> bankClientList;

    @Override
    public List<Info> getBankInfos() {
        log.info("Получаем информацию о банках");
        final List<Info> bankInfos = new ArrayList<>();
        for (BankClient bankClient : bankClientList) {
            bankInfos.add(mapBankInfo(bankClient.getBankInfo()));
        }
        return bankInfos;
    }

    @Override
    public Info getShopInfo() {
        log.info("Получаем информацию о магазине.");
        return Info.builder()
                .name("Интернет-Магазин игрушек.")
                .address("Ул. Пушкина, д. Колотушкина")
                .build();
    }

    private Info mapBankInfo(final BankInfo bankInfo) {
        return Info.builder()
                .name(bankInfo.getName())
                .address(bankInfo.getAddress())
                .build();
    }

}
