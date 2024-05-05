package edu.hebut.ActivityLifeCycle.exam3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import edu.hebut.ActivityLifeCycle.R;

import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MyContextMenu extends AppCompatActivity {

    private TextView mTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_context_menu);
        mTextView = findViewById(R.id.exam3_context_menu_textview);
        registerForContextMenu(mTextView);//注册上下文菜单
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflator = new MenuInflater(this);
        inflator.inflate(R.menu.context_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    //上下文菜单的点击事件
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        Log.e("210236 申洪建", String.valueOf(item.getItemId()));
        int itemId = item.getItemId();
        if (itemId == R.id.menu_item1) {
            mTextView.setText("点击了第一个");
            Toast.makeText(this, "点击了:" + item.getTitle(), Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId == R.id.menu_item2) {
            mTextView.setText("点击了第二个");
            Toast.makeText(this, "点击了:" + item.getTitle(), Toast.LENGTH_SHORT).show();
            return true;

        } else if (itemId == R.id.menu_item3) {
            mTextView.setText("点击了第三个");
            Toast.makeText(this, "点击了:" + item.getTitle(), Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return super.onContextItemSelected(item);
        }
    }
}
