package com.prosidney.java8.forkjoin.action;

import com.prosidney.java8.forkjoin.model.Animal;

import java.util.List;
import java.util.Random;
import java.util.concurrent.RecursiveAction;

/**
 * Created by Sidney on 2017-01-23.
 */
public class MedicateAnimalAction extends RecursiveAction {
    private int start;
    private int end;
    private List<Animal> animals;

    public MedicateAnimalAction(List<Animal> animals, int start, int end) {
        this.start = start;
        this.end = end;
        this.animals = animals;
    }

    @Override
    protected void compute() {
        if(end - start <= 5){

            for (int i=start; i<end; i++){
                int newPills = new Random().nextInt(10);
                computar(animals.get(i));
            }
        } else {
            int middle = start+((end-start) / 2);

            final MedicateAnimalAction action1 = new MedicateAnimalAction(animals, start, middle);
            final MedicateAnimalAction action2 = new MedicateAnimalAction(animals, middle, end);

            invokeAll(action1, action2);
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
