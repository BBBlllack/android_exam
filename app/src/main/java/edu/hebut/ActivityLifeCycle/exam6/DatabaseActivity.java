package edu.hebut.ActivityLifeCycle.exam6;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import edu.hebut.ActivityLifeCycle.R;

public class DatabaseActivity extends AppCompatActivity {

    private DatabaseManager dbManager;

    private final static String MY_TAG = "210236 申洪建";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        dbManager = new DatabaseManager(this);

        EditText name = findViewById(R.id.exam6_sql_name);
        EditText email = findViewById(R.id.exam6_sql_email);
        TextView textView = findViewById(R.id.exam6_display_all);
        EditText queryName = findViewById(R.id.exam6_query_name);
        EditText delIdView = findViewById(R.id.exam6_del_id);

        findViewById(R.id.exam6_insert_user).setOnClickListener(v -> {
            // 插入用户数据
            long newUserId = dbManager.insertUser(name.getText().toString(), email.getText().toString());
            Toast.makeText(this, "Inserted user with ID: " + newUserId, Toast.LENGTH_SHORT).show();
            Log.d(MY_TAG, "Inserted user with ID: " + newUserId);
        });

        findViewById(R.id.exam6_query_all).setOnClickListener(v -> {
            StringBuilder all = new StringBuilder();
            // 查询所有用户
            Cursor cursor = dbManager.getAllUsers();
            if (cursor.moveToFirst()) {
                do {
                    String id = cursor.getString(cursor.getColumnIndex("id"));
                    String userName = cursor.getString(cursor.getColumnIndex("name"));
                    String userEmail = cursor.getString(cursor.getColumnIndex("email"));
                    Log.d(MY_TAG, "User: " + userName + ", Email: " + userEmail);
                    all.append(String.format("%s, %s, %s\n", id, userName, userEmail));
                } while (cursor.moveToNext());
            }
            Toast.makeText(this, "查询所有用户信息成功!", Toast.LENGTH_SHORT).show();
            textView.setText(all.toString());
        });

        findViewById(R.id.exam6_query_name_btn).setOnClickListener(v -> {
            StringBuilder all = new StringBuilder();
            Cursor cursor = dbManager.getUserByName( "%" + queryName.getText().toString() + "%");
            if (cursor.moveToFirst()) {
                do {
                    String id = cursor.getString(cursor.getColumnIndex("id"));
                    String userName = cursor.getString(cursor.getColumnIndex("name"));
                    String userEmail = cursor.getString(cursor.getColumnIndex("email"));
                    Log.d(MY_TAG, "User: " + userName + ", Email: " + userEmail);
                    all.append(String.format("%s, %s, %s\n", id, userName, userEmail));
                } while (cursor.moveToNext());
            }
            Toast.makeText(this, String.format("模糊匹配查询%s用户信息成功!", queryName.getText().toString()), Toast.LENGTH_SHORT).show();
            textView.setText(all.toString());
        });

        findViewById(R.id.exam6_del_btn).setOnClickListener(v -> {
            Long aLong = Long.valueOf(delIdView.getText().toString());
            int i = dbManager.deleteUser(aLong);
            if (i > 0) {
                Toast.makeText(this, String.format("删除%s号用户成功", aLong), Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, String.format("删除%s号用户失败, 请检查id", aLong), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        // 关闭数据库连接
        dbManager.close();
    }
}
