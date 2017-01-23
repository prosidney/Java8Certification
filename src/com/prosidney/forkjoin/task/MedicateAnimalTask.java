package com.prosidney.forkjoin.task;

import com.prosidney.forkjoin.model.Animal;

import java.util.List;
import java.util.Random;
import java.util.concurrent.RecursiveTask;

/**
 * Created by Sidney on 2017-01-23.
 */
public class MedicateAnimalTask extends RecursiveTask {
    private int start;
    private int end;
    private List<Animal> animals;

    public MedicateAnimalTask(List<Animal> animals, int start, int end) {
        this.start = start;
        this.end = end;
        this.animals = animals;
    }

    @Override
    protected Integer compute() {
        if(end - start <= 5){
            Integer qtdePills = 0;
            for (int i = start; i < end; i++){
                computar(animals.get(i));
                qtdePills += animals.get(i).getQtdPills();
            }
            return qtdePills;
        } else {
            int middle = start+((end-start) / 2);


            final MedicateAnimalTask task1 = new MedicateAnimalTask(animals, start, middle);

            task1.fork();

            final MedicateAnimalTask task2 = new MedicateAnimalTask(animals, middle, end);

            return task2.compute() + (Integer) task1.join();
        }
    }

    private void computar(Animal animal){
        animal.setMedicated(true);
        animal.setQtdPills(new Random().nextInt(10) + 1);
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
