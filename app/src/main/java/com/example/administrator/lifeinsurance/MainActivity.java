package com.example.administrator.lifeinsurance;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;
import android.view.MotionEvent;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> list1 = new ArrayList<String>();
    private Spinner mySpinner1;
    private ArrayAdapter<String> adapter1;
    private int type;
    private List<String> list2 = new ArrayList<String>();
    private Spinner mySpinner2;
    private ArrayAdapter<String> adapter2;
    private double money2;
    private List<String> list3 = new ArrayList<String>();
    private Spinner mySpinner3;
    private ArrayAdapter<String> adapter3;
    private double money3;
    private List<String> list4 = new ArrayList<String>();
    private Spinner mySpinner4;
    private ArrayAdapter<String> adapter4;
    private double money4;
    private double money3_coefficient;
    private double sum_money;
    private TextView myTextView;
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.item1:
                //Intent是一种运行时绑定（run-time binding）机制，它能在程序运行过程中连接两个不同的组件。
                //page1为先前已添加的类，并已在AndroidManifest.xml内添加活动事件(<activity android:name="page1"></activity>),在存放资源代码的文件夹下下，
                Intent i = new Intent(MainActivity.this , Explain.class);
                ////启动
                startActivity(i);
                break;
            case R.id.item2:
                Intent j = new Intent(MainActivity.this , Explain2.class);
                startActivity(j);
                break;
            case R.id.item3:
                Intent k = new Intent(MainActivity.this , explain3.class);
                startActivity(k);
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        //第一步：添加一个下拉列表项的list，这里添加的项就是下拉列表的菜单项
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");
        list1.add("5");
        mySpinner1 = (Spinner) findViewById(R.id.spinner1);
        //第二步：为下拉列表定义一个适配器，这里就用到里前面定义的list。
        adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list1);
        //第三步：为适配器设置下拉列表下拉时的菜单样式。
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //第四步：将适配器添加到下拉列表上
        mySpinner1.setAdapter(adapter1);
        //第五步：为下拉列表设置各种事件的响应，这个事响应菜单被选中
        mySpinner1.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                /* 将所选mySpinner 的值带入myTextView 中*/
                type = Integer.parseInt(adapter1.getItem(arg2));
                System.out.println(type);
                /* 将mySpinner 显示*/
                arg0.setVisibility(View.VISIBLE);
            }
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
                arg0.setVisibility(View.VISIBLE);
            }
        });

        //第一步：添加一个下拉列表项的list，这里添加的项就是下拉列表的菜单项
        list2.add("50000");
        list2.add("100000");
        list2.add("150000");
        list2.add("200000");
        list2.add("300000");
        mySpinner2 = (Spinner) findViewById(R.id.spinner2);
        //第二步：为下拉列表定义一个适配器，这里就用到里前面定义的list。
        adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list2);
        //第三步：为适配器设置下拉列表下拉时的菜单样式。
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //第四步：将适配器添加到下拉列表上
        mySpinner2.setAdapter(adapter2);
        //第五步：为下拉列表设置各种事件的响应，这个事响应菜单被选中
        mySpinner2.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                /* 将所选mySpinner 的值带入myTextView 中*/
                money2 = Double.parseDouble(adapter2.getItem(arg2));
                System.out.println(money2);
                /* 将mySpinner 显示*/
                arg0.setVisibility(View.VISIBLE);
            }
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
                arg0.setVisibility(View.VISIBLE);
            }
        });

        //第一步：添加一个下拉列表项的list，这里添加的项就是下拉列表的菜单项
        list3.add("5000");
        list3.add("10000");
        list3.add("15000");
        list3.add("20000");
        list3.add("30000");
        mySpinner3 = (Spinner) findViewById(R.id.spinner3);
        //第二步：为下拉列表定义一个适配器，这里就用到里前面定义的list。
        adapter3 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list3);
        //第三步：为适配器设置下拉列表下拉时的菜单样式。
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //第四步：将适配器添加到下拉列表上
        mySpinner3.setAdapter(adapter3);
        //第五步：为下拉列表设置各种事件的响应，这个事响应菜单被选中
        mySpinner3.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                /* 将所选mySpinner 的值带入myTextView 中*/
                money3 = Double.parseDouble(adapter3.getItem(arg2));
                System.out.println(money3);
                /* 将mySpinner 显示*/
                arg0.setVisibility(View.VISIBLE);
            }
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
                arg0.setVisibility(View.VISIBLE);
            }
        });

        //第一步：添加一个下拉列表项的list，这里添加的项就是下拉列表的菜单项
        list4.add("0");
        list4.add("50");
        list4.add("80");
        list4.add("100");
        list4.add("120");
        list4.add("150");
        list4.add("200");
        mySpinner4 = (Spinner) findViewById(R.id.spinner4);
        //第二步：为下拉列表定义一个适配器，这里就用到里前面定义的list。
        adapter4 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list4);
        //第三步：为适配器设置下拉列表下拉时的菜单样式。
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //第四步：将适配器添加到下拉列表上
        mySpinner4.setAdapter(adapter4);
        //第五步：为下拉列表设置各种事件的响应，这个事响应菜单被选中
        mySpinner4.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                /* 将所选mySpinner 的值带入myTextView 中*/
                money4 = Double.parseDouble(adapter4.getItem(arg2));
                System.out.println(money4);
                /* 将mySpinner 显示*/
                arg0.setVisibility(View.VISIBLE);
            }
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
                arg0.setVisibility(View.VISIBLE);
            }
        });

        Button button1 = (Button)findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
               // Toast.makeText(MainActivity.this, "1111", Toast.LENGTH_SHORT).show();
                myTextView  = (TextView)findViewById(R.id.textView5);
                if(5000 == money3){
                    money3_coefficient = 1;
                }else if(10000 == money3){
                    money3_coefficient = 1 + (10000 - 5000)/5000*0.6;
                    System.out.println("money3_coefficient"+money3_coefficient);
                }else if(15000 == money3){
                    money3_coefficient = 1 + (15000 - 5000)/5000*0.4;
                    System.out.println("money3_coefficient"+money3_coefficient);
                }else if(20000 == money3){
                    money3_coefficient = 1.6 + (20000 - 5000)/5000*0.2;
                    System.out.println("money3_coefficient"+money3_coefficient);
                }else if(30000 == money3){
                    money3_coefficient = 4.8 + (30000 - 5000)/5000*0.1;
                    System.out.println("money3_coefficient"+money3_coefficient);
                }

                if(1 == type) {
                    sum_money = (money2 *2.5/1000 * 0.4) + (money3_coefficient * 32 * 1.3 + money4/10*8)*0.4;
                }else if(2 == type) {
                    sum_money = (money2 *3.5/1000 * 0.4) + (money3_coefficient * 36 * 1.3 + money4/10*10)*0.4;
                }else if(3 == type) {
                    sum_money = (money2 *4/1000 * 0.4) + (money3_coefficient * 40 * 1.3 + money4/10*12)*0.4;
                }else if(4 == type) {
                    sum_money = (money2 *6/1000 * 0.4) + (money3_coefficient * 44 * 1.3 + money4/10*18)*0.4;
                }else if(5 == type) {
                    sum_money = (money2 *9/1000 * 0.4) +(money3_coefficient * 48 * 1.3 + money4/10*26)*0.4;
                }
                DecimalFormat df = new DecimalFormat("0.00");
                myTextView.setText("您选择的是：\n"+ "职业类别：" + type +"\n"+"意外身故、伤残、烧伤保障："+ df.format(money2) + "\n" +
                                "意外医疗保障："+ df.format(money3) +"\n"+"意外住院津贴："+ df.format(money4) + "\n" + "合计：" +df.format(sum_money)+ "\n");
            }
        });

    }
}
