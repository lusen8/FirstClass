package com.example.lusen.firstclass;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    private EditText editTextA;
    private EditText editTextP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.register);
        editTextA = (EditText)findViewById(R.id.Account);
        editTextP = (EditText)findViewById(R.id.Password);
        editTextA.setText(read("account.txt"));
        editTextP.setText(read("password.txt"));
        TextView textView1 = (TextView) findViewById(R.id.Denglu);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputA = editTextA.getText().toString();
                String inputP = editTextP.getText().toString();
                save("account.txt",inputA);
                save("password.txt",inputP);
                Toast.makeText(MainActivity.this,"登陆成功",Toast.LENGTH_SHORT).show();

            }
        });
    }
    public void save(String filename,String inputText) {
        FileOutputStream fileWriter = null;
        FileInputStream fileRead = null;
        BufferedReader read = null;
        BufferedWriter writer = null;
        try {
            fileRead = openFileInput(filename);
            read = new BufferedReader(new InputStreamReader(fileRead));
                fileWriter = openFileOutput(filename, Context.MODE_PRIVATE);
                writer = new BufferedWriter(new OutputStreamWriter(fileWriter));
                writer.write(inputText);
                writer.write("\r\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(writer !=null){
                try {
                    writer.close();
                    read.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public String read(String outputText) {
        FileInputStream in = null;
        BufferedReader br = null;
        String line = "";
        try {
            in = openFileInput(outputText);
            br = new BufferedReader(new InputStreamReader(in));
            line = br.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }   finally {
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return line;
    }
}
