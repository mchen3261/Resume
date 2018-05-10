//Author:      Makayla Chen
//Assignment:  Programming Assignment 5
//Due:         11/16/17
//Description: Create a program that executes a game 
//             of Tic-Tac-Toe (Human vs. Computer).
//Test Cases:  One winning game, one losing game

package tictactoe;

public class GameBoard 
{
	private char [][] board = new char[3][3]; //TicTacToe board
	private int plays; //The number of valid plays
	
	public GameBoard() 
	{
		plays = 0;
		for (int row = 0; row < board.length; row++) 
		{
			for (int col = 0; col < board[row].length; col++)
				board[row][col] = ' ';
		}
		
	}//end of GameBoard
	
	public boolean play (boolean x, int row, int col)
	{
		if ((row >= 0 && row < 3 ) && ( col >= 0 && col < 3 ) && board[row][col] == ' ') //checks if valid
		{
			if(x == true)
				board[row][col] = 'x';
			else
			{
				board[row][col] = 'o';
				checkWin();
				
			}// end of inner if-else
			
			plays++;
			checkWin();
			return true;
		}
		else
		{
			System.out.println(" ");
			System.out.println("Invalid move. Please enter different coordinates.");
			System.out.println(" ");
			return false;
		}//end of outer if-else
	}//end of play
	
	public int validPlayCount()
	{
		return plays;
		
	}//end of validPlayCount
	

	public char checkWin()
	{
		for (int i = 0; i < 3; i++)
		{
			if (board[i][0] == 'x' && board[i][1] == 'x' && board[i][2] == 'x')
				return 'X';
			if (board[0][i] == 'x' && board[1][i] == 'x' && board[2][i] == 'x')
				return 'X';
			if (board[i][0] == 'o' && board[i][1] == 'o' && board[i][2] == 'o')
				return 'O';
			if (board[0][i] == 'o' && board[1][i] == 'o' && board[2][i] == 'o')
				return 'O';
			
		}//end of for loop
		
		if (board[0][0] == 'x' && board[1][1] == 'x' && board[2][2] == 'x')
			return 'X';
		if (board[0][2] == 'x' && board[1][1] == 'x' && board[2][0] == 'x')
			return 'X';
		if (board[0][0] == 'o' && board[1][1] == 'o' && board[2][2] == 'o')
			return 'O';
		if (board[0][2] == 'o' && board[1][1] == 'o' && board[2][0] == 'o')
			return 'O';
		
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if(board[i][j] == ' ')
					return ' ';
			}//end of inner for loop
			
		}//end of outer for loop
		
		return 'T';
		
	}//end of checkWin
	
	public void showBoard()
	{
		    System.out.println("  0  " + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
		    System.out.println("    --+-+--");
		    System.out.println("  1  " + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
		    System.out.println("    --+-+--");
		    System.out.println("  2  " + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
		    System.out.println("     0 1 2 ");
		    
	}// end of showBoard

}//end of GameBoard class
