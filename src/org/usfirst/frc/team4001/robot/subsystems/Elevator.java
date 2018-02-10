package org.usfirst.frc.team4001.robot.subsystems;

import org.usfirst.frc.team4001.robot.ElectricalConstants;
import org.usfirst.frc.team4001.robot.NumberConstants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */

public class Elevator extends Subsystem {

	private WPI_TalonSRX elevatorMotor;
	private WPI_TalonSRX extendMotor;
	//private WPI_TalonSRX pushMotor;
	private WPI_TalonSRX climbMotor;
	private DigitalInput elevatorLimit;
	//private DigitalInput pusherFrontLimit;
	//private DigitalInput pusherBackLimit;
	private DigitalInput extenderLimit;
	
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public Elevator() {
		elevatorMotor = new WPI_TalonSRX(ElectricalConstants.ELEVATOR_MOTOR);
		elevatorMotor.set(ControlMode.Position, 1);
		/*
		pushMotor = new WPI_TalonSRX(ElectricalConstants.PUSH_MOTOR);
		pushMotor.set(ControlMode.Position, 1);
		*/
		extendMotor = new WPI_TalonSRX(ElectricalConstants.EXTEND_MOTOR);
		extendMotor.set(ControlMode.Position, 1);
		climbMotor = new WPI_TalonSRX(ElectricalConstants.CLIMB_MOTOR);
		
		
		elevatorLimit = new DigitalInput(ElectricalConstants.CUBE_LIFT_LIMIT);
		extenderLimit = new DigitalInput(ElectricalConstants.EXTEND_LIMIT);
		/*
		pusherFrontLimit = new DigitalInput(ElectricalConstants.PUSHER_FRONT_LIMIT);
		pusherBackLimit = new DigitalInput(ElectricalConstants.PUSHER_BACK_LIMIT);
		*/
		
		
		//elevatorMotor.configPeakOutputForward(arg0, arg1) correct method but might not need
	}
	
	public void setElevatorSpeed(double power) {
		elevatorMotor.set(power);
	}
	
	public boolean getElevatorLimit(){
		return elevatorLimit.get();
	}
	
	public boolean getExtenderLimit(){
		return extenderLimit.get();
	}
	/*
	public boolean getPusherFrontLimit(){
		return pusherFrontLimit.get();
	}
	
	public boolean getPusherBackLimit(){
		return pusherBackLimit.get();
	}
	*/
	
	/*
	public void elevatorPushForward(){
		pushMotor.set(0.2);
	}
	*/
	/*
	public void elevatorPushBack(){
		pushMotor.set(-1*0.2);
	}
	*/
	/*
	public void setElevatorEncLocation(int location){
		elevatorMotor.getSensorCollection().setQuadraturePosition(location, 0);
	}
	*/
	
	public void setExtendSpeed(double speed){
		extendMotor.set(speed);
	}
	
	public void setClimbSpeed(double speed) {
		climbMotor.set(speed);
	}
	
	public void elevatorHardStop() {
		elevatorMotor.set(0);
	}
	
	public void extendHardStop(){
		extendMotor.set(0);
	}
	/*
	public void pusherHardStop(){
		pushMotor.set(0);
	}
	*/
	
	public void climbHardStop() {
		climbMotor.set(0);
	}
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}


