package ws.wolfsoft.cryptostar;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import customfonts.Button_SF_Pro_Display_Semibold;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SplashScreenActivity extends AppCompatActivity {

    Button_SF_Pro_Display_Semibold button;
    RelativeLayout relativeLayout;
    float prevX, prevY;
    private float x1, x2;
    private Paint circlePaint;
    public static String URL = "https://guarded-basin-93568.herokuapp.com";

    Context context;
    public static final MediaType JSON = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
    private Path circlePath;
    static final int MIN_DISTANCE = 150;
    public float x_init, y_init, x_fin, y_fin;
    long timeTaken, length;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        relativeLayout = findViewById(R.id.rootLayout);
        context = this;
        prevX = -1;
        prevY = -1;
        length = 0;
        circlePaint = new Paint();
        circlePath = new Path();
        circlePaint.setAntiAlias(true);
        circlePaint.setColor(Color.BLUE);
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setStrokeWidth(20f);

    }

    private float X, Y;
    float TOUCH_TOLERANCE = 0.0f;


    private void touch_start(float x, float y) {
        X = x;
        Y = y;
    }

    private void touch_move(float x, float y) {
        float dx = Math.abs(x - X);
        float dy = Math.abs(y - Y);
        if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {
            X = x;
            Y = y;
            circlePath.reset();
            circlePath.addCircle(X, Y, 60, Path.Direction.CW);
        }
    }

    private void touch_up() {
//        path.lineTo(X, Y);
        circlePath.reset();
        //draw the line on Canvas
        //reset the path so that we don't redraw it
//        path.reset();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x_init = x;
                prevX = x;
                prevY = y;
                length = 0;
                timeTaken = -1 * System.currentTimeMillis();
                y_init = y;
                break;
            case MotionEvent.ACTION_UP:
                x_fin = x;
                timeTaken = timeTaken + System.currentTimeMillis();
                y_fin = y;
                JSONObject object = new JSONObject();
                try {
                    object.put("xi", x_init);
                    object.put("yi", y_init);
                    object.put("xf", x_fin);
                    object.put("yf", y_fin);
                    object.put("length", length);
                    object.put("time", timeTaken);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
//                trainModel(object);
                String tempUrl = URL + "/ipi/gesture/";
                postRequest(tempUrl, object);
//                Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
//                startActivity(intent);
//                finish();


                break;
            case MotionEvent.ACTION_MOVE:
                float temp = (x - prevX) * (x - prevX) + (y - prevY) * (y - prevY);
                temp = (float) Math.sqrt(temp);
                length = (long) (length + temp);
                prevX = x;
                prevY = y;
                break;
        }
        return super.onTouchEvent(event);
    }


    void trainModel(JSONObject object) {
        String temp = URL + "/ipi/gesture_train/";
        postRequest(temp, object);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    void postRequest(String url, JSONObject object) {
        Log.d("MY_OBJECT", object.toString());
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

                Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


}


