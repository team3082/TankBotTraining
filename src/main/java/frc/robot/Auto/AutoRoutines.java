package frc.robot.Auto;

import frc.robot.Auto.CAS.AutoRoutine;
import frc.robot.Auto.CAS.ChickenCommands.ChickenCommand;
import frc.robot.Auto.CAS.ChickenCommands.DebugCommand;
import frc.robot.Auto.CAS.ChickenCommands.LoopCommand;

public class AutoRoutines {
    @AutoRoutine
    public ChickenCommand[] ElectricBoogaloo(){
        return new ChickenCommand[]{
            new LoopCommand(
                5, 
                new MoveCommand(1, 1),
                new MoveCommand(1, -1),
                new DebugCommand("Electric Boogaloo")
            )
        };
    }
}
