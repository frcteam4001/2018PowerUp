package org.usfirst.frc.team4001.robot.commands.auto;

import org.usfirst.frc.team4001.robot.NumberConstants;
import org.usfirst.frc.team4001.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PushForward extends Command {

	Timer timer;
    public PushForward() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize(){
    	timer = new Timer();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(timer.get() <= 2){
    		Robot.elevator.setPusherSpeed(NumberConstants.pusherSpeed);
    	}
    	//Robot.elevator.setElevatorPosition(23904);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
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
