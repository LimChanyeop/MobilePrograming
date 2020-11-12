package com.example.activityforresult_201612085;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static final int GET_STRING = 1;
    TextView text;
    TextView text2; //두번째 input

    private String[] input_list = new String[2]; //Sub로부터 받아올 intent 내에 들어있는 String 배열을 받기 위함
    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.text);
        text2 = findViewById(R.id.text2);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, SubActivity.class);
                startActivityForResult(in, GET_STRING);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GET_STRING) {
            if (resultCode == RESULT_OK) {
                input_list = data.getStringArrayExtra("INPUT_TEXT"); // 배열 전달받음
                text.setText(input_list[0]); //sub에서 받아온 문자열
                text2.setText(input_list[1]); //sub2에서 받아온 문자열
            }
        }
    }
}