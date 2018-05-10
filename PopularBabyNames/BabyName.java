//Author: Makayla Chen
//Course: Computer Science II: Section 2
//Assignment: Programming Assignment 2
//Due Date: 2/27/2018
//Task: Create a program that designs and implements a character graphics 
//		graphing application for baby name frequency

public class BabyName
//Class note: This class stores a name and an array of eleven ints
//            		representing the name ranks from the census
{
	private String name;  //This stores the name
    private int [] ranks; //This stores the ranks

	
	///// C O N S T R U C T O R S /////
    public BabyName(String n, int [] r)
    //TAS: initialize the name and rank array
    {
		name = n;
		ranks = r;
    }//BabyName Constructor

	
    public BabyName()
    //POS: name == "None" && ranks == null
    //TAS: initialize the name and rank array
    {
		name = "none";
		ranks = null;
		
    }//BabyName Constructor


    //////// A C C E S S O R S ////////
    public String getName()
    //TAS: return the baby's name
    {
        return name;
		
    }//getName

	
    public int [] getRanks ()
    //TAS: Return the rank for a specific decade
    {
		return ranks;       
		
    }//getRank

	
    public String toString()
    //TAS: Return the data in this babyname as a String
    {
		String ret = "";
		ret = name + ranks.toString();
		return ret;     
		
    }//toString
	
}//BabyName class	
