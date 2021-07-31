package com.aimtupsu.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Info {

    private final String name;
    private final String address;

}
