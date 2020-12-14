
public class Utility 
{
	public static void main(String[] args) 
	{
		 
		
		LinkedListArray<Integer> theLA = new LinkedListArray<Integer>();
		theLA.insert(9);
		System.out.println(theLA.toString());
		//Integer theNum= new Integer(7);
		theLA.insert(7);
		System.out.println(theLA.toString());	
		theLA.insert(13);
		theLA.insert(30);
		theLA.insert(3);
		System.out.println(theLA.toString());
		theLA.insertHead(2);
		theLA.insertHead(1);
		theLA.insertHead(0);
		System.out.println(theLA.toString());
		System.out.println(theLA.contains(new Node<Integer>(2)));
		theLA.addBefore(99, new Node<Integer>(9));
		System.out.println(theLA.toString());
		theLA.addAfter(91,new Node<Integer>(3));
		theLA.addAfter(71,new Node<Integer>(3));
		theLA.addAfter(55,new Node<Integer>(3));
		System.out.println(theLA.toString());
		theLA.removeFirst();
		System.out.println(theLA.toString());
		theLA.removeLast();
		System.out.println(theLA.toString());
		theLA.remove(9);
		System.out.println(theLA.toString());
		theLA.remove(-1);
		System.out.println(theLA.toString());
		theLA.remove(new Node<Integer>(99));
		System.out.println(theLA.toString());
		theLA.sort();
		System.out.println(theLA.toString());
		
		
	}

	
}
