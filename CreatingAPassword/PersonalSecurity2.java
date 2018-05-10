//Author: Makayla Chen
//Due Date: 9/29/2017
//Task: Create a program that will accept a potential password from the user using a dialogue box.

package personalsecurity2;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class PersonalSecurity2 
{
	public static boolean tooShort (String s)
	{
	if (s.length() >= 8)
		return false;
	else
		return true;
	}//tooShort
	
	public static boolean noContain (String s)
	{
		if (s.contains("!"))
			return false;
		else if (s.contains("$"))
			return false;
		else if (s.contains("@"))
			return false;
		else
			return true;
	}//noContain
	
	public static boolean thereSpace (String s)
	{
		 if (s.contains(" "))
			 return true;
		 else 
			 return false;
	}//thereSpace
	
	public static boolean beginningChar (String s)
	{
		if (s.startsWith("!"))
		 return true;
		if (s.startsWith("?"))
		 return true;
	 else 
		 return false;
	}//beginningChar
	
	public static boolean firstFewSame (String s)
	{
		if (s.charAt(0) == s.charAt(1) && s.charAt(1) == s.charAt(2))
			return true;
		else
			return false;
	}//firstFewSame
	
	public static boolean lastFewSame (String s)
	{
		if (s.charAt(s.length()-1)==s.charAt(s.length()-2) &&
				s.charAt(s.length()-2)==s.charAt(s.length()-3))
			return true;
		else
			return false;
	}//lastFewSame

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		String password = JOptionPane.showInputDialog( null, "Please create a password.");
		
		if (tooShort(password))
			JOptionPane.showMessageDialog(null, "Your password is too short. You must have at least 8 characters.");
		else if (noContain(password))
			JOptionPane.showMessageDialog(null, "Your password does not contain one of the special characters (!, @, $).");
		else if (thereSpace(password))
			JOptionPane.showMessageDialog(null, "Your password should not contain any spaces.");
		else if (beginningChar(password))
			JOptionPane.showMessageDialog(null, "The first character of your password should not have '!' or '?'.");
		else if (firstFewSame(password))
			JOptionPane.showMessageDialog(null, "The first three characters should not be the same.");
		else if (lastFewSame(password))
			JOptionPane.showMessageDialog(null, "The last three characters should not be the same.");
		else
			JOptionPane.showMessageDialog(null, "Your password is fantastic! Amazing!");

	}//end of method

}//end of PersonalSecurity2 class
