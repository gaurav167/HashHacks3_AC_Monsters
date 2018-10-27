package ws.wolfsoft.cryptostar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;

import Adapter.ItemData;
import Adapter.ItemDataClass;
import Adapter.SpinnerClassAdapter;
import Adapter.SpinnerCousineAdapter;

public class Payment_Details extends AppCompatActivity {

    String name;
    ImageView imageView;
    customfonts.MyTextView_Roboto_Medium nextStepButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment__details);
        Intent intent = getIntent();
        imageView = findViewById(R.id.nameOfP);
        nextStepButton = findViewById(R.id.nextButton);

        if (intent.getStringExtra("name").equals("rupay")) {
            imageView.setImageResource(R.drawable.rupay__);
        } else if (intent.getStringExtra("name").equals("visa")) {
            imageView.setImageResource(R.drawable.ic_visa);
//            imageView.setImageResource(getDrawable(R.id));
//            imageView.setImageResource(R.id.ic_visa);
        } else {
            imageView.setImageResource(R.drawable.ic_mastercard);
//            imageView.setImageResource(R.id.ic_mastercard);

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
                Log.d("MYT", "GOING NEXT");
            }
        });
    }
}
