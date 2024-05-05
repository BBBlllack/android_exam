package edu.hebut.ActivityLifeCycle.exam4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import edu.hebut.ActivityLifeCycle.R;

public class BroadcastStandActivity extends AppCompatActivity {

    BroadcastReceiverDemo receiverDemo;

    private static final String STAND_ACTION = "edu.hebut.ActivityLifeCycle.exam4.BroadcastStandActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_stand);

        findViewById(R.id.exam4_send_broadcast).setOnClickListener(v -> {
            Intent intent = new Intent(STAND_ACTION);
            sendBroadcast(intent);
            Toast.makeText(this, "发送广播成功", Toast.LENGTH_SHORT).show();
        });
    }

    // 注册广播接受者
    @Override
    protected void onStart() {
        super.onStart();
        receiverDemo = new BroadcastReceiverDemo();
        // 创建过滤器，只处理STAND_ACTION类型的广播
        IntentFilter filter = new IntentFilter(STAND_ACTION);
        registerReceiver(receiverDemo, filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        // 注销广播接受者
        unregisterReceiver(receiverDemo);
    }
}