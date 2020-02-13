package frc.Library.Controllers;
import com.revrobotics.CANSparkMax;
import java.util.ArrayList;

public class DriveSpark
{
	ArrayList<CANSparkMax> CAN = new ArrayList<CANSparkMax>();
	
	static CANSparkMax[] FullCAN;
	
	public DriveSpark(CANSparkMax[] CAN)
	{
		this.CAN.clear();
		for(int i = 0; i < CAN.length; i++)
		{
			this.CAN.add(CAN[i]);
		}
	}
	
	public DriveSpark(int[] nums)
	{
		CAN = new ArrayList<CANSparkMax>();
		for(int i = 0; i < nums.length; i++)
		{
			CAN.add(FullCAN[nums[i]]);
		}
	}
	
	public void drive(double val)
	{
		for (CANSparkMax spark : CAN)
		{
			spark.set(val);
		}
	}
	
	public double GetSpeed()
	{
		if(CAN != null && CAN.get(0) != null)
			return CAN.get(0).get();
		return 0;
	}
	
	public static void SetFullCAN(CANSparkMax[] CAN)
	{
		FullCAN = CAN;
	}
	
	public ArrayList<CANSparkMax> GetTalons()
	{
		return CAN;
	}
}