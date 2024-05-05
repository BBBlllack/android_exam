package edu.hebut.ActivityLifeCycle.exam5;

import java.util.Random;

public class ThreadRandomServiceDemo implements Runnable {

    private volatile boolean isRunning = false;
    private Random random = new Random();
    private String threadName;
    private OnRandomNumberGeneratedListener listener;

    public interface OnRandomNumberGeneratedListener {
        void onRandomNumberGenerated(String threadName, int randomNumber);
    }

    public ThreadRandomServiceDemo(String threadName) {
        this.threadName = threadName;
    }

    public void setOnRandomNumberGeneratedListener(OnRandomNumberGeneratedListener listener) {
        this.listener = listener;
    }

    @Override
    public void run() {
        isRunning = true;
        while (isRunning) {
            int randomNumber = random.nextInt(100); // 产生0到99的随机数
            if (listener != null) {
                listener.onRandomNumberGenerated(threadName, randomNumber);
            }
            try {
                Thread.sleep(1000); // 每隔一秒产生一个随机数
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void stop() {
        isRunning = false;
    }
}
