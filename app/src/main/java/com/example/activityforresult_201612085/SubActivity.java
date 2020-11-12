package com.example.activityforresult_201612085;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {
    static final int GET_STRING = 1;
    EditText edit; //문자열 입력 칸
    TextView text2; //sub2에서 입력한 문자열
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub);

        String[] input_list = new String[2]; // 문자열 2개를 mainActivity에 전달할 배열

        text2 = (TextView) findViewById(R.id.textview2);
        edit = (EditText) findViewById(R.id.edit);

        Button button_ok = (Button) findViewById(R.id.button_ok);
        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                input_list[0] = edit.getText().toString(); //현재 창에서 입력한 값
                if(text2.getText() != "")
                    input_list[1] = text2.getText().toString(); //sub2 에서 입력한 값
                intent.putExtra("INPUT_TEXT", input_list); //intent에 실음
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        Button button_input2 = (Button)findViewById(R.id.button_input2); //sub2로 이동할 버튼
        button_input2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(SubActivity.this, SubActivity2.class); //인텐트 설정
                startActivityForResult(in, GET_STRING); //이동
            }
        });
        Button button_cancel = (Button)findViewById(R.id.button_cancel);
        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GET_STRING) {
            if (resultCode == RESULT_OK) {
                text2.setText(data.getStringExtra("INPUT_TEXT")); //sub2로부터 받은 문자열 ->TextVIew에 띄움
            }
        }
    }
}