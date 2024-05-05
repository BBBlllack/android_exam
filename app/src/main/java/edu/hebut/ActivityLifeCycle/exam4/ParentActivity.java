package edu.hebut.ActivityLifeCycle.exam4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import edu.hebut.ActivityLifeCycle.R;

public class ParentActivity extends AppCompatActivity {

    private static final int REQUEST_REPLY = 1;
    private TextView receivedMessageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent);

        receivedMessageTextView = findViewById(R.id.exam4_receivedMessageTextView);

        Button startChildActivityButton = findViewById(R.id.exam4_startChildActivityButton);
        startChildActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 创建一个 Intent，启动子 Activity
                Intent intent = new Intent(ParentActivity.this, ChildActivity.class);
                startActivityForResult(intent, REQUEST_REPLY);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // 检查请求代码和结果代码
        if (requestCode == REQUEST_REPLY) {
            if (resultCode == Activity.RESULT_OK) {
                // 从 Intent 中获取回复消息
                String replyMessage = data.getStringExtra("reply");

                // 显示回复消息
                receivedMessageTextView.setText("Received reply: " + replyMessage);
            }
        }
    }
}