package com.aimtupsu;

import com.aimtupsu.factory.BeanFactory;
import com.aimtupsu.info.InfoService;
import com.aimtupsu.model.Info;
import com.aimtupsu.model.Position;
import com.aimtupsu.model.Sale;
import com.aimtupsu.payment.PaymentService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class BridgeDemo {

    public static void main(String[] args) {

        log.info("Создаём фабрику наших сервисов.");
        final BeanFactory factory = new BeanFactory();

        log.info("Создаём инфо-сервис.");
        final InfoService infoService = factory.getInfoService();

        log.info("Получаем информацию о банках.");
        final List<Info> bankInfos = infoService.getBankInfos();
        for (Info bankInfo : bankInfos) {
            log.info("Имя банка: {}. Адрес: {}", bankInfo.getName(), bankInfo.getAddress());
        }

        log.info("Получаем информацию о магазине.");
        final Info shopInfo = infoService.getShopInfo();
        log.info("Имя магазина: {}. Адрес: {}", shopInfo.getName(), shopInfo.getAddress());

        log.info("Создаём сервис оплаты через КурскДорРезервПромБанк.");
        final PaymentService paymentServiceByKurskDorReservPromBank
                = factory.getPaymentServiceByKurskDorReservPromBank();

        paymentScenario(paymentServiceByKurskDorReservPromBank);

        log.info("Создаём сервис оплаты через РосБухГлавБанк.");
        final PaymentService paymentServiceByRosBukhGlavBank = factory.getPaymentServiceByRosBukhGlavBank();

        paymentScenario(paymentServiceByRosBukhGlavBank);

    }

    private static void paymentScenario(final PaymentService paymentService) {

        log.info("Оплачиваем покупку.");
        final Sale saleToPay = getSaleToPay();
        paymentService.paySale(saleToPay);

        log.info("Возвращаем денежные средства за одну из позиций покупки.");
        final Sale saleToRefund = getSaleToRefund();
        paymentService.refundSale(saleToRefund);
    }

    private static Sale getSaleToPay() {
        final List<Position> positionList = new ArrayList<>();
        positionList.add(new Position(1, 1245667, "Паровозик Чух-Чух", BigDecimal.valueOf(12350)));
        positionList.add(new Position(2, 1245, "Кубик-рубика", BigDecimal.valueOf(125950)));
        positionList.add(new Position(3, 98766665, "Мишка Тедди", BigDecimal.valueOf(99999)));
        return Sale.builder()
                .number(1)
                .customerName("Михаил Задурнов")
                .customerEmail("mickhael.zadoornov@eboy.ru")
                .positionList(positionList)
                .build();
    }

    private static Sale getSaleToRefund() {
        final List<Position> positionList = new ArrayList<>();
        positionList.add(new Position(2, 1245, "Кубик-рубика", BigDecimal.valueOf(125950)));
        return Sale.builder()
                .number(2)
                .customerName("Михаил Задурнов")
                .customerEmail("mickhael.zadoornov@eboy.ru")
                .positionList(positionList)
                .build();
    }

}
