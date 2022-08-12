package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView webView = findViewById(R.id.WebViewer);
        WebSettings webSettings = webView.getSettings();
        webSettings.setSupportZoom(true);

        webView.loadUrl("file:///android_asset/webview.html");
        webSettings.setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new WebAppInterface(this), "android");
    }
    public class WebAppInterface {
        Context mContext;
        int a = 0;

        /** Instantiate the interface and set the context */
        WebAppInterface(Context c) {
            mContext = c;
        }

        /** Show a toast from the web page */
        @JavascriptInterface
        public void showToast(String toast) {
            Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
        }
        @JavascriptInterface
        public void UpaButton(){
            a++;
            Toast.makeText(mContext, "t"+a, Toast.LENGTH_SHORT).show();
        }
    }

}