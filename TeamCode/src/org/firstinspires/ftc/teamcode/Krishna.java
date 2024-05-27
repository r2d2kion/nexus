

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Amecanum bot demo 2", group = "MecanumBot")
public class Krishna extends LinearOpMode {

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
            // Setup a variable for each drive wheel to save power level for telemetry
            //double leftPower;
            forward();
            //telemetryUpdate();
            //backward();
            //forward();
            turnback();
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
