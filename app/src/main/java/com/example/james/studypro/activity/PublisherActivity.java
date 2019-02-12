package com.example.james.studypro.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.james.studypro.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class PublisherActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_publish_event;
    private EditText et_sticky_event;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus_publisher);

        btn_publish_event = findViewById(R.id.btn_publish_event);
        btn_publish_event.setOnClickListener(this);
        et_sticky_event = findViewById(R.id.et_sticky_event);
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_publish_event:
                EventBus.getDefault().post("im from eventbus");
                break;
            default:
                break;
        }
    }

    @Subscribe(sticky = true)
    public void onGetEventBus(String s){
        et_sticky_event.setText(s);
    }
}
