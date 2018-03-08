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
//	private JoystickButton pushForward;
//	private JoystickButton pushBack;
	//private JoystickButton 
	
	private JoystickButton extendUpButton;
	private JoystickButton extendDownButton;
	private JoystickButton extendHoldButton;

	private JoystickButton goToHome;
	private JoystickButton goToZone1;
	private AxisButton goToZone2;
	private JoystickButton goToZone3;

	private JoystickButton rollInButton;
	private JoystickButton rollOutButton;
	private JoystickButton climbButton;
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
		extendHoldButton = primary_controller.getRightShoulder();
		extendHoldButton.whileHeld(new ExtendHold());
		
		extendUpButton = primary_controller.getButtonX();
		extendUpButton.whileHeld(new ExtendUp());
		
		extendDownButton = primary_controller.getButtonA();
		extendDownButton.whileHeld(new ExtendDown());

		//Secondary controller
		manualButton = secondary_controller.getLeftShoulder();
		
		rollInButton = secondary_controller.getButtonY();
		rollInButton.whileHeld(new RollInArms());

		rollOutButton = secondary_controller.getButtonB();
		rollOutButton.whileHeld(new RollOutArms());
		
		climbButton = secondary_controller.getButtonA();
		climbButton.whileHeld(new ClimbUp());
		
		goToHome = secondary_controller.getButtonX();
		goToHome.whenPressed(new GoToHome());
		
		goToZone1 = secondary_controller.getRightShoulder();
		goToZone1.whenPressed(new GoToZone1());
		
		goToZone2 = secondary_controller.getRightTriggerClick();
		goToZone2.whenPressed(new GoToZone2());
		
		goToZone3 = secondary_controller.getLeftShoulder();
		goToZone3.whenPressed(new GoToZone3());
		// TODO bind primary_controller buttons to commands
		
	}
	
}
