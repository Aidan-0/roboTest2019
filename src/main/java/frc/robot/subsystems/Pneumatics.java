/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Pneumatics extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public Solenoid sully1;
  public DoubleSolenoid sully2;
  public boolean DoubleTrouble = false;

  public Pneumatics(int mod1, int sully1id, int sully2id1, int sully2id2) {

    sully1 = new Solenoid(mod1, sully1id);
    sully2 = new DoubleSolenoid(mod1, sully2id1, sully2id2);
    
  }
  public void PistonIn() {
    sully1.set(false);
  }

  public void PistonOut() {
    sully1.set(true);
  }
  public void DoubleToggle() {
    if (DoubleTrouble == true) {
      sully2.set(Value.kForward);
      DoubleTrouble = false;
    }
    if (DoubleTrouble == false) {
      sully2.set(Value.kReverse);
      DoubleTrouble = true;
    }

  }

  public void DoubleIn() {
    doubleSully1.set(DoubleSolenoid.Value.kReverse);
  }

  public void DoubleOut() {
    doubleSully1.set(DoubleSolenoid.Value.kForward);
  }

  public void DoubleTroubleToggle () {

    

  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

}
