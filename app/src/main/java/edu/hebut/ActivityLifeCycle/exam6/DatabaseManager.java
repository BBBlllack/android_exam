package edu.hebut.ActivityLifeCycle.exam6;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseManager {

    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;

    public DatabaseManager(Context context) {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    // 插入数据
    public long insertUser(String name, String email) {
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("email", email);
        return db.insert("users", null, values);
    }

    // 查询所有用户
    public Cursor getAllUsers() {
        return db.query("users", null, null, null, null, null, null);
    }

    // 查询指定用户(id)
    public Cursor getUserById(long userId) {
        return db.query("users", null, "id = ?", new String[]{String.valueOf(userId)}, null, null, null);
    }

    // 查询指定用户(name)
    public Cursor getUserByName(String name) {
        return db.query("users", null, "name like ?", new String[]{String.valueOf(name)}, null, null, null);
    }

    // 更新用户信息
    public int updateUser(long userId, String newName, String newEmail) {
        ContentValues values = new ContentValues();
        values.put("name", newName);
        values.put("email", newEmail);
        return db.update("users", values, "id = ?", new String[]{String.valueOf(userId)});
    }

    // 删除用户
    public int deleteUser(long userId) {
        return db.delete("users", "id = ?", new String[]{String.valueOf(userId)});
    }

    // 关闭数据库
    public void close() {
        dbHelper.close();
    }
}
