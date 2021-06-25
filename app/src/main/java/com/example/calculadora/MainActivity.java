package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtResult;
    private Button btnNumberOne;
    private Button btnNumberTwo;
    private Button btnNumberThree;
    private Button btnNumberFour;
    private Button btnNumberFive;
    private Button btnNumberSix;
    private Button btnNumberSeven;
    private Button btnNumberEight;
    private Button btnNumberNine;
    private Button btnNumberZero;
    private Button btnPlus;
    private Button btnLess;
    private Button btnMulti;
    private Button btnDiv;
    private Button btnEquual;
    private Button btnClear;

    private int numberOne;
    private int numberTwo;
    private String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setView();
    }


    public void setView() {
        txtResult = findViewById(R.id.txtResult);
        btnNumberOne = findViewById(R.id.btnOne);
        btnNumberTwo = findViewById(R.id.btnTwo);
        btnNumberThree = findViewById(R.id.btnThree);
        btnNumberFour = findViewById(R.id.btnFour);
        btnNumberFive = findViewById(R.id.btnFive);
        btnNumberSix = findViewById(R.id.btnSix);
        btnNumberSeven = findViewById(R.id.btnSeven);
        btnNumberEight = findViewById(R.id.btnEight);
        btnNumberNine = findViewById(R.id.btnNine);
        btnNumberZero = findViewById(R.id.btnZero);
        btnPlus = findViewById(R.id.btnPlus);
        btnMulti = findViewById(R.id.btnMultli);
        btnDiv = findViewById(R.id.btnDiv);
        btnEquual = findViewById(R.id.btnEqual);
        btnClear = findViewById(R.id.btnClear);

        btnNumberOne.setOnClickListener(this);
        btnNumberTwo.setOnClickListener(this);
        btnNumberThree.setOnClickListener(this);
        btnNumberFour.setOnClickListener(this);
        btnNumberFive.setOnClickListener(this);
        btnNumberSix.setOnClickListener(this);
        btnNumberSeven.setOnClickListener(this);
        btnNumberEight.setOnClickListener(this);
        btnNumberNine.setOnClickListener(this);
        btnNumberZero.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnMulti.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnEquual.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnClear){
            resetValues();
        }
        else if(v.getId() == R.id.btnDiv){
            makeOperation(Integer.parseInt(txtResult.getText().toString()), "division");
        }
        else if(v.getId() == R.id.btnPlus){
            makeOperation(Integer.parseInt(txtResult.getText().toString()), "pluss");
        }
        else if(v.getId() == R.id.btnLess){
            makeOperation(Integer.parseInt(txtResult.getText().toString()), "less");
        }
        else if(v.getId() == R.id.btnMultli){
            makeOperation(Integer.parseInt(txtResult.getText().toString()), "multiply");
        }
        else if(v.getId() == R.id.btnEqual){

        } else {
            if(!operation.equalsIgnoreCase("") && numberOne != 0){
                txtResult.setText("");
            }
            Button btnButton = findViewById(v.getId());
            txtResult.setText(txtResult.getText() + btnButton.getText().toString());
        }
    }

    private void makeOperation(int number, String operationSelected){
        txtResult.setText("");
        if(numberOne != 0) {
            numberTwo = number;
            resultOperation(operation);
            operation = operationSelected;
        }
        else {
            operation = operationSelected;
            numberOne = number;
        }
        resultOperation(operationSelected);
    }

    private void resultOperation(String operation){
        if(operation.equalsIgnoreCase("plus")){
            numberOne = numberOne+numberTwo;
        }else if(operation.equalsIgnoreCase("less")){
            numberOne = numberOne-numberTwo;
        }else if(operation.equalsIgnoreCase("multiply")){
            numberOne = numberOne*numberTwo;
        }else {
            Double result = (double)numberOne/(double)numberTwo;
            numberOne = result.intValue();
            txtResult.setText(result.toString());
        }
        if(!operation.equalsIgnoreCase("division")){
            txtResult.setText(String.valueOf(numberOne));
        }
        numberOne = numberTwo;
        numberTwo = 0;
    }

    private void resetValues() {
        txtResult.setText("");
        numberOne = 0;
        numberTwo = 0;
        operation = "";
    }


}