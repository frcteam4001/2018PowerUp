package org.usfirst.frc.team4001.robot;

/**
 * Used to store various constants used throughout the robot i.e speed settings, pid values
 *  @author Eric Fabroa
 * 
 */


public class NumberConstants {
	
	//**************************************************************************
    //*************************** PID VALUES (DRIVE) ***************************
    //**************************************************************************
	
	//Competition

	public static double pDrive 									 = 0.1;
	public static double iDrive 									 = 0.00;
	public static double dDrive 									 = 0.0;
	
	public static final double DRIVE_SCALE 								 = 0;
	
	
	//**************************************************************************
    //**************************** PID VALUES (GYRO) ***************************
    //**************************************************************************
	
	//Competition
	public static final double pGyro 									 = 0.1;
	public static final double iGyro 									 = 0.00;
	public static final double dGyro 									 = 0.00;
	
	// ************************************************************************
	// **************************  ELEVATOR  **********************************
	// ************************************************************************
	
	//public static final double elevatorMaxVoltage  						 = 0.5;
	public static final double elevatorResetSpeed						 = 0.75;	
	public static final double extendSpeed								 = 0.75;
	public static final double extendClimbSpeed							 = 0.5;
	public static final double extendShuffleSpeed						 = 0.3;
	public static final double extendHoldSpeed							 = 0.05;
	public static final double extendResetSpeed							 = 0.75;
	//public static final int	extendScaleZone							 = 35000;
	public static final int elevatorLowHeight							 = 10320;
	public static final int elevatorSwitchZone							 = 23098;
	public static final int elevatorMaxZone							 	 = 36500;
	public static final double climbSpeed 								 = 1;
	public static final double climbResetSpeed							 = 0.5; //climb shuffleboard speed slower due to it being a button 
	public static final double extenderThreshold						 = 10000;
	public static final double pusherSpeed								 = 0.5;
	
	// ************************************************************************
	// **************************  INTAKE  ************************************
	// ************************************************************************
	
	public static final double rollInSpeed								= -1;
	public static final double rollOutSpeed								= 1;
	
}
