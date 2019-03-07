package com.example.james.studypro.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.james.studypro.ProducerConsumer.ConsumeThread;
import com.example.james.studypro.ProducerConsumer.ProduceThread;
import com.example.james.studypro.ProducerConsumer.PublicRes;
import com.example.james.studypro.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_leet_code;
    private Button btn_view;
    private Button btn_event_bus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();


    }

    private void init(){
        btn_leet_code = findViewById(R.id.btn_leet_code);
        btn_leet_code.setOnClickListener(this);
        btn_view = findViewById(R.id.btn_view);
        btn_view.setOnClickListener(this);
        btn_event_bus = findViewById(R.id.btn_event_bus);
        btn_event_bus.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.btn_leet_code:
                intent = new Intent(MainActivity.this,LeetCodeActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_view:
                intent = new Intent(MainActivity.this,ViewActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_event_bus:
                intent = new Intent(MainActivity.this, EventBusActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }


    public static void main(String[] args){
        ReentrantLock lock = new ReentrantLock();
        PublicRes publicRes = new PublicRes(lock);
        ConsumeThread consumeThread0 = new ConsumeThread(publicRes);
        consumeThread0.setName("consumeThread0");
        consumeThread0.start();

        ConsumeThread consumeThread1 = new ConsumeThread(publicRes);
        consumeThread1.setName("consumeThread1");
        consumeThread1.start();

        ConsumeThread consumeThread2 = new ConsumeThread(publicRes);
        consumeThread2.setName("consumeThread2");
        consumeThread2.start();

        ConsumeThread consumeThread3 = new ConsumeThread(publicRes);
        consumeThread3.setName("consumeThread3");
        consumeThread3.start();

        ConsumeThread consumeThread4 = new ConsumeThread(publicRes);
        consumeThread4.setName("consumeThread4");
        consumeThread4.start();

        ProduceThread produceThread0 = new ProduceThread(publicRes);
        produceThread0.setName("produceThread0");
        produceThread0.start();

        ProduceThread produceThread1 = new ProduceThread(publicRes);
        produceThread1.setName("produceThread1");
        produceThread1.start();

        ProduceThread produceThread2 = new ProduceThread(publicRes);
        produceThread2.setName("produceThread2");
        produceThread2.start();

        ProduceThread produceThread3 = new ProduceThread(publicRes);
        produceThread3.setName("produceThread3");
        produceThread3.start();

        ProduceThread produceThread4 = new ProduceThread(publicRes);
        produceThread4.setName("produceThread4");
        produceThread4.start();
    }

}
