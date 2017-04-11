package com.prosidney.java8.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by admin on 20/01/17.
 */
public class Main {
    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            System.out.println("begin");
            final Future<Integer> first = service.submit(() -> {
                System.out.println("Printing zoo inventory");
                return 10;
            });
            final Future<Integer> second = service.submit(() -> {
                        for (int i = 0; i < 3; i++)
                            System.out.println("Printing record: " + i);
                        return 20;
                    }
            );
            service.execute(() -> System.out.println("Printing zoo inventory"));
            System.out.println("end");
        } finally {
            if(service != null) service.shutdown();
        }
    }
}
