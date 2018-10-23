package com.example.jens.androidprojekt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import lejos.nxt.Motor;
import lejos.nxt.comm.Bluetooth;
import lejos.nxt.comm.BTConnection;


public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public static void main(String [] args)
    {
        BTConnection btc = Bluetooth.waitForConnection();
        DataInputStream dIN = btc.openDataInputStream();
        DataOutputStream dOut = btc.openDataOutputStream();



    }
}
