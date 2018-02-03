package g2016;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


public class Program3 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new FileReader("input//test.in"));
		PrintWriter out = new PrintWriter("input//test.out");
		
		int testCases = Integer.parseInt(reader.readLine());
		
		for(int i=1;i<=testCases;i++)
		{
			out.write("Case #"+i+": ");
			String str[] = reader.readLine().split(" ");
			
			int J = Integer.parseInt(str[0]);
			int P = Integer.parseInt(str[1]);
			int S = Integer.parseInt(str[2]);
			int K = Integer.parseInt(str[3]);
			
			ArrayList<String> combinations = new ArrayList<String>();
			int k1=0;
			
			for(int j=1;j<=J;j++)
				for(int p=1;p<=P;p++)
					for(int s=1;s<=S;s++)
						combinations.add(""+j+" "+p+" "+s);
						
			Collections.sort(combinations);
			String prevStr = combinations.get(0).substring(0,2);
			Iterator<String> it = combinations.iterator();
			ArrayList<String> finalcomb = new ArrayList<String>();
			while(it.hasNext())
			{
				String element = it.next();
				String str1 = element.substring(0,3);
				if(str1.equals(prevStr))
				{
					k1++;
					//System.out.println("check1::"+str1+":"+prevStr+":"+k1);					
				}
				else
				{
					k1=0;
					prevStr = str1;
					k1++;
					//System.out.println("check2::"+str1+":"+prevStr+":"+k1);
				}	
				if(k1<=K)
				{
					finalcomb.add(element);
				}
				
			}
			it = finalcomb.iterator();
			out.write(""+finalcomb.size());
			while(it.hasNext())
			{
				out.write("\n");
				out.write(it.next());
			}
			System.out.println(finalcomb);
			
			if(i!=testCases)
				out.write("\n");
		}
		out.close();
	}

}
