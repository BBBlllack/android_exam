package edu.hebut.ActivityLifeCycle.exam4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class BroadcastReceiverDemo extends BroadcastReceiver {
    private final static String STAND_ACTION = "edu.hebut.ActivityLifeCycle.exam4.BroadcastStandActivity";

    // 接受到广播之后，触发此方法
    @Override
    public void onReceive(Context context, Intent intent) {
        // 接收到指定类型的广播
        if (intent != null && STAND_ACTION.equals(intent.getAction())){
            Log.w("210236 申洪建", "收到一个广播");
            Toast.makeText(context, "收到了一个广播",Toast.LENGTH_SHORT).show();
        }
    }
}
