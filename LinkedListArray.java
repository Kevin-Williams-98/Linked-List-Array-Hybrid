import java.util.HashMap;
import java.util.NoSuchElementException;

public class LinkedListArray<T> 
{

	private Node<T> front;
	private Node<T> rear;
	private int size;
	private HashMap<T,Node<T>> map ;

	public LinkedListArray()
	{
		front = null;
		rear =null;
		size =0;
		map = new HashMap<T, Node<T>>();
	}

	public boolean isEmpty() 
	{
		if (front==null)
			return true ;
		return false;
		//return true if list is empty, otherwise false
	}
	public boolean contains(Node<T> node)
	{
		if (isEmpty())
		{
			return false;
		}
		System.out.println("got to the checking");
		if(map.containsKey(node.getData()))
		{
			return true;
		}
		return false;
		//: returns true if the given node is in the list , false otherwise
	}
	public void insert(T x) 
	{
		rear = new Node<T>(rear,x, null); 
		if(front==null)
			front =rear;

		if(rear.getPrev()!=null)
			rear.getPrev().setNext(rear);
		size++;
		map.put(rear.getData(), rear);
	}

	public void insertHead(T x)
	{

		front = new Node<T>(null,x,front);
		if(size ==0)
			rear = front;
		if(front.getNext()!=null)
			front.getNext().setPrev(front);
		size++;
		map.put(front.getData(), front);

	}
	public void addBefore(T x, Node<T> node) 
	{
		Node<T> temp1=front;
		Node<T> temp2;
		Node<T> newNode ;

		if(front==null)
		{
			front = new Node<T>(null,x,temp1);
			map.put(front.getData(), front);
			return;
		}
		if(temp1.getData()==node.getData())
		{
			front = new Node<T>(null,x,temp1);
			temp1.setPrev(front);
			map.put(front.getData(),front);
			return;
		}

		while(temp1!=null)
		{
			System.out.println("in the loop");

			if(temp1.getData()==node.getData())
			{
				System.out.println("was equal so now rearraging to insert");
				temp2 = temp1.getPrev();
				newNode = new Node<T>(temp2,x,temp1);

				temp2.setNext(newNode);


				temp1.setPrev(newNode);
				map.put(x,newNode);
				size++;
				return;
			}
			temp1=temp1.getNext();

		}


		//: insert the new element before the given node
	}
	public void addAfter(T x, Node<T> node)
	{
		Node<T> temp1=front;
		Node<T> temp2=rear;
		Node<T> newNode ;

		if(front==null)
		{
			front = new Node<T>(null,x,temp1);
			map.put(front.getData(), front);
			return;
		}
		if(temp2.equals(node))
		{
			rear = new Node<T>(temp2,x,null);
			temp2.setNext(rear);
			map.put(rear.getData(), rear);
			return;
		}

		while(temp1!=null)
		{
			System.out.println("in the loop");

			if(temp1.equals(node))
			{
				System.out.println("was equal so now rearraging to insert");
				temp2 = temp1.getNext();
				newNode = new Node<T>(temp1,x,temp2);
				temp2.setPrev(newNode);


				temp1.setNext(newNode);
				map.put(x,newNode);
				size++;
				return;
			}
			temp1=temp1.getNext();

		}

		// : insert the new element after the given node
	}
	public boolean removeFirst()
	{


		T temp;
		if(size==0)
			return false;
		else if(size ==1 )
		{
			temp=front.getData();
			front = null;
			rear=null;
		}
		else
		{
			temp=front.getData();
			front = front.getNext();
			front.setPrev(null);

		}

		map.remove(temp);
		size--;
		return true; 

		//: Remove the first element in the list. Returns true if removal was successful, false otherwise
	}
	public boolean removeLast()
	{
		T temp;
		if(size==0)
			return false;
		else if(size ==1 )
		{
			temp=rear.getData();
			front = null;
			rear=null;

		}
		else
		{
			//if(rear!=null)
			temp = rear.getData();

			rear =rear.getPrev();
			rear.setNext(null);


		}
		map.remove(temp);
		size--;
		return true;
		//: Remove  the last element in the list. Returns true if removal was successful, false otherwise
	}
	public boolean remove(int position)
	{
		Node<T>thePrev;
		Node<T>theNext;
		Node<T>currentNode=front;

		if (size==0)
			return false;

		for(int i=0; i<position;i++)
		{
			if(currentNode==null)
			{
				return false;
			}
			currentNode=currentNode.getNext();
		}
		theNext=currentNode.getNext();
		thePrev=currentNode.getPrev();

		if(thePrev==null)
		{
			front =theNext;
		}
		else
			if(theNext==null)
				thePrev.setNext(null);
			else 
			{
				thePrev.setNext(theNext);
				theNext.setPrev(thePrev);
			}
		//: Removes the element at the given position : Returns true if removal was successful, false otherwise
		map.remove(currentNode.getData());
		size--;
		return true;
	}

	public boolean remove(Node<T> node)
	{
		Node<T>thePrev=null;
		Node<T>theNext=null;
		Node<T>currentNode=front;

		if (size==0)
			return false;

		while(currentNode!=null)
		{
			if(currentNode.getData()==node.getData())
			{
				theNext=currentNode.getNext();
				thePrev=currentNode.getPrev();
				break;
			}

			currentNode=currentNode.getNext();
		}
		if((thePrev==null)&&(theNext==null))
		{
			return false;
		}

		if(thePrev==null)
		{
			front =theNext;
		}
		else
			if(theNext==null)
				thePrev.setNext(null);
			else 
			{
				thePrev.setNext(theNext);
				theNext.setPrev(thePrev);
			}
		//: Removes the element at the given position : Returns true if removal was successful, false otherwise
		map.remove(currentNode.getData());
		size--;
		return true;
		//: Removes the given node from the list : Returns true if removal was successful, false otherwise
	}

	public void sort () 
	{
		Node<T> start = front;
		int swapped, i;  
		Node<T> ptr1;  
		Node<T>lptr = null;  

		// Checking for empty list  
		if (start == null)  
			return ;  
System.out.println("sort ran");
		do
		{  
			swapped = 0;  
			ptr1 = start;  

			while (ptr1.getNext() != lptr)  
			{  
				if (ptr1.compareTo(ptr1.getNext().getData())>0)  
				{  
					T t = ptr1.getData(); 
					ptr1.setData(ptr1.getNext().getData()); 
					ptr1.getNext().setData(t); 
					swapped = 1;  
				}  
				ptr1 = ptr1.getNext();  
			}  
			lptr = ptr1;  
		}  
		while (swapped != 0);  
		System.out.println("sort finished");
		return ; 
		
	}  

	//: Sort the current state of the linked list

	public T get(int position)
{
		try
		{
		int count;
		Node <T> temp;
		if(size==0)
			throw new NoSuchElementException("Element not there");
		else

		{
			count = 0;
			temp = front; 
			while((count!=position)&&(temp!=null))
			{
				count++;	
				temp=temp.getNext();
			}

			if(position>size)
			{
				throw new NoSuchElementException("Element not in Doubly Linked List");
			}

		}
		return temp.getData();
		}
		catch (NoSuchElementException J)
		{
			return null;
		}
}


	public String toString()
	{	
		Node<T>temp=front;
		System.out.println(map.toString());
		String output= new String();
		while(temp!=null)
		{
			output+=temp.toString()+"\n";
			temp=temp.getNext();
		}
		return output;  
	}

}
