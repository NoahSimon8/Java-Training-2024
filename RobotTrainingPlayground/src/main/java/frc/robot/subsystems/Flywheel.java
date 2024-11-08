// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.FlywheelSim;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Flywheel extends SubsystemBase {

  private FlywheelSim flywheel = new FlywheelSim(DCMotor.getNEO(1), 6.75,
      0.02931);

  private double positionRad = 0;

  public Flywheel() {
  }

  public void setVoltage(double volts) {
    if (volts > 12) {
      volts = 12;
    } else if (volts < -12) {
      volts = -12;
    }
    flywheel.setInputVoltage(volts);
    SmartDashboard.putNumber("Applied Volts", volts);

  }

  public double getPositionRad() {
    return positionRad;
  }

  @Override
  public void periodic() {
    flywheel.update(0.02);

    positionRad += flywheel.getAngularVelocityRadPerSec() * 0.02;
    SmartDashboard.putNumber("Position Deg", positionRad / (2 * Math.PI) * 360);
    SmartDashboard.putNumber("Velocity DegPerSec",
        flywheel.getAngularVelocityRadPerSec() / (2 * Math.PI) * 360);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
