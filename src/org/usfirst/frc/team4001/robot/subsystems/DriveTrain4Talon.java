package org.usfirst.frc.team4001.robot.subsystems;

import org.usfirst.frc.team4001.robot.ElectricalConstants;
import org.usfirst.frc.team4001.robot.NumberConstants;
import org.usfirst.frc.team4001.robot.commands.ArcadeDrive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.team4001.lib.util.PIDController;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class DriveTrain4Talon extends DriveTrain {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private WPI_TalonSRX upperLeftMotor;
	private WPI_TalonSRX upperRightMotor;
	private WPI_TalonSRX bottomLeftMotor;
	private WPI_TalonSRX bottomRightMotor;
	
	private Encoder leftEncoder;
	private Encoder rightEncoder;
	
	private ADXRS450_Gyro gyro;
	
	private SpeedControllerGroup leftMotors;
	private SpeedControllerGroup rightMotors;
	
	public PIDController drivePID;
	public PIDController gyroPID;
	
	public DriveTrain4Talon(){
		upperLeftMotor = new WPI_TalonSRX(ElectricalConstants.DRIVETRAIN_FRONT_LEFT);
		
		upperLeftMotor.config_kF(0, 0, 0);
		upperLeftMotor.config_kP(0, 0.1, 0);
		upperLeftMotor.config_kI(0, 0, 0);
		upperLeftMotor.config_kD(0, 0, 0);
		
		upperRightMotor = new WPI_TalonSRX(ElectricalConstants.DRIVETRAIN_FRONT_RIGHT);
		upperRightMotor.config_kF(0,0,0);
		upperRightMotor.config_kP(0,0.1,0);
		upperRightMotor.config_kI(0,0,0);
		upperRightMotor.config_kD(0,0,0);
		
		bottomLeftMotor = new WPI_TalonSRX(ElectricalConstants.DRIVETRAIN_REAR_LEFT);
		bottomLeftMotor.config_kF(0,0,0);
		bottomLeftMotor.config_kP(0,0.1,0);
		bottomLeftMotor.config_kI(0,0,0);
		bottomLeftMotor.config_kD(0,0,0);
		
		bottomRightMotor = new WPI_TalonSRX(ElectricalConstants.DRIVETRAIN_REAR_RIGHT);
		bottomRightMotor.config_kF(0, 0, 0);
		bottomRightMotor.config_kP(0, 0.1, 0);
		bottomRightMotor.config_kI(0, 0, 0);
		bottomRightMotor.config_kD(0, 0, 0);
		
		gyro = new ADXRS450_Gyro();
		gyro.calibrate();
		gyro.reset();
		
		
		drivePID = new PIDController(NumberConstants.pDrive, NumberConstants.iDrive, NumberConstants.dDrive);
		gyroPID = new PIDController(NumberConstants.pGyro, NumberConstants.iGyro, NumberConstants.dGyro);
		
		leftEncoder = new Encoder(ElectricalConstants.LEFT_DRIVE_ENCODER_A,ElectricalConstants.LEFT_DRIVE_ENCODER_B,ElectricalConstants.leftDriveTrainEncoderReverse, EncodingType.k4X);
		leftEncoder.setDistancePerPulse(ElectricalConstants.driveEncoderDistPerTick);
		
		rightEncoder = new Encoder(ElectricalConstants.RIGHT_DRIVE_ENCODER_A,ElectricalConstants.RIGHT_DRIVE_ENCODER_B,ElectricalConstants.rightDriveTrainEncoderReverse, EncodingType.k4X);
		rightEncoder.setDistancePerPulse(ElectricalConstants.driveEncoderDistPerTick);
		
		leftMotors = new SpeedControllerGroup(upperLeftMotor, bottomLeftMotor);
		rightMotors = new SpeedControllerGroup(upperRightMotor, bottomRightMotor);
		
		drive = new DifferentialDrive(leftMotors, rightMotors);
		
		leftEncoder.reset();
		rightEncoder.reset();
	} 

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ArcadeDrive());
    }

	@Override
	public void runLeftDrive(double power) {
		// TODO Auto-generated method stub
		leftMotors.set(power);
	}

	@Override
	public void runRightDrive(double power) {
		// TODO Auto-generated method stub
		rightMotors.set(power);
	}
	
	public double getAverageDistance(){
		return (leftEncoder.getDistance() + rightEncoder.getDistance())/2;
	}
	
	public double getYaw() {
		return gyro.getAngle();
	}
	
	public void gyroReset(){
		gyro.reset();
	}
	
	public void reset(){
		leftEncoder.reset();
		rightEncoder.reset();
	}
	
	public void resetPID(){
		drivePID.resetPID();
		gyroPID.resetPID();
	}
	
	public double talonAverageDistance(){
		return (upperLeftMotor.getSelectedSensorPosition(0) + upperRightMotor.getSelectedSensorPosition(0) + bottomLeftMotor.getSelectedSensorPosition(0) + bottomRightMotor.getSelectedSensorPosition(0))/4;
	}
	
	public void positionMove(int position){
		upperLeftMotor.set(ControlMode.Position, position);
		upperRightMotor.set(ControlMode.Position, position);
		bottomLeftMotor.set(ControlMode.Position, position);
		bottomRightMotor.set(ControlMode.Position, position);
	}
	
	
	public void driveStraight(double setPoint, double speed, double setAngle, double epsilon) {
		double output = drivePID.calcPIDDrive(setPoint, getAverageDistance(), epsilon);
		double angle = gyroPID.calcPID(setAngle, getYaw(), epsilon);
		
		runLeftDrive((output + angle) * speed);
		runRightDrive(-(output + angle) * speed);
		//runLeftDrive((output) * speed);
		//runRightDrive(-(output) * speed);
	}
	
	public void turnDrive(double setAngle, double speed, double epsilon) {
		double angle = gyroPID.calcPID(setAngle, getYaw(), epsilon);
		
		runLeftDrive(angle * speed);
		runRightDrive(angle * speed);
	}
	
}

