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
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RemoteMath extends AppCompatActivity {

    private RemoteAIDL mathService;
    private boolean isBound = false;
    private EditText num1EditText, num2EditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remote_math);

        num1EditText = findViewById(R.id.num1_edit_text);
        num2EditText = findViewById(R.id.num2_edit_text);
        resultTextView = findViewById(R.id.result_text_view);

        Button addButton = findViewById(R.id.add_button);
        Button subtractButton = findViewById(R.id.subtract_button);
        Button multiplyButton = findViewById(R.id.multiply_button);
        Button divideButton = findViewById(R.id.divide_button);
        Button unbindButton = findViewById(R.id.Exam5_4unbindServiceButton);
        Button bindButton = findViewById(R.id.Exam5_4bindServiceButton);

        bindButton.setOnClickListener(v -> bindMathService());

        unbindButton.setOnClickListener(v -> unbindMathService());

        addButton.setOnClickListener(v -> performOperation("ADD"));

        subtractButton.setOnClickListener(v -> performOperation("SUBTRACT"));

        multiplyButton.setOnClickListener(v -> performOperation("MULTIPLY"));

        divideButton.setOnClickListener(v -> performOperation("DIVIDE"));
    }
    private void bindMathService() {
        Intent intent = new Intent(this, RemoteMathServiceDemo.class);
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
        Toast.makeText(this, "成功绑定服务", Toast.LENGTH_SHORT).show();
    }

    private void unbindMathService() {
        if (isBound) {
            unbindService(mConnection);
            isBound = false;
            Toast.makeText(this, "服务解除绑定", Toast.LENGTH_SHORT).show();
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
        try {
            switch (operation) {
                case "ADD":
                    result = mathService.add(num1, num2);
                    break;
                case "SUBTRACT":
                    result = mathService.subtract(num1, num2);
                    break;
                case "MULTIPLY":
                    result = mathService.multiply(num1, num2);
                    break;
                case "DIVIDE":
                    result = mathService.divide(num1, num2);
                    break;
            }
            resultTextView.setText(String.valueOf(result));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mathService = RemoteAIDL.Stub.asInterface(service);
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mathService = null;
            isBound = false;
        }
    };
}