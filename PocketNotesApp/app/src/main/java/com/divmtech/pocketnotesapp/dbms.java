package com.divmtech.pocketnotesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class dbms extends AppCompatActivity {
    WebView wb;
    ProgressBar pg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);
        wb=(WebView)findViewById(R.id.webview);
        pg=(ProgressBar)findViewById(R.id.prog1);
        wb.getSettings().setJavaScriptEnabled(true);
        wb.getSettings().setSupportZoom(true);

        wb.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                pg.setVisibility(View.VISIBLE);
                setTitle("Wait Pdf file is loading");

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                pg.setVisibility(View.GONE);
                setTitle("Done");
            }
        });
        String pdf = "http://www.mahagurustudyhub.com/mt/notes/DBMS.pdf";
        wb.loadUrl("http://drive.google.com/viewerng/viewer?embedded=true&url=" + pdf);
    }
}
