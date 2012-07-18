package com.olheingenieros.simplecalc;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        final String LOG_TAG = "MainScreen";
        final boolean DEVELOPER_MODE = true;
        if (DEVELOPER_MODE) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .penaltyDialog()
                    .build()
                    );
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll()
                    .penaltyLog()
                    .build()
                    );
        }
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        final EditText value1 = (EditText) findViewById(R.id.editText1);
        final EditText value2 = (EditText) findViewById(R.id.editText2);

        final TextView result = (TextView) findViewById(R.id.textView2);

        final Button addButton = (Button) findViewById(R.id.button1);
        addButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(final View v) {
                try {
                    final int val1 = Integer.parseInt(value1.getText().toString());
                    final int val2 = Integer.parseInt(value2.getText().toString());

                    final Integer answer = val1 + val2;
                    result.setText(answer.toString());
                } catch (final Exception e) {
                    Log.e(LOG_TAG, "Failed to add numbers", e);
                }
            }
        });

        final Button multiplyButton = (Button) findViewById(R.id.button2);
        multiplyButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(final View v) {
                try {
                    final int val1 = Integer.parseInt(value1.getText().toString());
                    final int val2 = Integer.parseInt(value2.getText().toString());

                    final Integer answer = val1 * val2;
                    result.setText(answer.toString());
                } catch (final Exception e) {
                    Log.e(LOG_TAG, "Failed to multiply numbers", e);
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


}
