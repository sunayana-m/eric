package com.example.calci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    Button one,two,three,four,five,six,seven,eight,nine,zero;
    Button plus,minus,division,mod,equals,clear,dot,multiply;
    EditText res;
    String operatorpressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res=findViewById(R.id.result);
        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        four=findViewById(R.id.four);
        five=findViewById(R.id.five);
        six=findViewById(R.id.six);
        seven=findViewById(R.id.seven);
        eight=findViewById(R.id.eight);
        nine=findViewById(R.id.nine);
        zero=findViewById(R.id.zero);
        plus=findViewById(R.id.plus);
        minus=findViewById(R.id.minus);
        multiply=findViewById(R.id.multiply);
        division=findViewById(R.id.division);
        clear=findViewById(R.id.clr);
        equals=findViewById(R.id.equals);
        mod=findViewById(R.id.mod);
        dot=findViewById(R.id.dot);


        res.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
        //operators
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        division.setOnClickListener(this);
        mod.setOnClickListener(this);
        multiply.setOnClickListener(this);

        equals.setOnClickListener(this);
        clear.setOnClickListener(this);
        dot.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        double finalres=0;
        switch (view.getId())
        {
            case R.id.one : res.append("1");
                break;
            case R.id.two : res.append("2");
                break;
            case R.id.three: res.append("3");
                break;
            case R.id.four : res.append("4");
                break;
            case R.id.five : res.append("5");
                break;
            case R.id.six : res.append("6");
                break;
            case R.id.seven : res.append("7");
                break;
            case R.id.eight : res.append("8");
                break;
            case R.id.nine: res.append("9");
                break;
            case R.id.zero : res.append("0");
                break;
            case R.id.plus : res.append("+");
                operatorpressed="+";
                break;
            case R.id.minus : res.append("-");
                operatorpressed="-";
                break;
            case R.id.multiply : res.append("*");
                operatorpressed="*";
                break;
            case R.id.division : res.append("/");
                operatorpressed="/";
                break;
            case R.id.clr:  res.setText(" ");
                break;
            case R.id.dot : res.append(".");
                break;
            case R.id.mod : res.append("%");
                operatorpressed="%";
                break;
            case R.id.equals: finalres=compute(res.getText().toString(),operatorpressed);
                res.setText(String.valueOf(finalres));
                break;

            default:return;
        }

    }

    private double compute(String toString, String operatorpressed) {
        String[] tokens=toString.split("\\+|-|\\*|\\/|%");
        double firstoperand=Double.parseDouble(tokens[0]);
        double secondoperand=Double.parseDouble(tokens[1]);

        switch (operatorpressed)
        {
            case "+" : return firstoperand+secondoperand;
            case "-" : return firstoperand-secondoperand;

            case "*" : return firstoperand*secondoperand;
            case "/" : return firstoperand/secondoperand;
            case "%" : return firstoperand%secondoperand;
            default: return 0;
        }



    }
}
