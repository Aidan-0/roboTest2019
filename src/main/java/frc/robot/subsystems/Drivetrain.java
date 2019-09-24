/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.*;

/**
 * An example subsystem. You can replace me with your own Subsystem.
 */
public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public WPI_TalonSRX tally1;
  public double encoder1;
  public int goalPoint = 6000;
  public int variance = 450;

  public Drivetrain(int tally1id, int encoder1id) {

    tally1 = new WPI_TalonSRX(tally1id);

  }

  public void MovingMotors() {
    tally1.set(0.5);
  }

  public void StoppingMotors() {
    tally1.set(0);
  }

  public void AutoCorrect() {
    encoder1 = tally1.getSensorCollection().getQuadraturePosition();
    SmartDashboard.putNumber("Encoder is at pos: ", encoder1);

    if (encoder1 > (goalPoint + variance)) {
      tally1.set(0.5);
    }

    else if (encoder1 < (goalPoint - variance)) {
      tally1.set(-0.5);
    }

    if (encoder1 >= (goalPoint - variance) && encoder1 <= (goalPoint + variance)) {
      tally1.set(0);
    }

  }

  @Override
  public void initDefaultCommand() {

    // Set the default command for a subsystem here.
    setDefaultCommand(new AutoCorrect());
  }
}
