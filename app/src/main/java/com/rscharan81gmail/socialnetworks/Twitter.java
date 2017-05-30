package com.rscharan81gmail.socialnetworks;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class Twitter extends Activity {
    private WebView mywebview3;
    private InterstitialAd interstitial;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter);
        mywebview3=(WebView)findViewById(R.id.webView3);
        WebSettings webSettings=mywebview3.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mywebview3.loadUrl("https://www.twitter.com");
        mywebview3.setWebViewClient(new WebViewClient());
        MobileAds.initialize(getApplicationContext(),
                "ca-app-pub-6802224915723701~9335982875");
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        adRequest = new AdRequest.Builder().build();
        interstitial = new InterstitialAd(Twitter.this);
        interstitial.setAdUnitId(getString(R.string.admob_interstitial_id));

        interstitial.loadAd(adRequest);

        interstitial.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                displayInterstitial();
            }
        });
    }


    public void displayInterstitial() {

        if (interstitial.isLoaded()) {
            interstitial.show();
        }



    }

    @Override
    public void onBackPressed() {
        if (mywebview3.canGoBack())  {
            mywebview3.goBack();
        }else {

        }
        super.onBackPressed();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_twitter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
