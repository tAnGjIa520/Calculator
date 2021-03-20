package com.tangjia.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private HashMap<Integer,String> map=new HashMap<Integer,String>();
    private String string="";

    private static final String TAG ="test" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        map.put(R.id.but0,"0");
        map.put(R.id.but1,"1");
        map.put(R.id.but2,"2");
        map.put(R.id.but3,"3");
        map.put(R.id.but4,"4");
        map.put(R.id.but5,"5");
        map.put(R.id.but6,"6");
        map.put(R.id.but7,"7");
        map.put(R.id.but8,"8");
        map.put(R.id.but9,"9");
        map.put(R.id.but_jia,"+");
        map.put(R.id.but_jian,"-");
        map.put(R.id.but_cheng,"*");
        map.put(R.id.but_chu,"/");
        map.put(R.id.but_doc,".");
    }
    public void  click(View view){

          int id = view.getId();
        String s = map.get(id);
        Log.i(TAG, "click: "+s);
        string+=s; 
        TextView textView = findViewById(R.id.text);
        textView.setText(string);
    }

    public void clear(View view){
        string="";
        TextView textView = findViewById(R.id.text);
        textView.setText(string);
    }

    public void equ(View view){
        try {
            Log.i(TAG, "equ: "+string);
            double calculate = new Calculator().calculate(string);
            Log.i(TAG, "equ: "+calculate);
            string=Double.toString(calculate);


            TextView textView = findViewById(R.id.text);
            textView.setText(string);
        }catch (Exception e){
            TextView textView = findViewById(R.id.text);
            textView.setText("您的输入有误！");
        }



    }
}