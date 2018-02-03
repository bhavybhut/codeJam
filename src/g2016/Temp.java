package g2016;

import java.util.Arrays;
import java.util.Comparator;

public class Temp {

	public static void main(String[] args) {
	    int[][] iiArray = new int[3][2];
	     
	    iiArray[0][0] = 1; iiArray[0][1] = 2;
	    iiArray[1][0] = 9; iiArray[1][1] = 6;
	    iiArray[2][0] = 4; iiArray[2][1] = 7;
	     
	    Arrays.sort(iiArray, new Comparator<int[]>()
	    		{
	    		     public int compare(int[] o1, int[] o2)
	    		     {
	    		               return(Integer.valueOf(o1[0]).compareTo(o2[0]));
	    		     }
	    		 
	    		     public boolean equals(Object obj)
	    		     {
	    		          return(true);
	    		     }
	    		});
	    
	    System.out.println("The Sorted Array:");
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<2;j++)
            {
                System.out.print(iiArray[i][j]+"\t");
            }
            System.out.println();
        }
	}
}
