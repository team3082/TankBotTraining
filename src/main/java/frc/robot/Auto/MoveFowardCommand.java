package frc.robot.Auto;

import edu.wpi.first.wpilibj.Timer;
import frc.robot.Telemetry;
import frc.robot.Auto.CAS.ChickenCommands.ChickenCommand;

public class MoveFowardCommand extends ChickenCommand {
    double time;
    double startTime;

    public MoveFowardCommand(double time){
        this.time = time;
    }

    public void init(){
        this.startTime = Timer.getFPGATimestamp();
        this.isFinished = false;
        Telemetry.setSimVelocity(1);
    }

    public void update(){
        if(Timer.getFPGATimestamp() < startTime+time){
            Telemetry.setSimVelocity(1);
            this.isFinished = false;
        } else {
            this.isFinished = true;
        }
    }

    public void whenFinished(boolean interrupted){
        Telemetry.setSimVelocity(0);
    }
}
