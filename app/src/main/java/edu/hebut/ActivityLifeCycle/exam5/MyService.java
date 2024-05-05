package edu.hebut.ActivityLifeCycle.exam5;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyService extends Service {

    private Handler mHandler = new Handler(Looper.getMainLooper());

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        // 如果服务不与任何组件绑定，返回 null
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // 在这里执行你的服务逻辑
        // 这个方法在每次服务启动时调用
        // 返回值表示系统如何处理服务在被杀死后重新启动的情况
        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                mHandler.post(() -> {
                    Toast.makeText(this, "服务循环",
                            Toast.LENGTH_SHORT).show();
                });
                Log.w("210236 申洪建", "服务循环");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // 在服务销毁时执行的逻辑
        mHandler.post(() -> {
            Toast.makeText(this, "服务销毁", Toast.LENGTH_SHORT).show();
            Log.w("210236 申洪建", "服务销毁");
        });
    }
}
