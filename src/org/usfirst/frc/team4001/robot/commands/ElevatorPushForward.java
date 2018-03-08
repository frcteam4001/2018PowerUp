package org.usfirst.frc.team4001.robot.commands;

import org.usfirst.frc.team4001.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */

public class ElevatorPushForward extends Command {

    public ElevatorPushForward() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.oi.secondary_controller.getRawAxis(6) > -0.5){
    		Robot.elevator.setPusherSpeed(0.5);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished(){
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevator.pusherHardStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.elevator.pusherHardStop();
    }
}

