package com.aimtupsu.bankclient.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BankInfo {

    private final String name;
    private final String address;
    private final String inn;
    private final String kpp;
    private final String bik;

}
