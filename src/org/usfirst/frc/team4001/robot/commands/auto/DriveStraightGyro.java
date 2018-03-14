package org.usfirst.frc.team4001.robot.commands.auto;

import org.usfirst.frc.team4001.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


/**
 *
 */

public class DriveStraightGyro extends Command {
	
	private double distance;
	private double speed;
	private double angle;
	private double timeOut;
	private double epsilon;
	
	public DriveStraightGyro(double setPoint, double speed, double angle, double timeOut, double epsilon) {
		this.distance = setPoint;
		this.speed = speed;
		this.angle = angle;
		this.timeOut = timeOut;
		this.epsilon = epsilon;
		requires(Robot.drive);
	}

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drive.reset();
    	Robot.drive.gyroReset();
    	setTimeout(timeOut);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		Robot.drive.driveStraight(distance, speed, angle, epsilon);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drive.runLeftDrive(0);
    	Robot.drive.runRightDrive(0);
    	Robot.drive.drivePID.resetPID();
    	Robot.drive.gyroPID.resetPID();
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.drive.runLeftDrive(0);
    	Robot.drive.runRightDrive(0);
    	Robot.drive.drivePID.resetPID();
    	Robot.drive.gyroPID.resetPID();
    }
    
}

