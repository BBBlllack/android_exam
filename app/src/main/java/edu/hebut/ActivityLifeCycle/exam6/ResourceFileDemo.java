package edu.hebut.ActivityLifeCycle.exam6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import edu.hebut.ActivityLifeCycle.R;

public class ResourceFileDemo extends AppCompatActivity {

    /**
     * R.layout.activity_resource_file_demo 访问了布局文件, 将此activaty和R.layout.activity_resource_file_demo相关联, 展示布局
     * getString(R.string.person_info) 获取了在string中定义的person_info字符串
     * imageButton.setImageResource(R.drawable.exam3_image) 当点击imageButton的时候，将imageButton的资源图设置为R.drawable.exam3_image
     * 以上三种方式都实现了在程序运行时访问资源文件
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *                           previously being shut down then this Bundle contains the data it most
     *                           recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource_file_demo);
        String info = getString(R.string.person_info);
        ImageButton imageButton = findViewById(R.id.exam6_read_image);
        findViewById(R.id.exam6_read_string).setOnClickListener(v -> {
            Toast.makeText(this, "读取字符串: " + info, Toast.LENGTH_SHORT).show();
        });
        imageButton.setOnClickListener(v -> {
            imageButton.setImageResource(R.drawable.exam3_image);
            Toast.makeText(this, "更改背景图", Toast.LENGTH_SHORT).show();
        });
    }
}