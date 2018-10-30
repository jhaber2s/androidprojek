package com.example.jens.androidprojekt;

import android.hardware.Sensor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.DataOutputStream;



public class MainActivity extends AppCompatActivity {

    public BluetoothConnector connector;
    public TextView textView;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connector = new BluetoothConnector("00:16:53:07:1D:00");
        textView = (TextView)findViewById(R.id.textView5);






    }
    public void testOnClick(View v){
        boolean test;
        test = connector.connect();


        if(test) {
            textView.setText("funktioniert");
        }else{

            textView.setText("funktioniert nicht");
        }



    }



    public static void main(String [] args)
    {


    }





}
