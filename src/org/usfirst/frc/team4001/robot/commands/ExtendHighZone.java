package org.usfirst.frc.team4001.robot.commands;

import org.usfirst.frc.team4001.robot.NumberConstants;
import org.usfirst.frc.team4001.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ExtendHighZone extends Command {

    public ExtendHighZone() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.elevator.setExtendSpeed(NumberConstants.extendSpeed);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.elevator.getExtenderTopLimit();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevator.setExtendSpeed(NumberConstants.extendHoldSpeed);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.elevator.setExtendSpeed(NumberConstants.extendHoldSpeed);
    }
}
