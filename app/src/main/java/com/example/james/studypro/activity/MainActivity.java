package com.example.james.studypro.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.james.studypro.R;

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
}
