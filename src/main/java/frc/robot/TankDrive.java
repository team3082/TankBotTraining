package frc.robot;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class TankDrive {
  static TankSide left;
  static TankSide right;

  public static void init() {
    VictorSPX backRight = new VictorSPX(0);
    VictorSPX frontRight = new VictorSPX(0);
    VictorSPX backLeft = new VictorSPX(0);
    VictorSPX frontLeft = new VictorSPX(0);

    left = new TankSide(frontLeft, backLeft, false);
    right = new TankSide(frontRight, backRight, true);
  }

  public static void drive(double percentRight, double percentLeft) {
    left.output(percentLeft);
    right.output(percentRight);
  }

  public static void arcadeDrive(double rotate, double drive) {
    // Variables for assigning output values
    double max = Math.max(Math.abs(rotate), Math.abs(drive)); // The most extreme value
    double total = drive + rotate;
    double difference = drive - rotate;

    double rightOutput = 0;
    double leftOutput = 0;

    // Constraining by quadrant
    // Joystick (x,y) -> Motor output [L, R] (in terms of percent output)
    if (drive >= 0) { // Q1 and Q2
      if (rotate >= 0) { // Q1
        // (1, 1) -> [1, 0]
        leftOutput = (max);
        rightOutput = (difference);
      } else { // Q2
        // (-1, 1) -> [0, 1]
        leftOutput = (total);
        rightOutput = (max);
      }
    } else { // Q3 and Q4
      if (rotate >= 0) { // Q4
        // (1,-1) -> [-1, 0]
        rightOutput = (-max);
        leftOutput = (total);
      } else { // Q3
        // (-1,-1) -> [0, -1]
        rightOutput = (difference);
        leftOutput = (-max);
      }
    }

    if (Robot.isReal()) {
      right.output(rightOutput);
      left.output(leftOutput);
    } else {
      Telemetry.setSimRot(rightOutput - leftOutput);
      Telemetry.setSimVelocity(leftOutput + rightOutput);
    }
  }
}
