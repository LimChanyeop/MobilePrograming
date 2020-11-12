package com.example.activityforresult_201612085;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SubActivity2 extends AppCompatActivity {
    EditText edit2; //입력할 칸

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub2);

        edit2 = (EditText) findViewById(R.id.edit2);
        Button button_ok = (Button) findViewById(R.id.button_ok2);
        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("INPUT_TEXT", edit2.getText().toString()); //입력한 값울 string 형태로 인텐트에 실어 sub에 전달함
                setResult(RESULT_OK,intent); //Sub에서 확인할 수 있도록 설정
                finish();
            }
        });
        Button button_cancel = (Button)findViewById(R.id.button_cancel2); // 취소버튼
        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED); //취소
                finish();
            }
        });
    }
}