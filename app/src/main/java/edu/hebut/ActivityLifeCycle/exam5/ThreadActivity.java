package edu.hebut.ActivityLifeCycle.exam5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.CopyOnWriteArrayList;

import edu.hebut.ActivityLifeCycle.R;

public class ThreadActivity extends AppCompatActivity  implements ThreadRandomServiceDemo.OnRandomNumberGeneratedListener{
    private LinearLayout randomNumberLayout;
    private Button startButton, stopButton;
    private int threadCount = 0;
    private final CopyOnWriteArrayList<Thread> test5_2ThreadList = new CopyOnWriteArrayList<>(); // 线程列表

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);


        randomNumberLayout = findViewById(R.id.random_number_layout);
        startButton = findViewById(R.id.exam5_2_start_button);
        stopButton = findViewById(R.id.exam5_2_stop_button);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addThreadRandomServiceDemo();
                Toast.makeText(ThreadActivity.this, "开始生成随机数", Toast.LENGTH_SHORT).show();

            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ThreadActivity.this, "已销毁所有线程", Toast.LENGTH_SHORT).show();
                stopAllThreadRandomServiceDemos();
            }
        });
    }

    private void addThreadRandomServiceDemo() {
        String threadName = "Thread " + (test5_2ThreadList.size() + 1); // 生成线程名称
        ThreadRandomServiceDemo ThreadRandomServiceDemo = new ThreadRandomServiceDemo(threadName);
        ThreadRandomServiceDemo.setOnRandomNumberGeneratedListener(this);
        Thread randomNumberThread = new Thread(ThreadRandomServiceDemo);
        randomNumberThread.start();
        test5_2ThreadList.add(randomNumberThread); // 添加线程到列表中
    }

    private void stopAllThreadRandomServiceDemos() {
        // 中断并等待每个线程结束
        for (Thread thread : test5_2ThreadList) {
            thread.interrupt();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 清空线程列表
        test5_2ThreadList.clear();
    }

    @Override
    public void onRandomNumberGenerated(final String threadName, final int randomNumber) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                TextView textView = new TextView(ThreadActivity.this);
                textView.setText(threadName + ": " + randomNumber);
                randomNumberLayout.addView(textView);
            }
        });
    }
}