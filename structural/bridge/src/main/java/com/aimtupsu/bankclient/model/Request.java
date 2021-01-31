package com.aimtupsu.bankclient.model;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Request {

    private final int id;
    private final CustomerInfo customerInfo;
    private final OperationType operationType;
    private final List<PositionInfo> positionInfoList;

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("{\n\tID: ").append(this.id).append(".\n")
                .append("\tТип операции: ").append(operationType.name()).append(".\n")
                .append("\tПозиции: {\n");
        for (PositionInfo positionInfo : positionInfoList) {
            stringBuilder
                    .append("\t\t- ")
                    .append("номер: ").append(positionInfo.getItemInfo().getNumber()).append(", ")
                    .append("имя: ").append(positionInfo.getItemInfo().getName()).append(", ")
                    .append("цена в копейках: ").append(positionInfo.getPrice().longValue()).append(";\n");
        }
        stringBuilder.append("\t}\n}");
        return stringBuilder.toString();
    }

}
