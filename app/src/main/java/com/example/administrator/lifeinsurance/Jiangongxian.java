package com.example.administrator.lifeinsurance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Jiangongxian extends AppCompatActivity {
    private double money1;
    private double money2;
    private double money3;
    private double sum_money;
    private TextView myTextView;
    private double discount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jiangongxian);

        Button button1 = (Button)findViewById(R.id.button_jiangong4);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                myTextView  = (TextView)findViewById(R.id.textView_jiangong4);
                EditText M1 = (EditText) findViewById(R.id.editText_jiangong0);
                EditText M2 = (EditText) findViewById(R.id.editText_jiangong1);
                EditText M3 = (EditText) findViewById(R.id.editText_jiangong2);
                EditText Discount = (EditText) findViewById(R.id.editText_jiangong3);

                money1 = Double.parseDouble(((!TextUtils.isEmpty(M1.getText()))?(M1.getText().toString()):"0"));
                money2 = Double.parseDouble(((!TextUtils.isEmpty(M2.getText()))?(M2.getText().toString()):"0"));
                money3 = Double.parseDouble(((!TextUtils.isEmpty(M2.getText()))?(M2.getText().toString()):"0"));

                discount = Double.parseDouble(((!TextUtils.isEmpty(Discount.getText()))?(Discount.getText().toString()):"0"));

                sum_money = (money1/10000*money2*0.15/1000)+(money1/10000*money3*0.5/1000);
                sum_money = sum_money * discount /10;
                DecimalFormat df = new DecimalFormat("0.00");
                myTextView.setText("您选择的是：\n"+ "工程造价：" + money1 +"\n"+"意外身故、伤残保障："+ df.format(money2) + "\n" +
                        "意外医疗保障："+ df.format(money3) +"\n" + "\n" + "合计：" +df.format(sum_money)+ "\n");
            }
        });




    }
}
