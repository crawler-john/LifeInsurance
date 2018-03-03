package com.example.administrator.lifeinsurance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button button1 = (Button)findViewById(R.id.button_menu1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Toast.makeText(Menu.this, "1111", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Menu.this , MainActivity.class);
                ////启动
                startActivity(i);
            }
        });

        Button button2 = (Button)findViewById(R.id.button_menu2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Toast.makeText(Menu.this, "2222", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Menu.this , Jiangongxian.class);
                ////启动
                startActivity(i);
            }
        });

        Button button3 = (Button)findViewById(R.id.button_menu3);
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Toast.makeText(Menu.this, "3333", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Menu.this , Zhidingchangsuoxian.class);
                ////启动
                startActivity(i);
            }
        });
    }
}
