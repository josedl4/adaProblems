package chapter2.problem12;


public class Main {

	private static int M = 3;
	private static int N = 3;
	private static boolean hasResult = false;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[][] src = new double[M][N];
		double[][] result = new double[M][N];
		
		src[0][0] = 1.2;
		src[0][1] = 3.4;
		src[0][2] = 2.4;
		
		src[1][0] = 3.9;
		src[1][1] = 4.0;
		src[1][2] = 2.1;
		
		src[2][0] = 7.9;
		src[2][1] = 1.6;
		src[2][2] = 0.5;
		
		viewMatrix(src);
		
		backtracking(src, result, 0, 0);
		
		if(!hasResult)
			System.out.println("Not have any solutions");
	}
	
	public static void backtracking(double[][] src, double[][] result, int row, int column){
		if(row < M){
			
			if(column < N){
				
				result[row][column] = Math.floor(src[row][column]);
				backtracking(src, result.clone(), row, column + 1);
				
				result[row][column] = Math.ceil(src[row][column]);
				backtracking(src, result.clone(), row, column + 1);
			
			} else {
			
				double srcSum = 0;
				double resultSum = 0;
				
				for(int i = 0; i < N; i++) {
					
					srcSum += src[row][i];
					resultSum += result[row][i];
					
				}
				
				if(srcSum == resultSum)
					backtracking(src, result.clone(), row + 1, 0);
				
			}
			
		} else {
			
			boolean flag = true;
			for(int j = 0; j < N; j++){
				double srcSum = 0;
				double resultSum = 0;
				
				for(int i = 0; i < M; i++){
					
					srcSum += src[i][j];
					resultSum += result[i][j];
					
				}
				
				if(srcSum != resultSum)
					flag = false;
			}
			
			if(flag){
				viewMatrix(result);
				hasResult = true;
			}
			
		}
	}
	
	public static void viewMatrix(double[][] matrix){
		System.out.println();
		for(int i = 0; i < matrix.length; i++){
			System.out.print("| ");
			for(int j = 0; j < matrix[0].length; j++){
				System.out.printf("%.1f ", matrix[i][j]);
			}
			System.out.println(" |");
		}
		
		System.out.println();
	}

}
