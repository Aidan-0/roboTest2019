/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.*;
/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class JoystickSys extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
public WPI_TalonSRX armTally1;
double deadzone = 0.5;

public JoystickSys(int tally1id) {
  armTally1 = new WPI_TalonSRX(tally1id);
}
  
public void JoystickMotors(Joystick stickBoi) {
  if (stickBoi.getY()>deadzone){
    armTally1.set(stickBoi.getY());
  }
}

@Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new JoystickMotors());
  }
}
