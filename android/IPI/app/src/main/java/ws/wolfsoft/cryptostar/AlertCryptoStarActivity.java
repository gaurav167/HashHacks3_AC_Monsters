package ws.wolfsoft.cryptostar;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import Adapter.CategoryPagerAdapterMyBooking;

public class AlertCryptoStarActivity extends AppCompatActivity implements View.OnClickListener {


    ImageView wallet_img, chart_img, trading_img, alert_img, setting_img;
    TextView wallet_txt, chart_txt, trading_txt, alert_txt, setting_txt;
    LinearLayout linear1, linear2, linear3, linear4, linear5;


    private TabLayout tabLayout;
    private Typeface mTypeface;
    private Typeface mTypefaceBold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_crypto_star);


        tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_btc));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_etherium));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_ripple));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_litecoin));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_monero));



        final ViewPager viewPager1 = (ViewPager) findViewById(R.id.pager);
        CategoryPagerAdapterMyBooking adapter = new CategoryPagerAdapterMyBooking(getSupportFragmentManager(), 5);
        viewPager1.setAdapter(adapter);
        viewPager1.setOffscreenPageLimit(2);
        viewPager1.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager1.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });



        wallet_img = findViewById(R.id.wallet_img);
        chart_img = findViewById(R.id.chart_img);
        trading_img = findViewById(R.id.trading_img);
        alert_img = findViewById(R.id.alert_img);
        setting_img = findViewById(R.id.setting_img);

        wallet_txt = findViewById(R.id.wallet_txt);
        chart_txt = findViewById(R.id.chart_txt);
        trading_txt = findViewById(R.id.trading_txt);
        alert_txt = findViewById(R.id.alert_txt);
        setting_txt = findViewById(R.id.setting_txt);

        linear1 = findViewById(R.id.linear1);
        linear2 = findViewById(R.id.linear2);
        linear3 = findViewById(R.id.linear3);
        linear4 = findViewById(R.id.linear4);
        linear5 = findViewById(R.id.linear5);


        linear1.setOnClickListener(this);
        linear2.setOnClickListener(this);
        linear3.setOnClickListener(this);
        linear4.setOnClickListener(this);
        linear5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.linear1:

                wallet_img.setImageResource(R.drawable.ic_wallet_coloring);
                chart_img.setImageResource(R.drawable.ic_chart_gray);
                trading_img.setImageResource(R.drawable.ic_trading_gray);
                alert_img.setImageResource(R.drawable.ic_alert_gray);
                setting_img.setImageResource(R.drawable.ic_settings_gray);


                wallet_txt.setTextColor(Color.parseColor("#141a22"));
                chart_txt.setTextColor(Color.parseColor("#a6b0b9"));
                trading_txt.setTextColor(Color.parseColor("#a6b0b9"));
                alert_txt.setTextColor(Color.parseColor("#a6b0b9"));
                setting_txt.setTextColor(Color.parseColor("#a6b0b9"));

                break;


            case R.id.linear2:

                wallet_img.setImageResource(R.drawable.ic_wallet_gray);
                chart_img.setImageResource(R.drawable.ic_chart_coloring);
                trading_img.setImageResource(R.drawable.ic_trading_gray);
                alert_img.setImageResource(R.drawable.ic_alert_gray);
                setting_img.setImageResource(R.drawable.ic_settings_gray);


                wallet_txt.setTextColor(Color.parseColor("#a6b0b9"));
                chart_txt.setTextColor(Color.parseColor("#141a22"));
                trading_txt.setTextColor(Color.parseColor("#a6b0b9"));
                alert_txt.setTextColor(Color.parseColor("#a6b0b9"));
                setting_txt.setTextColor(Color.parseColor("#a6b0b9"));


                break;

            case R.id.linear3:

                wallet_img.setImageResource(R.drawable.ic_wallet_gray);
                chart_img.setImageResource(R.drawable.ic_chart_gray);
                trading_img.setImageResource(R.drawable.ic_trading_coloring);
                alert_img.setImageResource(R.drawable.ic_alert_gray);
                setting_img.setImageResource(R.drawable.ic_settings_gray);


                wallet_txt.setTextColor(Color.parseColor("#a6b0b9"));
                chart_txt.setTextColor(Color.parseColor("#a6b0b9"));
                trading_txt.setTextColor(Color.parseColor("#141a22"));
                alert_txt.setTextColor(Color.parseColor("#a6b0b9"));
                setting_txt.setTextColor(Color.parseColor("#a6b0b9"));

                break;

            case R.id.linear4:

                wallet_img.setImageResource(R.drawable.ic_wallet_gray);
                chart_img.setImageResource(R.drawable.ic_chart_gray);
                trading_img.setImageResource(R.drawable.ic_trading_gray);
                alert_img.setImageResource(R.drawable.ic_alert_coloring);
                setting_img.setImageResource(R.drawable.ic_settings_gray);



                wallet_txt.setTextColor(Color.parseColor("#a6b0b9"));
                chart_txt.setTextColor(Color.parseColor("#a6b0b9"));
                trading_txt.setTextColor(Color.parseColor("#a6b0b9"));
                alert_txt.setTextColor(Color.parseColor("#141a22"));
                setting_txt.setTextColor(Color.parseColor("#a6b0b9"));

                break;


            case R.id.linear5:

                wallet_txt.setTextColor(Color.parseColor("#a6b0b9"));
                chart_txt.setTextColor(Color.parseColor("#a6b0b9"));
                trading_txt.setTextColor(Color.parseColor("#a6b0b9"));
                alert_txt.setTextColor(Color.parseColor("#a6b0b9"));
                setting_txt.setTextColor(Color.parseColor("#141a22"));

                break;

        }
    }
}
