

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.IMU;

@TeleOp(name = "Auto", group = "MecanumBot")
//@Disabled
public class Auto extends LinearOpMode {

    // Declare OpMode members.
    private DcMotor m1 = null;
    private DcMotor m2 = null;
    private DcMotor m3 = null;
    private DcMotor m4 = null;
    private IMU imu;


    @Override
    public void runOpMode() {

        m1=hardwareMap.get(DcMotor.class, "front_left_motor");
        m2=hardwareMap.get(DcMotor.class, "front_right_motor");
        m3=hardwareMap.get(DcMotor.class, "back_left_motor");
        m4=hardwareMap.get(DcMotor.class, "back_right_motor");
        imu = hardwareMap.get(IMU.class, "imu");
        m1.setDirection(DcMotor.Direction.REVERSE);
        m3.setDirection(DcMotor.Direction.REVERSE);
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        if (opModeIsActive()) {
            double drive = -gamepad1.left_stick_y;  // Forward and backward movement
            double strafe = gamepad1.left_stick_x;  // Left and right movement (strafing)
            double rotate = gamepad1.right_stick_x; // Rotation (turning)
            double frontLeftPower = drive + strafe + rotate;
            double frontRightPower = drive - strafe - rotate;
            double backLeftPower = drive - strafe + rotate;
            double backRightPower = drive + strafe - rotate;

            // Normalize motor powers so no value exceeds 1.0
            double max = Math.max(Math.abs(frontLeftPower), Math.max(Math.abs(frontRightPower),
                    Math.max(Math.abs(backLeftPower), Math.abs(backRightPower))));
            if (max > 1.0) {
                frontLeftPower /= max;
                frontRightPower /= max;
                backLeftPower /= max;
                backRightPower /= max;
            }

            // Set power to the motors
            m1.setPower(frontLeftPower);
            m2.setPower(frontRightPower);
            m3.setPower(backLeftPower);
            m4.setPower(backRightPower);

            // Display the power levels on telemetry for debugging
            telemetry.addData("Front Left Power", m1);
            telemetry.addData("Front Right Power", m2);
            telemetry.addData("Back Left Power", m3);
            telemetry.addData("Back Right Power", m4);
            telemetry.update();

            //forward();
            //telemetryUpdate();
            //backward();
            //forward();
            //turnback();
            //forward();
            //telemetryUpdate();
        }
    }

    private void telemetryUpdate() {
        telemetry.addData("Encoders"," %d %d %d %d", m1.getCurrentPosition(), m2.getCurrentPosition(),
                m3.getCurrentPosition(), m4.getCurrentPosition());
        telemetry.update();
    }

    private void forward() {
        m1.setPower(1);
        m2.setPower(1);
        m3.setPower(1);
        m4.setPower(1);
        sleep(2000);
    }
    private void backward() {
        m1.setPower(-1);
        m2.setPower(-1);
        m3.setPower(-1);
        m4.setPower(-1);
        sleep(2000);
    }
    private void turnback() {
//        m1.setDirection(DcMotor.Direction.FORWARD);
//        m2.setDirection(DcMotor.Direction.FORWARD);
//        m3.setDirection(DcMotor.Direction.FORWARD);
//        m4.setDirection(DcMotor.Direction.FORWARD);
        m1.setPower(-1);
        m2.setPower(1);
        m3.setPower(-1);
        m4.setPower(1);
        sleep(2000);
    }


}
