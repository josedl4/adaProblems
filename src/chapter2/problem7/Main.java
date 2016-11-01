package chapter2.problem7;

import java.util.ArrayList;

public class Main {

	private static final int M = 5;
	private static final int N = 3;
	private static ArrayList<ArrayList<Integer>> solutions = new ArrayList<ArrayList<Integer>>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] knights = new int[M][M];
		knights[0][1] = 1;
		knights[0][3] = 1;
		//
		knights[1][0] = 1;
		knights[1][2] = 1;
		knights[1][3] = 1;
		knights[1][4] = 1;
		//
		knights[2][1] = 1;
		knights[2][3] = 1;
		knights[2][4] = 1;
		//
		knights[3][0] = 1;
		knights[3][1] = 1;
		knights[3][2] = 1;
		//
		knights[4][1] = 1;
		knights[4][2] = 1;
		
		ArrayList<Integer> list =new ArrayList<Integer>();
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		backtracking(new ArrayList<Integer>(), list, knights);
		System.out.println("Solutions: " + solutions);
	}
	
	public static void backtracking(ArrayList<Integer> init, ArrayList<Integer> end, int[][] matrix){
		if(init.size() == N){
			solutions.add(init);
		} else {
			if((init.size() + end.size()) >= N){
				for(int element : end){
					boolean tmp = true;
					
					for(int i : init){
						if(matrix[element][i] == 0)
							tmp = false;
					}
					
					if(tmp){
						ArrayList<Integer> nInit = (ArrayList<Integer>)init.clone();
						ArrayList<Integer> nEnd = (ArrayList<Integer>)end.clone();
						nInit.add(element);
						for(int i = 0; i <= element; i++){
							nEnd.remove((Integer)i);
						}

						backtracking(nInit, nEnd, matrix);
					}
				}
			}
		}
	}

}
