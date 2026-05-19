package org.firstinspires.ftc.teamcode.RobotMecanum.Subsystems;

import com.qualcomm.robotcore.hardware.Servo;

public class Hood {
    private final Servo hood;
    private static final double degreesToMoveHoodServo = 0.016;
    public Hood(Servo hood) {
        hood.setDirection(Servo.Direction.FORWARD);
        hood.setPosition(0.5);
        this.hood = hood;
    }

    public void moveForwards() {
        moveDegrees(Servo.Direction.FORWARD);
    }

    public void moveBackwards() {
        moveDegrees(Servo.Direction.REVERSE);
    }

    public void moveDegrees(Servo.Direction direction) {
        hood.setDirection(direction);
        hood.setPosition(hood.getPosition()+degreesToMoveHoodServo);
    }
}
