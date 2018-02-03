package g2016;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class CoinJam {

	static long coincounter = 0;
	static long bin=0;
	static long nonPrime = 1;
	static long number;
	static long list[] = new long[9];
	static BufferedReader reader;
	static BufferedWriter writer;
	static HashMap<Long, Integer> primeHolder = new HashMap<Long,Integer>();
	
	public static void main(String[] args) {
		try{
			String inputFilePath = new File("input//C-large.in").getAbsolutePath();
			String outputFilePath = new File("output//C-large.out").getAbsolutePath();
			reader = new BufferedReader(new FileReader(new File(inputFilePath)));
			writer = new BufferedWriter(new FileWriter(new File(outputFilePath)));
			String line = reader.readLine();
			Integer testCases = Integer.parseInt(line);
			long N,J;
			
			for(long t = 1; t <= testCases; t++){
				line = reader.readLine();
				String nums[] = line.split("[ \t]+");
				N = Integer.parseInt(nums[0]);
				J = Integer.parseInt(nums[1]);
				
				writer.write("Case #" + t+":");
				writer.newLine();
				
				for(long i=0; coincounter<J; i++)
                {
                    dictobin(i);
                    number = (long) (Math.pow(10,N-1) + bin*10 +1);
                    bin = 0;
                    jamcoincker(number);
                }
			}
			reader.close();
			writer.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void dictobin(long n)
    {
        if(n/2!=0) dictobin(n/2);
        bin = bin*10 + n%2;
    }
    
    public static long primecker(long num , int bs){
    	if(primeHolder.containsKey(num)){
    		if(primeHolder.get(num)!=-1){
    			list[bs-2] = primeHolder.get(num);
    			return 1;
    		}else{
    			return 0;
    		}
    	}
    	
        if ( num > 2 && num%2 == 0 ) {
            System.out.println(num + " is not prime");
            list[bs-2] = 2;
            primeHolder.put(num, 2);
            return 1;
        }
        long top = (long)Math.sqrt(num) + 1;
        for(int i = 3; i < top; i+=2){
            if(num % i == 0){
            	list[bs-2] = i;
            	primeHolder.put(num, i);
                System.out.println(num + " is not prime");
                return 1;
            }
        }
        System.out.println(num + " is prime");
        primeHolder.put(num, -1);
        return 0; 
    }
    
    public static void conveter(int i, long nm)
    {
         long  dec = 0, rem, num, base = 1;
         num = nm;
        while (num > 0)
        {
            rem = num % 10;
            dec = dec + rem * base;
            base = base * i;
            num = num / 10;
        }
     nonPrime =primecker(dec,i);
    }

    public static void jamcoincker(long nm) throws IOException
    {
        for(int i=2; i<11;i++)
        {
            conveter( i, nm );
            if(nonPrime == 0) break;
        }
       if(nonPrime == 1)
       {
           coincounter++;
           System.out.println("nm="+nm);
           writer.write(""+nm);
           for(int j = 0; j<9;j++)
           {
        	   System.out.println(list[j]);
        	   writer.write("\t"+list[j]);
           }
           writer.newLine();
           writer.flush();
       }
         nonPrime = 1;
    }
}
