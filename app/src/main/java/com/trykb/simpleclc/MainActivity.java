package com.trykb.simpleclc;

import static com.trykb.simpleclc.R.*;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;

  private Button  btnAC,btnDel, btnAdd , btnMinus, btnDivide , btnMulti, btnEquals, btnDot;

    private TextView textViewResult,textViewHistory;

    private String number = null;

    double firstNumber = 0;
    double lastNumber = 0;

    String status = null;
    boolean operator = false;

    DecimalFormat myformatter = new DecimalFormat("######.######");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3= findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnAC = findViewById(R.id.btnAC);
        btnDel = findViewById(R.id.btnDel);
        btnAdd = findViewById(R.id.btnAdd);
        btnMinus = findViewById(R.id.btnMinus);
        btnMulti = findViewById(R.id.btnMulti);
        btnDot = findViewById(R.id.btnDot);


        textViewResult = findViewById(id.textViewResult);
        textViewHistory = findViewById(id.textViewHistory);


        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                numberClick("0");

            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                numberClick("1");

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                numberClick("2");

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                numberClick ("3");

            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                numberClick("4");

            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                numberClick("5");


            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                numberClick("6");

            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                numberClick("7");

            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                numberClick("8");

            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                numberClick("9");

            }
        });

        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                number = null;
                status = null;
                textViewResult.setText("0");
                textViewHistory.setText("");
                firstNumber = 0;
                lastNumber = 0;

            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                number = number.substring(0,number.length()-1);
                textViewResult.setText(number);

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (operator == true)
                {
                    if (status == "multiplication")
                    {
                        multiply();
                    }
                    else if (status == "division")
                    {
                        divide();
                    }
                    else if (status == "subtraction")
                    {
                        minus();
                    }
                    else
                    {
                        add();
                    }
                }

                status = "sum";
                operator = false;
                number = null;
            }
        });


        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (operator == true)
                {
                    if (status == "multiplication")
                    {
                        multiply();
                    }
                    else if (status == "division")
                    {

                        divide();
                    }

                    else if (status == "sum")
                    {
                        add();
                    }

                    else
                    {
                       minus();
                    }
                }

                status = "subtraction";
                operator = false;
                number = null;
            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operator == true)
                {
                    if(status == "sum")
                    {
                        add();

                    }
                    else if (status == "division")
                    {
                        divide();
                    }
                    else if (status == "subtraction")
                    {
                        minus();
                    }
                    else
                    {
                        multiply();
                    }
                }

                status = "multiplication";
                operator = false;
                number = null;

            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (operator == true)
                {
                    if(status == "multiplication")
                    {
                        multiply();

                    }
                    else if (status == "sum")
                    {
                        add();
                    }
                    else if (status == "subtraction")
                    {
                        minus();
                    }
                    else
                    {
                        divide();
                    }
                }

                status = "division";
                operator = false;
                number = null;


            }
        });

        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(operator )
                {
                   if (status == "sum")
                   {
                       add();
                   }
                   else if (status == "subtraction")
                   {
                      minus();
                   }
                   else if (status == "multiplication")
                   {
                       multiply();
                   }
                   else if (status == "division")
                   {
                       divide();
                   }

                   else
                   {
                       firstNumber = Double.parseDouble(textViewResult.getText().toString());
                   }
                }

                operator = false;

            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (number == null)
                {
                    number = "0."
                }
                else
                {

                }

            }
        });





        public void numberClick(String view)

        {
          if (number == null)
          {
              number = view;
          }
          else
          {
            number = number + view;
          }

          textViewResult.setText(number);
          operator = true;
        }

    }
    public void add()
    {
        lastNumber = Double.parseDouble(textViewResult.getText().toString());
        firstNumber = firstNumber + lastNumber;

        textViewResult.setText(myformatter.format(firstNumber));
    }

    public void minus()
    {
        if (firstNumber == 0)
        {
            firstNumber = Double.parseDouble(textViewResult.getText().toString());

        }
        else
        {
           lastNumber = Double.parseDouble(textViewResult.getText().toString());
           firstNumber = firstNumber - lastNumber;

        }
        textViewResult.setText(myformatter.format(firstNumber));
    }

    public void multiply()
    {
        if(firstNumber == 0)
        {
            firstNumber = 1;
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = firstNumber * lastNumber;
        }
        else
        {
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = firstNumber * lastNumber;
        }
        textViewResult.setText(myformatter.format(firstNumber));
    }
    public void divide()
    {
        if(firstNumber == 0)
        {
           lastNumber = Double.parseDouble(textViewResult.getText().toString());
           firstNumber = lastNumber / 1;

        }
        else
        {
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = firstNumber / lastNumber;
        }
        textViewResult.setText(myformatter.format(firstNumber));
    }

}

