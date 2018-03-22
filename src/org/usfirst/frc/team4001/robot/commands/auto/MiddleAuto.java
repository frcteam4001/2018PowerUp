package org.usfirst.frc.team4001.robot.commands.auto;



import org.usfirst.frc.team4001.robot.Robot;
import org.usfirst.frc.team4001.robot.commands.RollOutArms;

//import org.usfirst.frc.team4001.robot.commands.RollOutArms;

//import org.usfirst.frc.team4001.robot.commands.RollOutArms;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */

public class MiddleAuto extends CommandGroup {

	private String gameData;
	
    public MiddleAuto() {
    	
    	gameData = DriverStation.getInstance().getGameSpecificMessage();
    	
    	if(gameData.charAt(0) == 'L'){
    		//System.out.println("The auto running is for the left side switch");
    		//addParallel(new PushForward());
    		//addSequential(new DriveStraightGyro(29, 1, 0, 1, 1));
    		/*
    		addSequential(new TurnGyro(-90, 0.5, 2));
    		addSequential(new DriveStraightGyro(93, 0.5, 0, 2.5, 1));
    		addSequential(new TurnGyro(90, 0.5, 2));
    		addSequential(new DriveStraightGyro(50, 0.5, 0, 1.5, 1));
    		addSequential(new RollOutArms());
    		
    		
    		*/
    		
    		addSequential(new ArcadeStraight(0.65, 1));
    		addSequential(new Turn(-0.6, 1));
    		addSequential(new ArcadeStraight(0.65, 2));
    		addSequential(new Turn(0.6, 1));
    		addParallel(new PushForward());
    		addSequential(new ArcadeStraight(0.65, 1));
    		addSequential(new RollOutArms());
    		
    		System.out.println("Auto running straight");
    		//addSequential(new ArcadeStraight(0.65, 3));
    		
    		} else {
    		
    		//System.out.println("The auto running is for the right side switch");
    		//addParallel(new PushForward());
    		//addSequential(new DriveStraightGyro(100, 1, 0, 1, 1));
    		//addSequential(new RollOutArms());
    		/*
    		addSequential(new TurnGyro(90, 0.5, 1));
    		addSequential(new DriveStraightGyro(32.2, 0.5, 0, 3, 1));
    		addSequential(new TurnGyro(-90, 0.5, 2));
    		addSequential(new DriveStraightGyro(102.2, 0.5, 0, 3, 1));
    		addSequential(new RollOutArms());
    		*/
    			
    		System.out.println("Auto running straight");
    		addParallel(new PushForward());
    		addSequential(new ArcadeStraight(0.65, 3));
    		addSequential(new RollOutArms());
        	
        		
    		
    	} 
    	
   
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}

