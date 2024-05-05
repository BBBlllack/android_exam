package edu.hebut.ActivityLifeCycle.exam3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import edu.hebut.ActivityLifeCycle.R;

public class SpinnerDemo extends AppCompatActivity {

    String[] colors = {"Red", "Green", "Blue", "Yellow", "Purple"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_demo);

        Spinner spinner = findViewById(R.id.exam3_spinner);

        // 创建 ArrayAdapter，传入上下文、布局样式和数据源
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, colors);

        // 设置下拉菜单的样式
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // 将 ArrayAdapter 设置到 Spinner 上
        spinner.setAdapter(adapter);
    }
}