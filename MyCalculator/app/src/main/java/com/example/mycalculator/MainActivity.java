package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private Button but0 , but1 , but2 , but3 , but4,but5,but6,but7,but8,but9,
                    butdel,butadd,butsub,butmul,butdiv,butdot,butequ,butAc;

    private TextView textViewresult , textViewHistory;

    private String number = null;

    double firstNumber = 0;
    double lastNumber = 0;

    String status = null;
    boolean operator = false;

    DecimalFormat myformate = new DecimalFormat("######.######");

    String history , currentResult;
    boolean dot = true;
    boolean butAcControl = true;
    boolean butEquControl = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        but0 = findViewById(R.id.Button0);
        but1 = findViewById(R.id.Button1);
        but2 = findViewById(R.id.Button2);
        but3 = findViewById(R.id.Button3);
        but4 = findViewById(R.id.Button4);
        but5 = findViewById(R.id.Button5);
        but6 = findViewById(R.id.Button6);
        but7 = findViewById(R.id.Button7);
        but8 = findViewById(R.id.Button8);
        but9 = findViewById(R.id.Button9);

        butdel = findViewById(R.id.DelButton);
        butadd = findViewById(R.id.AddButton);
        butsub = findViewById(R.id.SubButton);
        butmul = findViewById(R.id.MulButton);
        butdiv = findViewById(R.id.DivButton);
        butdot = findViewById(R.id.Buttondot);
        butequ = findViewById(R.id.EquButton);
        butAc = findViewById(R.id.AcButton);

        textViewHistory = findViewById(R.id.textViewHistroy);
        textViewresult = findViewById(R.id.textViewPresent);

        but0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumberClick("0");
            }
        });
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumberClick("1");
            }
        });
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumberClick("2");
            }
        });
        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumberClick("3");
            }
        });
        but4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumberClick("4");
            }
        });
        but5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumberClick("5");
            }
        });
        but6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumberClick("6");
            }
        });
        but7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumberClick("7");
            }
        });
        but8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumberClick("8");
            }
        });
        but9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumberClick("9");
            }
        });
        butadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                history = textViewHistory.getText().toString();
                currentResult = textViewresult.getText().toString();
                textViewHistory.setText(history+currentResult+"+");

                if(operator){
                    if(status == "multiplication"){
                        multiply();
                    }
                    else if(status == "division"){
                        divide();
                    }
                    else if(status == "substraction"){
                        minus();
                    }
                    else{
                        plus();
                    }
                }
                status = "add";
                operator = false;
                number = null;
            }
        });
        butsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history = textViewHistory.getText().toString();
                currentResult = textViewresult.getText().toString();
                textViewHistory.setText(history+currentResult+"-");

                if(operator){
                    if(status == "multiplication"){
                        multiply();
                    }
                    else if(status == "division"){
                        divide();
                    }
                    else if(status == "add"){
                        plus();
                    }
                    else{
                        minus();
                    }
                }
                status = "substraction";
                operator = false;
                number = null;
            }
        });
        butmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history = textViewHistory.getText().toString();
                currentResult = textViewresult.getText().toString();
                textViewHistory.setText(history+currentResult+"X");

                if(operator){
                    if(status == "division"){
                        divide();
                    }
                    else if(status == "add"){
                        plus();
                    }
                    else if(status == "substraction"){
                        minus();
                    }
                    else{
                        multiply();
                    }
                }
                operator = false;
                status = "multiplication";
                number = null;
            }
        });
        butdiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history = textViewHistory.getText().toString();
                currentResult = textViewresult.getText().toString();
                textViewHistory.setText(history+currentResult+"/");

                if(operator){
                    if(status == "multiplication"){
                        multiply();
                    }
                    else if(status == "add"){
                        plus();
                    }
                    else if(status == "substraction"){
                        minus();
                    }
                    else{
                        divide();
                    }
                }
                operator = false;
                number = null;
                status = "division";
            }
        });
        butdot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dot){
                    if(number == null){
                        number = "0.";
                    }
                    else{
                        number = number + ".";
                    }
                }
                dot = false;
                textViewresult.setText(number);
            }
        });
        butAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = null;
                status = null;
                firstNumber = 0;
                lastNumber = 0;
                textViewHistory.setText("");
                textViewresult.setText("0");
                dot = true;
                butAcControl = true;
            }
        });
        butdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(butAcControl){
                    textViewresult.setText("0");
                }
                else{
                    number = number.substring(0,number.length() - 1);
                    if(number.length() == 0){
                        butdel.setClickable(false);
                    }
                    else if(number.contains(".")){
                        dot = false;
                    }
                    else{
                        dot = true;
                    }
                    textViewresult.setText(""+number);
                }
            }
        });
        butequ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operator){
                    if(status == "multiplication"){
                        multiply();
                    }
                    else if(status == "add"){
                        plus();
                    }
                    else if(status == "substraction"){
                        minus();
                    }
                    else if(status == "division"){
                        divide();
                    }
                    else{
                        firstNumber = Double.parseDouble(textViewresult.getText().toString());
                    }
                }
                operator = false;
                butEquControl = true;
            }
        });
    }

    public void NumberClick(String view){
        if(number == null){
            number = view;
        }
        else if(butEquControl){
            firstNumber = 0;
            lastNumber = 0;
            number = view;
        }
        else{
            number = number + view;
        }
        textViewresult.setText(number);
        operator = true;
        butAcControl = false;
        butdel.setClickable(true);
        butEquControl = false;
    }
    public void plus(){
        lastNumber = Double.parseDouble(textViewresult.getText().toString());
        firstNumber = firstNumber + lastNumber;
        textViewresult.setText(myformate.format(firstNumber));
        dot = true;
    }
    public void minus(){
        if(firstNumber == 0){
            firstNumber = Double.parseDouble(textViewresult.getText().toString());
        }
        else{
            lastNumber = Double.parseDouble(textViewresult.getText().toString());
            firstNumber = firstNumber - lastNumber;
        }
        textViewresult.setText(myformate.format(firstNumber));
        dot = true;
    }
    public void multiply(){
        if(firstNumber == 0){
            firstNumber = 1;
            lastNumber = Double.parseDouble(textViewresult.getText().toString());
            firstNumber = firstNumber * lastNumber;
        }
        else{
            lastNumber = Double.parseDouble(textViewresult.getText().toString());
            firstNumber = firstNumber * lastNumber;
        }
        textViewresult.setText(myformate.format(firstNumber));
        dot = true;
    }
    public void divide(){
        if(firstNumber == 0){
            lastNumber = Double.parseDouble(textViewresult.getText().toString());
            firstNumber = lastNumber;
        }
        else{
            lastNumber = Double.parseDouble(textViewresult.getText().toString());
            firstNumber = firstNumber / lastNumber;
        }
        textViewresult.setText(myformate.format(firstNumber));
        dot = true;
    }
}