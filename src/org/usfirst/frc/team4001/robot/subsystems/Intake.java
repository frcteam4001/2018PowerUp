package org.usfirst.frc.team4001.robot.subsystems;

import org.usfirst.frc.team4001.robot.ElectricalConstants;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {

    private WPI_TalonSRX leftArm;
    private WPI_TalonSRX rightArm;
        
    //private DigitalInput cubeIn;
  

   
    public Intake() {
    	leftArm = new WPI_TalonSRX(ElectricalConstants.INTAKE_LEFT_ARM_MOTOR);
    	rightArm = new WPI_TalonSRX(ElectricalConstants.INTAKE_RIGHT_ARM_MOTOR);
    	
    	//cubeIn = new DigitalInput(ElectricalConstants.
    }
    
  
    public void armsRollIn()
    {
    	leftArm.set(0.5);
    	rightArm.set(0.5);
    }
  
    public void armsRollOut() 
    {
    	leftArm.set(-0.5);
    }
    
    /**
     * Left arm wheel rolls
     */
    public void leftArmRollIn()
    {
    	leftArm.set(0.5);
    }
   
    
    /**
     * Right arm wheel rolls
     */
    public void rightArmRollIn()
    {
    	rightArm.set(0.5);
    }


    

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
*/

