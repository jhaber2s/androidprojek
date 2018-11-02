package com.example.jens.androidprojekt;

import android.hardware.Sensor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    public BluetoothConnector connector;
    public TextView textView;
    public MotorControl control;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connector = new BluetoothConnector("00:16:53:07:1D:00");
        textView = (TextView)findViewById(R.id.textView5);






    }
    public void connectOnClick(View v){




        boolean connectiontest;
        connectiontest = connector.connect();


        if(connectiontest) {


            textView.setText("funktioniert");


            try {
                control = new MotorControl(connector);
                connector.bluetoothInStream = connector.bluetoothSocket.getInputStream();
                connector.bluetoothOutStream = connector.bluetoothSocket.getOutputStream();
                textView.setText("Verbunden mit: "+connector.address);
           }
            catch(IOException e)
            {


            }


        }else{

            textView.setText("Verbindung fehlgeschlagen");
        }



    }



    public static void main(String [] args)
    {


    }





}
