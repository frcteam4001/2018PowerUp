package org.usfirst.frc.team4001.robot.commands;

import org.usfirst.frc.team4001.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ExtendAllUp extends Command {

    public ExtendAllUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.elevator.setExtendPosition(34000);
    	Robot.elevator.setElevatorPosition(36500);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.elevator.getExtenderPosition() >= 34000 && Robot.elevator.getEncPosition() >= 36500;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevator.elevatorHardStop();
    	Robot.elevator.setExtendSpeed(0.05);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.elevator.elevatorHardStop();
    	Robot.elevator.setExtendSpeed(0.05);
    }
}