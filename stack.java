import java.util.Scanner;


class stack_implementation 
{
	
	int size;
	int top;
	Scanner s1 = new Scanner(System.in); 
	int arr[];
	
	stack_implementation(int size2)
	{
		size = size2;
		arr = new int[size];
		top=-1;
	}
	
	
	public void insert()
	{
		
		if(top == (size-1))
		{
			System.out.println("Stack is full");
		}
		else
		{
			
			System.out.println("Enter the element you want to insert");
			int el = s1.nextInt();
			top++;
			
			arr[top]=el;
			System.out.println("");
			System.out.println("Element add is "+el);
			
		}
		
		
	}
	
	
	public void pop()
	{
		if( top ==-1)
		{
			System.out.println("Stack is empty");
		}
		else
		{
			System.out.println("Element removed from the stack is "+arr[top]);
			top--;
		}
		
	}
	
	
	
	public void display()
	{
	
		
		for( int i =0;i<=top;i++)
		{
			System.out.println(arr[i]);
		}
		
		
	}
	
	
	public void peep()
	{
		System.out.println("the stack of top"+arr[top]);
	}
	
	
}

public class stack 
{
	public static void main(String args[])
	{
		
		int size;
		System.out.println("Enter the size of the stack");
		Scanner s1 = new Scanner(System.in);
		size= s1.nextInt();
		
		int d= 1;
		int choice;
		
		stack_implementation e1 = new stack_implementation(size);
		
		while(d==1)
		{
			
			System.out.println("1) Insert the element in the stack");
			System.out.println("2) Pop the element in the stack");
			System.out.println("3) Display the element ");
			System.out.println("4) Peep" );
			System.out.println("5) exit");
			
	
			choice=s1.nextInt();
			switch(choice)
			{
			
			case 1:
				e1.insert();
				break;
			
			case 2:
				e1.pop();
				break;
			case 3:
				e1.display();
				break;
			case 4:
				e1.peep();
				break;
				
			case 5:
				System.out.println("Bye ");
				d=5;
				break;
				
				
			}
			
			
		}
		
		
		
		
	}

}
