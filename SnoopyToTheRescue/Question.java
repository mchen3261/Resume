//Author: Makayla Chen
//Course: Computer Science II: Section 2
//Phase III
//Due Date: 5/7/2018

package Game;

public class Question 
{
	private String question;
	private String opA, opB, opC, opD;
	private String answer;

	  //////////////////////////////////////////////////////////
	
	public Question() 
	{
		question = "none";
		opA = opB = opC = opD = "none";
		answer = "none";

	}//Question

	/////////////////////////////////////////////////////

	public Question(String q, String a, String b, String c, String d, String ans ) 
	{
		question = q;
		opA = a;
		opB = b;
		opC = c;
		opD = d;
		answer = ans;
	}//Question

	/////////////////////////////////////////////////////

	public String getQuestion()
	{
		return question;
	}//getQuestion

	/////////////////////////////////////////////////////

	public String getAnswer()
	{
		return answer;
	}//getAnswer

	/////////////////////////////////////////////////////

	public String getA() 
	{
		return opA;
	}//getA

	/////////////////////////////////////////////////////
	
	public String getB() 
	{
		return opB;
	}//getB

	/////////////////////////////////////////////////////
	
	public String getC() 
	{
		return opC;
	}//getC

	/////////////////////////////////////////////////////

	public String getD() 
	{
		return opD;
	}//getD

}//Question class
