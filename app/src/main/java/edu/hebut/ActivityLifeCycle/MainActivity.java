package edu.hebut.ActivityLifeCycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import edu.hebut.ActivityLifeCycle.exam4.IntentResolutionDemo;

public class MainActivity extends AppCompatActivity {

//    private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("210236 申洪建","生命周期 onCreate");
        findViewById(R.id.jump_IntentResolutionDemo).setOnClickListener(v -> {
            Log.e ("210236", "click...");
            Intent intent = new Intent(this, IntentResolutionDemo.class);
            // 创建一个 URI 对象
            Uri uri = Uri.parse("https://hebut.edu.cn/");
            // 将 URI 数据附加到 Intent 中
            intent.setData(uri);
            intent.setAction("android.intent.action.VIEW");
            startActivity(intent);
        });

//        webView = findViewById(R.id.webView);
//        // 启用 JavaScript
//        webView.getSettings().setJavaScriptEnabled(true);

// 支持缩放控制
//        webView.getSettings().setSupportZoom(true);
//        webView.getSettings().setBuiltInZoomControls(true);

// 支持加载图片资源
//        webView.getSettings().setLoadsImagesAutomatically(true);

// 支持自动加载 JavaScript 弹窗
//        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);

        // 设置 WebViewClient 以便在 WebView 内加载网页
//        webView.setWebViewClient(new WebViewClient(){
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
//                if (request.getUrl().toString().contains("localhost")){
//                     拦截重定向, 跳转主页activity
//                    Toast.makeText(MainActivity.this,"被拦截啦!",Toast.LENGTH_SHORT).show();
//                    return true;
//                }
//                Toast.makeText(MainActivity.this,request.getUrl().toString(),Toast.LENGTH_SHORT).show();
//                return false;
            }
//        });
        // 加载网页
//        webView.loadUrl("http://49.232.244.90:8082");
//        webView.loadUrl("https://gitee.com/oauth/authorize?client_id=9525505dca256e3d45533fa95c28a86c00f219121dcf2fdd5a5da1aceb17888d&redirect_uri=http://localhost:8080/user/auth/success&response_type=code");
//        webView.loadUrl("http://192.168.43.154:9091/flask/word/preimg");

//    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.w("210236 申洪建","生命周期 onStart");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("210236 申洪建","生命周期 OnPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("210236 申洪建","生命周期 onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("210236 申洪建","生命周期 onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("210236 申洪建","生命周期 onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("210236 申洪建","生命周期 onDestroy");
    }
}