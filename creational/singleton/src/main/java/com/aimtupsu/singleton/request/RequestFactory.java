package com.aimtupsu.singleton.request;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.experimental.UtilityClass;

/**
 * @author Vladimir.Shchepin
 */
@UtilityClass
public class RequestFactory {

    private final int REQUEST_COUNT = 500;
    private final int FREQUENCY_ERROR = 15;
    private final Random RANDOM = new Random();

    private int i = 0;

    /**
     * Генерирует список запросов со случайными типами.
     */
    public List<Request> generateRequestList() {
        return Stream
                .generate(RequestFactory::generateRequest)
                .limit(REQUEST_COUNT)
                .collect(Collectors.toList());
    }

    /**
     * Генерирует запрос со случайным типом.
     */
    private Request generateRequest() {
        return new Request(generateRequestType(), LocalDateTime.now(), "SOMETHING");
    }

    /**
     * Генерирует тип запроса.
     * Пропускает тип {@link Request.RequestType#ERROR} каждые {@value RequestFactory#FREQUENCY_ERROR}.
     *
     * @return тип запроса.
     */
    private Request.RequestType generateRequestType() {
        Request.RequestType type;
        do {
            final Request.RequestType[] types = Request.RequestType.values();
            final int index = RANDOM.nextInt(types.length);
            type = types[index];
        } while(type == Request.RequestType.ERROR && i++ < FREQUENCY_ERROR);
        if (i > FREQUENCY_ERROR) {
            i = 0;
        }
        return type;
    }

}
