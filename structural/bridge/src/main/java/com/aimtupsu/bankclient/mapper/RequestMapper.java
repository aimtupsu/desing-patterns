package com.aimtupsu.bankclient.mapper;

import com.aimtupsu.bankclient.model.CustomerInfo;
import com.aimtupsu.bankclient.model.OperationType;
import com.aimtupsu.bankclient.model.PositionInfo;
import com.aimtupsu.bankclient.model.Request;
import com.aimtupsu.model.Position;
import com.aimtupsu.model.Receipt;
import java.util.ArrayList;
import java.util.List;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RequestMapper {

    public Request convertToPay(final Receipt receipt) {
        return commonConvertingSale(receipt)
                .operationType(OperationType.PAY)
                .build();
    }

    public Request convertToRefund(final Receipt receipt) {
        return commonConvertingSale(receipt)
                .operationType(OperationType.REFUND)
                .build();
    }

    private CustomerInfo convertCustomerInfo(final Receipt receipt) {
        return CustomerInfo.builder()
                .name(receipt.getCustomerName())
                .email(receipt.getCustomerEmail())
                .build();
    }

    private PositionInfo convertPositionInfo(final Position position) {
        return PositionInfo.builder()
                .itemInfo(convertItemInfo(position))
                .price(position.getPrice())
                .build();
    }

    private PositionInfo.ItemInfo convertItemInfo(final Position position) {
        return PositionInfo.ItemInfo.builder()
                .number(position.getItemNumber())
                .name(position.getItemName())
                .build();
    }

    private List<PositionInfo> convertPositionInfoList(final List<Position> positionList) {
        final ArrayList<PositionInfo> positionInfoList = new ArrayList<>();
        if (positionList.isEmpty()) {
            return positionInfoList;
        }
        for (Position position : positionList) {
            final PositionInfo positionInfo = convertPositionInfo(position);
            positionInfoList.add(positionInfo);
        }
        return positionInfoList;
    }

    private Request.RequestBuilder commonConvertingSale(final Receipt receipt) {
        return Request.builder()
                .id(receipt.getNumber())
                .customerInfo(convertCustomerInfo(receipt))
                .positionInfoList(convertPositionInfoList(receipt.getPositionList()));
    }

}
