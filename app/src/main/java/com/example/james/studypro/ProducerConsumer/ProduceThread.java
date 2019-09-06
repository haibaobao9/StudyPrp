package com.example.james.studypro.ProducerConsumer;

public class ProduceThread extends Thread {
    private PublicRes publicRes;

    public ProduceThread(PublicRes publicRes){
        this.publicRes = publicRes;
    }

    @Override
    public void run() {
        super.run();
        while (true){
            publicRes.produce();
        }
    }
}
