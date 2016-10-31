package chapter2.problem2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static ArrayList<String> solutions = new ArrayList<String>();
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String chain = in.next();
		
		if(!isNotRepeat(chain)){
			throw new IllegalArgumentException("this word has repeated characters");
		}
		
		recursive("", chain);
		
		viewResults();
	}
	
	public static boolean isNotRepeat(String chain){
		for(int i = 0; i < chain.length(); i++)
			for(int j = 0; j < i; j++)
				if(chain.charAt(i) == chain.charAt(j)){ return false;}
		
		return true;
	}
	
	public static void recursive(String init, String rest){
		if(rest.length() == 0){
			
			solutions.add(init);
		
		} else {
			
			for(int i = 0; i < rest.length(); i++){
				recursive(init + rest.charAt(i), rest.substring(0, i) + rest.substring(i+1, rest.length()));
			}
		}
	}
	
	public static void viewResults() {
		char tmp = solutions.get(0).charAt(0);
		
		for(int i = 0; i < solutions.size(); i ++) {
	
			if(tmp != solutions.get(i).charAt(0)) {
				tmp = solutions.get(i).charAt(0);
				System.out.println();
			}
			
			System.out.print(solutions.get(i) + " ");
		}
	}

}
