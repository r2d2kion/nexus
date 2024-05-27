


package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Sahoj Bot", group = "MecanumBot")
public class Sahoj extends LinearOpMode {

    // Declare OpMode members.
    private DcMotor m1 = null;
    private DcMotor m2 = null;
    private DcMotor m3 = null;
    private DcMotor m4 = null;

    @Override
    public void runOpMode() {

        m1=hardwareMap.get(DcMotor.class, "front_left_motor");
        m2=hardwareMap.get(DcMotor.class, "front_right_motor");
        m3=hardwareMap.get(DcMotor.class, "back_left_motor");
        m4=hardwareMap.get(DcMotor.class, "back_right_motor");
        m1.setDirection(DcMotor.Direction.REVERSE);
        m3.setDirection(DcMotor.Direction.REVERSE);
        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        // run until the end of the match (driver presses STOP)
        if (opModeIsActive()) {
            frontdiagonalright();
        }
    }
    private void forward () {
        m1.setPower(0.5);
        m2.setPower(0.5);
        m3.setPower(0.5);
        m4.setPower(0.5);
        sleep(2000);
    }

    private void backward () {
        m1.setPower(-0.5);
        m2.setPower(-0.5);
        m3.setPower(-0.5);
        m4.setPower(-0.5);
        sleep(1000);
    }

    private void leftTurnback () {
        m1.setPower(-0.5);
        m2.setPower(0.5);
        m3.setPower(-0.5);
        m4.setPower(0.5);
        sleep(1000);
    }
    private void rightTurnback () {
        m1.setPower(0.5);
        m2.setPower(-0.5);
        m3.setPower(0.5);
        m4.setPower(-0.5);
        sleep(1000);
    }

    private void sidewaysLeft () {
        m1.setPower(-0.5);
        m2.setPower(0.5);
        m3.setPower(0.5);
        m4.setPower(-0.5);
        sleep(1000);

    }
    private void sidewaysRight () {
        m1.setPower(0.5);
        m2.setPower(-0.5);
        m3.setPower(-0.5);
        m4.setPower(0.5);
        sleep(1000);
    }
    private void frontdiagonalright() {
        m1.setPower(0.5);
        m2.setPower(0);
        m3.setPower(0);
        m4.setPower(-0.5);
        sleep(1000);
    }
}

