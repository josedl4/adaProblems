package chapter2.problem13;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem13 {
	public static int marbles, tin, capacity;
	public static ArrayList<ArrayList<Integer>> solutions = new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		marbles = in.nextInt();
		tin = in.nextInt();
		capacity = in.nextInt();

		recursive(marbles, tin, null);
		
		System.out.println(solutions);
	}
	
	public static void recursive (int m, int t, ArrayList<Integer> solve){
		ArrayList<Integer> mySolve;
		
		if(solve == null)
			mySolve = new ArrayList<Integer>();
		else {
			mySolve = (ArrayList<Integer>) solve.clone();
		}
		
		for(int i = 0; i < capacity + 1; i++){
			int xm = m - (i);
			ArrayList<Integer> xSolve = (ArrayList<Integer>) mySolve.clone();
			xSolve.add(i);
			int xt = t - 1;
			System.out.println(xm + " " + xt + " " + i);
			System.out.println(xSolve);
			if(xt == 0){
				if(verifySolve(xSolve)){
					solutions.add(xSolve);
				}
			} else {
				recursive(xm, xt, xSolve);
			}
		}
	}
	
	public static boolean verifySolve(ArrayList<Integer> s) {
		int tmp = 0;
		if(s.size() != tin)
			return false;
		
		for(int i = 0; i < s.size(); i++){
			if(s.get(i) > capacity)
				return false;
			tmp += s.get(i);
		}
		
		if(tmp != marbles)
			return false;
		else
			return true;
		
	}

}
