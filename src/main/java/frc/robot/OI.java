package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI {
  static Joystick driverStick;

  public static void init() {
    driverStick = new Joystick(0);
  }

  public static void update() {
    double leftY = -driverStick.getRawAxis(1);
    double rightX = driverStick.getRawAxis(4);

    if (Math.abs(leftY) < 0.1) leftY = 0;
    if (Math.abs(rightX) < 0.1) rightX = 0;

    TankDrive.arcadeDrive(rightX*.5, leftY*.5);

    // TankDrive.drive(rightY, leftY);
  }
}
