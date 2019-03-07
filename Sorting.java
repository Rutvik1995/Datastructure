
import java.util.Random;
import java.util.Scanner;
import java.util.Collections;
import java.util.Arrays;
import java.util.ArrayList;

public class Sorting {
	final int MAX_SIZE = 10000000;

	// Set this to true if you wish the arrays to be printed.
	final static boolean OUTPUT_DATA = false;
	
	public static String sortAlg= null;
	public static  int size = 0;
	public static  int recursionDepth=0;
		   
	public static int rec_depth=0;
	
	
	public static void main(String[] args) 
	{
		
		readInput();
		int [] data = new int[size];
		GenerateSortedData(data, size);
		Sort(data, size,"Sorted Data");

		GenerateNearlySortedData(data, size);
		Sort(data, size,"Nearly Sorted Data");
		
		GenerateReverselySortedData(data, size);
		Sort(data, size,"Reversely Sorted Data");
		
		GenerateRandomData(data, size);
		Sort(data, size,"Random Data");
			
		System.out.println("\nProgram Completed Successfully.");
		
	}
	
	@SuppressWarnings("resource")
	public static void readInput()
	{
		System.out.println("  I:\tInsertion Sort");
		System.out.println("  M:\tMergeSort");
		System.out.println("  Q:\tQuickSort    Last Pivot");
		System.out.println("  Q2:\tQuickSort   Random Pivot");
		System.out.println("  Q3:\tQuickSort   Median Method Pivot");
		System.out.println("  Q4:\tQuickSort   <=40 Call Insertion Sort");
		System.out.println("  Q5:\tQuickSort   Extra Work");
		System.out.println("  S:\tSTLSort");
	    System.out.println("Enter sorting algorithm:");
	    Scanner reader = new Scanner(System.in);
	    sortAlg = reader.next();
	    System.out.println(sortAlg);
		String sortAlgName = "";
		
		if(sortAlg.equals("I"))
			sortAlgName = "Insertion Sort";
		else if(sortAlg.equals("M"))
			sortAlgName = "MergeSort";
		else if(sortAlg.equals("Q"))
			sortAlgName = "QuickSort";
		
		else if(sortAlg.equals("Q2"))
			sortAlgName = "QuickSort";
		else if(sortAlg.equals("Q3"))
			sortAlgName = "QuickSort";
		else if(sortAlg.equals("Q4"))
			sortAlgName = "QuickSort";
		else if(sortAlg.equals("Q5"))
			sortAlgName = "QuickSort";
		else if(sortAlg.equals("S"))
			sortAlgName = "STLSort";
		else {
			System.out.println("Unrecognized sorting algorithm Code:"+sortAlg);
			System.exit(1);
		}
		System.out.println("Enter input size: ");
	    size = reader.nextInt();
		System.out.println("\nSorting Algorithm: " + sortAlgName);
        System.out.println("\nInput Size = "  + size);
	}
	
	/******************************************************************************/

	public static void GenerateSortedData(int data[], int size)
	{
		int i;
		
		for(i=0; i<size; i++)
			data[i] = i * 3 + 5;
	}
	/*****************************************************************************/
	public static void GenerateNearlySortedData(int data[], int size)
	{
		int i;
		
		GenerateSortedData(data, size);
		
		for(i=0; i<size; i++)
			if(i % 10 == 0)
				if(i+1 < size)
					data[i] = data[i+1] + 7;
	}
	/*****************************************************************************/

	public static void GenerateReverselySortedData(int data[], int size)
	{
		int i;
		
		for(i = 0; i < size; i++)
			data[i] = (size-i) * 2 + 3;
	}
	/*****************************************************************************/

	public static void GenerateRandomData(int data[], int size)
	{
		int i;
		for(i = 0; i < size; i++)
			data[i] = new Random().nextInt(10000000);
	}
	/*****************************************************************************/

	
	public static void Sort(int[] data, int size,  String string)
	{

		System.out.print("\n"+string+":");
		if (OUTPUT_DATA)
		{
			printData(data, size, "Data before sorting:");
		}

		// Sorting is about to begin ... start the timer!
		long start_time = System.nanoTime();
			if (sortAlg.equals("I"))
			{
			InsertionSort(data, size);
			}
			else if (sortAlg.equals("M"))
			{
			MergeSort(data, 0, size-1);
			}
			else if (sortAlg.equals("Q"))
			{
				QuickSort(data, 0, size-1);
			System.out.println("Recursion depth: "+rec_depth);
			}
			else if (sortAlg.equals("Q2"))
			{
				QuickSort2(data, 0, size-1);
			System.out.println("Recursion depth: "+rec_depth);
			}
			else if (sortAlg.equals("Q3"))
			{
				QuickSort3(data, 0, size-1);
			System.out.println("Recursion depth: "+rec_depth);
			}
			
			else if (sortAlg.equals("Q4"))
			{
				QuickSort4(data, 0, size-1);
			System.out.println("Recursion depth: "+rec_depth);
			}
			
			else if (sortAlg.equals("Q5"))
			{
				QuickSort5(data, 0, size-1);
			System.out.println("Recursion depth: "+rec_depth);
			}
			else if (sortAlg.equals("S"))
			{
			STLSort(data, size);
			}
		else
		{
			System.out.print("Invalid sorting algorithm!");
			System.out.print("\n");
			System.exit(1);
		}

		// Sorting has finished ... stop the timer!
		
		double elapsed = System.nanoTime()-start_time;
		elapsed=elapsed/1000000;


		if (OUTPUT_DATA)
		{
			printData(data, size, "Data after sorting:");
		}


		if (IsSorted(data, size))
		{
			System.out.print("\nCorrectly sorted ");
			System.out.print(size);
			System.out.print(" elements in ");
			System.out.print(elapsed);
			System.out.print("ms");
		}
		else
		{
			System.out.print("ERROR!: INCORRECT SORTING!");
			System.out.print("\n");
		}
		System.out.print("\n-------------------------------------------------------------\n");
	}
	
	/*****************************************************************************/

	public static boolean IsSorted(int data[], int size)
	{
		int i;
		
		for(i=0; i<(size-1); i++)
		{
			if(data[i] > data[i+1])
				return false;
		}
		return true;
	}
	
	/*****************************************************************************/

	
	//Basic Insertion Sort 
	
	public static void InsertionSort(int data[], int size)
	{
		
		for(int i=1;i<size;i++)
		{
			int value=data[i];
			int id=i;
			while(id>0 && data[id-1]>value)
			{
				data[id]=data[id-1];
				id=id-1;
			}
			data[id]=value;
		}
	}
	
	
	// Insertion Sort Function is being called from QuickSort sorting when array size is less than 40 
	public static void InsertionSort2(int data[],int lo, int hi )
	{
		
		for(int i=lo+1;i<=hi;i++)
		{
			int value=data[i];
			int id=i;
			while(id>0 && data[id-1]>value)
			{
				data[id]=data[id-1];
				id=id-1;
			}
			data[id]=value;
		}
	}
	
	
	
	/*****************************************************************************/

	
	
	//Basic Merge Sort 
	public static void MergeSort(int data[], int lo, int hi)
	{
		
		
		
		if(lo>=hi)
		{
			return;
		};
		
		int m = (lo+hi)/2;
		MergeSort(data,lo,m);
		MergeSort(data,m+1,hi);
		merge(data,lo,m,hi);
		
	}
	
	private static void merge(int[] data, int lo, int m, int hi) 
	{
		int n1 = (m-lo)+1;
		int n2 = hi-m;
		int i,j,k;
		
		
		int[] L = new int[n1+1];
		int[] R = new int[n2+1];
		
	
		for(i =0;i<n1;i++)
		{
			L[i]=data[lo+i];
			
		}
		for(j=0;j<n2;j++)
		{
			R[j]=data[m+1+j];
		}
		
		int x = (Math.max(L[n1-1],R[n2-1])+1);
		L[n1]=x;
		R[n2]=x;
		i=0;
		j=0;
		
		for(k=lo;k<=hi;k++)
		{

	    		if(L[i] < R[j])
	    		{
	    				
	    			 	data[k] = L[i]; 
	 	            i++; 
	    		}
	    		else
	    		{
	    				
	    				data[k] = R[j]; 
	 	            j++; 
	    		}
    		
		}
		
		
	}

	/**
	 * @return 
	 * @return ***************************************************************************/

	
	//Extra Work
	public static int QuickSort5(int data[], int lo, int hi)
	{
		int rt,lt;
		//int size = data.length;
		int size =hi-lo;
		
		if(size<=40)
		{
			InsertionSort2(data,lo,hi);
			return 0;
		}
		
			if(lo>=hi)
			{
				return 0;
			}
			
			
			int pi = partition2(data,lo,hi);	 //Selecting Middle element as pivot which gives execution faster.
			
			lt=QuickSort5(data, lo, pi-1); 
			rt=QuickSort5(data, pi+1, hi); 
			rec_depth = Math.max(lt,rt);
			return rec_depth+1;
		
	}
	
	
	
	
	// <=40 Call Insertion Sort
	public static int QuickSort4(int data[], int lo, int hi)
	{
		int rt,lt;
		//int size = data.length;
		int size =hi-lo;
		
		if(size<=40)
		{
			InsertionSort2(data,lo,hi);
			return 0;
		}
		
			if(lo>=hi)
			{
				return 0;
			}
			
			int pi = partition(data,lo,hi); 					//Random Pivot
			
			lt=QuickSort4(data, lo, pi-1); 
			rt=QuickSort4(data, pi+1, hi); 
			rec_depth = Math.max(lt,rt);
			return rec_depth+1;
		
	}
	
	
	
	//Quick sort with last pivot
	public static int QuickSort(int data[], int lo, int hi)
	{
		
		int rt,lt;
		
		
		
		if(lo>=hi)
		{
			return 0;
		}
		
		
		int pi=partition_lastPivot(data,lo,hi);			//Selecting last element as pivot
	
		lt=QuickSort(data, lo, pi-1); 
		rt=QuickSort(data, pi+1, hi); 
		 rec_depth = Math.max(lt,rt);
		 return rec_depth+1;
		 
	}
	
	//Quick sort with random pivot
	public static int QuickSort2(int data[], int lo, int hi)
	{
		
		int rt,lt;
		
		
		
		if(lo>=hi)
		{
			return 0;
		}
		
		int pi = partition(data,lo,hi); 							//Random Pivot
	    
		lt=QuickSort2(data, lo, pi-1); 
		rt=QuickSort2(data, pi+1, hi); 
		 rec_depth = Math.max(lt,rt);
		 return rec_depth+1;
		 
	}
	
	
	
	//Quick Sort with median of three number
	public static int QuickSort3(int data[], int lo, int hi)
	{
		
		int rt,lt;
		
		
		
		if(lo>=hi)
		{
			return 0;
		}
		
		
		int pi=Median_Of_three_value(data,lo,hi);     		//Selecting the median of the the randomly generated value in the array
		lt=QuickSort3(data, lo, pi-1); 
		rt=QuickSort3(data, pi+1, hi); 
		 rec_depth = Math.max(lt,rt);
		 return rec_depth+1;
		 
	}
	
	private static int partition(int[] data, int lo, int hi) 
	{
		
		
		//Randomize pivot
		//////////////////////////////

			int range = (hi-lo)+1;

			int min=lo;
			int max=hi;
			Random rn = new Random();


	    int n = rn.nextInt(range) + lo;
		
		
		 int value1=data[n];
	     data[n]=data[hi];
	    data[hi]=value1;
	    
		
		int pivot = data[hi];
		int i= lo-1;
		
		for(int j=lo;j<hi;j++)
		{
			if(data[j]<=pivot)
			{
				swap(i+1,j,data);
//				int swap = data[j];
//				data[j]=data[i+1];
//				data[i+1]=swap;
				
				i++;
			}
		}
		
		swap(i+1,hi,data);
//		int temp = data[i+1];
//		data[i+1]=data[hi];
//		data[hi]=temp;
//		
		
		// TODO Auto-generated method stub
		return i+1;
	}
	private static int partition_lastPivot(int[] data, int lo, int hi) 
	{
		
		
		//Last element as pivot
		
		int pivot = data[hi];
		int i= lo-1;
		
		for(int j=lo;j<hi;j++)
		{
			if(data[j]<=pivot)
			{
				swap(i+1,j,data);
//				int swap = data[j];
//				data[j]=data[i+1];
//				data[i+1]=swap;
				
				i++;
			}
		}
		
		swap(i+1,hi,data);
//		int temp = data[i+1];
//		data[i+1]=data[hi];
//		data[hi]=temp;
		
		
		
		return i+1;
	}

	
	private static int Median_Of_three(int arr[], int low, int high) 
    { 
		
		//Selecting Pivot by using median of three method
		
		int range = (high-low)+1;
		Random rn = new Random();
	    
	    
	    int[] random= new int[3];
	    for(int a=0; a<3; a++)
		{

		    random[a] = rn.nextInt(range) + low;
		}
		int n;
		n= Math.max (Math.min (random[0],random[1]), Math.min (Math.max(random[0],random[1]),random[2]));
	    
		
		int value1=arr[n];
	     arr[n]=arr[high];
	    arr[high]=value1;
		
	    int pivot = arr[high];
		int i= low-1;
		
		for(int j=low;j<high;j++)
		{
			if(arr[j]<=pivot)
			{
				
				swap(i+1,j,arr);
//				int swap = arr[j];
//				arr[j]=arr[i+1];
//				arr[i+1]=swap;
				
				i++;
			}
		}
		
		swap(i+1,high,arr);

		return i+1;
	    
       
    } 
	
	private static int Median_Of_three_value(int arr[], int low, int high) 
    { 
		
		//Selecting Pivot by using median of three method
		
		int range = (high-low)+1;
		Random rn = new Random();
	    
	    
	    int[] random= new int[3];
	    for(int a=0; a<3; a++)
		{

		    random[a] = rn.nextInt(range) + low;
		}
	    
	    
		int n;
//		n= Math.max (Math.min (random[0],random[1]), Math.min (Math.max(random[0],random[1]),random[2]));
	    
		
		if(arr[random[0]]>arr[random[1]])
		{
			
			if(arr[random[1]]>arr[random[2]])
			{
				n= random[1];
				 // System.out.println(arr[random[1]]);
			}
			else if(arr[random[0]]>arr[random[2]])
			{
				n= random[2];
				//System.out.println(arr[random[2]]);
			}
			else
			{
			n= random[0];	
			//System.out.println(arr[random[0]]);
			}
		}
		else
		{
			if(arr[random[0]]>arr[random[2]])
			{
				n= random[0];	
				//System.out.println(arr[random[0]]);
			}
			else if(arr[random[1]]>arr[random[2]])
			{
				n= random[2];
				//System.out.println(arr[random[2]]);
			}
			else
			{
				n= random[1];
				//System.out.println(arr[random[1]]);
			}
			
		}
		
		
		
		
		
		int value1=arr[n];
	     arr[n]=arr[high];
	    arr[high]=value1;
		
	    int pivot = arr[high];
		int i= low-1;
		
		for(int j=low;j<high;j++)
		{
			if(arr[j]<=pivot)
			{
				
				
				int swap = arr[j];
				arr[j]=arr[i+1];
				arr[i+1]=swap;
				
				i++;
			}
		}
		
		//swap(i+1,high,arr);
		int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
		
	
		return i+1;
	    
		
       
    } 
	
 	
	static int partition2(int arr[], int low, int high) 
    { 
        //Middle Pivot
		int n= (low+high)/2;
		
		 	
		    	
		    int value1=arr[n];
		     arr[n]=arr[high];
		    arr[high]=value1;
		    int pivot = arr[high]; 
		  
        int i = (low-1);  
        for (int j=low; j<high; j++) 
        { 
           
        	
            if (arr[j] <= pivot) 
            { 
                i++; 
  
                
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
      
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 
	

	
	
	/*****************************************************************************/

	public static void STLSort(int data[], int size)
	{
		
		
		Arrays.sort(data);
		
	}
	
	/*****************************************************************************/
	
	public static void swap(int x , int y ,int data[])
	{
		int temp = data[x];
		data[x] = data[y];
	    data[y] = temp;
	}
	
	/*****************************************************************************/
	
	public static void printData(int[] data, int size, String title)
	{
		int i;

		System.out.print("\n");
		System.out.print(title);
		System.out.print("\n");
		for (i = 0; i < size; i++)
		{
			System.out.print(data[i]);
			System.out.print(" ");
			if (i % 10 == 9 && size > 10)
			{
				System.out.print("\n");
			}
		}
	}

}
