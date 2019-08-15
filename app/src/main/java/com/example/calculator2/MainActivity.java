package com.example.calculator2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {
TextView back,Result,Exp,point,equal,zero,one,two,three,four,five,six,seven,eight,nine,plus,minus,multi,div,
    clear,brackets,perc;
int n=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //To assign the variables to their values
        Result=(TextView)findViewById(R.id.Result);
        back=(TextView)findViewById(R.id.back);
        Exp=(TextView)findViewById(R.id.Exp);
        point=(TextView)findViewById(R.id.point);
        equal=(TextView)findViewById(R.id.equal);
        zero=(TextView)findViewById(R.id.zero);
        one=(TextView)findViewById(R.id.one);
        two=(TextView)findViewById(R.id.two);
        three=(TextView)findViewById(R.id.three);
        four=(TextView)findViewById(R.id.four);
        five=(TextView)findViewById(R.id.five);
        six=(TextView)findViewById(R.id.six);
        seven=(TextView)findViewById(R.id.seven);
        eight=(TextView)findViewById(R.id.eight);
        nine=(TextView)findViewById(R.id.nine);
        plus=(TextView)findViewById(R.id.plus);
       minus=(TextView)findViewById(R.id.minus);
       multi=(TextView)findViewById(R.id.multi);
        div=(TextView)findViewById(R.id.divide);
        clear=(TextView)findViewById(R.id.clear);
        brackets=(TextView)findViewById(R.id.brackets);
        perc=(TextView)findViewById(R.id.percent);


        //Assigning actions to the different buttons in our app


        zero.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                append("0");
            }
        });
        one.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                append("1");
            }
        });
        two.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                append("2");
            }
        });
        three.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                append("3");
            }
        });
        four.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                append("4");
            }
        });
        five.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                append("5");
            }
        });
        six.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                append("6");
            }
        });
       seven.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                append("7");
            }
        });
       eight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                append("8");
            }
        });zero.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                append("0");
            }
        });
        nine.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                append("9");
            }
        });
       point.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                append(".");
            }
        });

       perc.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               append("%");
           }
       });

       brackets.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               if(n==0){
                   append("(");
                   n=1;
               }
               else{
                   append(")");
                   n=0;
               }
           }
       });

        plus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                append("+");
            }
        });
        minus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                append("-");
            }
        });
        multi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                append("*");
            }
        });
        div.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                append("/");
            }
        });


        clear.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                Exp.setText("");
                Result.setText("");
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string=Exp.getText().toString();
                if(string.isEmpty()){

                }
                else{
                    Exp.setText(string.substring(0,string.length()-1));
                }
                Result.setText("");
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    //Here we use an ExpressionBuilder to convert our string to an expression
                    //and evaluate it accordingly
                    ExpressionBuilder expr = new ExpressionBuilder(Exp.getText().toString());
                    Expression r = expr.build();
                    double result = r.evaluate();
                    String fresult=Double.toString(result);

                    while(fresult.contains(".")&&fresult.endsWith("0"))
                    {
                        fresult=fresult.substring(0,fresult.length()-1);
                        if(fresult.endsWith("."));
                        {
                            fresult=fresult.substring(0,fresult.length()-1);
                        }
                    }
                    Exp.setText("");
                    Result.setText(fresult);
                    Exp.setText(fresult);
                }catch(Exception e){

                }
            }
        });
    }



    //The below function appends the users input into the string so that it can be
    //evaluated accordingly later



    public void append(String str){
        if(!str.isEmpty()) {
            Exp.append(str);
            Result.setText("");
        }
        else
        {
            Result.setText("");
            Exp.append(str);
        }
    }
}
