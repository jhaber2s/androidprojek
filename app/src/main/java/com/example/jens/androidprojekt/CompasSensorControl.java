package com.example.jens.androidprojekt;

import javax.microedition.sensor.NXTADSensorInfo;

import lejos.nxt.addon.CompassHTSensor;

public class CompasSensorControl {
    private BluetoothConnector connector;

    private byte responserequested = 0x00;
    private byte commandid = 0x05;
    private byte port = 0x00;
    private byte sensortype = 0x0A; // Low speed sensor
    private byte sensormode = 0x00; // raw

    public CompasSensorControl(BluetoothConnector connector) {
        this.connector = connector;
    }

    public void initPort(){
        connector.sendbyte(new byte[]{responserequested,commandid,port,sensortype,sensormode});
    }

    public void initSensor(){
        connector.sendbyte(new byte[]{responserequested,0x0F,port,0x03,0x0,0x02,0x41,sensormode}); //'Die 0x41 wird falsch sein, probieren? Vielleicht findet wer was?
    }

    public void lswrite(){
        connector.sendbyte(new byte[]{responserequested,commandid,port,0x02,0x06,0x02,0x46}); //0x02 und 0x46 am Ende für den ColorSensor, richtige Adresse herausfinden!
    }

    private byte[] lsread(){
        connector.sendbyte(new byte[]{responserequested,commandid,port});
        return new byte[]{0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00}; // rückgabe für Sendbyte muss noch geschrieben werden. Methode im BT Connector?
    }

    // TODO: 06.11.2018
    public int getSensorData() {
        byte[] ret = lsread();
        if(ret[2] == 0x20) // Fehler, wiederhole Anfrage
            return -1;
        /*
        Hier Berechnung aus den Bytes in Int.
         */
        return 0;
    }


}
