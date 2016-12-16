package com.example.qen.logs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    Button button1;
    Button button2;
    Button button3;

    private static final String TAG = "Logs"; // TAG це стрічка в яку буде записаний текст повідомлення з logs
    // Також в полі Log Tag при добавленні фільтру обовязково треба вказати значення стрічки TAG, в даному випадку це "Logs"

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

        Log.d(TAG, "Found View elements"); // Все це роюиться для того щоб легше в логах потім знайти саме те що нас цікавить

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
               /* int i = 6/2;*/
                    int i = 6/0;
                    textView.setText("Result is " + i);
                } catch (Exception e) {
                    Log.d(TAG, "Все працює, але на 0 ділити не можна!", e); // Тепер додаток не вивалиться а буде працювати також в
                    // логах виведеться вся інформація про помилку, постарається 3 параментр де ми передали обєкт Exception
                }
                Log.d(TAG, "The button 1 has been clicked");
            }
        });

        button2.setOnClickListener(this);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button3.setText("Clicked");
                Log.d(TAG, "Changed the text");
            }
        });
    }

    @Override
    public void onClick(View view) {
        textView.setText("Button 2 has been clicked");
        Log.d(TAG, "Button 2 clicked");
    }

    public void onClickButton3(View view) {
        textView.setText("Button 3 has been clicked");
        Log.d(TAG, "And finally button 3 clicked");
    }
}


// У випадку якщо логи не відображаюься але все працює зробити наступне
// Tools - Android - Android Device Monitor
