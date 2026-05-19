package org.firstinspires.ftc.teamcode.RobotMecanum.Subsystems;

import com.qualcomm.robotcore.hardware.Servo;

public class Spoon {
    private final Servo spoon;
    public static final int MAX_ANGLE_BY_RANGE = 1;
    public static final int MIN_ANGLE_BY_RANGE = 0;

    public Spoon(Servo spoon) {
        spoon.setDirection(Servo.Direction.FORWARD);
        this.spoon = spoon;
    }

    public void moveUp() {
        spoon.setPosition(MAX_ANGLE_BY_RANGE);
    }

    public void moveDown() {
        spoon.setPosition(MIN_ANGLE_BY_RANGE);
    }
}
