package com.example.jens.androidprojekt;

import android.hardware.Sensor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.DataInputStream;
import java.io.DataOutputStream;



public class MainActivity extends AppCompatActivity {

    public BluetoothConnector connector;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }



    public static void main(String [] args)
    {


    }





}
