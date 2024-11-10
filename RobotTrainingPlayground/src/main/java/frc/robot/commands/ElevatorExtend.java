package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;

public class ElevatorExtend extends Command{

    private double amount;

    public ElevatorExtend(double amount){
        this.amount = amount;
        addRequirements(Robot.elevator);
    }
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        Robot.elevator.setElevatorDistance(Robot.elevator.getElevatorDist() + amount);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
    return false;
    }
}
