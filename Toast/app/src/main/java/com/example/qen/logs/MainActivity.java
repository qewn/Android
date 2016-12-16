package com.example.qen.logs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView; // Добавляєм без іцініціалзіації щоб потім доступатись з любого участку коду в класі
    Button button1;
    Button button2;
    Button button3;

    private static final String TAG = "Logs"; // TAG це стрічка в яку буде записаний текст повідомлення з logs
    // Також в полі Log Tag при добавленні фільтру обовязково треба вказати значення стрічки TAG, в даному випадку це "Logs"

    @Override
    protected void onCreate(Bundle savedInstanceState) { // Метод який автоматично запускається при старті додатку і відображає activity_mail.xml
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView); // Знаходимо всі id віджетів
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

        Log.d(TAG, "Found View elements"); // Все це роюиться для того щоб легше в логах потім знайти саме те що нас цікавить

        button1.setOnClickListener(new View.OnClickListener() { // Присвоюється окремо listener кнопці і реалізується метод який встановлює текст
            @Override
            public void onClick(View view) {
                /*try {
                    int i = 6/2;
                    int i = 6/0;*/
                textView.setText(/*"Result is " + i*/ "Опрацьовуєм кнопку 1");

                Toast toast = Toast.makeText(MainActivity.this, "You just clicked button 1", Toast.LENGTH_LONG); // makeText() створює View для відображення текствого повідомлення
                // Перший параметр Context - дає доступ до базових функцій додатка. MainActivity є підкласом Context тому ми можем використовувати
                // його в коді як класс.this або просто this. 2 і 3 параменти це текст і тривалість відповідно
               /* } catch (Exception e) {
                    Log.d(TAG, "Все працює, але на 0 ділити не можна!", e); // Тепер додаток не вивалиться а буде працювати також в
                    // логах виведеться вся інформація про помилку, постарається 3 параментр де ми передали обєкт Exception
                }*/
                Log.d(TAG, "The button 1 has been clicked");
                toast.setGravity(Gravity.CENTER, 0, 0); // Розміщення відносно батьківського елемента

                LinearLayout toastImage = (LinearLayout) toast.getView();
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setImageResource(R.drawable.common_google_signin_btn_text_dark_pressed);
                toastImage.addView(imageView, 0);

                toast.show();
                // Через getView() отримуєм віджет, створюєм новий обєкт віджета картинки, добавляєм туди власне картинку і добавляєм її в тост.
            }
        });

        button2.setOnClickListener(this); // this це клас MainActivity в даному випадку а так як в ньому є поле button 2 то йому присвоюється listener

        textView.setOnClickListener(new View.OnClickListener() { // Окремо віджету текста присвоюється слухач
            @Override
            public void onClick(View view) {
                button3.setText("Clicked");
                Log.d(TAG, "Changed the text");
            }
        });
    }

    @Override
    public void onClick(View view) { // Реалізазація методу інтерефейсу
        textView.setText("Button 2 has been clicked");
        Log.d(TAG, "Button 2 clicked");
    }

    public void onClickButton3(View view) { // Окремо створений нами метод який викликається з xml
        textView.setText("Button 3 has been clicked");
        Log.d(TAG, "And finally button 3 clicked");
    }
}
// У випадку якщо логи не відображаюься але все працює зробити наступне:
// Tools - Android - Android Device Monitor
