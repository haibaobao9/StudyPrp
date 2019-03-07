package com.example.james.studypro.ProducerConsumer;

public class ConsumeThread extends Thread{
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
