package com.prosidney.java8.forkjoin;

import com.prosidney.java8.forkjoin.model.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Sidney on 2017-01-23.
 */
public class UglyWay {
    public static void main(String args[]) throws InterruptedException {
        List<Animal> animals = new ArrayList<>();

        int size = 10;
        for (int i = 0; i< size; i++){
            Animal e = new Animal();
            e.setName("Animal" + new Random().nextDouble());
            animals.add(e);
        }
        System.out.println("List has been created");

        long start = System.currentTimeMillis();

        Integer qtde = 0;
        for (Animal animal : animals) {
            computar(animal);
            qtde += animal.getQtdPills();
        }

        System.out.println("Time:"+ (System.currentTimeMillis() - start)/1000);
        System.out.println("qtde pills:"+ qtde);
        animals.stream().forEach(d -> System.out.print(d));

    }

    private static void computar(Animal animal) throws InterruptedException {
        animal.setMedicated(true);
        animal.setQtdPills(new Random().nextInt(10) + 1);
        Thread.sleep(2500);
    }
}
