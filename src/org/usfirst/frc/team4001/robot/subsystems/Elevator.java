package org.usfirst.frc.team4001.robot.subsystems;

import org.usfirst.frc.team4001.robot.ElectricalConstants;
import org.usfirst.frc.team4001.robot.NumberConstants;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {

	private WPI_TalonSRX elevatorMotor;
	private Solenoid pushSolIn;
	private Solenoid pushSolOut;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	
	public Elevator() {
		elevatorMotor = new WPI_TalonSRX(ElectricalConstants.ELEVATOR_MOTOR);
		pushSolIn = new Solenoid(ElectricalConstants.ELEVATOR_SOL_IN);
		pushSolOut = new Solenoid(ElectricalConstants.ELEVATOR_SOL_OUT);
	}
	
	public void setSpeed(double power) {
		elevatorMotor.set(power);
		elevatorMotor.configVoltageCompSaturation(NumberConstants.elevatorMaxVoltage, 25);
	}
	
	public double getVoltage() {
		return elevatorMotor.getBusVoltage();
	}
	
	public void hardStop() {
		elevatorMotor.set(0);
	}
	
	
	public void pushOut() {
		pushSolIn.set(false);
		pushSolOut.set(true);
	}
	
	public void pushIn() {
		pushSolIn.set(true);
		pushSolOut.set(false);
	}
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

