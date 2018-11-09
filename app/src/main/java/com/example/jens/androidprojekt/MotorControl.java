package com.example.jens.androidprojekt;

public class MotorControl {
    private BluetoothConnector connector;


    byte motor = 0x00;
    byte motorSpeed = 0x00;
    byte motorRegulationMode = 0x01;
    byte motorRunState = 0x20;

    byte[] command;


    public MotorControl(BluetoothConnector connector) {
        this.connector = connector;

    }

    public void turn90DegreeRight() {


    } 

    public void turn90DegreeLeft() {


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


    // TODO: 06.11.2018  kontrolieren welcher motor 1 und welcher 2 ist um die dreh richtung zu bestimmen
    public void turnLeft() {
        motorRegulationMode = 0x01;
        motorRunState = 0x20;
        motor = 0x02;
        motorSpeed = 0x20;
        sendByte();
        motor = 0x01;
        motorSpeed = -0x02;
        sendByte();



    }

    // TODO: 06.11.2018  kontrolieren welcher motor 1 und welcher 2 ist um die dreh richtung zu bestimmen
    public void turnRight() {
        motorRegulationMode = 0x01;
        motorRunState = 0x20;
        motor = 0x02;
        motorSpeed = 0x20;
        sendByte();
        motor = 0x01;
        motorSpeed = -0x02;
        sendByte();


    }

    public void sendByte() {
        command = new byte[]{0x0C, 0x00, 0x00, 0x04, motor, motorSpeed, 0x05, motorRegulationMode, motorSpeed, motorRunState, 0x00, 0x00, 0x00, 0x00};
        connector.sendbyte(command);

    }


}

