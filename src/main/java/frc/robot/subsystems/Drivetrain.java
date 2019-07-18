/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public WPI_TalonSRX tally1;
  public Encoder encoder1;

  public Drivetrain(int tally1id, int encoder1id) {

    tally1 = new WPI_TalonSRX(tally1id);
    /* encoder1 = new Encoder(sourceA, sourceB);
    I have no idea what i'm doing with encoders
    */

  }

  public void MovingMotors() {
    tally1.set(0.5);
  }

  public void StoppingMotors() {
    tally1.set(0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
