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
    public TextView testtext;
    public CompasSensorControl compass;


    //Ausfuerung bei start der app
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connector = new BluetoothConnector("00:16:53:07:1D:00");
        textView = (TextView) findViewById(R.id.textView5);
        testtext = (TextView) findViewById(R.id.SensorTextView);


    }

    //onclickfunktion zum verbinden
    public void connectOnClick(View v) {


        boolean connectiontest;

        //Verbinden
        connectiontest = connector.connect();


        if (connectiontest) {


            textView.setText("funktioniert");


            try {

                //In/Out putstream festlegen
                control = new MotorControl(connector,compass);
                connector.bluetoothInStream = connector.bluetoothSocket.getInputStream();
                connector.bluetoothOutStream = connector.bluetoothSocket.getOutputStream();
                textView.setText("Verbunden mit: " + connector.address);
            } catch (IOException e) {


            }


        } else {

            textView.setText("Verbindung fehlgeschlagen");
        }


    }


    //onclick zum senden einer nachricht welche einen ton erzeugt
    public void soundonclick(View v) {
        //byte fuer ton
        byte[] test = new byte[]{0x06, 0x00, 0x00, 0x03, 0x0B, 0x02, (byte) 0xF4, 0x01};


        // connector.sendbyte(test);
        connector.sendbyte(test);

    }

    // onclick fuer Sensor Daten
    public void Sensoronclick(View v) {


    }

    public void VorwaertsOnClick(View v){

        control.driveForward();


    }

    public void StopOnClick(View v){

        control.stop();

    }

    public void LeftOnClick(View v){

        control.turnLeft();

    }

    public void RightOnClick(View v){

        control.turnRight();

    }


    public static void main(String[] args) {


    }


}
