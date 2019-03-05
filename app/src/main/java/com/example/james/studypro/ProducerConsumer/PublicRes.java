package com.example.james.studypro.ProducerConsumer;

import android.util.Log;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PublicRes {
    private int num = 0;
    private ReentrantLock lock;
    private Condition condition;
    public PublicRes(ReentrantLock lock){
        this.lock = lock;
        condition = lock.newCondition();
    }

    public void produce(){
        try {
            lock.lock();
            while (num != 0){
                condition.await();
            }
            condition.signal();
            num ++;
            Thread.sleep(1000);
            Log.d("xxy","num = " + num);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

//        synchronized (this){
//            try {
//                while (num == 1){
//                    wait();
//                }
//                num ++;
//                notify();
//                Log.d("xxy","num = " + num);
//                Thread.sleep(1000);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//        }
    }

    public void consume(){
        try {
            lock.lock();
            while (num == 0){
                condition.await();
            }
            condition.signal();
            num --;
            Thread.sleep(1000);
            Log.d("xxy","num = " + num);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }


//        synchronized (this){
//            try {
//                while (num == 0){
//                    wait();
//                }
//                num --;
//                Log.d("xxy","num = " + num);
//                notify();
//                Thread.sleep(1000);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//        }
    }

}
