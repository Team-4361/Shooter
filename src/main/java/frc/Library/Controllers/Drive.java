package frc.Library.Controllers;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import java.util.ArrayList;

public class Drive
{
	ArrayList<WPI_TalonSRX> CAN = new ArrayList<WPI_TalonSRX>();
	ArrayList<CANSparkMax> sCAN = new ArrayList<CANSparkMax>();
	
	static WPI_TalonSRX[] TalonCAN;
	static CANSparkMax[] SparkCAN;
	
	public Drive(WPI_TalonSRX[] CAN)
	{
		this.CAN.clear();
		for(int i = 0; i < CAN.length; i++)
		{
			this.CAN.add(CAN[i]);
		}
	}
	
	public Drive(int[] nums)
	{
		CAN = new ArrayList<WPI_TalonSRX>();
		for(int i = 0; i < nums.length; i++)
		{
			CAN.add(TalonCAN[nums[i]]);
		}
	}
	
	public void drive(double val)
	{
		for (WPI_TalonSRX tal : CAN)
		{
			tal.set(val);
		}
	}
	
	public double GetSpeed()
	{
		if(CAN != null && CAN.get(0) != null)
			return CAN.get(0).get();
		return 0;
	}
	
	public static void SetFullCAN(WPI_TalonSRX[] CAN)
	{
		TalonCAN = CAN;
	}
	
	public ArrayList<WPI_TalonSRX> GetTalons()
	{
		return CAN;
	}
}