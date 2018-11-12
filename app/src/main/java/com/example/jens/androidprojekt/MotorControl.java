package com.example.jens.androidprojekt;

public class MotorControl {
    private BluetoothConnector connector;
    private CompasSensorControl compas;


    byte motor = 0x00;
    byte motorSpeed = 0x00;
    byte motorRegulationMode = 0x01;
    byte motorRunState = 0x20;

    byte[] command;


    public MotorControl(BluetoothConnector connector, CompasSensorControl compas) {
        this.connector = connector;
        this.compas = compas;

    }

    public void turn90DegreeRight() {
        int degree = compas.getSensorData();
        // TODO: 09.11.2018 while schleife anpassen je nach dem welche werte der kompass zurueck gibt
        while (degree + 90 >= compas.getSensorData()) {
            turnRight();
        }
        stop();


    }

    public void turn90DegreeLeft() {

        int degree = compas.getSensorData();
        // TODO: 09.11.2018 while schleife anpassen je nach dem welche werte der kompass zurueck gibt
        while (degree - 90 <= compas.getSensorData()) {
            turnLeft();
        }
        stop();


    }

    // TODO: 06.11.2018
    public void stop() {
        motor = 0x02;
        motorSpeed = 0x00;
        motorRunState = 0x00;
        motorRegulationMode = 0x00;
        sendByte();
        motor = 0x01;
        sendByte();


    }

    // TODO: 06.11.2018  
    public void driveForward() {
        motorRegulationMode = 0x01;
        motorRunState = 0x20;
        motor = 0x02;
        motorSpeed = 0x20;
        sendByte();
        motor = 0x01;
        sendByte();


    }



    public void turnLeft() {
        motorRegulationMode = 0x01;
        motorRunState = 0x20;
        motor = 0x01;
        motorSpeed = 0x20;
        sendByte();
        motor = 0x02;
        motorSpeed = -0x20;
        sendByte();


    }

   
    public void turnRight() {
        motorRegulationMode = 0x01;
        motorRunState = 0x20;
        motor = 0x02;
        motorSpeed = 0x20;
        sendByte();
        motor = 0x01;
        motorSpeed = -0x20;
        sendByte();


    }

    public void sendByte() {
        command = new byte[]{0x0C, 0x00, 0x00, 0x04, motor, motorSpeed, 0x05, motorRegulationMode, motorSpeed, motorRunState, 0x00, 0x00, 0x00, 0x00};
        connector.sendbyte(command);

    }


}

