package com.prosidney.forkjoin.task;

import com.prosidney.forkjoin.model.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * Created by Sidney on 2017-01-23.
 */
public class ForkTask {
    public static void main(String args[]){
        List<Animal> animals = new ArrayList<>();

        int size = 10;
        for (int i=0; i<size; i++){
            Animal e = new Animal();
            e.setName("Animal" + new Random().nextDouble());
            animals.add(e);
        }
        System.out.println("List has been created");

        long start = System.currentTimeMillis();

        ForkJoinTask<Integer> task = new MedicateAnimalTask(animals,0,animals.size());
        ForkJoinPool pool = new ForkJoinPool();
        final Integer invokeResult = pool.invoke(task);
        System.out.println("Time:"+ (System.currentTimeMillis() - start)/1000);
        System.out.println("qtde pills:"+ invokeResult);
        animals.stream().forEach(d -> System.out.print(d));

    }
}
