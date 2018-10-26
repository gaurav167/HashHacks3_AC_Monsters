package ws.wolfsoft.cryptostar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import ws.wolfsoft.cryptostar.R;

public class Payment_method extends AppCompatActivity implements View.OnClickListener{

    private LinearLayout americanExpress, visa, mastercard;
    public ImageView rightmark1,rightmark2,rightmark3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_method);

        americanExpress = (LinearLayout) findViewById(R.id.americanExpress);
        visa = (LinearLayout) findViewById(R.id.visa);
        mastercard = (LinearLayout) findViewById(R.id.mastercard);
        rightmark1 = (ImageView) findViewById(R.id.rightmark1);
        rightmark2 = (ImageView) findViewById(R.id.rightmark2);
        rightmark3 = (ImageView) findViewById(R.id.rightmark3);

        americanExpress.setOnClickListener(this);
        visa.setOnClickListener(this);
        mastercard.setOnClickListener(this);


    }

    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.americanExpress:

                rightmark1.setImageResource(R.drawable.ic_right);
                rightmark2.setImageResource(R.drawable.ic_round);
                rightmark3.setImageResource(R.drawable.ic_round);
                break;

            case R.id.visa:

                rightmark1.setImageResource(R.drawable.ic_round);
                rightmark2.setImageResource(R.drawable.ic_right);
                rightmark3.setImageResource(R.drawable.ic_round);
                break;

            case R.id.mastercard:

                rightmark1.setImageResource(R.drawable.ic_round);
                rightmark2.setImageResource(R.drawable.ic_round);
                rightmark3.setImageResource(R.drawable.ic_right);
                break;



        }
    }

    private void changeBackground(int i, LinearLayout americanExpress) {
    }
}
