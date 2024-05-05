package edu.hebut.ActivityLifeCycle.exam5;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import android.os.Binder;
import android.widget.Toast;

public class SimpleMathServiceDemo extends Service {
    private final IBinder binder = new LocalBinder();

    public class LocalBinder extends Binder {
        SimpleMathServiceDemo getService() {
            return SimpleMathServiceDemo.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            Toast.makeText(this, "除数不能为0!", Toast.LENGTH_SHORT).show();
            return 0;
        }
        return a / b;
    }
}
