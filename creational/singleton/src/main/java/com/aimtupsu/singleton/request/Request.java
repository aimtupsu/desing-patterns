package com.aimtupsu.singleton.request;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Vladimir.Shchepin
 */
@Getter
@EqualsAndHashCode(of = "uuid")
@ToString(exclude = "uuid")
public class Request {

    private final UUID uuid;
    private final RequestType type;
    private final LocalDateTime dateTime;
    private final String payload;

    public Request(final RequestType type, final LocalDateTime dateTime, final String payload) {
        this.uuid = UUID.randomUUID();
        this.type = type;
        this.dateTime = dateTime;
        this.payload = payload;
    }

    public enum RequestType {

        TYPE1,
        TYPE2,
        TYPE3,
        TYPE4,
        TYPE5,
        ERROR;

    }

}
