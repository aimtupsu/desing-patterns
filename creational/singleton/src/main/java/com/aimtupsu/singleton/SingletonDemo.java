package com.aimtupsu.singleton;

import com.aimtupsu.singleton.counter.Counter;
import com.aimtupsu.singleton.counter.impl.lazy.demandholder.InitOnDemandHolderCounter;
import com.aimtupsu.singleton.counter.impl.lazy.doublecheck.DoubleCheckedLockingCounter;
import com.aimtupsu.singleton.counter.impl.lazy.synchronised.SyncCounter;
import com.aimtupsu.singleton.counter.impl.notlazy.enumeration.EnumCounter;
import com.aimtupsu.singleton.counter.impl.notlazy.statical.StaticCounter;
import com.aimtupsu.singleton.handler.RequestHandler;
import com.aimtupsu.singleton.request.Request;
import com.aimtupsu.singleton.request.RequestFactory;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;
import lombok.extern.log4j.Log4j2;

/**
 * @author Vladimir.Shchepin
 */
@Log4j2
public class SingletonDemo {

    private static final int THREAD_COUNT = 10;

    public static void main(String[] args) throws InterruptedException {
        final List<Request> requestList = RequestFactory.generateRequestList();
        final long count = requestList.stream().filter(r -> r.getType() == Request.RequestType.ERROR).count();
        log.info("Error request count: " + count);

        log.info("Not Lazy Counters");
        log.info("Enum Counter");
        requestListHandling(requestList, getEnumCounterSupplier(), count);
        log.info("Static Counter");
        requestListHandling(requestList, getStaticCounterSupplier(), count);
        log.info("Lazy Counters");
        log.info("Synchronized Counter");
        requestListHandling(requestList, getSyncCounterSupplier(), count);
        log.info("Double Checked Locking Counter");
        requestListHandling(requestList, getDoubleCheckedLockingCounterSupplier(), count);
        log.info("Initialization-On-Demand Holder Counter");
        requestListHandling(requestList, getInitOnDemandHolderCounterSupplier(), count);

        System.exit(0);
    }

    private static Supplier<Counter> getEnumCounterSupplier() {
        return () -> EnumCounter.INSTANCE;
    }

    private static Supplier<Counter> getStaticCounterSupplier() {
        return () -> StaticCounter.INSTANCE;
    }

    private static Supplier<Counter> getSyncCounterSupplier() {
        return SyncCounter::getInstance;
    }

    private static Supplier<Counter> getDoubleCheckedLockingCounterSupplier() {
        return DoubleCheckedLockingCounter::getInstance;
    }

    private static Supplier<Counter> getInitOnDemandHolderCounterSupplier() {
        return InitOnDemandHolderCounter::getInstance;
    }

    private static void requestListHandling(final List<Request> requestList,
                                            final Supplier<Counter> counter,
                                            final long count) throws InterruptedException {

        final ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
        requestList.forEach(request -> executorService.submit(new RequestHandler(counter, request)));

        int total = 0;
        while (total < count) {
            Thread.sleep(3000);
            total = counter.get().total();
            log.info("Total: {}", total);
        }
    }

}
