/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.XboxController;


public class Robot extends TimedRobot {
  public CANSparkMax lSpark, rSpark;

  public XboxController xbox;


  @Override
  public void robotInit() {
    lSpark = new CANSparkMax(3, MotorType.kBrushless);
    rSpark = new CANSparkMax(7, MotorType.kBrushless);

    xbox = new XboxController(0);



  }

  @Override public void autonomousPeriodic() {
  }

  @Override
  public void teleopPeriodic()
  {
    if (xbox.getAButton())
    {
      lSpark.set(1.0);
      rSpark.set(-1.0);
      System.out.println("AAAAAAAAA");
    }
    else if (xbox.getBButton())
    {
      lSpark.set(-1.0);
      rSpark.set(1.0);
      System.out.println("BBBBBBBBBB");
    }
    else
    {
      lSpark.stopMotor();
      rSpark.stopMotor();
      System.out.println("CCCCCCCCCCC");
    }
  }
}