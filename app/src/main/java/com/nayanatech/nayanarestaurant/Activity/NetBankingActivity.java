package com.nayanatech.nayanarestaurant.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.nayanatech.nayanarestaurant.R;

public class NetBankingActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_banking);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        webView = (WebView) findViewById(R.id.netBanking_webView);

        WebSettings webSettings = webView.getSettings();
        WebChromeClient webChromeClient=new WebChromeClient();
        webView.setWebChromeClient(webChromeClient);
        webSettings.setJavaScriptEnabled(true);

        webView.loadUrl("https://infinity.icicibank.com/corp/AuthenticationController?FORMSGROUP_ID__=AuthenticationFG&__START_TRAN_FLAG__=Y&FG_BUTTONS__=LOAD&ACTION.LOAD=Y&AuthenticationFG.LOGIN_FLAG=1&BANK_ID=ICI&ACCESS_DEV=WAP&_ga=1.7652858.97892247.1402396153");

    }
}
