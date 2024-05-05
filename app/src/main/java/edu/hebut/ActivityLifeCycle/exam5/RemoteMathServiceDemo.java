package edu.hebut.ActivityLifeCycle.exam5;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class RemoteMathServiceDemo extends Service {

        @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    private final RemoteAIDL.Stub mBinder = new RemoteAIDL.Stub() {
        @Override
        public double add(double a, double b) {
            return a + b;
        }

        @Override
        public double subtract(double a, double b) {
            return a - b;
        }

        @Override
        public double multiply(double a, double b) {
            return a * b;
        }

        @Override
        public double divide(double a, double b) {
            if (b == 0) {
                Toast.makeText(RemoteMathServiceDemo.this, "除数不能为0", Toast.LENGTH_SHORT).show();
                return 0;
            }
            return a / b;
        }
    };

}