package org.usfirst.frc.team4001.robot.subsystems;

import org.usfirst.frc.team4001.robot.ElectricalConstants;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
/*
public class Intake extends Subsystem {

    private WPI_TalonSRX leftArm;
    private WPI_TalonSRX rightArm;
    
    private Solenoid leftArmSol;
    private Solenoid rightArmSol;
    
    private Solenoid extenderIn;
    private Solenoid extenderOut;
    
    private DigitalInput cubeIn;
*/    
    /**
     * Constructor
     */
    /*
    public Intake() {
    	leftArm = new WPI_TalonSRX(ElectricalConstants.INTAKE_LEFT_ARM_MOTOR);
    	rightArm = new WPI_TalonSRX(ElectricalConstants.INTAKE_RIGHT_ARM_MOTOR);
    	
    	leftArmSol = new Solenoid(ElectricalConstants.INTAKE_LEFT_ARM_SOLENOID);
    	rightArmSol = new Solenoid(ElectricalConstants.INTAKE_RIGHT_ARM_SOLENOID);
    	
    	extenderIn = new Solenoid(ElectricalConstants.INTAKE_EXTENDER_IN_SOLENOID);
    	extenderOut = new Solenoid(ElectricalConstants.INTAKE_EXTENDER_OUT_SOLENOID);
    	
    	cubeIn = new DigitalInput(ElectricalConstants.
    }
    */
    /**
     * Extender opens
     */
    /*
    public void extenderOut() 
    {
    	extenderIn.set(false);
    	extenderOut.set(true);
    }
    */
    
    /**
     * Extender closes
     */
    /*
    public void extenderIn() 
    {
    	extenderIn.set(true);
    	extenderOut.set(false);
    }
    */
    
    /**
     * Wheels on both arms start rolling, taking in the cube
     */
    /*
    public void armsRollIn()
    {
    	leftArm.set(0.5);
    	rightArm.set(0.5);
    }
    */
    /**
     * Left arm wheel rolls
     */
    /*
    public void leftArmRollIn()
    {
    	leftArm.set(0.5);
    }
    */
    
    /**
     * Right arm wheel rolls
     */
    /*
    public void rightArmRollIn()
    {
    	rightArm.set(0.5);
    }
    */
    /**
     * Extender opens and arms open, releasing the cube
     */
    /*
    public void release()
    {
    	this.extenderOut();
    	leftArmSol.set(true);
    	rightArmSol.set(true);
    }
    */
    
    /*
    public void clamp(){
    	this.extenderIn();
    	leftArmSol.set(false);
    	rightArmSol.set(false);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
*/

