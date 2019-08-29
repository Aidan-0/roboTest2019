/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.MovingArm;


/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class FinalArm extends Subsystem {
  double encoder1;
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public FinalArm() {

  }
  public void MovingArm() {

  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new MovingArm());
  }
}
