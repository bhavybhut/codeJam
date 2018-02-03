package g2016;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Pancakes {
	public static void main(String[] args) throws IOException {
		String inputFilePath = new File("input//B-large.in").getAbsolutePath();
		String outputFilePath = new File("output//B-large.out").getAbsolutePath();
		BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
		BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));
		
		int testCases = Integer.parseInt(reader.readLine());
		
		for(int i=0;i<testCases;i++)
		{
			String stack = reader.readLine();
			int length = stack.length();
			int flip = 0;
			
			String stack1=stack;
			while(true)
			{	
				if(stack.charAt(length-1) == '-')
				{
					flip++;
					stack = Pancakes.flipPancakes(stack);
				}
				else
				{
					if(stack.lastIndexOf('-')!=-1)
					{
						flip++;						
						stack1 = stack.substring(stack.lastIndexOf('-')+1,stack.length());
						if(stack.lastIndexOf('-')==0)
							stack = Pancakes.flipPancakes(""+stack.charAt(0))+stack1;
						else
							stack = Pancakes.flipPancakes(stack.substring(0, stack.lastIndexOf('-')+1))+stack1;						
					}
					else
						break;
					
				}
			}
			writer.write("Case #"+(i+1)+": "+flip);
			if(i!=testCases-1)
				writer.write("\n");
		}
		
		writer.close();
	}
	
	public static String flipPancakes(String stack)
	{
		String stack1="";
		for(int i=0;i<stack.length();i++)
		{
			if(stack.charAt(i)=='-')
				stack1=stack1+'+';
			else
				stack1=stack1+'-';
				
		}
		return stack1;
	}
}