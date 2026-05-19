package org.firstinspires.ftc.teamcode.RobotMecanum;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.RobotMecanum.Subsystems.Flywheel;
import org.firstinspires.ftc.teamcode.RobotMecanum.Subsystems.Intake;
import org.firstinspires.ftc.teamcode.RobotMecanum.Subsystems.Mecanum;
import org.firstinspires.ftc.teamcode.RobotMecanum.Subsystems.Rail;

public class RobotMecanum {
    private final Rail rail;
    private final Flywheel flywheel;
    private final Mecanum mecanum;
    private final IMU imu;
    private final Intake intake;

    public Intake getIntake() {
        return intake;
    }

    public RobotMecanum(HardwareMap hardwareMap) {
        this.rail = new Rail(
                hardwareMap.crservo.get("rightRail"),
                hardwareMap.crservo.get("leftRail")
        );
        this.flywheel = new Flywheel(
                hardwareMap.get(DcMotorEx.class,"flywheelMotor"),
                hardwareMap.get(DcMotor.class,"flywheelMotor2")
        );
        this.mecanum = new Mecanum(hardwareMap); //TODO: name calibration
        this.imu = hardwareMap.get(IMU.class,"imu");
        this.intake = new Intake(hardwareMap.get(DcMotor.class, "intakeMotor"));
        imu.initialize(new IMU.Parameters(
                new RevHubOrientationOnRobot(
                        RevHubOrientationOnRobot.LogoFacingDirection.LEFT, RevHubOrientationOnRobot.UsbFacingDirection.FORWARD
                )
        ));
        imu.resetYaw();
    }

    public Rail getRail() {
        return rail;
    }

    public Flywheel getFlywheel() {
        return flywheel;
    }

    public Mecanum getMecanum() {
        return mecanum;
    }
    public IMU getImu(){
        return imu;
    }
    public double getYaw(){
        return imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES);
    }

//     .-. __ _ .-.
//     |  `  / \  |
//     /     '.()--\
//    |         '._/
//   _| O   _   O |_
//   =\    '-'    /=
//     '-._____.-'
//     /`/\___/\`\
//    /\/o     o\/\
//   (_|         |_)
//     |____,____|
//     (____|____)

}
