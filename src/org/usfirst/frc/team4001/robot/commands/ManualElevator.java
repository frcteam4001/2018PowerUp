package org.usfirst.frc.team4001.robot.commands;

import org.usfirst.frc.team4001.robot.NumberConstants;
import org.usfirst.frc.team4001.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ManualElevator extends Command {

    public ManualElevator() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("Manual Elevator");
    	double speed = Robot.oi.secondary_controller.getLeftY();
    	double velocity = Robot.oi.secondary_controller.getRightY();
    	/*                                         
    	if(Robot.elevator.getElevatorLimit() && speed < 0){
    		System.out.println("Manual Elevator: limit true" + speed);
    		Robot.elevator.elevatorHardStop();
    	}
    	else{
    	*/
    		Robot.elevator.setElevatorSpeed(-speed*1);
    		//System.out.println("Manual Elevator: limit false" + speed);
    	//}
    		/*
    	if(Robot.elevator.getExtenderLimit() && velocity < 0){
    		System.out.println("Manual Elevator: extender" + velocity);
        	*/
    		Robot.elevator.setExtendSpeed(-velocity*0.85);
    	//}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    	Robot.elevator.elevatorHardStop();
    	Robot.elevator.setExtendSpeed(NumberConstants.extendHoldSpeed);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.elevator.elevatorHardStop();
    	Robot.elevator.setExtendSpeed(NumberConstants.extendHoldSpeed);
    }
}
