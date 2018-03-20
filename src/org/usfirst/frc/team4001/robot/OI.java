package org.usfirst.frc.team4001.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Scheduler;

import com.team4001.lib.util.AxisButton;
import com.team4001.lib.util.Gamepad;
import org.usfirst.frc.team4001.robot.ElectricalConstants;
import org.usfirst.frc.team4001.robot.commands.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	/**
	 * The primary game controller (driver controller).  Gamepad controller mappings based on Logitech F310 controller.
	 * @see Gamepad
	 */
	public Gamepad primary_controller;
	public Gamepad secondary_controller;
	
	//primary controller buttons
//	private JoystickButton slowButton;
//	private JoystickButton raiseExtendAndIntake;
//	private JoystickButton breakButton;
//	
//	//secondary controller buttons
//	private JoystickButton goToHomeZone;
//	private JoystickButton goToZone1;
//	private JoystickButton goToZone2;
//	private JoystickButton goToZone3;
//	
//	
	private AxisButton pushForward;
	private AxisButton pushBack;
	//private JoystickButton 
	
	private JoystickButton extendUpButton;
	private AxisButton extendDownButton;
	private JoystickButton extendAllUp;

	private JoystickButton goToHome;
	private JoystickButton goToSwitch;
	private JoystickButton goToMinHeight;

	private AxisButton rollInButton;
	private AxisButton rollOutButton;
	private JoystickButton climbUpButton;
	public JoystickButton slowButton;
	public JoystickButton manualButton;
	
	private JoystickButton stopButton;
	
	
	// TODO declare primary controller buttons


	/**
	 * Instantiate controller objects and bind buttons to commands.
	 */
	public OI() {
		// instantiate game controllers
		primary_controller = new Gamepad(ElectricalConstants.GAMECONTROLLER_PRIMARY_PORT);
		secondary_controller = new Gamepad(ElectricalConstants.GAMECONTROLLER_SECONDARY_PORT);
		
		//checks to see if it is being pressed in the command rather than over here.
		//slowButton = primary_controller.getLeftShoulder();
		
		//raiseExtendAndIntake = primary_controller.getRightShoulder();
		//raiseExtendAndIntake.whenPressed(new RaiseExtendAndIntake());
		
		//goToHome = primary_controller.getButtonA();
		//goToHome.whenPressed(new goToZone1());
		
		//Primary controller
		slowButton = primary_controller.getLeftShoulder();
		
		rollInButton = primary_controller.getLeftTriggerClick();
		rollInButton.whileHeld(new RollInArms());

		rollOutButton = primary_controller.getRightTriggerClick();
		rollOutButton.whileHeld(new RollOutArms());
		
		extendUpButton = primary_controller.getRightShoulder();
		extendUpButton.whenPressed(new ExtendHighZone());
		
		//extendDownButton = primary_controller.get
		//extendDownButton.whenPressed(new ExtendAllDown());
		
		//Secondary controller
		manualButton = secondary_controller.getLeftShoulder();
		manualButton.whileHeld(new ManualElevator());
		/*
		climbUpButton = secondary_controller.getRightShoulder();
		climbUpButton.whileHeld(new ClimbUp());
		*/
		goToHome = secondary_controller.getButtonA();
		goToHome.whenPressed(new GoToHome());
		
		goToSwitch = secondary_controller.getButtonB();
		goToSwitch.whenPressed(new GoToSwitch());
		
		goToMinHeight = secondary_controller.getButtonX();
		goToMinHeight.whenPressed(new GoToLowHeight());
		
		extendAllUp = secondary_controller.getButtonY();
		extendAllUp.whenPressed(new ExtendAllUp());
		
		pushForward = secondary_controller.getRightTriggerClick();
		pushForward.whileHeld(new ElevatorPushForward());
		
		pushBack = secondary_controller.getLeftTriggerClick();
		pushBack.whileHeld(new ElevatorPushBack());
		// TODO bind primary_controller buttons to commands
		
	}
	
}
