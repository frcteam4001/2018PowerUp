package org.usfirst.frc.team4001.robot.subsystems;

import org.usfirst.frc.team4001.robot.ElectricalConstants;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {

    private Victor leftArm;
    private Victor rightArm;
    
    private Solenoid leftArmSol;
    private Solenoid rightArmSol;
    
    private Solenoid extenderIn;
    private Solenoid extenderOut;
    

    public Intake() {
    	leftArm = new Victor(ElectricalConstants.INTAKE_LEFT_ARM_MOTOR);
    	rightArm = new Victor(ElectricalConstants.INTAKE_RIGHT_ARM_MOTOR);
    	
    	leftArmSol = new Solenoid(ElectricalConstants.INTAKE_LEFT_ARM_SOLENOID);
    	rightArmSol = new Solenoid(ElectricalConstants.INTAKE_RIGHT_ARM_SOLENOID);
    	
    	extenderIn = new Solenoid(ElectricalConstants.INTAKE_EXTENDER_IN_SOLENOID);
    	extenderOut = new Solenoid(ElectricalConstants.INTAKE_EXTENDER_OUT_SOLENOID);
    }
    
    public void extenderOut() 
    {
    	extenderIn.set(false);
    	extenderOut.set(true);
    }
    
    public void extenderIn() 
    {
    	extenderIn.set(true);
    	extenderOut.set(false);
    }
    
    public void armsRollIn()
    {
    	leftArm.set(0.5);
    	rightArm.set(0.5);
    }
    
    public void leftArmRollIn()
    {
    	leftArm.set(0.5);
    }
    
    public void rightArmRollIn()
    {
    	rightArm.set(0.5);
    }
    
    public void release()
    {
    	this.extenderOut();
    	leftArmSol.set(true);
    	rightArmSol.set(true);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

