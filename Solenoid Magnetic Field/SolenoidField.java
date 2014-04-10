//Basic program for estimating the magnetic field inside a solenoid


import java.text.*;
//import java.lang.Math.*;


public class SolenoidField 
{

	public static void main(String[] args) 
	{
		NumberFormat formatter = new DecimalFormat("0.00000E0");

		//Properties of wire
		double wireRadius = 0.000725;  //1.45 mm diameter/0.725 mm radius for 15 AWG wire
		double wireLength;
		double wireResistivity = 1.68*(Math.pow(10.0, -8.0)); //1.68 e-8 for copper
		double wireResistance;
		double copperVolume;
		
		//Solenoid properties
		double solenoidRadius = 0.034925 + wireRadius;
		double solenoidLength = 0.15;
		int spacingError = 1;  //estimated number of unused loop space (in number of loops) due to manufacturing/winding error
		double solenoidBField;
		
		//Ion properties
		double particleSpeed = 2.7*(Math.pow(10, 8));   //Assuming a speed of 270 000 km/s
		double particleCharge = 1.602176487*(Math.pow(10.0, -19.0));
		double particleMass = 9.10938215*(Math.pow(10.0, -31));
		double minParticleCurvature;		
				
		//Misc variables
		double permFreeSpace = (4*Math.PI)*(Math.pow(10.0, -7.0));
		double voltage = 12.0;
		double current;
	
		
		
		//Current calculation
		wireLength = (2*Math.PI*solenoidRadius)*((solenoidLength/(wireRadius*2))-spacingError);
		wireResistance = wireResistivity*(wireLength/(Math.PI*wireRadius*wireRadius));
		current = voltage/wireResistance;
		System.out.printf("Wire length: %f\n", wireLength);
		System.out.printf("Wire resistance: %f\n", wireResistance);
		
		
		//Magnetic field along center axis of solenoid
		
		solenoidBField = permFreeSpace*(((solenoidLength/(wireRadius*2))-spacingError)/solenoidLength)*current;
	//	solenoidBField = formatter.format(solenoidBfield);
		
		System.out.printf("The magnetic field inside the solenoid is: %s T\n", formatter.format(solenoidBField));
		
		//Maximum radius of curvature of electron/positron (assuming the angle between B and v is 90)
		
		minParticleCurvature = (particleMass*particleSpeed)/(particleCharge*solenoidBField);
		
		System.out.printf("The minimum radius of curvature of electron/positron is %f m\n", minParticleCurvature);
		
		copperVolume = wireLength*(Math.PI*wireRadius*wireRadius);
		
		System.out.printf("Volume of copper required: %s\n", formatter.format(copperVolume));
		System.out.println("Mass of copper required: " + copperVolume*8960);
		
	}

}
