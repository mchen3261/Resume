//Author: Makayla Chen
//Course: Computer Science II: Section 2
//Assignment: Programming Assignment 2
//Due Date: 2/27/2018
//Task: Create a program that designs and implements a character graphics 
//		graphing application for baby name frequency

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class BabySurfer
{
	public static void display(BabyName baby)
	{
		int year = 1900;
		String asterisks = "";
		int [] ranks = baby.getRanks();
		
		System.out.println("Name: " + baby.getName());
		
		for(int i = 0; i < 11; i++)
		{
			year = year + (10*i);
			
			int count_asterisks = (1000 - ranks[i])/100;
			for (int j = 0; j < count_asterisks+1; j++)
			{
				if(ranks[i] == 0)
					break;
				asterisks += "*";
			}//for
			
			
			if (ranks[i] == 0)
				System.out.println(year);
			else
				System.out.println(year + asterisks + ranks[i]);

			year = 1900;
			asterisks = "";
		}//for
		
	}//display
	
	///////////////////////////////////////////////////////////////////////////
	
	public static void main(String[] args) throws FileNotFoundException
	{
		String n; //name
		int [] ranks = new int [11];
		
		File baby_names = new File("names-data.txt");
		Scanner scan = new Scanner(baby_names);
		Scanner input = new Scanner(System.in);
		
		/////STEP 1: Tests BabyName/////
		// int [] rank = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
		// BabyName test = new BabyName("DeClue", rank);
		// System.out.println(test.getName());
		// System.out.println(test.getRanks());
		// System.out.println(test.toString());
		
		/////STEP 2: Scans and prints file/////
		//while(scan.hasNextLine())
		//{
			//System.out.println(scan.nextLine());
		//}//while
		
		LinkedQueue <BabyName> nameQ = new LinkedQueue <BabyName>();
		
		System.out.println("Is your name popular? Please enter a name.");
		String in = input.nextLine();
		
		while(scan.hasNext())
		{
			n = scan.next();
			
			for(int i = 0; i < 11; i++)
				ranks[i] = scan.nextInt();
			
			BabyName bn = new BabyName(n, ranks);
			nameQ.enqueue(bn);
			
			while(!nameQ.isEmpty())
			{	
				if (nameQ.front().getName().equals(in))
				{
					display(nameQ.front());
					System.exit(0);
				}//if
				nameQ.dequeue();
			}//while
			
		}//while
		
		System.out.println("That name is not a popular name. Please try a different name.");
		
	}//main
	
}//BabySurfer