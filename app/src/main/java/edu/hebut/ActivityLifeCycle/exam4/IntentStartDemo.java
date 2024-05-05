package edu.hebut.ActivityLifeCycle.exam4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.hebut.ActivityLifeCycle.R;

public class IntentStartDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_start_demo);

        Button button = findViewById(R.id.exam4_start_button);
        button.setOnClickListener(v -> {
            // 创建一个 Intent，指定要启动的 Activity
            Intent intent = new Intent(IntentStartDemo.this, IntentEndDemo.class);

            // 向 Intent 中添加额外的数据
            intent.putExtra("message", "Hello from StartActivity!");

            // 启动新的 Activity
            startActivity(intent);

        });
    }
}