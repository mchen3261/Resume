//Author: Makayla Chen
//Course: Computer Science II: Section 2
//Phase III
//Due Date: 5/7/2018

package Game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ScoreFacade extends FileNotFoundException
{
	private String name;
	private int score;
	private String addName;
	private int addScore;
	private String listName;
	private int listScore;
	private String list;
	private HeapEntry listHeap;
	
	private Heap h;
	private File scoreList;
	private Scanner scan;
	private FileWriter append;
	private BufferedWriter bufferWrite;
	
	public ScoreFacade() throws IOException
	{
		scoreList = new File("scores.txt");
		scan = new Scanner(scoreList);
		append = new FileWriter(scoreList, true);
		bufferWrite = new BufferedWriter(append);
		h = new Heap();
		name = "";
		score = 0;
		addName = "";
		addScore = 0;
		listName = "";
		listScore = 0;
		list = "";
		listHeap = null;
	}//ScoreKeeperFacade
	
	//////////////////////////////////////////////////////////

	public void newScore(int newScore, String insertName) throws IOException
	{
		score = newScore;
		name = insertName;
		bufferWrite = new BufferedWriter(append);
		
		bufferWrite.newLine();
		bufferWrite.write(name);
		bufferWrite.newLine();
		bufferWrite.write(Integer.toString(score));
		bufferWrite.flush();
		
		h.insert(insertName, newScore);
	}// getScores
	
	//////////////////////////////////////////////////////////
	
	public void saveAllScores() throws IOException
	{
		bufferWrite.close();
	}// saveAllScores
	
	//////////////////////////////////////////////////////////

	public void fromFileToHeap() throws FileNotFoundException
	{	
		if(h.isEmpty())
		{
			while(scan.hasNextLine())
			{
				addName = scan.nextLine();
				addScore = Integer.parseInt(scan.nextLine());
				h.insert(new String(addName), addScore);
			}// while
		}
	}// fromFile
	
	//////////////////////////////////////////////////////////
	
	public String displayScore()
	{
		int size = h.size();
		for (int i = 1; i < size + 1; i++)
		{
			listHeap = h.remove();
			listName = (String) listHeap.getElement();
			listScore = listHeap.getPriority();
			list = list + "#" + i + " " + listName + " " + listScore + "\n";
		}// for
		h = new Heap();
		return list;
	}// printTop10

}//ScoreFacade
