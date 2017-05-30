package com.rscharan81gmail.socialnetworks;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends Activity {
    private AdView mAdView;

    private InterstitialAd interstitial;

    public Button but1;

    public void init() {
        but1 = (Button) findViewById(R.id.but1);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy = new Intent(MainActivity.this, Facebook.class);

                startActivity(toy);
            }
        });
    }


    public Button but2;

    public void init1() {
        but2 = (Button) findViewById(R.id.but2);
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy = new Intent(MainActivity.this, Google.class);

                startActivity(toy);
            }
        });


    }

    public Button but3;

    public void init2() {
        but3 = (Button) findViewById(R.id.but3);
        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy = new Intent(MainActivity.this, Twitter.class);

                startActivity(toy);
            }
        });
    }


    public Button but4;

    public void init3() {
        but4 = (Button) findViewById(R.id.but4);
        but4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy = new Intent(MainActivity.this, Blogger.class);
                startActivity(toy);
            }
        });
    }


    public Button but5;

    public void init4() {
        but5 = (Button) findViewById(R.id.but5);
        but5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy = new Intent(MainActivity.this, Youtube.class);
                startActivity(toy);
            }
        });
    }
    public Button but6;

    public void init5() {
        but6 = (Button) findViewById(R.id.but6);
        but6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy = new Intent(MainActivity.this, Instagram.class);
                startActivity(toy);
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        init1();
        init2();
        init3();
        init4();
        init5();

        MobileAds.initialize(getApplicationContext(),
                "ca-app-pub-6802224915723701~9335982875");
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        adRequest = new AdRequest.Builder().build();
        interstitial = new InterstitialAd(MainActivity.this);
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






    public void but1(View View){
        Intent browserIntent1=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/"));
        startActivity(browserIntent1);
    }


    public void but2(View View){
        Intent browserIntent2=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.google.com/"));
        startActivity(browserIntent2);
    }


    public void but3(View View){
        Intent browserIntent3=new Intent(Intent.ACTION_VIEW,Uri.parse("https://twitter.com/"));
        startActivity(browserIntent3);
    }



    public void but4 (View View){
        Intent browserIntent4=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.blogger.com"));
        startActivity(browserIntent4);
    }

    public void but5 (View View){
        Intent browserIntent5=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com"));
        startActivity(browserIntent5);
    }

    public void but6 (View View){
        Intent browserIntent6=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.instagram.com"));
        startActivity(browserIntent6);
    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
