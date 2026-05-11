package org.firstinspires.ftc.teamcode.RobotMecanum.Subsystems;

import com.qualcomm.robotcore.hardware.Servo;

public class Spoon {
    private Servo spoon;

    public Spoon(Servo spoon) {
        spoon.setDirection(Servo.Direction.FORWARD);
        this.spoon = spoon;
    }

    public void moveUp(){
        spoon.setPosition(1);
    }

    public void moveDown(){
        spoon.setPosition(0);
    }
}
