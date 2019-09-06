package com.example.james.studypro.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.james.studypro.ProducerConsumer.ConsumeThread;
import com.example.james.studypro.ProducerConsumer.ProduceThread;
import com.example.james.studypro.ProducerConsumer.PublicRes;
import com.example.james.studypro.R;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_leet_code;
    private Button btn_view;
    private Button btn_event_bus;
    private Button btn_Rxjava;

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

    private void init() {
        BackService service = new BackService();
        Intent intent = new Intent(this, service.getClass());
        startService(intent);
        stopService(intent);
        btn_leet_code = findViewById(R.id.btn_leet_code);
        btn_leet_code.setOnClickListener(this);
        btn_view = findViewById(R.id.btn_view);
        btn_view.setOnClickListener(this);
        btn_event_bus = findViewById(R.id.btn_event_bus);
        btn_event_bus.setOnClickListener(this);
        btn_Rxjava = findViewById(R.id.btn_Rxjava);
        btn_Rxjava.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btn_leet_code:
                intent = new Intent(MainActivity.this, LeetCodeActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_view:
                intent = new Intent(MainActivity.this, ViewActivity.class);
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
}
