package com.example.james.studypro.ProducerConsumer;

public class ConsumeThread implements Runnable{
    private PublicRes publicRes;
    public ConsumeThread(PublicRes publicRes){
        this.publicRes = publicRes;
    }

    @Override
    public void run() {
        while (true){
            publicRes.consume();
        }
    }
}
