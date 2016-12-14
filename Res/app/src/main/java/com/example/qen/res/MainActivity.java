package com.example.qen.res;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Встановлюєм картинку через в java коді
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_chat_black_48dp));
        // Перекреслення означає що методи застірілі і їх підтримка в наступних версіях не гарантується
    }
}
