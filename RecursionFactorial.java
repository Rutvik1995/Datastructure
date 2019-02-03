import java.util.Scanner;

public class RecursionFactorial
{

	
	public static int factorial(int n)
	{
		if(n==0)
		{
			return 1;
		}
		else
		{
			
			
			return n * factorial(n-1);
			
		}
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		Scanner s1 = new Scanner(System.in);
		
		
		System.out.println("Enter the number you want to find recursion");
		int number = s1.nextInt();
		int fact =1;
		
		
		fact = factorial(number);
		
		System.out.println("Ans= "+fact);
		
		
		
		
		

	}

}
