package edu.hebut.ActivityLifeCycle.exam4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import edu.hebut.ActivityLifeCycle.R;

public class IntentResolutionDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_resolution_demo);
        // 获取传入的 Intent
        Intent intent = getIntent();
//        Log.e("210236",intent.getAction());
        // 检查 Intent 的 Action 和 Data
        if (intent != null && Intent.ACTION_VIEW.equals(intent.getAction())) {
            Uri uri = intent.getData();
            if (uri != null) {
                Log.e("210236", uri.toString());
                startActivity(new Intent(Intent.ACTION_VIEW, uri));
                // 结束当前活动，避免返回时重新处理 Intent
                finish();
            }
        }

    }
}