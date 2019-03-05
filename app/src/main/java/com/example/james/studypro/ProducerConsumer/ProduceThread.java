package com.example.james.studypro.ProducerConsumer;

public class ProduceThread implements Runnable{
    private PublicRes publicRes;
    public ProduceThread(PublicRes publicRes){
        this.publicRes = publicRes;
    }
    @Override
    public void run() {
        while (true){
            publicRes.produce();
        }
    }
}
