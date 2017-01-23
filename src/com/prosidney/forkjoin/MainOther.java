package com.prosidney.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * Created by Sidney on 2017-01-23.
 */
public class MainOther {
    public static void main(String args[]){
        List<Animal> animals = new ArrayList<>();

        int size = 9000000;

        for (int i = 0; i< size; i++){
            Animal e = new Animal();
            e.setName("Animal" + new Random().nextDouble());
            animals.add(e);
        }
        System.out.println("List has been created");

        long start = System.currentTimeMillis();

        for (Animal animal : animals) {
            animal.setMedicated(true);
            animal.setQtdPills(10);
        }

        System.out.println("Time:"+ (System.currentTimeMillis() - start));
        //System.out.println("Animais: ");
        System.out.println(animals.get(0).getQtdPills());
        System.out.println(animals.get(size-1).getName());
        //animals.stream().forEach(
          //      d -> System.out.println(d.getName()+" " + d.getQtdPills()));

    }
}
