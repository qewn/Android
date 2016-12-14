package com.example.qen.listener;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView; // Створюєм поля без ініціалізації щоб мати доступ в любому місці класу
    Button button;
    Button button2;
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) { // Метод який запускається при старті додатка
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Layout файл який буде прочитаний і відображений

        textView = (TextView) findViewById(R.id.textView); // Знаходимо по id з класу R
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() { // Присвоюєм інтерефейс окремо одній кнопці
            @Override
            public void onClick(View view) { // Метод який при нажатті кнопки змінить текст на визначний
                textView.setText("Button 1 has been clicked");
            }
        });

        button2.setOnClickListener(this); // Присвоєння інтерефейсу класу Activity а потім другій кнопці
        
        textView.setOnClickListener(new View.OnClickListener() { // Присвоюєм інтерефейс окремо елементу textView який тепер клікабельний
            @Override
            public void onClick(View view) {
                button3.setText("Clicked");
            }
        });
    }

    @Override
    public void onClick(View view) {
        textView.setText("Button 2 has been clicked"); // Реалізація імплементованого інтерефейсу
    }

    public void onClickButton3(View view) {
        textView.setText("Button 3 has been clicked"); // Метод на який посилається віджет з Layout
    }
}
