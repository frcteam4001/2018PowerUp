package org.usfirst.frc.team4001.robot.commands.auto;

import org.usfirst.frc.team4001.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TalonDriveStraight extends Command {

    public TalonDriveStraight() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drive.positionMove(20000);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drive.hardStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.drive.hardStop();
    }
}
