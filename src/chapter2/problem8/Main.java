package chapter2.problem8;

import java.util.ArrayList;

public class Main {

	private static final int N = 5;
	private static final ArrayList<ArrayList<Integer>> tableOfCosts 
		= new ArrayList<ArrayList<Integer>>();
	
	public static void main(String[] args) {
		int[][] canoesCost = new int [N][N];
		
		canoesCost[0][1] = 2;
		canoesCost[0][2] = 4;
		canoesCost[0][3] = 8;
		canoesCost[0][4] = 16;
		//
		canoesCost[1][2] = 2;
		canoesCost[1][3] = 4;
		canoesCost[1][4] = 8;
		//
		canoesCost[2][3] = 2;
		canoesCost[2][4] = 4;
		
		for(int i = 0; i < N - 1; i++){
			costs(i);
		}

	}
	
	public static void costs(int village){
		int[] auxTable = new int[N - 1 - village];
		for(int i = 0; i < auxTable.length; i++){
			
		}
	}

}
