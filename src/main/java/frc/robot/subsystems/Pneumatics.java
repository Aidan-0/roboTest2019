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
 * An example subsystem. You can replace me with your own Subsystem.
 */
public class Pneumatics extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  // hey, i changed operating systems again, yay!
  public Solenoid sully1;
  public DoubleSolenoid doubleSully1;
  public boolean DoubleTrouble = false;

  public Pneumatics(int mod1, int sully1id, int doubleSully1id1, int doubleSully1id2) {

    sully1 = new Solenoid(mod1, sully1id);
    doubleSully1 = new DoubleSolenoid(mod1, doubleSully1id1, doubleSully1id2);

  }

  public void PistonIn() {
    sully1.set(false);
  }

  public void PistonOut() {
    sully1.set(true);
  }

  public void DoubleToggle() {
    if (DoubleTrouble == true) {
      doubleSully1.set(Value.kForward);
      DoubleTrouble = false;
    } else if (DoubleTrouble == false) {
      doubleSully1.set(Value.kReverse);
      DoubleTrouble = true;
    }

  }

  public void DoubleIn() {
    doubleSully1.set(DoubleSolenoid.Value.kForward);
  }

  public void DoubleOut() {
    doubleSully1.set(DoubleSolenoid.Value.kReverse);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

}
