package ws.wolfsoft.cryptostar;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.formatter.SimpleAxisValueFormatter;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.LineChartView;


public class ChartCryptoStarActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView wallet_img,chart_img,trading_img,alert_img,setting_img;
    TextView wallet_txt,chart_txt,trading_txt,alert_txt,setting_txt;
    LinearLayout linear1,linear2,linear3,linear4,linear5;


    private LineChartView chart,chart1;
    private LineChartData data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart_crypto_star);


        chart = findViewById(R.id.chart) ;
        chart1 = findViewById(R.id.chart1) ;

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

        generateTempoData();
        generateTempoData1();


    }


    private void generateTempoData() {
        // I got speed in range (0-50) and height in meters in range(200 - 300). I want this chart to display both
        // information. Differences between speed and height values are large and chart doesn't look good so I need
        // to modify height values to be in range of speed values.

        // The same for displaying Tempo/Height chart.

        float minHeight = 200;
        float maxHeight = 300;
        float tempoRange = 15; // from 0min/km to 15min/km

        float scale = tempoRange / maxHeight;
        float sub = (minHeight * scale) / 2;

        int numValues = 52;

        Line line;
        List<PointValue> values;
        List<Line> lines = new ArrayList<Line>();




        // Height line, add it as first line to be drawn in the background.
        values = new ArrayList<PointValue>();
        for (int i = 0; i < numValues; ++i) {
            // Some random height values, add +200 to make line a little more natural
            float rawHeight = (float) (Math.random() * 100 + 200);
            float normalizedHeight = rawHeight * scale - sub;
            values.add(new PointValue(i, normalizedHeight));
        }

        line = new Line(values);
        line.setColor(Color.BLUE);
        line.setHasPoints(false);
        line.setFilled(true);
        line.setStrokeWidth(1);
        lines.add(line);


        values = new ArrayList<PointValue>();
        for (int i = 0; i < numValues; ++i) {

            float realTempo = (float) Math.random() * 6 + 2;
            float revertedTempo = tempoRange - realTempo;
            values.add(new PointValue(i, revertedTempo));
        }

        data = new LineChartData(lines);


        Axis distanceAxis = new Axis();

        distanceAxis.setTextColor(ChartUtils.COLOR_ORANGE);
        distanceAxis.setMaxLabelChars(4);

        List<AxisValue> axisValues = new ArrayList<AxisValue>();
        for (float i = 0; i < tempoRange; i += 0.25f) {
            axisValues.add(new AxisValue(i).setLabel(formatMinutes(tempoRange - i)));
        }


        chart.setLineChartData(data);
        Viewport v = chart.getMaximumViewport();
        v.set(v.left, tempoRange, v.right, 0);
        chart.setMaximumViewport(v);
        chart.setCurrentViewport(v);
        chart1.setLineChartData(data);











        Line line1;
        List<PointValue> values1;
        List<Line> lines1 = new ArrayList<Line>();




        // Height line, add it as first line to be drawn in the background.
        values1 = new ArrayList<PointValue>();
        for (int i = 0; i < numValues; ++i) {
            // Some random height values, add +200 to make line a little more natural
            float rawHeight = (float) (Math.random() * 100 + 200);
            float normalizedHeight = rawHeight * scale - sub;
            values1.add(new PointValue(i, normalizedHeight));
        }

        line1 = new Line(values1);
        line1.setColor(Color.BLACK);
        line1.setHasPoints(false);
        line1.setFilled(true);
        line1.setStrokeWidth(1);
        lines1.add(line1);


        values1 = new ArrayList<PointValue>();
        for (int i = 0; i < numValues; ++i) {

            float realTempo = (float) Math.random() * 6 + 2;
            float revertedTempo = tempoRange - realTempo;
            values1.add(new PointValue(i, revertedTempo));
        }

        data = new LineChartData(lines1);


        Axis distanceAxis1 = new Axis();

        distanceAxis1.setTextColor(ChartUtils.COLOR_ORANGE);
        distanceAxis1.setMaxLabelChars(4);

        List<AxisValue> axisValues1 = new ArrayList<AxisValue>();
        for (float i = 0; i < tempoRange; i += 0.25f) {
            axisValues1.add(new AxisValue(i).setLabel(formatMinutes(tempoRange - i)));
        }



        Viewport v1 = chart1.getMaximumViewport();
        v1.set(v1.left, tempoRange, v1.right, 0);
        chart1.setMaximumViewport(v);
        chart1.setCurrentViewport(v);

    }

    private void generateTempoData1() {
        // I got speed in range (0-50) and height in meters in range(200 - 300). I want this chart to display both
        // information. Differences between speed and height values are large and chart doesn't look good so I need
        // to modify height values to be in range of speed values.

        // The same for displaying Tempo/Height chart.

        float minHeight = 200;
        float maxHeight = 300;
        float tempoRange = 15; // from 0min/km to 15min/km

        float scale = tempoRange / maxHeight;
        float sub = (minHeight * scale) / 2;

        int numValues = 52;

        Line line;
        List<PointValue> values;
        List<Line> lines = new ArrayList<Line>();




        // Height line, add it as first line to be drawn in the background.
        values = new ArrayList<PointValue>();
        for (int i = 0; i < numValues; ++i) {
            // Some random height values, add +200 to make line a little more natural
            float rawHeight = (float) (Math.random() * 100 + 200);
            float normalizedHeight = rawHeight * scale - sub;
            values.add(new PointValue(i, normalizedHeight));
        }

        line = new Line(values);
        line.setColor(Color.GRAY);
        line.setHasPoints(false);
        line.setFilled(true);
        line.setStrokeWidth(1);
        lines.add(line);


        values = new ArrayList<PointValue>();
        for (int i = 0; i < numValues; ++i) {

            float realTempo = (float) Math.random() * 6 + 2;
            float revertedTempo = tempoRange - realTempo;
            values.add(new PointValue(i, revertedTempo));
        }

        data = new LineChartData(lines);


        Axis distanceAxis = new Axis();

        distanceAxis.setTextColor(ChartUtils.COLOR_ORANGE);
        distanceAxis.setMaxLabelChars(4);

        List<AxisValue> axisValues = new ArrayList<AxisValue>();
        for (float i = 0; i < tempoRange; i += 0.25f) {
            axisValues.add(new AxisValue(i).setLabel(formatMinutes(tempoRange - i)));
        }


        chart1.setLineChartData(data);
        Viewport v = chart1.getMaximumViewport();
        v.set(v.left, tempoRange, v.right, 0);
        chart1.setMaximumViewport(v);
        chart1.setCurrentViewport(v);
        chart1.setLineChartData(data);





    }

    private String formatMinutes(float value) {
        StringBuilder sb = new StringBuilder();

        // translate value to seconds, for example
        int valueInSeconds = (int) (value * 60);
        int minutes = (int) Math.floor(valueInSeconds / 60);
        int seconds = (int) valueInSeconds % 60;

        sb.append(String.valueOf(minutes)).append(':');
        if (seconds < 10) {
            sb.append('0');
        }
        sb.append(String.valueOf(seconds));
        return sb.toString();
    }

    /**
     * Recalculated height values to display on axis. For this example I use auto-generated height axis so I
     * override only formatAutoValue method.
     */
    private static class HeightValueFormatter extends SimpleAxisValueFormatter {

        private float scale;
        private float sub;
        private int decimalDigits;

        public HeightValueFormatter(float scale, float sub, int decimalDigits) {
            this.scale = scale;
            this.sub = sub;
            this.decimalDigits = decimalDigits;
        }

        @Override
        public int formatValueForAutoGeneratedAxis(char[] formattedValue, float value, int autoDecimalDigits) {
            float scaledValue = (value + sub) / scale;
            return super.formatValueForAutoGeneratedAxis(formattedValue, scaledValue, this.decimalDigits);
        }
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
