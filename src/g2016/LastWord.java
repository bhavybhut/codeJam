package g2016;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LastWord {

	static BufferedReader reader;
	static BufferedWriter writer;
	
	public static void main(String[] args) {
		try{
			String inputFilePath = new File("input//test.in").getAbsolutePath();
			String outputFilePath = new File("output//test.out").getAbsolutePath();
			reader = new BufferedReader(new FileReader(new File(inputFilePath)));
			writer = new BufferedWriter(new FileWriter(new File(outputFilePath)));
			String line = reader.readLine();
			Integer testCases = Integer.parseInt(line);
			
			
			for(int i = 0; i<testCases;i++){
				ArrayList<String> holder = new ArrayList<String>();
				ArrayList<String> holder1 = new ArrayList<String>();
				line = reader.readLine();
				
				writer.write("Case #" + (i+1) +":");
				
				for(int j=0;j<line.length();j++)
				{
					if(j==0)
						holder.add(""+line.charAt(0));
					else
					{
						for(String str : holder){
							holder1.add(line.charAt(j)+str);
							holder1.add(str+line.charAt(j));
						}
						holder.clear();
						holder.addAll(holder1);
						holder1.clear();					
					}				
					if(j==line.length()-1)
					{
						Collections.sort(holder);
						System.out.println(holder);
						writer.write(holder.get(holder.size()-1));
						writer.newLine();
					}
				}
				
			}
			reader.close();
			writer.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
