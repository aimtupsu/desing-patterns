package com.aimtupsu;

import com.aimtupsu.client.RestClient;
import com.aimtupsu.dao.Dao;
import com.aimtupsu.factory.RestClientFactory;
import com.aimtupsu.model.rest.HttpMethod;
import com.aimtupsu.model.rest.Request;
import java.util.Random;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class DecoratorDemo {

    private static final Random R = new Random();

    public static void main(String[] args) {
        log.info("Use simple REST client.");
        final RestClient simpleRestClient = RestClientFactory.getSimpleRestClient();
        simpleRestClient.send(generateRequest());
        logDb();

        log.info("Use REST client with logging.");
        final RestClient restClientWithLogging = RestClientFactory.getRestClientWithLogging();
        restClientWithLogging.send(generateRequest());
        logDb();

        log.info("Use REST client with DB writing.");
        final RestClient restClientWithDbWriting = RestClientFactory.getRestClientWithDbWriting();
        restClientWithDbWriting.send(generateRequest());
        logDb();

        log.info("Use REST client with logging and DB writing.");
        final RestClient restClientWithLoggingAndDbWriting = RestClientFactory.getRestClientWithLoggingAndDbWriting();
        restClientWithLoggingAndDbWriting.send(generateRequest());
        logDb();
    }

    private static void logDb() {
        final Dao dao = RestClientFactory.getDao();
        log.info("Db entries: {}.\n", dao.getAll());
    }

    private static Request generateRequest() {
        final HttpMethod[] values = HttpMethod.values();
        final HttpMethod httpMethod = values[R.nextInt(values.length)];
        final String header = "Header: " + R.nextInt();
        final String body = "Body: " + R.nextInt();
        final Request request = new Request(httpMethod, header, body);
        log.info("Generated request: {}.", request);
        return request;
    }

}
