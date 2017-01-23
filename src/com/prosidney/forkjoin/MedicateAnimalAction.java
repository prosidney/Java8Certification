package com.prosidney.forkjoin;

import java.util.List;
import java.util.Random;
import java.util.concurrent.RecursiveTask;

/**
 * Created by Sidney on 2017-01-23.
 */
public class MedicateAnimalAction extends RecursiveTask {
    private int start;
    private int end;
    private List<Animal> animals;

    public MedicateAnimalAction(List<Animal> animals, int start, int end) {
        this.start = start;
        this.end = end;
        this.animals = animals;
    }

    @Override
    protected Integer compute() {
        if(end - start <= 5){
            Integer qtdePills = 0;
            for (int i=start; i<end; i++){
                int newPills = new Random().nextInt();

                Animal animal = animals.get(i);

                animal.setMedicated(true);
                animal.setQtdPills(newPills);

                qtdePills += newPills;
            }
            return qtdePills;
        } else {
            int middle = start+((end-start) / 2);
            invokeAll(new MedicateAnimalAction(animals, start, middle),
                      new MedicateAnimalAction(animals, middle, end));
        }
    }

    private void computar(Animal animal){
        animal.setMedicated(true);
        animal.setQtdPills(new Random().nextInt());
    }
}
