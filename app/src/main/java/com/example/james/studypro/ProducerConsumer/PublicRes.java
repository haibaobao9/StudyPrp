package com.example.james.studypro.ProducerConsumer;

import android.util.Log;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PublicRes {
    private ReentrantLock lock;
    private Condition conditionA;
    private Condition conditionB;
    private boolean hasValue = false;

    public PublicRes(ReentrantLock lock){
        this.lock = lock;
        conditionA = lock.newCondition();
        conditionB = lock.newCondition();
    }

//    public void produce(){
//        try{
//            lock.lock();
//            while (hasValue){
//                conditionB.await();
//            }
//            hasValue = true;
//            conditionA.signalAll();
//            System.out.println(Thread.currentThread().getName());
//            Thread.sleep(1000);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }finally {
//            lock.unlock();
//        }
//    }


//    public void consume(){
//        try {
//            lock.lock();
//            while (!hasValue){
//                conditionA.await();
//            }
//            hasValue = false;
//            conditionB.signalAll();
//            System.out.println(Thread.currentThread().getName());
//            Thread.sleep(1000);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }finally {
//            lock.unlock();
//        }
//    }

    public void produce(){
        synchronized (this){
            try {
                while (hasValue){
                    wait();
                }
                hasValue = true;
                notifyAll();
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName());
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void consume(){
        synchronized (this){
            try {
                while (!hasValue){
                    wait();
                }
                hasValue = false;
                notifyAll();
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName());
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
