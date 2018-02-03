package g2009;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class AlienLanguage {
	
	public static int test(String[] words, boolean[][] pattern){
		int num = 0;
		for(int i = 0 ; i < words.length ; i ++){
			String word = words[i];
			boolean match = true;
			for(int j = 0 ; j < word.length() ; j ++){
				char ch = word.charAt(j);
				int index = (int)(ch - 'a');
				if(!pattern[j][index]){
					match = false;
					break;
				}
			}
			if(match)
				num ++;
		}
		return num;
	}
	
	
	public static void main(String args[]){
		try{
			String inputFilePath = new File("input//A-large-practice.in").getAbsolutePath();
			String outputFilePath = new File("output//A-large-practice.in").getAbsolutePath();
			BufferedReader reader = new BufferedReader(new FileReader(new File(inputFilePath)));
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(outputFilePath)));
			String line = reader.readLine();
			String nums[] = line.split("[ \t]+");
			int L = Integer.parseInt(nums[0]);
			int lines = Integer.parseInt(nums[1]);
			int testCases = Integer.parseInt(nums[2]);
			String[] words = new String[lines];
			
			for(int i = 0 ; i < lines ; i ++){
				line = reader.readLine();
				words[i] = line;
			}
			
			for(int i = 0 ; i < testCases ; i ++){
				boolean[][] pattern = new boolean[L][26];
				for(int j = 0 ; j < L ; j ++){
					for(int k = 0 ; k < 26 ; k ++){
						pattern[j][k] = false;
					}
				}			
				line = reader.readLine();
				int num = 0;
				boolean start = false;
				for(int j = 0 ; j < line.length() ; j ++){
					char ch = line.charAt(j);
					if(ch == '('){
						start = true;
					}else if(ch == ')'){
						start = false;
					}else{
						int index = (int)(ch - 'a');
						pattern[num][index] = true;
					}
					if(!start)
						num ++;					
				}
				int result = test(words , pattern);
				writer.write("Case #" + (i + 1) + ": " + result + "\r\n");
			}
			reader.close();
			writer.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}

}
