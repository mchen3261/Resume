//Author:      Makayla Chen
//Assignment:  Programming Assignment 5
//Due:         11/16/17
//Description: Create a program that executes a game 
//             of Tic-Tac-Toe (Human vs. Computer). 
//Test Cases:  One winning game, one losing game

package tictactoe;

import java.util.Scanner;
import java.util.Random;

public class TicTacToeGame 
{

	public static void main(String[] args) 
	{
		Scanner k = new Scanner(System.in);
		Random rand = new Random();
		GameBoard gb = new GameBoard();
		boolean humanTurn = true;
		boolean gameOver = false;
		int row = 0;
		int col = 0;
		

		System.out.println("Welcome to TicTacToe!");
		System.out.println("Player: x | " + "Computer: o");
		System.out.println("Please type in your coordinates:");
		System.out.println(" ");

		while (!(gameOver)) 
		{
			if (humanTurn) //Player's Turn
			{
				System.out.println("Player's Turn");
				col = k.nextInt();
				row = k.nextInt();
				if (gb.play(true, row, col))
					humanTurn = false;
			}//end of humanTurn
			
			else //COMP's Turn
			{
				System.out.println("COMP's Turn");
				col = rand.nextInt(3);
				row = rand.nextInt(3);
				System.out.println("(" + col + ", " + row + ")");
				if (gb.play(false, row, col))
					humanTurn = true;
			}//end of COMP's Turn

			gb.checkWin();
			gb.showBoard();
			System.out.println("_________________");
			System.out.println(" ");
			
			if(gb.checkWin() == 'X')
			{
				gb.checkWin();
				gameOver = true;
				System.out.println("Congrats! You won.");
			}//game over: Player is winner
			
			else if (gb.checkWin() == 'O')
			{
				gb.checkWin();
				gameOver = true;
				System.out.println("Too bad! The computer won.");
			}//game over: Computer is winner
			
			else if (gb.checkWin() == 'T')
			{
				gb.checkWin();
				gameOver = true;
				System.out.println("It is a tie.");
			}//game over: No winner, tie
				
			
		}//end while loop
		
		System.out.println("Thanks for playing!");
		System.out.println("Number of valid play counts: " + gb.validPlayCount());

	}// end of main method

}//end of TicTacToeGame class