package frc.robot.Auto;

import edu.wpi.first.wpilibj.Timer;
import frc.robot.Telemetry;
import frc.robot.Auto.CAS.ChickenCommands.ChickenCommand;

public class MoveCommand extends ChickenCommand {
    double time;
    double startTime;
    double speed;

    public MoveCommand(double time, double speed){
        this.time = time;
        this.speed = speed;
    }

    public void init(){
        this.startTime = Timer.getFPGATimestamp();
        this.isFinished = false;
        Telemetry.setSimVelocity(speed);
    }

    public void update(){
        if(Timer.getFPGATimestamp() < startTime+time){
            Telemetry.setSimVelocity(speed);
            this.isFinished = false;
        } else {
            this.isFinished = true;
        }
    }

    public void whenFinished(boolean interrupted){
        Telemetry.setSimVelocity(0);
    }
}
