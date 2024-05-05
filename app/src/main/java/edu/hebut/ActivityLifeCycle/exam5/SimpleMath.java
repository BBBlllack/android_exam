package edu.hebut.ActivityLifeCycle.exam5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import edu.hebut.ActivityLifeCycle.R;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SimpleMath extends AppCompatActivity {

    private SimpleMathServiceDemo msd;
    private boolean isBound = false;
    private EditText num1EditText, num2EditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_math);


        num1EditText = findViewById(R.id.num1_edit_text);
        num2EditText = findViewById(R.id.num2_edit_text);
        resultTextView = findViewById(R.id.result_text_view);

        Button addButton = findViewById(R.id.add_button);
        Button subtractButton = findViewById(R.id.subtract_button);
        Button multiplyButton = findViewById(R.id.multiply_button);
        Button divideButton = findViewById(R.id.divide_button);
        Button unbind = findViewById(R.id.exam5_3unbindServiceButton);
        Button bind = findViewById(R.id.exam5_3bindServiceButton);
        bind.setOnClickListener(v -> bindMathService());
        unbind.setOnClickListener(v -> unbindMathService());


        addButton.setOnClickListener(v -> performOperation("ADD"));

        subtractButton.setOnClickListener(v -> performOperation("SUBTRACT"));

        multiplyButton.setOnClickListener(v -> performOperation("MULTIPLY"));

        divideButton.setOnClickListener(v -> performOperation("DIVIDE"));

        // 绑定到 SimpleMathServiceDemo
        Intent serviceIntent = new Intent(this, SimpleMathServiceDemo.class);
        bindService(serviceIntent, mConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isBound) {
            unbindService(mConnection);
            isBound = false;
        }
    }

    private Context context = this;
    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            SimpleMathServiceDemo.LocalBinder binder = (SimpleMathServiceDemo.LocalBinder) service;
            msd = binder.getService();
            isBound = true;
            Toast.makeText(context, "成功绑定服务", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            msd = null;
            isBound = false;
        }
    };

    private void bindMathService() {
        Intent intent = new Intent(this, SimpleMathServiceDemo.class);
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }

    private void unbindMathService() {
        if (isBound) {
            Toast.makeText(this, "服务解除绑定", Toast.LENGTH_SHORT).show();
            unbindService(mConnection);
            isBound = false;
        }
    }

    private void performOperation(String operation) {
        if (!isBound) {
            Toast.makeText(this, "Service未绑定", Toast.LENGTH_SHORT).show();
            return;
        }

        String num1Str = num1EditText.getText().toString();
        String num2Str = num2EditText.getText().toString();

        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            Toast.makeText(this, "请输入两个数", Toast.LENGTH_SHORT).show();
            return;
        }

        double num1 = Double.parseDouble(num1Str);
        double num2 = Double.parseDouble(num2Str);

        double result = 0;
        switch (operation) {
            case "ADD":
                result = msd.add(num1, num2);
                break;
            case "SUBTRACT":
                result = msd.subtract(num1, num2);
                break;
            case "MULTIPLY":
                result = msd.multiply(num1, num2);
                break;
            case "DIVIDE":
                if (num2 == 0) {
                    Toast.makeText(this, "除数不能为0", Toast.LENGTH_SHORT).show();
                    return;
                }
                result = msd.divide(num1, num2);
                break;
        }

        resultTextView.setText(String.valueOf(result));
    }


}