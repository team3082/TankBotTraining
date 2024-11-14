package frc.robot.Auto.CAS;

import frc.robot.Auto.CAS.ChickenCommands.ChickenCommand;

@FunctionalInterface
public interface ChickenCommandSupplier {
    ChickenCommand[] getCommands();
}

