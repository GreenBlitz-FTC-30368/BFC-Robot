package org.firstinspires.ftc.teamcode.RobotMecanum;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.RobotMecanum.Subsystems.Flywheel;



public class JoystickBindings {
    public final Gamepad gamepad1;
    public JoystickBindings(Gamepad gamepad1) {
        this.gamepad1 = gamepad1;
    }

    public void mainJoystickButtons(RobotMecanum robot) {
        robot.getMecanum().drive(gamepad1);

        if (gamepad1.right_trigger > 0.5) {
            robot.getRail().go();
        } else {
            robot.getRail().stop();
        }

        if (gamepad1.b) {
            robot.getFlywheel().shoot();
        } else if (gamepad1.x) {
            robot.getRail().rewind();
        } else {
            robot.getRail().stop();
        }

        if (gamepad1.left_bumper) {
            robot.getFlywheel().stop();
        }
        if (gamepad1.back) {
            robot.getFlywheel().stop();
        }
        if (gamepad1.psWasPressed()) {
            robot.getFlywheel().stop();
            robot.getRail().stop();
            robot.getMecanum().stop();
        }
        if (gamepad1.y) {
            robot.getFlywheel().powerModifier = Flywheel.slowModeShootingModifier;
        } else {
            robot.getFlywheel().powerModifier = 1;
        }
//        if (gamepad1.b) {
//            robot.getMecanum().velocityModifier = Mecanum.slowModeVelocityModifier;
//        } else {
//            robot.getMecanum().velocityModifier = 1;
//        }

        if (gamepad1.left_trigger > 0.5) {
            robot.getIntake().spin();
        } else {
            robot.getIntake().stop();
        }


        if (gamepad1.a){
            for (int i = 0; i < 3; i++) {
                robot.getRail().go();
                try{
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                robot.getRail().stop();
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }

    }











}
