package org.usfirst.frc.team4001.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

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
	public Gamepad game_controller;
	private JoystickButton extendUpButton;
	private JoystickButton intakeUpButton;
	private JoystickButton extendDownButton;
	private JoystickButton intakeDownButton;
	private JoystickButton extendHoldButton;
	
	// TODO declare primary controller buttons
	

		
	/**
	 * Instantiate controller objects and bind buttons to commands.
	 */
	public OI() {
		// instantiate game controllers
		game_controller = new Gamepad(ElectricalConstants.GAMECONTROLLER_PRIMARY_PORT);
		
		intakeUpButton = game_controller.getButtonY();
		intakeUpButton.whileHeld(new ElevatorUp());

		intakeDownButton = game_controller.getButtonB();
		intakeDownButton.whileHeld(new ElevatorDown());
		
		extendHoldButton = game_controller.getRightShoulder();
		extendHoldButton.whileHeld(new ExtendHold());
		
		extendUpButton = game_controller.getButtonX();
		extendUpButton.whileHeld(new ExtendUp());
		
		extendDownButton = game_controller.getButtonA();
		extendDownButton.whileHeld(new ExtendDown());
		
		
		// TODO bind game_controller buttons to commands
	
	}
}
