package ws.wolfsoft.cryptostar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Payment_method extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout americanExpress, visa, mastercard;
    public ImageView rightmark1, rightmark2, rightmark3;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_method);
        context = this;

        americanExpress = findViewById(R.id.americanExpress);
        visa = findViewById(R.id.visa);
        mastercard = findViewById(R.id.mastercard);
        rightmark1 = findViewById(R.id.rightmark1);
        rightmark2 = findViewById(R.id.rightmark2);
        rightmark3 = findViewById(R.id.rightmark3);

        americanExpress.setOnClickListener(this);
        visa.setOnClickListener(this);
        mastercard.setOnClickListener(this);


    }

    public void onClick(View view) {
        Intent intent = new Intent(context, Payment_method.class);
        switch (view.getId()) {
            case R.id.americanExpress:

                rightmark1.setImageResource(R.drawable.ic_right);
                rightmark2.setImageResource(R.drawable.ic_round);
                rightmark3.setImageResource(R.drawable.ic_round);
                intent = new Intent(context, Payment_Details.class);
                intent.putExtra("name", "rupay");
                break;

            case R.id.visa:

                rightmark1.setImageResource(R.drawable.ic_round);
                rightmark2.setImageResource(R.drawable.ic_right);
                rightmark3.setImageResource(R.drawable.ic_round);
                intent = new Intent(context, Payment_Details.class);
                intent.putExtra("name", "visa");
                break;

            case R.id.mastercard:

                rightmark1.setImageResource(R.drawable.ic_round);
                rightmark2.setImageResource(R.drawable.ic_round);
                rightmark3.setImageResource(R.drawable.ic_right);
                intent = new Intent(context, Payment_Details.class);
                intent.putExtra("name", "mastercard");
                break;

        }
        intent.putExtra("reciever", "Minkush");

        startActivity(intent);
    }

    private void changeBackground(int i, LinearLayout americanExpress) {
    }
}
