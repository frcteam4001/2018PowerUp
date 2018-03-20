package org.usfirst.frc.team4001.robot.commands;

import org.usfirst.frc.team4001.robot.NumberConstants;
import org.usfirst.frc.team4001.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */

public class GoToHome extends Command {

    public GoToHome() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.elevator.getElevatorLimit()){
    		Robot.elevator.setElevatorSpeed(0);
    	}
    	else{
    		Robot.elevator.setElevatorSpeed(-NumberConstants.elevatorResetSpeed);
    	}
    	if(Robot.elevator.getExtenderBotLimit()){
    		Robot.elevator.setExtendSpeed(0);
    	}
    	else{
    		Robot.elevator.setExtendSpeed(-NumberConstants.extendResetSpeed);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.elevator.getElevatorLimit() && Robot.elevator.getExtenderBotLimit();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevator.elevatorHardStop();
    	Robot.elevator.extendHardStop();
    	Robot.elevator.zeroElevatorPosition();
    	Robot.elevator.zeroExtenderPosition();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.elevator.elevatorHardStop();
    	Robot.elevator.extendHardStop();;
    	Robot.elevator.zeroElevatorPosition();
    	Robot.elevator.zeroExtenderPosition();
    }
}

