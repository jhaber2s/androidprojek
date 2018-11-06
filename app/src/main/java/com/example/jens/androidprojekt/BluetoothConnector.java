package com.example.jens.androidprojekt;


import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

public class BluetoothConnector {
    // Variabelen zum Conect
    public BluetoothAdapter bluetoothAdapter;
    public BluetoothSocket bluetoothSocket;
    public OutputStream bluetoothOutStream;
    public InputStream bluetoothInStream;
    public String address;

    //Constructor mit Adress uebergabe
    public BluetoothConnector(String adress) {
        this.address = adress;
        this.bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    }

    //Verbindungs Methode
    public boolean connect() {
        boolean connected = false;

        //nxt als ziel waehlen
        BluetoothDevice nxt = this.bluetoothAdapter.getRemoteDevice(this.address);


        //connect
        try {
            this.bluetoothSocket = nxt.createRfcommSocketToServiceRecord(UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"));
            this.bluetoothSocket.connect();
            connected = true;
        } catch (IOException e) {

            connected = false;

        }

        return connected;
    }

    //Daten in form von Byte array an den NXT Senden
    public void sendbyte(byte[] message) {

        try {
            bluetoothOutStream.write(message);
        } catch (IOException e) {


        }


    }
// Datten fom NXT lesen
    // TODO: 06.11.2018  
    public byte[] readbyte() {

        return null;
    }


}
