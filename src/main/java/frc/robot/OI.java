package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI {
  static Joystick driverStick;

  public static void init() {
    driverStick = new Joystick(0);
  }

  public static void update() {
    double rightY = -driverStick.getRawAxis(5);
    double rightX = driverStick.getRawAxis(4);
    // double leftY = -driverStick.getRawAxis(1);

    if (Math.abs(rightY) < 0.05) rightY = 0;
    if (Math.abs(rightX) < 0.05) rightX = 0;

    rightX *= 0.3;
    rightY *= 0.3;

    TankDrive.arcadeDrive(rightX, rightY);

    // TankDrive.drive(rightY, leftY);
  }
}
