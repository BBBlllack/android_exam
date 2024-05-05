package edu.hebut.ActivityLifeCycle.exam5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import edu.hebut.ActivityLifeCycle.R;

public class SimpleRandomServiceDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_random_service_demo);

        Intent serviceIntent = new Intent(this, MyService.class);

        findViewById(R.id.exam5_start_service).setOnClickListener(v -> {
            startService(serviceIntent);
            Log.w("210236 申洪建", "服务启动");
        });

        findViewById(R.id.exam5_stop_service).setOnClickListener(v -> {
            stopService(serviceIntent);
            Log.w("210236 申洪建", "服务停止");
        });
    }
}