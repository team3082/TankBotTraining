package frc.robot.Auto.Commands;

import edu.wpi.first.wpilibj.Timer;
import frc.robot.TankDrive;
import frc.robot.Auto.CAS.ChickenCommands.ChickenCommand;

public class MoveForward extends ChickenCommand {
    private double time;
    private double startTime;
    private double speed;

    public MoveForward(double duration, double speed){
        time = duration;
        this.speed = speed;
    }

    public void init(){
        this.startTime = Timer.getFPGATimestamp();
        this.isFinished = false;
    }

    public void update(){
        if (startTime + time >  Timer.getFPGATimestamp()){
            TankDrive.drive(speed, speed);
        } else {
            isFinished = true;
        }
    }

    public void whenFinished(boolean interrupted){
        TankDrive.drive(0, 0);
    }
}
