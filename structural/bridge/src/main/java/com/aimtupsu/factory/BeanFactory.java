package com.aimtupsu.factory;

import com.aimtupsu.bankclient.BankClient;
import com.aimtupsu.bankclient.impl.KurskDorReservPromBankClient;
import com.aimtupsu.bankclient.impl.RosBukhGlavBankClient;
import com.aimtupsu.info.InfoService;
import com.aimtupsu.info.InfoServiceImpl;
import com.aimtupsu.payment.PaymentService;
import com.aimtupsu.payment.PaymentServiceImpl;
import java.util.ArrayList;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class BeanFactory {

    private PaymentService paymentServiceByKurskDorReservPromBank;
    private PaymentService paymentServiceByRosBukhGlavBank;
    private BankClient kurskDorReservPromBankClient;
    private BankClient rosBukhGlavBankClient;
    private InfoService infoService;

    public PaymentService getPaymentServiceByKurskDorReservPromBank() {
        if (this.paymentServiceByKurskDorReservPromBank == null) {
            this.paymentServiceByKurskDorReservPromBank = this.createPaymentServiceByKurskDorReservPromBank();
        }
        return this.paymentServiceByKurskDorReservPromBank;
    }

    public PaymentService getPaymentServiceByRosBukhGlavBank() {
        if (this.paymentServiceByRosBukhGlavBank == null) {
            this.paymentServiceByRosBukhGlavBank = this.createPaymentServiceByRosBukhGlavBank();
        }
        return this.paymentServiceByRosBukhGlavBank;
    }

    public InfoService getInfoService() {
        if (this.infoService == null) {
            this.infoService = this.createInfoService();
        }
        return this.infoService;
    }

    private BankClient getKurskDorReservPromBankClient() {
        if (this.kurskDorReservPromBankClient == null) {
            this.kurskDorReservPromBankClient = this.createKurskDorReservPromBankClient();
        }
        return this.kurskDorReservPromBankClient;
    }

    private BankClient getRosBukhGlavBankClient() {
        if (this.rosBukhGlavBankClient == null) {
            this.rosBukhGlavBankClient = this.createRosBukhGlavBankClient();
        }
        return this.rosBukhGlavBankClient;
    }

    private PaymentService createPaymentServiceByKurskDorReservPromBank() {
        return new PaymentServiceImpl(this.getKurskDorReservPromBankClient());
    }

    private PaymentService createPaymentServiceByRosBukhGlavBank() {
        return new PaymentServiceImpl(this.getRosBukhGlavBankClient());
    }

    private InfoService createInfoService() {
        final List<BankClient> bankClientList = new ArrayList<>();
        bankClientList.add(this.getKurskDorReservPromBankClient());
        bankClientList.add(this.getRosBukhGlavBankClient());
        return new InfoServiceImpl(bankClientList);
    }

    private BankClient createKurskDorReservPromBankClient() {
        return new KurskDorReservPromBankClient();
    }

    private BankClient createRosBukhGlavBankClient() {
        return new RosBukhGlavBankClient();
    }

}
