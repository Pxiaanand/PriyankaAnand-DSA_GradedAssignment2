package skyScraper;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class buildingSkyScraper {

	public buildingSkyScraper() {
		// TODO Auto-generated constructor stub
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Queue<Integer> qu = new LinkedList<>();
		Queue<Integer> sorted_qu = new LinkedList<>();
		
		//Getting Inputs from the User
		int floorsize,n,i,max_floor_size,j;
		System.out.println("Enter the number of floors in the Building :");
		Scanner in = new Scanner(System.in);
		n=in.nextInt();
		System.out.println("Enter the Floor sizes of the Building :");
		int[] arr = new int[n];
		int[] arr_unused_popped = new int[n];
		for(i=0;i<n;i++)
		{
			floorsize=in.nextInt();
			qu.add(floorsize);
			arr[i]=floorsize;
		}
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		//Sorting the Queue and storing it in Another Queue in Descending Order
		for(i=n-1;i>=0;i--)
		{
			sorted_qu.add(arr[i]);
		}
		System.out.println(sorted_qu);
		max_floor_size=sorted_qu.remove();
		boolean ground_floor_flag=false;
		
		for(i=0;i<n;++i)
		{
			
		    if(max_floor_size!=qu.peek()&&(!ground_floor_flag))  // Empty days until Max floor size is found
		    {
		    	arr_unused_popped[i]=qu.remove();
		    	System.out.println("Day: "+(i+1));
		    	System.out.println("");
		    }
		    
		    else
		    {
		    	if(arr_unused_popped==null)                   // Building the Ground floor with the highest floor size
		    	{
		    		System.out.println("Day: "+(i+1));
		    		System.out.print(qu.remove()+" ");
		    		System.out.println("");
		    		ground_floor_flag=true;
		    	}
		    	
		    	else                                         // Traversing the Queue and Building other floors if available
		    	{
		    		System.out.println("Day: "+(i+1));
		    		System.out.print(qu.remove()+" ");
		    		max_floor_size=sorted_qu.remove();
		    		j=0;
		    		while(j<arr_unused_popped.length)
		    		{
		    			if(arr_unused_popped[j]==max_floor_size)
		    			{
		    				System.out.print(max_floor_size+" ");
		    				if(!sorted_qu.isEmpty())
		    				{
		    					max_floor_size=sorted_qu.remove();
			    				j=0;
		    				}
		    				else
		    				{
		    					java.lang.System.exit(0);
		    				}
		    			}
		    			else
		    			{
		    				++j;
		    			}
		    		}
		    		System.out.println("");
		    		
		    	}
		    	
		    	
		    }
		    
		    
		}
		
		

	}

}
