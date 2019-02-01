import java.util.Scanner;

class execution
{
	
	int size;
	int front=-1;
	int rear=-1;
	Scanner s1= new Scanner(System.in);
	int arr[];
	
	
	
	execution(int size2)
	{
		size=size2;		
		arr = new int[size];
		
	}
	

	
	public void AddFront()
	{
	
		if(rear==-1 & front==-1)
		{
			rear++;
			front++;
			
			System.out.print("Enter the element you want to add in starting of array for add front: ");
			int no =s1.nextInt();
			arr[rear]=no;
			
		}
		
		else
		{
			if((rear+1)==size)
			{
				System.out.println("The dequeue is full");
			}
			else
			{
				
				System.out.print("Enter the element you want to add in front: ");
				int no =s1.nextInt();
				
				if(front==0)
				{
				
				System.out.println("going in for loop");
				for(int i=rear;i>=front;i--)
				{
					
					arr[i+1]=arr[i];
					System.out.println("in for loop");
					//System.out.println(arr[i+1]);
				}
				
				
				arr[front]=no;
				rear++;
				
				}
				
				else
				{	
					
					front--;
					arr[front]=no;
					//rear++;	
				}
			
			}
			
		}
		
	}
	
	public void AddBack()
	{
		
		
		if(rear==-1 && front==-1)
		{
			
				rear++;
				front++;
				
				System.out.println("Enter the lement you want to add at startinf in array for add back");
				int no =s1.nextInt();
				arr[rear]=no;
				
			
		}
		else
		{
			if((rear+1)==size)
			{
				System.out.println("The dequeue is full");
			}
			else
			{
			rear++;
			System.out.println("Enter the lement you want to add for back ");
			int no =s1.nextInt();
			arr[rear]=no;
	
			
			}
		}
			
	}
	
	public void DeleteFront()
	{
		
		if(rear==-1 && front==-1)
		{
			System.out.println("Dequeue is empty");
		}
		
		
		else if(rear==front)
		{
			System.out.println("Element to delete is "+arr[front]);
			front=-1;
			rear=-1;
		}
		
		else
		{
			System.out.println("Element to delete is "+arr[front]);
			front++;
		}
		
		
		
	}
	
	public void DeleteBack()
	{
		
		
		if(rear==-1 && front==-1)
		{
			System.out.println("Dequeue is empty");
		}
		
		else if(rear==front)
		{
			System.out.println("Element to delete is "+arr[front]);
			front=-1;
			rear=-1;
		}
		
		
		else
		{
			System.out.println("Element to delete is "+arr[rear]);
			rear--;
		}
		
		
		
	}
	
	public void display()
	{
		for(int i=front;i<=rear;i++)
		{
			System.out.println(arr[i]);
		}
		
		System.out.println("Rear is"+rear);
		System.out.println("Front is "+front);
		
	}
	
}



public class dequeue 
{

	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		
		int i=1;
		// TODO Auto-generated method stub
		
		
		System.out.println("Enter the size of the array:");
		int size= s.nextInt();
		
		

		execution e = new execution(size);
		

		while(i==1)
		{
			
			
			System.out.println("Enter the choice");
			System.out.println("1) Add at front");
			System.out.println("2) Add at back");
			System.out.println("3) Delete at front");
			System.out.println("4) Delete at back");
			System.out.println("5) Display Dequeue");
			System.out.println("6) Exit");
			int choice=s.nextInt();
			
			
			
			switch(choice)
			{
			
			case 1: 
				e. AddFront();
				break;
			case 2:
				e.AddBack();
				break;
			case 3:
				e.DeleteFront();
				break;
			case 4:
				e.DeleteBack();
				break;
			case 5:
				e.display();
				break;
			case 6:
				System.out.println("Bye ");
				i=5;
				break;
			
			
			}
			
			
			
			
		}
		
		
		
		
	}
	
	

}
