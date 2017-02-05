package com.hector.mentalmaths;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MentalMaths extends AppCompatActivity {
    Integer answer=0;
    String SnackBarMessage = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mental_maths);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Integer FirstNumber =  MakeNumber(getIntent().getIntExtra("FirstNumberLength",1));
        Integer SecondNumber = MakeNumber(getIntent().getIntExtra("SecondNumberLength",1));

        String InstructionText = Integer.toString(FirstNumber)
                + getIntent().getStringExtra("Operation") + Integer.toString(SecondNumber)+"=";
        TextView instruction = (TextView) findViewById(R.id.Instruction);
        instruction.setText(InstructionText);

        switch (getIntent().getStringExtra("Operation")){
            case "+":
                answer = FirstNumber+SecondNumber;
                break;
            case "-":
                answer = FirstNumber-SecondNumber;
                break;
            case "*":
                answer = FirstNumber*SecondNumber;
                break;
            case "/":
                answer = FirstNumber/SecondNumber;
                break;
        }

        Button One = (Button) findViewById(R.id.One);
        Button Two = (Button) findViewById(R.id.Two);
        Button Three = (Button) findViewById(R.id.Three);
        Button Four = (Button) findViewById(R.id.Four);
        Button Five = (Button) findViewById(R.id.Five);
        Button Six = (Button) findViewById(R.id.Six);
        Button Seven = (Button) findViewById(R.id.Seven);
        Button Eight = (Button) findViewById(R.id.Eight);
        Button Nine = (Button) findViewById(R.id.Nine);
        Button Point = (Button) findViewById(R.id.Point);
        Button Zero = (Button) findViewById(R.id.Zero);
        Button Minus = (Button) findViewById(R.id.Minus);

        Button[] Buttons = new Button[12];
        Buttons[0] = One;
        Buttons[1] = Two;
        Buttons[2] = Three;
        Buttons[3] = Four;
        Buttons[4] = Five;
        Buttons[5] = Six;
        Buttons[6] = Seven;
        Buttons[7] = Eight;
        Buttons[8] = Nine;
        Buttons[9] = Point;
        Buttons[10] = Zero;
        Buttons[11] = Minus;

        final TextView answerView = (TextView) findViewById(R.id.Answer);
        answerView.setText("");

        for(final Button b: Buttons){
            b.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v) {
                    answerView.append(b.getText());
                }
            });
        }








        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Integer.parseInt(answerView.getText().toString()) == answer){
                    SnackBarMessage = "Correct";
                }else{
                    SnackBarMessage = "Wrong";
                }

                Snackbar.make(view, SnackBarMessage, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

    public Integer MakeNumber(int i){
        Integer Output = 0;
        for(int counter = 0; counter<i;counter++){
            Output = Output + (10^counter) *((int) Math.floor(9.9*Math.random()));
        }
        return Output;
    }
}

