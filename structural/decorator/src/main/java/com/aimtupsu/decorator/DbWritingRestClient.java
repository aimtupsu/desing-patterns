package com.aimtupsu.decorator;

import com.aimtupsu.client.RestClient;
import com.aimtupsu.dao.Dao;
import com.aimtupsu.model.db.DbEntry;
import com.aimtupsu.model.rest.Request;
import com.aimtupsu.model.rest.Response;
import javax.annotation.Nonnull;
import lombok.extern.log4j.Log4j2;

/**
 * REST клиент, который записывает в БД запросы/ответа.
 */
@Log4j2
public class DbWritingRestClient extends RestClientDecorator {

    private final Dao dao;

    public DbWritingRestClient(final RestClient restClient, Dao dao) {
        super(restClient);
        this.dao = dao;
    }

    @Nonnull
    @Override
    public Response send(Request request) {
        final Response response = restClient.send(request);
        dao.save(new DbEntry(request, response));
        return response;
    }

}
