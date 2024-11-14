package frc.robot;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Auto.CAS.CommandRunner;

public class Telemetry {
  private static Field2d field;
  private static Vector2 simVel = new Vector2();
  private static double simRot = 0;

  public static void init() {

    field = new Field2d();

    SmartDashboard.putData("Field", field);
    SmartDashboard.putData("AutoSelector", CommandRunner.getSelector());
  }

  public static void update() {

    field.setRobotPose(getSimPose());

    field.setRobotPose(
        field.getRobotPose().getX() + simVel.x,
        field.getRobotPose().getY() + simVel.y,
        field.getRobotPose().getRotation().plus(Rotation2d.fromRadians(simRot)));
  }

  /**
   * Sets the linear robot velocity based on magnitude, and rotates it based on current robot
   * rotation
   *
   * @param mag The magnitude of the straight line vector representing forward and backward tank
   *     motion
   */
  public static void setSimVelocity(double mag) {
    simVel = new Vector2(mag, mag);
    simVel = simVel.rotate(field.getRobotPose().getRotation().getRadians() - Math.PI / 4);
    // 6in wheel diameter
    // rpm -> 4200/9
    // rpm * d
    simVel = simVel.mul((93.33) * .025 * .02);
  }

  public static void setSimRot(double rot) {
    // Rotation speed -> 0.656 revolutions/s
    simRot = (0.656 * rot);
    simRot *= (2 * Math.PI); // Convert to radians/s
    simRot *= 0.02; // Accounting for periodic being called every 20 ms
  }

  public static Pose2d getSimPose() {
    return field.getRobotPose();
  }
}
