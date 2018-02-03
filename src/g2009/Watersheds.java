package g2009;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Watersheds {

	public static void main(String[] args) {
		try{
			String inputFilePath = new File("input//B-small-practice.in").getAbsolutePath();
			String outputFilePath = new File("output//B-small-practice.in").getAbsolutePath();
			BufferedReader reader = new BufferedReader(new FileReader(new File(inputFilePath)));
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(outputFilePath)));
			String line = reader.readLine();
			int casenum = Integer.parseInt(line);
			
			for(int i = 0 ; i < casenum ; i ++){	
				if(i == 5){
					System.out.println(casenum);
				}
				line = reader.readLine();
				String tokens[] = line.split("[ \t]+");
				int rownum = Integer.parseInt(tokens[0]);
				int linenum = Integer.parseInt(tokens[1]);
				int[][] matrix = new int[rownum][linenum];
				
				for(int j = 0 ; j < rownum ; j ++){
					line = reader.readLine();
					tokens = line.split("[ \t]+");
					for(int k = 0 ; k < linenum ; k ++){
						System.out.println(tokens[k]);
						matrix[j][k] = Integer.parseInt(tokens[k]);
					}
				}
				System.out.println();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
