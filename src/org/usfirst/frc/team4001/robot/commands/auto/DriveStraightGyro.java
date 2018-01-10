package org.usfirst.frc.team4001.robot.commands.auto;

import org.usfirst.frc.team4001.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


/**
 *
 */
public class DriveStraightGyro extends Command {
	
	double setPoint = 10;
	double speed = 0.5;
	double setAngle = 0;
	double epsilon = 2;
	
	

    public DriveStraightGyro() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    	requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drive.driveStraight(setPoint, speed, setAngle, epsilon);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
