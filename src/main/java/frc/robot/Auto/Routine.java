package frc.robot.Auto;

import frc.robot.Auto.CAS.AutoRoutine;
import frc.robot.Auto.CAS.ChickenCommands.ChickenCommand;
import frc.robot.Auto.CAS.ChickenCommands.DebugCommand;
import frc.robot.Auto.CAS.ChickenCommands.LoopCommand;
import frc.robot.Auto.Commands.MoveForward;

public class Routine {
    @AutoRoutine
    public ChickenCommand[] bigGuapoBoogaloo(){
        return new ChickenCommand[]{
            new MoveForward(.7, .3),
            new MoveForward(.7, -.3),
            new DebugCommand("Oliver is super very extremely amazaing"),
            new MoveForward(.7, .3),
            new MoveForward(.7, -.3),
            new DebugCommand("onemilio is super very extremely amazaing")
        };
    }
}
