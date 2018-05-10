//	Name: Makayla Chen		
//	Program: Programming Assignment 3: Part 2
//  Due Date: 10/10/2017                                       
//	Desc: This program displays a series of jpeg images in a frame
//	Test cases: Ten pictures named 1.jpeg, 2.jpeg, 3.jpeg, 4.jpeg....etc.


package claymation;

import java.awt.Dimension; // So we can use Dimension objects
import javax.swing.*; // JFrames, JScrollPanes, JLabels & ImageIcons

public class Claymation 
{
	public static void main(String[] args) 
	{
		//////// DECLARATIONS AND COMPONENTS ///////
		String play;
		String repeat;
		JFrame frame; // The frame for holding everything
		ImageIcon image; // The picture we will display
		JLabel imageLabel;// The picture label
		JScrollPane sp; // The scrolling pane will contain the label
		// that holds the picture
		Integer Objecti = null; // An integer object

		play = JOptionPane.showInputDialog(null, "Do you want the claymation to go forward 'F' or reverse 'R'?");

		while ((play.equalsIgnoreCase("f")) || play.equalsIgnoreCase("r")) 
		{
			//////// ALGORITHM ///////

			// user will be commanded to play claymation forward or reverse
			// 14 pictures, so write a loop that executes 14 times
			if (play.equalsIgnoreCase("F"))
				for (int i = 1; i < 15; i++) 
				{
					// Step 1: Create an Integer object from int i
					Objecti = new Integer(i);

					// Step 2: image is created as “1.jpg” “2.jpg” and so on
					image = new ImageIcon(Objecti.toString() + ".jpg");

					// Step 3: Set up the Frame
					frame = new JFrame("Claymation");
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

					// Step 4: Show the picture
					imageLabel = new JLabel(image);
					sp = new JScrollPane(imageLabel);
					sp.setPreferredSize(new Dimension(1100, 1100));
					frame.getContentPane().add(sp);
					frame.pack();
					frame.setVisible(true);

					// Step 5: Pause long enough to view the picture
					for (long j = 0; j < 100000000; j++)
						;

				} // end of "forward" loop

			else if (play.equalsIgnoreCase("R"))
				for (int i = 15; i > 0; i--) 
				{
					// Step 1: Create an Integer object from int i
					Objecti = new Integer(i);

					// Step 2: image is created as “1.jpg” “2.jpg” and so on
					image = new ImageIcon(Objecti.toString() + ".jpg");

					// Step 3: Set up the Frame
					frame = new JFrame("Claymation");
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

					// Step 4: Show the picture
					imageLabel = new JLabel(image);
					sp = new JScrollPane(imageLabel);
					sp.setPreferredSize(new Dimension(1100, 1100));
					frame.getContentPane().add(sp);
					frame.pack();
					frame.setVisible(true);

					// Step 5: Pause long enough to view the picture
					for (long j = 0; j < 100000000; j++)
						;

				} // end of "reverse" loop

			else
				JOptionPane.showMessageDialog(null, "That is not an option, please try again.");

			repeat = JOptionPane.showInputDialog(null, "Would you like to play it again? Yes or No?");
			
			if (repeat.equalsIgnoreCase("yes")) 
			{
				repeat = "yes";
				play = JOptionPane.showInputDialog(null,
						"Do you want the claymation to go forward 'F' or reverse 'R'?");
			} else if (repeat.equalsIgnoreCase("no")) 
			{
				repeat = "no";
				JOptionPane.showMessageDialog(null, "Thank you for watching!");
				play = "false";
			}
		} // end of while loop
	}// end of main method
}// end of Claymation class
