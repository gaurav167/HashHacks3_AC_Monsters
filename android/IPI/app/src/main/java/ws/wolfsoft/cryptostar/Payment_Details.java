package ws.wolfsoft.cryptostar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import Adapter.ItemData;
import Adapter.ItemDataClass;
import Adapter.SpinnerClassAdapter;
import Adapter.SpinnerCousineAdapter;
import ModelClass.Transaction;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Payment_Details extends AppCompatActivity {

    String name;
    ImageView imageView;
    customfonts.MyTextView_Roboto_Medium nextStepButton;
    Transaction transaction;
    customfonts.EditText_Roboto_Regular reciverCityView;
    customfonts.EditText_Roboto_Regular reciverNameView;
    customfonts.EditText_Roboto_Regular amountView;
    public static String URL = "https://guarded-basin-93568.herokuapp.com";

    public static final MediaType JSON = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment__details);
        Intent intent = getIntent();
        transaction = new Transaction();

        android.text.format.DateFormat df = new android.text.format.DateFormat();
        String s = String.valueOf(df.format("dd/MM/yy hh:mm", new java.util.Date()));
        transaction.timeFormat = s;


        imageView = findViewById(R.id.nameOfP);
        nextStepButton = findViewById(R.id.nextButton);
        reciverCityView = findViewById(R.id.recieverCity);
        amountView = findViewById(R.id.amountBox);
        reciverNameView = findViewById(R.id.recieverName);


        if (intent.getStringExtra("name").equals("rupay")) {
            imageView.setImageResource(R.drawable.rupay__);
        } else if (intent.getStringExtra("name").equals("visa")) {
            imageView.setImageResource(R.drawable.ic_visa);
        } else {
            imageView.setImageResource(R.drawable.ic_mastercard);
        }

        ArrayList<ItemData> list = new ArrayList<>();

        list.add(new ItemData("Jan"));
        list.add(new ItemData("Feb"));
        list.add(new ItemData("Mar"));
        list.add(new ItemData("Apr"));
        list.add(new ItemData("May"));
        list.add(new ItemData("Jun"));
        list.add(new ItemData("Jul"));
        list.add(new ItemData("Aug"));
        list.add(new ItemData("Sep"));
        list.add(new ItemData("Oct"));
        list.add(new ItemData("Nov"));
        list.add(new ItemData("Dec"));
        Spinner sp = (Spinner) findViewById(R.id.spinner_month);
        SpinnerCousineAdapter adapter = new SpinnerCousineAdapter(this, R.layout.spinner_selecting_adults, R.id.data, list);
        sp.setAdapter(adapter);

        ArrayList<ItemDataClass> lists = new ArrayList<>();


        lists.add(new ItemDataClass("2018"));
        lists.add(new ItemDataClass("2019"));
        lists.add(new ItemDataClass("2020"));
        lists.add(new ItemDataClass("2021"));
        lists.add(new ItemDataClass("2022"));
        lists.add(new ItemDataClass("2023"));
        lists.add(new ItemDataClass("2024"));
        lists.add(new ItemDataClass("2025"));
        lists.add(new ItemDataClass("2026"));
        lists.add(new ItemDataClass("2027"));
        lists.add(new ItemDataClass("2028"));
        lists.add(new ItemDataClass("2029"));
        lists.add(new ItemDataClass("2030"));


        Spinner spinner = (Spinner) findViewById(R.id.spinner_year);
        SpinnerClassAdapter adapters = new SpinnerClassAdapter(this, R.layout.spinner_selecting_adults, R.id.data, lists);
        spinner.setAdapter(adapters);

        nextStepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction.recieverName = reciverNameView.getText().toString();
                transaction.recieverLocation = reciverCityView.getText().toString();
                transaction.amount = Float.parseFloat(amountView.getText().toString());
                if (transaction.amount > 5000.00) {
                    transaction.amountRange = "High";
                } else {
                    transaction.amountRange = "Low";
                }
                transaction.cardType = "Debit";
                transaction.currency = "INR";
                transaction.senderLocation = "Washington";
                transaction.typeOfTransact = "deposit";
                android.text.format.DateFormat df = new android.text.format.DateFormat();
                String s = String.valueOf(df.format("dd/MM/yy hh:mm", new java.util.Date()));
                transaction.timeFormat = s;

                JSONObject object = JSONIFY(transaction);
                Log.d("MY__PAYMENT_DATA", object.toString());
                String toSend = URL + "/ipi/pay/";

                postRequest(toSend, object);
            }
        });
    }


    void postRequest(String url, JSONObject object) {

        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(JSON, object.toString());

        final Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();


        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("MY__FAILURE", e.toString());
                call.cancel();

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str = response.body().string();
                Log.d("MY__PAYMENT_RESPONSE", str);

                boolean isAllowedAccess = false;
                if (str.charAt(str.length() - 6) == 'T') {
                    isAllowedAccess = true;
                }

                if (isAllowedAccess) {
                    Intent intent = new Intent(Payment_Details.this, PaymentRecieptActivity.class);
                    intent.putExtra("state", "success");
                    intent.putExtra("amount", transaction.amount);
                    intent.putExtra("reciever", transaction.recieverName);
                    intent.putExtra("timestamp", transaction.timeFormat);
                    intent.putExtra("type", transaction.typeOfTransact);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(Payment_Details.this, PaymentRecieptActivity.class);
                    intent.putExtra("state", "unsuc");
                    intent.putExtra("amount", transaction.amount);
                    intent.putExtra("reciever", transaction.recieverName);
                    intent.putExtra("timestamp", transaction.timeFormat);
                    intent.putExtra("type", transaction.typeOfTransact);
                    startActivity(intent);
                }
            }
        });
    }

    JSONObject JSONIFY(Transaction transaction) {
        JSONObject object = new JSONObject();

        try {
            object.put("amtRange", transaction.amountRange.toString());
            object.put("card_type", transaction.cardType.toString());
            object.put("currency", transaction.currency);
            object.put("s_location", transaction.senderLocation);
            object.put("reciever", transaction.recieverName);
            object.put("r_location", transaction.recieverLocation);
            object.put("t_type", transaction.typeOfTransact);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return object;
    }
}
