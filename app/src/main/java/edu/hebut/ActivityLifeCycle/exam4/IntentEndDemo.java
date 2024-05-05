package edu.hebut.ActivityLifeCycle.exam4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import edu.hebut.ActivityLifeCycle.R;

public class IntentEndDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_end_demo);

        // 从 Intent 中获取传递的数据
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String message = extras.getString("message");
            TextView textView = findViewById(R.id.exam4_end_textview);
            textView.setText(message);
        }
        findViewById(R.id.exam4_end_button).setOnClickListener(v -> {
            finish();
        });
    }


}