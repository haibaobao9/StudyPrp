package com.example.james.studypro.ProducerConsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PublicRes {
    private ReentrantLock lock;
    private Condition condition;
    private int count = 0;

    public PublicRes(ReentrantLock lock){
        this.lock = lock;
        this.condition = lock.newCondition();
    }

    public void produce(){
        try {
            lock.lock();
            if (count == 10){
                condition.await();
            }
            count++;
            System.out.println("Produce : "+ count);
            Thread.sleep(1000);
            condition.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void consume(){
        try {
            lock.lock();
            if (count == 0){
                condition.await();
            }
            count--;
            System.out.println("consume : " + count);
            Thread.sleep(1000);
            condition.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
