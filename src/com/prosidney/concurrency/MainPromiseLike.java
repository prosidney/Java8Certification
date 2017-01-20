package com.prosidney.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by admin on 20/01/17.
 */
public class MainPromiseLike {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            System.out.println("begin");
            final Callable<Object> integerCallableFirst = () -> {
                Thread.sleep(2000);
                System.out.println("retornando 30+11");
                return 30 + 11;
            };
            final Callable<Object> integerCallableSecond = () -> {
                Thread.sleep(4000);
                System.out.println("retornando 30+12");
                return 30 + 12;
            };

            final ArrayList<Callable<Object>> callables = new ArrayList<>();
            callables.add(integerCallableFirst);
            callables.add(integerCallableSecond);

            final List<Future<Object>> futures = service.invokeAll(callables);
            try {
                System.out.println("vendo resultados");
                System.out.println(futures.get(0).get());
                System.out.println(futures.get(1).get());
            } finally {
                if (service != null) service.shutdown();
            }

            System.out.println("end");
        } finally {
            if(service != null) service.shutdown();
        }
    }
}
