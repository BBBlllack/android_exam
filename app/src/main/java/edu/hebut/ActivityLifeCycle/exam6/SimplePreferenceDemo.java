package edu.hebut.ActivityLifeCycle.exam6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import edu.hebut.ActivityLifeCycle.R;

public class SimplePreferenceDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_preference_demo);
        SharedPreferences config = getSharedPreferences("config", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = config.edit();

        TextView textView = findViewById(R.id.exam6_share_textview);
        EditText editText = findViewById(R.id.exam6_share_edittext);

        findViewById(R.id.exam6_save_button).setOnClickListener(v -> {
            editor.putString("info", editText.getText().toString());
            Toast f = editor.commit() ? Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT) : Toast.makeText(this, "保存失败", Toast.LENGTH_SHORT);
            f.show();
        });

        findViewById(R.id.exam6_read_button).setOnClickListener(v -> {
            textView.setText("获取: " + config.getString("info", "获取失败"));
        });
    }
}