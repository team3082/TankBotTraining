// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.Auto.AutoRoutines;
import frc.robot.Auto.CAS.CommandRunner;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    CommandRunner.addRoutineClass(new AutoRoutines());
    TankDrive.init();
    Telemetry.init();
  }

  @Override
  public void robotPeriodic() {
    Telemetry.update();
  }

  @Override
  public void autonomousInit() {
    CommandRunner.initRoutine();
    
  }

  @Override
  public void autonomousPeriodic() {
    CommandRunner.update();
  }

  @Override
  public void teleopInit() {
    OI.init();
  }

  @Override
  public void teleopPeriodic() {
    OI.update();
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
