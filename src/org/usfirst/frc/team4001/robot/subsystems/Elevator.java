//
//
package org.usfirst.frc.team4001.robot.subsystems;
//
import org.usfirst.frc.team4001.robot.ElectricalConstants;
import org.usfirst.frc.team4001.robot.NumberConstants;
import org.usfirst.frc.team4001.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */

public class Elevator extends Subsystem {

	private WPI_TalonSRX elevatorMotor;
	private WPI_TalonSRX extendMotor;
	private WPI_TalonSRX climbMotor;
	//private WPI_TalonSRX climbMotor2;

	private Victor pushMotor;

	private DigitalInput elevatorLimit;
	//private DigitalInput pusherFrontLimit;
	//private DigitalInput pusherBackLimit;
	private DigitalInput extenderBotLimit;
	private DigitalInput extenderTopLimit;
	
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public Elevator() {
		elevatorMotor = new WPI_TalonSRX(ElectricalConstants.ELEVATOR_MOTOR);
		elevatorMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);		
		
		elevatorMotor.config_kF(0, 0, 0);
		elevatorMotor.config_kP(0, 0.5, 0);
		elevatorMotor.config_kI(0, 0, 0);
		elevatorMotor.config_kD(0, 0, 0);
		
		pushMotor = new Victor(ElectricalConstants.PUSH_MOTOR);
		
		extendMotor = new WPI_TalonSRX(ElectricalConstants.EXTEND_MOTOR);
		extendMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		
		extendMotor.config_kF(0, 0, 0);
		extendMotor.config_kP(0, 0.2, 0);
		extendMotor.config_kI(0, 0, 0);
		extendMotor.config_kD(0, 0, 0);
		//extendMotor.set(ControlMode.Position, 0);
		
		climbMotor = new WPI_TalonSRX(ElectricalConstants.CLIMB_MOTOR);
		//climbMotor2 = new WPI_TalonSRX(ElectricalConstants.CLIMB_MOTOR2);
		
		elevatorLimit = new DigitalInput(ElectricalConstants.CUBE_LIFT_LIMIT);
		extenderBotLimit = new DigitalInput(ElectricalConstants.EXTEND_BOT_LIMIT);
		extenderTopLimit = new DigitalInput(ElectricalConstants.EXTEND_TOP_LIMIT);
		/*
		pusherFrontLimit = new DigitalInput(ElectricalConstants.PUSHER_FRONT_LIMIT);
		pusherBackLimit = new DigitalInput(ElectricalConstants.PUSHER_BACK_LIMIT);
		*/
		
		//elevatorMotor.configPeakOutputForward(arg0, arg1) correct method but might not need
	}
	
	public void setElevatorSpeed(double power) {
		if(elevatorLimit.get() && power < 0){
			elevatorMotor.set(0);
		} else {
			elevatorMotor.set(power);
		}
		
	}
	
	public void setExtendSpeed(double speed){
		
		if(extenderBotLimit.get() && speed < 0){
			extendMotor.set(0);
		}
		else if(extenderTopLimit.get() && speed > 0){
			extendMotor.set(0);
		}
		
		else{
			extendMotor.set(speed);
		}
	}
		
	public void setPusherSpeed(double speed) {
		pushMotor.set(-speed);
	}
	
	public boolean getElevatorLimit(){
		return elevatorLimit.get();
	}
	
	public boolean getExtenderBotLimit(){
		return extenderBotLimit.get();
	}
	
	public boolean getExtenderTopLimit(){
		return extenderTopLimit.get();
	}
	
	/*
	public boolean getPusherFrontLimit(){
		return pusherFrontLimit.get();
	}
	
	public boolean getPusherBackLimit(){
		return pusherBackLimit.get();
	}
	
	*/
	/* change this to an encoder value soon
	public void elevatorPushForward(){
		pushMotor.set(0.2);
	}
	*/
	/* change this to an encoder value soon
	public void elevatorPushBack(){
		pushMotor.set(-1*0.2);
	}
	*/
	/*
	public void setElevatorEncLocation(int location){
		elevatorMotor.getSensorCollection().setQuadraturePosition(location, 0);
	}
	*/
	
	/**
	 * Reset the encoder position value to zero.
	 */
	
	public void setClimbSpeed(double speed){
		climbMotor.set(speed);
	}
	
	public void zeroExtenderPosition(){
		extendMotor.setSelectedSensorPosition(0, 0, 0);
	}
	public void zeroElevatorPosition(){
		elevatorMotor.setSelectedSensorPosition(0, 0, 0);
	}
	
	public int getEncPosition(){
		return elevatorMotor.getSelectedSensorPosition(0);
	}
	
	/*
	public void setExtendPosition(int position){
		extendMotor.set(ControlMode.Position, position);
	}
	*/
	
	public int getExtenderPosition() {
		return extendMotor.getSelectedSensorPosition(0);
	}
	
	/**
	 * Move the motor to a specified position.
	 * @param position The position to move to
	 */
	public void setElevatorPosition(int position){
		elevatorMotor.set(ControlMode.Position, position);
	}
	
	public void elevatorHardStop() {
		elevatorMotor.set(0);
	}
	
	public void extendHardStop(){
		extendMotor.set(0);
	}
	
	public void pusherHardStop(){
		pushMotor.set(0);
	}
	
	public void climbHardStop() {
		climbMotor.set(0);
		//climbMotor2.set(0);
	}
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}


