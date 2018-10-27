package ws.wolfsoft.cryptostar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import java.util.ArrayList;

public class PaymentRecieptActivity extends AppCompatActivity {

    private ArrayList<ModelClass> homeListModelClassArrayList;
    private RecyclerView recyclerView;
    private RecyclerAdapter mAdapter;
    ImageView tvimageView;
    customfonts.MyTextView_Roboto_Regular tvtextView;
    customfonts.MyTextView_Roboto_Regular amountTxtView;
    double amount;
    String timeStamp;
    String typeOfTransact;
    String recieverName;
    customfonts.MyTextView_Roboto_Medium totalAmntView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reciept_payment);
        Intent intent = getIntent();
        amount = intent.getDoubleExtra("amount", 100.00);
        recieverName = intent.getStringExtra("reciever");
        timeStamp = intent.getStringExtra("timestamp");

        typeOfTransact = intent.getStringExtra("type");

        tvimageView = findViewById(R.id.transactionStateIV);
        totalAmntView = findViewById(R.id.totalAmnt);
        amountTxtView = findViewById(R.id.amountTxtViews);
        tvtextView = findViewById(R.id.transactionState);

        amountTxtView.setText(String.valueOf(amount));
        totalAmntView.setText(String.valueOf(amount));

        if (intent.getStringExtra("state").equals("success")) {

            Log.d("MY__", "Succcess");
        } else {

            tvtextView.setText("Transaction Unsuccessful");
            tvimageView.setImageResource(R.drawable.error);

            Log.d("MY__", "Failure");
        }
        String iteamName[] = {"Reciever", "Time", "Transaction Type"};
        String price[] = {recieverName, timeStamp, typeOfTransact};
        recyclerView = findViewById(R.id.recyclerview);
        homeListModelClassArrayList = new ArrayList<>();

        for (int i = 0; i < iteamName.length; i++) {
            ModelClass beanClassForRecyclerView_contacts = new ModelClass(iteamName[i], price[i]);
            homeListModelClassArrayList.add(beanClassForRecyclerView_contacts);
        }
        mAdapter = new RecyclerAdapter(PaymentRecieptActivity.this, homeListModelClassArrayList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(PaymentRecieptActivity.this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

    }
}
