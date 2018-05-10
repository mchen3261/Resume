//	Name:		Makayla Chen							            	                        
//  Due Date:   10/10/2017                                               
//	Desc: 	    Write a program that calculates the distance traveled in 
//              a series of dropped ball experiments.

package bouncingBall;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;


public class BouncingBall 
{
	public static void main(String[] args) throws IOException
	{
		File bounceDataFile = new File("bouncedata.txt");
		Scanner ball = new Scanner(bounceDataFile);
		
		while (ball.hasNextDouble( )) 
		{
			double initialDropHeight = ball.nextDouble( ); //reads drop height from file
			double firstBounceHeight = ball.nextDouble() ; //reads bounce height from file
			double numberBounces = ball.nextDouble( ); //reads number of bounces from file
			double actualBounces = 0;
			
			double bounceIndex = (firstBounceHeight / initialDropHeight); //calculates the bounciness index
			double distance = 0;
			
			System.out.println("Initial drop height (in ft): " + initialDropHeight);
			System.out.println("First bounce height (in ft): " + firstBounceHeight);
			System.out.println("Bounciness Index results: " + bounceIndex);
			System.out.println("Number of bounces: " + numberBounces);
			
			while (numberBounces > 0 && firstBounceHeight > 0.001) //creates loop to calculate distance for each bounce
			{
				distance = distance + initialDropHeight + firstBounceHeight; //distance of first bounce
				initialDropHeight = firstBounceHeight; //drop height same as bounce height
				firstBounceHeight = initialDropHeight*bounceIndex; //heighth of the next bounce
				numberBounces--; //counts bounces for 0
				actualBounces++; //how many times the ball bounces
			}
			
			System.out.println("Actual number of bounces: " + actualBounces);
			System.out.println("Distance in ft: " + distance);
			System.out.println("================");
	
		}//end of loop
		
	}//end of method

}//end of BouncingBall class
