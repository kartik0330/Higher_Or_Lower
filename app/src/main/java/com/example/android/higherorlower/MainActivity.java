package com.example.android.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int numberToBeGuessed;


    public void generateNextNumberToGuess(){

        Random rand = new Random();

        numberToBeGuessed = rand.nextInt(20) + 1;

    }

    public void  checkTheNumber(View view){

        EditText editText = (EditText) findViewById(R.id.numGuessed);

        int numberEntered = Integer.parseInt(editText.getText().toString());

        String message ;

        if(numberEntered > numberToBeGuessed){

            message = "LOWER!";

        } else if(numberEntered < numberToBeGuessed){

            message = "HIGHER!";

        } else {

            message = "YOU GOT IT RIGHT! PLAY AGAIN";

            generateNextNumberToGuess();

        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

        Log.i("Number Entered", editText.getText().toString());

        Log.i("Random Number", Integer.toString(numberToBeGuessed));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateNextNumberToGuess();
    }
}
