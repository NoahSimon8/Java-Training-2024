package frc.robot.subsystems;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.Mechanism2d;
import edu.wpi.first.wpilibj.smartdashboard.MechanismLigament2d;
import edu.wpi.first.wpilibj.smartdashboard.MechanismRoot2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {

    private Mechanism2d elevatorMech = new Mechanism2d(3, 3);
    private MechanismRoot2d elevatorRoot = elevatorMech.getRoot("climber", 1.5, 0.5);
    private MechanismLigament2d elevator = elevatorRoot.append(new MechanismLigament2d("elevator", 0.5, 90));

    private double dist = 0.5;

    public Elevator() {
        elevator.setLineWeight(12);
    }

    public void setElevatorDistance(double dist) {
        this.dist = dist;
        elevatorRoot.setPosition(1.5,dist);
    }

    public double getElevatorDist() {
        return dist;
    }

    @Override
    public void periodic() {
        SmartDashboard.putData("elevator mechanism", elevatorMech);
    }
}
