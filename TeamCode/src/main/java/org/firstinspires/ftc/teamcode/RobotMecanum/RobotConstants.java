package org.firstinspires.ftc.teamcode.RobotMecanum;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class RobotConstants {
    public static final int wheelAccelerationTimeMS = 1000;
    public static final int timeToShootAnArtifactMS = 500;
    public static final int timeBetweenArtifactShootings = 1000;
    public static final int rPM = 312;
    public static final double mecanumWheelRadiusCm = 5;
    public static final double mecanumDiagonalMaxVelocityCmPerMinute=/*rPM*mecanumWheelRadiusCm*Math.PI*2*/ /*108*60*/ 160.439*60 ; //on school floor, need to configure on arena
    public static final double distanceToShootCm = 120;
    public static final double tileSizeCm = 60.96;
    public static final double diagonalDriftAtMaxVelocityCm = 0; //on school floor, need to configure on arena
}
