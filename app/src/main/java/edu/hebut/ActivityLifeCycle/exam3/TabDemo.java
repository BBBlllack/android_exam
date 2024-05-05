package edu.hebut.ActivityLifeCycle.exam3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TabHost;
import android.app.TabActivity;

import edu.hebut.ActivityLifeCycle.R;

public class TabDemo extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_demo);
        // 获取 TabHost 对象
        TabHost tabHost = getTabHost();

        // 添加选项卡1
        tabHost.addTab(tabHost.newTabSpec("TAB1")
                .setIndicator("线性布局")
                .setContent(R.id.layout01));

        // 添加选项卡2
        tabHost.addTab(tabHost.newTabSpec("TAB2")
                .setIndicator("相对布局")
                .setContent(R.id.layout02));

        // 添加选项卡3
        tabHost.addTab(tabHost.newTabSpec("TAB3")
                .setIndicator("绝对布局")
                .setContent(R.id.layout03));
    }
}