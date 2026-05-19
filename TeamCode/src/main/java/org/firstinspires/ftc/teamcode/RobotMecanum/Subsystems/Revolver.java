package org.firstinspires.ftc.teamcode.RobotMecanum.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class Revolver {
    private DcMotorEx revolverMotor;
    private static final double timeBetweenSamplesSec =0.1;
    private byte isFilled;
    private int currentSelectedIndex;
    private double positionDegrees;

    private static final double defaultTolerance=5;
    public Revolver(DcMotorEx revolverMotor){
        this.revolverMotor =revolverMotor;
        isFilled = 0;
        currentSelectedIndex = 0;
        revolverMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void rotate(double degrees, double tolerance){
        double reachedDegrees = 0;
        double signOfDifference;
        while (Math.abs(reachedDegrees -degrees)<=tolerance){
            signOfDifference = Math.signum(degrees- reachedDegrees);
            reachedDegrees += timeBetweenSamplesSec *revolverMotor.getVelocity(AngleUnit.DEGREES)/60;
            revolverMotor.setPower(-signOfDifference);
            try {
                Thread.sleep((int) (timeBetweenSamplesSec * 1000));
            } catch (Exception _){}
        }
        revolverMotor.setPower(0);
        positionDegrees+= reachedDegrees;
    }

    public boolean rotateUntilEmpty(){
        for (int i=0; i<3; i++){
            if (!isFilledAt(currentSelectedIndex+i)){
                rotateBalls(i);
                currentSelectedIndex = (currentSelectedIndex +i)%3;
                return true;
            }
        }
        return false;
    }

    public boolean rotateUntilFull(){
        for (int i=0; i<3; i++){
            if (isFilledAt(currentSelectedIndex+i)){
                rotateBalls(i);
                currentSelectedIndex = (currentSelectedIndex +i)%3;
                return true;
            }
        }
        return false;
    }

    public boolean isFilledAt(int index){
        return ((1<<Math.floorMod(index,3))&isFilled) != 0;
    }

    public boolean isFilledAt(){
        return isFilledAt(currentSelectedIndex);
    }

    public void fillCurrent(){
        isFilled= (byte) (isFilled|(1<< currentSelectedIndex));
    }

    public void rotateBalls(int numOfBalls){
        rotate(numOfBalls *120,defaultTolerance);
        currentSelectedIndex=(currentSelectedIndex+ numOfBalls);
    }
}
