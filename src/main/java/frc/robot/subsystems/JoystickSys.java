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

/**
 * An example subsystem. You can replace me with your own Subsystem.
 */
public class JoystickSys extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public WPI_TalonSRX joyTally1;
  double deadzone = 0.02;
  double armEncoder1;
  int upperLimit = 5000;
  int lowerLimit = -5000;
  int tinyVariance = 300;
  int bigBoiVariance = 600;

  public JoystickSys(int tally1id) {
    joyTally1 = new WPI_TalonSRX(tally1id);
  }

  public void JoystickMotors(Joystick stickBoi) {
    armEncoder1 = joyTally1.getSensorCollection().getQuadraturePosition();
    if (armEncoder1 < lowerLimit + tinyVariance) {

      if (stickBoi.getY() > deadzone) {
        joyTally1.set(stickBoi.getY());
      } else {
        joyTally1.set(0);
      }

    } else if (armEncoder1 < lowerLimit + bigBoiVariance) {
      if (stickBoi.getY() > deadzone) {
        joyTally1.set(stickBoi.getY());
      } else if (armEncoder1 < -deadzone) {
        joyTally1.set(stickBoi.getY() / 2);
      }
    }
    if (armEncoder1 > upperLimit - tinyVariance) {
      if (stickBoi.getY() > deadzone) {
        joyTally1.set(stickBoi.getY());
      } else {
        joyTally1.set(0);
      }
    } else if (armEncoder1 < upperLimit + bigBoiVariance) {
      if (stickBoi.getY() > deadzone) {
        joyTally1.set(stickBoi.getY());
      } else if (stickBoi.getY() < -deadzone) {
        joyTally1.set(stickBoi.getY() / 2);
      }
    }

    if (stickBoi.getY() > deadzone || stickBoi.getY() < -deadzone) {
      joyTally1.set(stickBoi.getY());
    }

    else {
      joyTally1.set(0);
    }
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    // setDefaultCommand(new JoystickMotors());
  }
}
