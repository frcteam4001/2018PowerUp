package org.usfirst.frc.team4001.robot.commands.auto;

import org.usfirst.frc.team4001.robot.Robot;
//import org.usfirst.frc.team4001.robot.commands.RollOutArms;
//import org.usfirst.frc.team4001.robot.commands.RollOutArms;
import org.usfirst.frc.team4001.robot.commands.RollOutArms;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */

public class RightAuto extends CommandGroup {

	private String gameData;
	private Timer timer;
	
    public RightAuto() {
    	
    	timer = new Timer();
    	
    	gameData = DriverStation.getInstance().getGameSpecificMessage();
    	
    	if(gameData.charAt(0) == 'R'){
    		//System.out.println("Auto running for right side switch");
    		//addParallel(new PushForward());
    		//addSequential(new DriveStraightGyro(130, 0.5, 0, 1, 1));
    		/*
    		addSequential(new TurnGyro(-90, 0.5, 2));
    		addSequential(new DriveStraightGyro(2, 0.5, 0, 0.5, 1));
    		addSequential(new RollOutArms());
    		*/
    		System.out.println("Auto running right switch");
    		addParallel(new PushForward());
    		addSequential(new ArcadeStraight(0.65, 3));
    		addSequential(new Turn(-0.5, 1));
    		addSequential(new RollOutArms());
    		
    		
    	}
    	
    	else if(gameData.charAt(1) == 'R'){
    		System.out.println("Auto running for right side scale");
    		addSequential(new ArcadeStraight(1, 2.5));
    		addSequential(new Turn(-0.5, 1));
    		addParallel(new PushForward());
    		addSequential(new ArcadeStraight(0.5, 0.5));
    		addSequential(new RollOutArms());
    	}
    
//    	else if(gameData.charAt(0) == 'L'){
//    		System.out.println("Auto running for left side switch");
//    		addSequential(new DriveStraightGyro(225.70866, 0.5, 0, 3, 1));
//    		addSequential(new TurnGyro(-90));
//    		addSequential(new DriveStraightGyro(181.8901, 0.5, 0, 3, 1)); 
//    		addSequential(new TurnGyro(-90));
//    		addSequential(new DriveStraightGyro(60.62994, 0.5, 0, 3, 1)); 
//    		addSequential(new TurnGyro(-90));
//    		addSequential(new DriveStraightGyro(11.0236, 0.5, 0, 3, 1));
//    		addSequential(new RollOutArms());
//    		
//    		
//    		
//    		
//    	}
    	/*
    	else if(gameData.charAt(1) == 'L'){
    		System.out.println("Auto running for left side scale");
    		addSequential(new DriveStraightGyro(225.9845, 0.5, 0, 3, 1));
    		addSequential(new TurnGyro(-90));
    		addSequential(new DriveStraightGyro(195.6696, 0.5, 0, 3, 1));
    		addSequential(new TurnGyro(90));
    		addSequential(new DriveStraightGyro(121.8683, 0.5, 0, 3, 1));
    		addSequential(new TurnGyro(90));
    		addSequential(new DriveStraightGyro(8.2677, 0.5, 0, 3, 1));
    		
    		System.out.println("Driving straight");
    		addSequential(new DriveStraightGyro(200, 1, 0, 5, 1));
    		addParallel(new PushForwardAndIntakeUp());
    		addSequential(new RollOutArms());
    	*/	
    		
    		//Not sure what this is
//    		addSequential(new DriveStraightGyro(70));
//    		addSequential(new TurnGyro(-90));
//    		addSequential(new DriveStraightGyro(149));
//    		addSequential(new TurnGyro(90));
//    		addSequential(new DriveStraightGyro(262));
//    		addSequential(new TurnGyro(90));
//    		addSequential(new DriveStraightGyro(30));
    	//}
    	else{
    		//System.out.println("Auto running to move forward");
    		//addSequential(new DriveStraightGyro(200, 1, 0, 1, 1));
//    		addParallel(new PushForwardAndIntakeUp());
//    		addSequential(new RollOutArms());
    		
    		System.out.println("Auto running straight");
    		addParallel(new PushForward());
    		addSequential(new ArcadeStraight(0.65, 3));
    		
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

