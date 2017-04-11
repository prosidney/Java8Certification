package com.prosidney.java8.douts;


import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by admin on 06/02/17.
 */
public class ReadWriteLock {

    public static void main(String args[]){
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        lock.readLock().lock();
        lock.readLock().unlock();

        lock.writeLock().lock();
        lock.writeLock().unlock();
    }
}
