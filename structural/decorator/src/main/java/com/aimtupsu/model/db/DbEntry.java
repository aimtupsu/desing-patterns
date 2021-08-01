package com.aimtupsu.model.db;

import com.aimtupsu.model.rest.Request;
import com.aimtupsu.model.rest.Response;
import java.util.UUID;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Сущность в БД.
 */
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@RequiredArgsConstructor
public class DbEntry {

    @EqualsAndHashCode.Include
    private final UUID id = UUID.randomUUID();
    @Getter
    private final Request request;
    @Getter
    private final Response response;

}
