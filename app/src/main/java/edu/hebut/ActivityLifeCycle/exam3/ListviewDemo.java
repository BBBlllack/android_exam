package edu.hebut.ActivityLifeCycle.exam3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import edu.hebut.ActivityLifeCycle.R;

public class ListviewDemo extends AppCompatActivity {

    String[] colors = {"Red", "Green", "Blue", "Yellow", "Purple"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_demo);

        ListView listView = findViewById(R.id.exam3_listView);

        // 创建 ArrayAdapter，传入上下文、布局样式和数据源
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, colors);

        // 将 ArrayAdapter 设置到 ListView 上
        listView.setAdapter(adapter);

        // 设置 ListView 的点击监听器
        listView.setOnItemClickListener((parent, view, position, id) -> Toast.makeText(ListviewDemo.this, "选择了: " + colors[position], Toast.LENGTH_SHORT).show());
    }
}