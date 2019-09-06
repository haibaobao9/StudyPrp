package com.example.james.studypro.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.james.studypro.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

public class EventBusActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText et_common_register;
    private Button btn_publisher_activity;
    private Button btn_sticky_event;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);

//        EventBus.getDefault().register(this);
        et_common_register = findViewById(R.id.et_common_register);
        btn_publisher_activity = findViewById(R.id.btn_publisher_activity);
        btn_publisher_activity.setOnClickListener(this);
        btn_sticky_event = findViewById(R.id.btn_sticky_event);
        btn_sticky_event.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btn_publisher_activity:
                intent = new Intent(EventBusActivity.this, PublisherActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_sticky_event:
                EventBus.getDefault().postSticky("sticky event");
                intent = new Intent(EventBusActivity.this,PublisherActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void getEventBus(String s){
//        et_common_register.setText(s);
//    }
}
