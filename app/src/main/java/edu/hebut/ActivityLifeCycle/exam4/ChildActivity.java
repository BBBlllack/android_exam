package edu.hebut.ActivityLifeCycle.exam4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.hebut.ActivityLifeCycle.R;

public class ChildActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);


        editText = findViewById(R.id.exam4_child_edittext);

        Button replyButton = findViewById(R.id.exam4_replyButton);
        replyButton.setOnClickListener(v -> {
            // 获取编辑框中的文本
            String replyMessage = editText.getText().toString();

            // 创建一个 Intent，将回复消息放入 Intent 中
            Intent replyIntent = new Intent();
            replyIntent.putExtra("reply", replyMessage);

            // 设置结果代码为 RESULT_OK，并将 Intent 返回给父 Activity
            setResult(Activity.RESULT_OK, replyIntent);

            // 结束当前子 Activity
            finish();
        });
    }
}