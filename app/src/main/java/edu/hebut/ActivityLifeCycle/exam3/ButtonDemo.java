package edu.hebut.ActivityLifeCycle.exam3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import edu.hebut.ActivityLifeCycle.R;

public class ButtonDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_demo);
        findViewById(R.id.exam3_button).setOnClickListener(v -> {
            Log.w("210236 申洪建", "exam3 button is clicked");
        });
        findViewById(R.id.exam3_image_button).setOnClickListener(v -> {
            Log.w("210236 申洪建", "exam3 image button is clicked");
        });
    }
}