package ws.wolfsoft.cryptostar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    customfonts.TextViewSFProDisplayRegular signUpLink;
    customfonts.EditText_SF_Pro_Display_Medium emailId;
    customfonts.Button_SF_Pro_Display_Semibold okButton;
    customfonts.EditText_SF_Pro_Display_Medium pswrd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        signUpLink = findViewById(R.id.signUpLink);
        okButton = findViewById(R.id.bottom_btn);
        emailId = findViewById(R.id.emailId);
        pswrd = findViewById(R.id.passwrdText);

        signUpLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = String.valueOf(emailId.getText());
                String password = String.valueOf(pswrd.getText());
//                Log.d("CLICKED!", mail+password);

                if (isAuthenticated(mail, password)) {
                    Intent intent = new Intent(LoginActivity.this, WalletCryptoStarActivity.class);
                    startActivity(intent);
                }
            }
        });
    }


    boolean isAuthenticated(String emailId, String password) {

        return true;
    }
}
