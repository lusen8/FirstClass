package com.example.lusen.firstclass;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by lusen on 2016/11/23.
 */

public class MaintextActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintext);
        TextView textView1 = (TextView) findViewById(R.id.登录);
        TextView textView2 = (TextView) findViewById(R.id.注册);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MaintextActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MaintextActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
