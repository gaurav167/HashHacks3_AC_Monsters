package ws.wolfsoft.cryptostar;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import Adapter.CryptoListRecycleAdapter;
import Adapter.WalletRecycleAdapter;
import ModelClass.CryptoListModelClass;
import ModelClass.WalletModelClass;

public class WalletCryptoStarActivity extends AppCompatActivity implements View.OnClickListener{



    ImageView wallet_img,chart_img,trading_img,alert_img,setting_img;
    TextView wallet_txt,chart_txt,trading_txt,alert_txt,setting_txt;
    LinearLayout linear1,linear2,linear3,linear4,linear5;


    private ArrayList<WalletModelClass> walletModelClasses;
    private RecyclerView recyclerView;
    private WalletRecycleAdapter bAdapter;


    private String title[] = {"Bitcoin","Ethereum","Ripple","LiteCoin","Bitcoin"};
    private Integer icon[]={ R.drawable.ic_btc,R.drawable.ic_etherium,R.drawable.ic_ripple,R.drawable.ic_litecoin,R.drawable.ic_btc};
    private String icon_type[] = {"BTC","ETH","XRP","LTC","BTC"};
    private String percentage[] = {"20%","5%","5%","18%","25%"};
    private Integer arrow[] = {R.drawable.ic_arrowup,R.drawable.ic_arrowup,R.drawable.ic_arrowdown,R.drawable.ic_arrowdown,R.drawable.ic_arrowup};
    private String price[] = {"$5,291.20","$2,213.04","$4,831.69","$2,529.21","$5,291.20"};
    private String value[] = {"0.592 BTC","2.624 ETH","2.624 XRP","2.624 XRP","0.592 BTC"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet_crypto_star);




        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(WalletCryptoStarActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        walletModelClasses = new ArrayList<>();

        for (int i = 0; i < title.length; i++) {
            WalletModelClass beanClassForRecyclerView_contacts = new WalletModelClass(title[i],icon[i],icon_type[i],
                    percentage[i],arrow[i],price[i],value[i]);
            walletModelClasses.add(beanClassForRecyclerView_contacts);
        }
        bAdapter = new WalletRecycleAdapter(WalletCryptoStarActivity.this,walletModelClasses);
        recyclerView.setAdapter(bAdapter);





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
