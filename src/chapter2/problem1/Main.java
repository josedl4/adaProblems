package chapter2.problem1;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Main {

	private static ArrayList<ArrayList<Integer>> allResults = new ArrayList<ArrayList<Integer>>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		File fInput = new File("input.txt");
		FileReader fr = new FileReader(fInput);
	    BufferedReader br = new BufferedReader(fr);
		
		int repetition = Integer.parseInt(br.readLine());
		
		for(int x = 0; x < repetition; x++){
			String [] array = br.readLine().split(" ");
			int[] input = new int[array.length];
			
			for(int i = 0; i < array.length; i++){
				input[i] = Integer.parseInt(array[i]);
			}
			
			int sum = Integer.parseInt(br.readLine());
			
			ArrayList<Integer> arrayListInput = new ArrayList<Integer>();
			
			for(int i = 0; i < input.length; i++)
				arrayListInput.add(input[i]);
			
			ArrayList<Integer> result = new ArrayList<Integer>();
			
			backtracking(arrayListInput, sum, 0, result);
			
			if(allResults.size() != 0)
				System.out.println("Test " + x +": Have combination that "
						+ "satisfy the conditions. " + allResults.get(0));
			else
				System.out.println("Test " + x +": Not have a valid combination.");
			
			allResults = new ArrayList<ArrayList<Integer>>();
		}

	}
	
	public static void backtracking(ArrayList<Integer> array, 
			int sum, int n, ArrayList<Integer> result){
		
		if(n == sum) {
			ArrayList<Integer> cloneResult = (ArrayList<Integer>) result.clone();
			allResults.add(cloneResult);
			result = new ArrayList<Integer>();
		
		} else{
			if(n < sum){
			
				for(int i = 0; i < array.size(); i++){
					
					if((aceptable(array.get(i), sum, n))){
						result.add(array.get(i));
						ArrayList<Integer> newArray = (ArrayList<Integer>) array.clone();
						
						for(int j = 0; j <= i; j++)
							newArray.remove(0);
						
						backtracking(newArray, sum, n + array.get(i), result);
						result.remove(array.get(i));
					}	
				}
				result = new ArrayList<Integer>();
				n = 0;
			}
		}	
	}
	
	public static boolean aceptable(int arrayValue, int sum, int n){
		if((arrayValue + n) == sum){ return true;}
		else { if((arrayValue + n) < sum) { return true; }}
		return false;
	}

}
