package vn.hueic.student.maivan.dat.newsfeed.ui.newsdetail;

import android.content.Intent;
import android.os.BaseBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import vn.hueic.student.maivan.dat.newsfeed.AppContacts;
import vn.hueic.student.maivan.dat.newsfeed.R;
import vn.hueic.student.maivan.dat.newsfeed.ui.base.BaseActivity;

public class NewsDetailActivity extends BaseActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_detail);
        webView = findViewById(R.id.webview);
        Intent intent = getIntent();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(intent.getStringExtra(AppContacts.KEY_LINK));
    }
}
