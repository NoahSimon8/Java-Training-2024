// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class Turn extends Command {

  private double setpointRad;
  private double kP = 0.4;

  public Turn(double setpointRad) {
    this.setpointRad = setpointRad;
    addRequirements(Robot.flywheel);
  }

  @Override
  public void initialize() {
    SmartDashboard.putNumber("kP", kP);
  }

  @Override
  public void execute() {
    double error = setpointRad - Robot.flywheel.getPositionRad();
    double proportionOutput = error * kP;
    Robot.flywheel.setVoltage(proportionOutput);
    SmartDashboard.putNumber("error", error / (2 * Math.PI) * 360);
  }

  @Override
  public void end(boolean interrupted) {
    Robot.flywheel.setVoltage(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
