package ws.wolfsoft.cryptostar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import Adapter.CryptoListRecycleAdapter;
import ModelClass.CryptoListModelClass;

public class CryptoListActivity extends AppCompatActivity {

    private ArrayList<CryptoListModelClass> cryptoListModelClasses;
    private RecyclerView recyclerView;
    private CryptoListRecycleAdapter bAdapter;


    private  String title[] = {"1.SplashScreenActivity","2.LoginActivity","3.SignupActivity","4.CreatePinActivity","" +
            "5.TradCryptoStarActivity","6.WalletCryptoStarActctivity","7.AlertCryptoStarActivity","8.ChartCryptoStarActivity"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crypto_list);



        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(CryptoListActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        cryptoListModelClasses = new ArrayList<>();

        for (int i = 0; i < title.length; i++) {
            CryptoListModelClass beanClassForRecyclerView_contacts = new CryptoListModelClass(title[i]);
            cryptoListModelClasses.add(beanClassForRecyclerView_contacts);
        }
        bAdapter = new CryptoListRecycleAdapter(CryptoListActivity.this,cryptoListModelClasses);
        recyclerView.setAdapter(bAdapter);

    }
}
