package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.*;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends TimedRobot {
  CANSparkMax lMotor, rMotor;
  
  XboxController Xbox;

  Boolean spin;

  @Override
  public void robotInit() {
    lMotor = new CANSparkMax(3, MotorType.kBrushless);
    rMotor = new CANSparkMax(7, MotorType.kBrushless);
    lMotor.setVoltage(12.0);
    rMotor.setVoltage(12.0);

    Xbox = new XboxController(0);
    
    spin=false;

    SmartDashboard.putNumber("Left Voltage", lMotor.getBusVoltage());
    SmartDashboard.putNumber("Left Value", lMotor.get());
    SmartDashboard.putNumber("Right Voltage", rMotor.getBusVoltage());
    SmartDashboard.putNumber("Right Value", rMotor.get());
    SmartDashboard.putBoolean("Spin?", spin);
  }

  @Override
  public void robotPeriodic() {
  }@Override public void autonomousInit() {
  }@Override public void autonomousPeriodic() {
  }
  
  @Override
  public void teleopPeriodic() {
    SmartDashboard.putNumber("Left Voltage", lMotor.getBusVoltage());
    SmartDashboard.putNumber("Left Value", lMotor.get());
    SmartDashboard.putNumber("Right Voltage", rMotor.getBusVoltage());
    SmartDashboard.putNumber("Right Value", rMotor.get());
    SmartDashboard.putBoolean("Spin?", spin);

    if (Xbox.getAButton()==true)
    {
      lMotor.set(1.0);
      rMotor.set(-1.0);
      System.out.println("Shooter - Shoot");
      spin=true;
    }
    else if (Xbox.getBButton()==true)
    {
      lMotor.set(-1.0);
      rMotor.set(1.0);
      System.out.println("Shooter - Reverse");
      spin=true;
    }
    else
    {
      lMotor.stopMotor();
      rMotor.stopMotor();
      System.out.println("Shooter - Idle");
      spin=false;
    }
  }

  @Override
  public void testPeriodic() {
  }
}
