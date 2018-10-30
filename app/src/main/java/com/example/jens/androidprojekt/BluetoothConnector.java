package com.example.jens.androidprojekt;


import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;

import java.io.IOException;
import java.util.UUID;

public class BluetoothConnector {
    // Variabelen zum Conect
    public BluetoothAdapter bluetoothAdapter;
    public BluetoothSocket bluetoothSocket;
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




}
