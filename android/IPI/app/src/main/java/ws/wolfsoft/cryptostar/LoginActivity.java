package ws.wolfsoft.cryptostar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import ModelClass.CharacterTime;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class LoginActivity extends AppCompatActivity {

    customfonts.TextViewSFProDisplayRegular signUpLink;
    customfonts.EditText_SF_Pro_Display_Medium emailId;
    customfonts.Button_SF_Pro_Display_Semibold okButton;
    customfonts.EditText_SF_Pro_Display_Medium pswrd;
    ArrayList<CharacterTime> emailStack, pwdStack;
    boolean isAllowedAccess;
    public static String URL = "https://guarded-basin-93568.herokuapp.com";

    Context context;
    public static final MediaType JSON = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        signUpLink = findViewById(R.id.signUpLink);
        okButton = findViewById(R.id.bottom_btn);
        emailId = findViewById(R.id.emailId);
        context = this;
        pswrd = findViewById(R.id.passwrdText);
        emailStack = new ArrayList<>();
        isAllowedAccess = false;
        pwdStack = new ArrayList<>();

        String currentString = "";
        final long[] previousTime = {-1L};
        final long[] previousTimePwd = {-1L};
        emailId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String temp = charSequence.toString();
                if (temp.isEmpty()) {
                    return;
                }
                char newchar = temp.charAt(temp.length() - 1);
                long currentTime = System.currentTimeMillis();
                if (previousTime[0] == -1) {
                    previousTime[0] = currentTime;
                }
                emailStack.add(new CharacterTime(newchar, currentTime - previousTime[0]));
                previousTime[0] = currentTime;
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        pswrd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String temp = charSequence.toString();
                if (temp.isEmpty()) {
                    return;
                }
                char newchar = temp.charAt(temp.length() - 1);
                long currentTime = System.currentTimeMillis();
                if (previousTimePwd[0] == -1) {
                    previousTimePwd[0] = currentTime;
                }
                pwdStack.add(new CharacterTime((char) newchar, currentTime - previousTimePwd[0]));
                previousTimePwd[0] = currentTime;

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

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

                JSONObject mainObject = new JSONObject();

                JSONArray emailJSONArr = new JSONArray();
                JSONArray passwordJSONArr = new JSONArray();
                for (int i = 0; i < emailStack.size(); i++) {
                    JSONObject object = new JSONObject();
                    try {
                        object.put("character", (char) emailStack.get(i).c);
                        object.put("time", emailStack.get(i).timeStamp);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    emailJSONArr.put(object);
                }
                for (int i = 0; i < pwdStack.size(); i++) {
                    JSONObject object = new JSONObject();
                    try {
                        object.put("character", (char) pwdStack.get(i).c);
                        object.put("time", pwdStack.get(i).timeStamp);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    passwordJSONArr.put(object);
                }

                try {
                    mainObject.put("user", emailJSONArr.toString());
                    mainObject.put("pass", passwordJSONArr.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.d("MYTA", mainObject.toString());
                String toSend = URL + "/ipi/login/";
//                String toSend = URL + "/ipi/train/";
                postRequest(toSend, mainObject);
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
                Log.d("MYTAG_FAILURE", e.toString());
                call.cancel();

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str = response.body().string();
                Log.d("MYTAG_BODY", str);

                if (str.charAt(str.length() - 6) == 'T') {
                    isAllowedAccess = true;
                }

                if (isAllowedAccess) {
                    Intent intent = new Intent(LoginActivity.this, Payment_method.class);
                    startActivity(intent);
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            Toast.makeText(context, "SUCCESS!", Toast.LENGTH_LONG).show();
//                        }
//                    });
                } else {
                    Intent intent = new Intent(LoginActivity.this, Payment_method.class);
                    startActivity(intent);
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            Toast.makeText(context, "FAILURE!", Toast.LENGTH_LONG).show();
//                        }
//                    });
                }
            }
        });
    }

}
