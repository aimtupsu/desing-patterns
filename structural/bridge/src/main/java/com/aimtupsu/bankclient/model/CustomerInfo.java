package com.aimtupsu.bankclient.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerInfo {

    private final String name;
    private final String email;

}
