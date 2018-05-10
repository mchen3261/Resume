//Author: Makayla Chen
//Course: Computer Science II: Section 2
//Phase III
//Due Date: 5/7/2018

package Game;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Random;

public class Game
{
  private Grid grid;	//holds the grid used to store and display images
  private int userRow;	//keeps track of which row the user-controlled image
  						//	appears in, on the left edge of the grid
  private int msElapsed;//keeps track of the total number of milliseconds that 
  						//	have elapsed since the start of the game
  private int timesGet;	//keeps track of the total number of times the user has 
  						//	gotten the things they're supposed to get in the game
  private int timesAvoid;//keeps track of the total number of times the user has
  						//	been hit by the things they're supposed to avoid
  private int questionCount = 0; //counts how many question the player
  						//has gotten correct
  
  Question[] level1Pool = new Question[25];
  Question[] level2Pool = new Question[25];
  Question[] level3Pool = new Question[10];
  
  //////////////////////////////////////////////////////////
  
  public Game() throws FileNotFoundException
  {
    grid = new Grid(8, 18, 5000);
    userRow = 5;
    msElapsed = 0;
    timesGet = 0; 
    timesAvoid = 0; 		
    updateTitle();
    grid.setImage(new Location(userRow, 0), "Snoopy.gif");
  }//Game
  
  //////////////////////////////////////////////////////////
  
  public void play() throws FileNotFoundException
  {
	fillArrays();
	
    while (!isGameOver())
    {
      grid.pause(100);
      handleKeyPress();
      if (msElapsed % 300 == 0)
      {
        scrollLeft();
        populateRightEdge();
      }//if
      updateTitle();
      
      if (msElapsed % 10000 == 0 && msElapsed != 0)
      {
    	  questionGenerator();
      }//if
      
      msElapsed += 100;
    }//while
  }//play
  
  //////////////////////////////////////////////////////////
  
  public void fillArrays() throws FileNotFoundException
  {
		String question = "";
	  	String opA, opB, opC, opD;
	  	opA = opB = opC = opD = "";
		String answer = "";
		int i, j, k; // to insert into array spots
		i = j = k = 0;

		/// LEVEL ONE QUESTIONS ///
		Scanner level1 = new Scanner(new File("questions_1.txt"));
		while (level1.hasNextLine()) 
		{
			question = level1.nextLine();
			opA = level1.nextLine();
			opB = level1.nextLine();
			opC = level1.nextLine();
			opD = level1.nextLine();
			answer = level1.nextLine();

			Question que = new Question(question, opA, opB, opC, opD, answer);
			level1Pool[i] = que;
			i++;
		} // while

		/// LEVEL TW0 QUESTIONS ///
		Scanner level2 = new Scanner(new File("questions_2.txt"));
		while (level2.hasNextLine()) 
		{
			question = level2.nextLine();
			opA = level2.nextLine();
			opB = level2.nextLine();
			opC = level2.nextLine();
			opD = level2.nextLine();
			answer = level2.nextLine();

			Question que = new Question(question, opA, opB, opC, opD, answer);
	  		level2Pool[j] = que;
			j++;
		} // while

		/// LEVEL THREE QUESTIONS ///
		Scanner level3 = new Scanner(new File("questions_3.txt"));
		while (level3.hasNextLine()) 
		{
			question = level3.nextLine();
			opA = level3.nextLine();
			opB = level3.nextLine();
			opC = level3.nextLine();
			opD = level3.nextLine();
			answer = level3.nextLine();

			Question que = new Question(question, opA, opB, opC, opD, answer);
			level3Pool[k] = que;
			k++;
		} // while
  }
  
  //////////////////////////////////////////////////////////
  
  public void questionGenerator()
  {
		Random rand = new Random();
		int randQue = rand.nextInt(25);
		int randQue3 = rand.nextInt(10);

		///LEVEL ONE///
		if(questionCount <= 5)
		{
			ImageIcon redbaron = new ImageIcon("Red Baron.gif");
			ImageIcon balloon = new ImageIcon("Red_Balloon.gif");
			
			Object [] options = { level1Pool[randQue].getA(), level1Pool[randQue].getB(), 
									level1Pool[randQue].getC(), level1Pool[randQue].getD() };

			int ans = JOptionPane.showOptionDialog(null, level1Pool[randQue].getQuestion(), "The Red Baron has Dropped a Trap!!",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, balloon, options, options[0]);
			
			String StringAnswer = Character.toString((char)((ans + 65)));
			if(((String)StringAnswer).equals( (String)(level1Pool[randQue].getAnswer())))
			{
				timesGet++;
				questionCount++;
				JOptionPane.showMessageDialog(null, "Good Job!", 
						"Phase II Game", JOptionPane.PLAIN_MESSAGE, null);
			}//if
			else
			{
				timesGet-=3;
				JOptionPane.showMessageDialog(null, "Oh no! The Red Baron got you!", 
						"Phase II Game", JOptionPane.PLAIN_MESSAGE, redbaron);
			}//else
		}//if
		
		///LEVEL TWO///
		else if(questionCount <= 10)
		{
			ImageIcon redbaron = new ImageIcon("Red Baron.gif");
			ImageIcon balloon = new ImageIcon("Red_Balloon.gif");
			
			Object[] options = { level2Pool[randQue].getA(), level2Pool[randQue].getB(), 
									level2Pool[randQue].getC(), level2Pool[randQue].getD() };

			int ans = JOptionPane.showOptionDialog(null, level2Pool[randQue].getQuestion(), "The Red Baron has Dropped a Trap!!",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, balloon, options, options[0]);
			
			String StringAnswer = Character.toString((char)((ans + 65)));
			if(((String)StringAnswer).equals( (String)(level2Pool[randQue].getAnswer())))
			{
				timesGet++;
				questionCount++;
				JOptionPane.showMessageDialog(null, "Good Job!", 
						"Phase II Game", JOptionPane.PLAIN_MESSAGE, null);
			}//if
			else
			{
				timesGet-=3;
				JOptionPane.showMessageDialog(null, "Oh no! The Red Baron got you!", 
						"Phase II Game", JOptionPane.PLAIN_MESSAGE, redbaron);
			}//else
		}//elseif
		
		///LEVEL THREE///
		else if(questionCount <= 13)
		{
			ImageIcon redbaron = new ImageIcon("Red Baron.gif");
			ImageIcon balloon = new ImageIcon("Red_Balloon.gif");
			  
			Object[] options = { level3Pool[randQue3].getA(), level3Pool[randQue3].getB(), 
									level3Pool[randQue3].getC(), level3Pool[randQue3].getD() };

			int ans = JOptionPane.showOptionDialog(null, level3Pool[randQue3].getQuestion(), "The Red Baron has Dropped a Trap!!",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, balloon, options, options[0]);
			
			String StringAnswer = Character.toString((char)((ans + 65)));
			if(((String)StringAnswer).equals( (String)(level3Pool[randQue3].getAnswer())))
			{
				timesGet++;
				questionCount++;
				JOptionPane.showMessageDialog(null, "Good Job!", 
						"Phase II Game", JOptionPane.PLAIN_MESSAGE, null);
			}//if
			else
			{
				timesGet-=3;
				JOptionPane.showMessageDialog(null, "Oh no! The Red Baron got you!", 
						"Phase II Game", JOptionPane.PLAIN_MESSAGE, redbaron);
			}//else
		}//elseif
		
		//////////////////LEVEL UP NOTIFACTIONS//////////////////
		if(questionCount == 5)
		{
			JOptionPane.showMessageDialog(null, "Great job! Next Level!", 
					"Phase II Game", JOptionPane.PLAIN_MESSAGE, null);
		}//if
		else if(questionCount == 10) 
		{
			JOptionPane.showMessageDialog(null, "Great job! Final Level!", 
					"Phase II Game", JOptionPane.PLAIN_MESSAGE, null);
		}//elseif
  }//questionGenerator
  
  //////////////////////////////////////////////////////////
  
  public void handleKeyPress()
  {
	  int key = grid.checkLastKeyPressed();
	  
	  if((key == 38) && (userRow != 0)) //if up key pressed, Snoopy will move up
		  userRow -= 1;
	  if(key == 40 && (userRow != grid.getNumRows() - 1)) //if down key pressed, Snoopy will move down
		  userRow += 1;
	  handleCollision(new Location (userRow, 0));
	  grid.setImage(new Location(userRow, 0), null);
	  grid.setImage(new Location(userRow, 0), "Snoopy.gif"); //sets U
	  
  }//handleKeyPress
  
  //////////////////////////////////////////////////////////
  
  public void populateRightEdge()
  {
	  int size = 30;
	  int sizeLife = 600;
	  for(int i = 0; i < grid.getNumRows(); i++)
	  {
		  int number = (int)(Math.random()*size); //multiples random # 0-2 with size 
		  int numberLife = (int)(Math.random()*sizeLife); //multiplies random #0-2 with sizeLife (less often)
		  
		  if(number == 1) //if the int = 1, then set get.gif
			  grid.setImage(new Location(i, grid.getNumCols() -1), "Feather.gif"); 
		  else if(number == 2)//if the int = 2, then set avoid.gif
			  grid.setImage(new Location(i, grid.getNumCols() - 1), "Red_Balloon.gif");
		  else if(numberLife == 0)
			  grid.setImage(new Location(i, grid.getNumCols() - 1), "Woodstock.gif");
		  //nulls will be set if neither of the if's are met
	  }//for
  }//populateRightEdge
  
  //////////////////////////////////////////////////////////
  
  public void scrollLeft()
  {
	  handleCollision(new Location (userRow, 0));
	  for(int rows = 0; rows < grid.getNumRows(); rows++)
	  {
		 for(int cols = 0; cols < grid.getNumCols() - 1; cols++)
		 {
			 if(cols == 0)//sets the images at the left-most column to null
				 grid.setImage(new Location(rows, cols), null); 
			 if(grid.getImage(new Location(rows, cols + 1)) != null) //while the set image is not null
			 {
				 grid.setImage(new Location(rows, cols), grid.getImage(new Location(rows, cols+1))); //sets the image with the the previous image in cols 
				 grid.setImage(new Location(rows, cols+1), null); //sets the image that was in the previous cols to null
			 }//if
		 }//colsfor
	  }//rowsfor
  }//scrollLeft
  
  //////////////////////////////////////////////////////////
  
  public void handleCollision(Location loc)
  {
	  if(grid.getImage(loc) != null)
	  {
		  if(grid.getImage(loc).equals("Feather.gif"))
			  timesGet++;
		  else if(grid.getImage(loc).equals("Red_Balloon.gif"))
			  timesAvoid++;
		  else if(grid.getImage(loc).equals("Woodstock.gif"))
			  timesAvoid--;
	  }//if
  }//handleCollision
  
  //////////////////////////////////////////////////////////
  
  public int getScore()
  {
	  return timesGet;
	  
  }//getScore
  
  //////////////////////////////////////////////////////////
  
  public void updateTitle()
  {
	  grid.setTitle("Score: " + getScore() + " Lives: " + (3 - timesAvoid));
	  
  }//updateTitle
  
  //////////////////////////////////////////////////////////
  
  public boolean isGameOver()
  {
	  if(timesAvoid == 3)
	  {
		  JOptionPane.showMessageDialog(null, "Game Over! Better luck next time!\nYour Score: " + timesGet);
		  grid.closeFrame();
		  return true;
	  }//avoid if
	  if(questionCount == 25)
	  {
		  JOptionPane.showMessageDialog(null, "You Won!!!\nYour Score: " + timesGet);
		  grid.closeFrame();
		  return true;
	  }//if
	  
	  return false;
	  
  }//isGameOver
  
  //////////////////////////////////////////////////////////
  
  public static void main(String[] args) throws IOException
  {	
	  String name = "";
	  
	  ScoreFacade facade = new ScoreFacade();
	  
	  ImageIcon redbaron = new ImageIcon("Red Baron.gif");
	  ImageIcon snoopy = new ImageIcon("Snoopy.gif");
	  ImageIcon woodstock = new ImageIcon("Woodstock.gif");
	  
	  JLabel welcomeMessage = new JLabel();
	  JLabel story_inst = new JLabel();
	  
	  welcomeMessage.setFont (new Font ("Impact", Font.BOLD, 50) );
	  welcomeMessage.setText("Snoopy to the Rescue!");
	  JOptionPane.showMessageDialog(null, welcomeMessage, 
			  "Snoopy to the Rescue", JOptionPane.PLAIN_MESSAGE, null);
	  
	  story_inst.setFont (new Font ("Arial", Font.BOLD, 30) );
	  story_inst.setText("Snoopy and Woodstock are having a talk by the dog house.");
	  JOptionPane.showMessageDialog(null, story_inst, 
			  "Snoopy to the Rescue", JOptionPane.PLAIN_MESSAGE, woodstock);
	  story_inst.setText("Oh no! The Red Baron snatched Woodstock. Help Snoopy save Woodstock!");
	  JOptionPane.showMessageDialog(null, story_inst, 
			  "Snoopy to the Rescue", JOptionPane.PLAIN_MESSAGE, redbaron);
	  
	  story_inst.setText("<html>Instructions <br></br>1. Press the UP and DOWN arrow keys to move Snoopy. "
	  		+ "<br></br>2. Avoid the red baron’s red balloons or you will lose points!"
	  		+ "<br></br>3. Get the feathers to get more points"
	  		+ "<br></br>4. Answer the questions to avoid the red baron’s traps. "
	  		+ "<br></br>If you miss the question, you will lose 3 points. If you get it right, you will earn 1 point!"
	  		+ "<br></br>5. Be on the lookout for rare Woodstocks to earn more lives. </html>");
	  JOptionPane.showMessageDialog(null, story_inst, 
			  "Snoopy to the Rescue", JOptionPane.PLAIN_MESSAGE, snoopy);
	  
	  story_inst.setText("Enter your name");
	  name = JOptionPane.showInputDialog(null, story_inst);
	  
	  int reply = 0;
	  do
	  {
		  facade.fromFileToHeap();
		  
		  Game game = new Game();
		  game.play();
		  
		  facade.newScore(game.getScore(), name);
		  
		  story_inst.setText("<html>Score Board<br></br>" + 
				  facade.displayScore().replaceAll("\n", "<br></br>") + "</html>");
		  JOptionPane.showMessageDialog(null, story_inst, 
				  "Snoopy to the Rescue", JOptionPane.PLAIN_MESSAGE, null);
		  
		  reply = JOptionPane.showConfirmDialog(null, "Would you like to play again?", 
				"Snoopy to the Rescue", JOptionPane.YES_NO_OPTION);
		  
		  if(reply == JOptionPane.YES_OPTION)
		  {
			  JOptionPane.showMessageDialog(null,"Let's play again!",
					  "Snoopy to the Rescue", JOptionPane.PLAIN_MESSAGE, snoopy);
		  }//if

	  } while(reply == JOptionPane.YES_OPTION);
	  
	  JOptionPane.showMessageDialog(null, "Thanks for playing!", 
			  "Snoopy to the Rescue", JOptionPane.PLAIN_MESSAGE, snoopy);
	  facade.saveAllScores();
	  System.exit(0);
	  
  }//main
}//Game