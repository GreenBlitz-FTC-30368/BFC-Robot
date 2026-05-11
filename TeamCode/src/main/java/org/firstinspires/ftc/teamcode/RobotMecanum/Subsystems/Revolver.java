package org.firstinspires.ftc.teamcode.RobotMecanum.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class Revolver {
    private DcMotorEx revolverMotor;
    private byte isFilled;
    private int state;
    private double positionDegrees;
    public Revolver(DcMotorEx revolverMotor){
        this.revolverMotor =revolverMotor;
        isFilled = 0;
        state = 0;
        revolverMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void rotate(double degrees, double tolerance){
        double got = 0;
        double timeBetweenSamples=0.1;
        double signOfDifference;
        while (Math.abs(got-degrees)<=tolerance){
            signOfDifference = Math.signum(degrees-got);
            got+=timeBetweenSamples*revolverMotor.getVelocity(AngleUnit.DEGREES)/60;
            revolverMotor.setPower(-signOfDifference);
            try {
                Thread.sleep((int) (timeBetweenSamples * 1000));
            } catch (Exception _){}
        }
        revolverMotor.setPower(0);
        positionDegrees+=got;
    }

    public boolean rotateUntilEmpty(){
        for (int i=0; i<3; i++){
            if ((1<<((state+i)%3)&isFilled)!=0){
                rotate(120*((state+1)%3-1),5);
                state = (state+i)%3;
                return true;
            }
        }
        return false;
    }

    public void fillCurrent(){
        isFilled= (byte) (isFilled|(1<<state));
    }

    public void rotateBalls(int balls){
        rotate(balls*120,5);
    }
}
