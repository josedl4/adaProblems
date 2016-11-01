package chapter2.problem3;

import java.util.ArrayList;

public class Main {

	private static int[][] board = new int[9][9];
	private static ArrayList<int[][]> solutions = new ArrayList<int[][]>();
	private static ArrayList<Integer> steps = fillValues();

	
	public static void main(String[] args) {
		board[0][0] = 5;
		board[0][1] = 3;
		board[0][4] = 7;
		//
		board[1][0] = 6;
		board[1][3] = 1;
		board[1][4] = 9;
		board[1][5] = 5;
		//
		board[2][1] = 9;
		board[2][2] = 8;
		board[2][7] = 6;
		//
		board[3][0] = 8;
		board[3][4] = 6;
		board[3][8] = 3;
		//
		board[4][0] = 4;
		board[4][3] = 8;
		board[4][5] = 3;
		board[4][8] = 1;
		//
		board[5][0] = 7;
		board[5][4] = 2;
		board[5][8] = 6;
		//
		board[6][1] = 6;
		board[6][6] = 2;
		board[6][7] = 8;
		//
		board[7][3] = 4;
		board[7][4] = 1;
		board[7][5] = 9;
		board[7][8] = 5;
		//
		board[8][4] = 8;
		board[8][7] = 7;
		board[8][8] = 9;
		
		viewBoard(board);
		
		backtrackingMethod(board);
		
		System.out.println("\n Solutions:");
		for(int[][] tmp : solutions){
			viewBoard(tmp);
		}
	}
	
	public static void viewBoard(int[][] myboard){
		for(int i = 0; i < myboard.length; i++){
			for(int j = 0; j < myboard.length; j++){
				if((j == 3)||(j == 6))
					System.out.print(" | ");
				
				System.out.print(myboard[i][j] + " ");
			}
			System.out.println();
			if((i == 2)||(i == 5))
				System.out.println("-----------------------");
		}
	}
	
	public static void backtrackingMethod(int[][] myboard){
		int a = -1;
		int b = -1;
		int maxValue = 10;
		
		for(int i = 0; i < myboard.length; i++){
			for(int j = 0; j < myboard.length; j++){
				
				if(myboard[i][j]==0){
					ArrayList<Integer> possibilities = possibleSteps(i, j, myboard);
					if(possibilities.size() < maxValue){
						a = i;
						b = j;
						maxValue = possibilities.size();
					}
					
				}
				
			}
		}
		if((a != -1) && (b != -1)){
			ArrayList<Integer> possibilities = possibleSteps(a, b, myboard);
			if(possibilities.size()!=0){
				for(int x = 0; x < possibilities.size(); x++) {
					int tmp[][] = myClone(myboard);
					tmp[a][b] = possibilities.get(x);
					backtrackingMethod(tmp);
				}
			}
		}

		if(checkSolution(myboard)){
			solutions.add(myboard);
		}
	
	}
	
	public static boolean checkSolution(int[][] solution){
		for(int i = 0; i < solution.length; i++)
			for(int j = 0; j < solution.length; j++)
				if(solution[i][j] == 0){ return false;}
		
		return true;
	}
	
	public static ArrayList<Integer> possibleSteps(int x, int y, int[][] myboard){
		@SuppressWarnings("unchecked")
		ArrayList<Integer> result = (ArrayList<Integer>)steps.clone();
		
		for(int i = 0; i < myboard.length; i ++){
			if((myboard[i][y]!=0) && result.contains(myboard[i][y]))
				result.remove((Integer)myboard[i][y]);
		}
		
		for(int j = 0; j < myboard.length; j ++){
			if((myboard[x][j]!=0) && result.contains(myboard[x][j]))
				result.remove((Integer)myboard[x][j]);
		}
		
		for(int i = ((x/3) * 3); i < ((x/3) * 3) + 3; i ++){
			for(int j = ((y/3) * 3); j < ((y/3) * 3) + 3; j ++){
				if((myboard[i][j]!=0) && result.contains(myboard[i][j]))
					result.remove((Integer)myboard[i][j]);
			}
		}
		
		return result;
	}
	
	public static ArrayList<Integer> fillValues(){
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		result.add(1);
		result.add(2);
		result.add(3);
		result.add(4);
		result.add(5);
		result.add(6);
		result.add(7);
		result.add(8);
		result.add(9);
		
		return result;
	}
	
	public static int[][] myClone(int[][] element){
		int[][] result = new int[element.length][element[0].length];
		for(int i = 0; i < element.length; i++) {
			for(int j = 0; j < element[0].length; j++) {
				result[i][j] = element[i][j];
			}
		}
		return result;
	}

}

