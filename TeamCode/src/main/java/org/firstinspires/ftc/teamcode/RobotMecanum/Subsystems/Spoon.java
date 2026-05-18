package org.firstinspires.ftc.teamcode.RobotMecanum.Subsystems;

import com.qualcomm.robotcore.hardware.Servo;

public class Spoon {
    private Servo spoon;
    public static int MAXANGLEBYRANGE = 1;
    public static int MINANGLEBYRANGE = 0;

    public Spoon(Servo spoon) {
        spoon.setDirection(Servo.Direction.FORWARD);
        this.spoon = spoon;
    }

    public void moveUp() {
        spoon.setPosition(MAXANGLEBYRANGE);
    }

    public void moveDown() {
        spoon.setPosition(MINANGLEBYRANGE);
    }
}
