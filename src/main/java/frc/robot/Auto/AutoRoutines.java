package frc.robot.Auto;

import frc.robot.Auto.CAS.AutoRoutine;
import frc.robot.Auto.CAS.ChickenCommands.ChickenCommand;

public class AutoRoutines {
    @AutoRoutine
    public ChickenCommand[] exampleRoutine(){
        return new ChickenCommand[]{
            new MoveFowardCommand(1),
        };
    }
}
