package com.example.jens.androidprojekt;

import javax.microedition.sensor.NXTADSensorInfo;

import lejos.nxt.I2CPort;
import lejos.nxt.SensorPort;
import lejos.nxt.addon.CompassHTSensor;

public class CompasSensorControl {
    private BluetoothConnector connector;

    public CompasSensorControl(BluetoothConnector connector) {
        this.connector = connector;
    }
    private CompassHTSensor compass = new CompassHTSensor(SensorPort.S1); // Port S1 - S4, noch definieren?

    /*
        Davor mit einem calibrateDegree Nullen!
     */
    public float getDegrees(){ //Cartesian
        return compass.getDegreesCartesian();
    }

    public float getDegrees2(){ //orientiert sich an Norden, zum benutzen umständlicher
        return compass.getDegrees();
    }

    public void calibrateDegree(){
        compass.resetCartesianZero();
    }

    public void calibrate(){
        compass.startCalibration();
        // TODO: Der NXT muss sich langsam drehen, vorgeschlagen sind 1-1,5 Umdrehungen in mind. 20 Sekunden
        compass.stopCalibration();
    }
}
