package roundone;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Digits {

	static BufferedReader reader;
	static BufferedWriter writer;
	
	public static void main(String[] args) {
		try{
			String inputFilePath = new File("input//Digits.in").getAbsolutePath();
			String outputFilePath = new File("output//Digits.out").getAbsolutePath();
			reader = new BufferedReader(new FileReader(new File(inputFilePath)));
			writer = new BufferedWriter(new FileWriter(new File(outputFilePath)));
			String line = reader.readLine();
			Integer testCases = Integer.parseInt(line);
			LinkedList<String> stringHolder = new LinkedList<String>();
			stringHolder.add("ZERO");
			stringHolder.add("ONE");
			stringHolder.add("TWO");
			stringHolder.add("THREE");
			stringHolder.add("FOUR");
			stringHolder.add("FIVE");
			stringHolder.add("SIX");
			stringHolder.add("SEVEN");
			stringHolder.add("EIGHT");
			stringHolder.add("NINE");
			
			for(int t = 1; t <= testCases; t++){
				line = reader.readLine();
				String[] digits = line.split("(?<=.)");
				ArrayList<String> iterable = new ArrayList<String>();
				for(String digit:digits){
					iterable.add(digit);
				}
				for(String test:stringHolder){
					String[] testDigits = test.split("(?<=.)");
					ArrayList<String> valueHolder = new ArrayList<String>();
					for(String tmp:testDigits){
						if(iterable.contains(tmp)){
							valueHolder.add(tmp);
							iterable.remove(tmp);
						}else{
							break;
						}
						StringBuilder builder = new StringBuilder();
						for(String s : valueHolder) {
						    builder.append(s);
						}
						if(builder.toString().equalsIgnoreCase(test.toString())){
							System.out.println(builder.toString());
						}
					}
				}
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
