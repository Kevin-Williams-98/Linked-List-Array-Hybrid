
public class Node<T> implements Comparable<T>
{
	private T data;
	private Node<T> next;
	private Node<T> prev;

	public Node(T x)
	{
		data =x;
		next = null;
		prev =null;
	}
	public Node(Node<T> iPrev,T x,Node<T> iNext)
	{
		data=x;
		next=iNext;
		prev=iPrev;
	}

	public T getData() {
		return data;
	}

	public void setData(T data)
	{
		this.data = data;
	}

	public Node<T> getNext() 
	{
		return next;
	}

	public void setNext(Node<T> next) 
	{
		this.next = next;
	}

	public Node<T> getPrev() 
	{
		return prev;
	}

	public void setPrev(Node<T> prev) 
	{
		this.prev = prev;
	}


	@SuppressWarnings("unchecked")
	public int compareTo(T element)
	{
		return ((Comparable<T>) data).compareTo(element);
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}
	@Override
	public String toString() 
	{
		return "Node [data=" + data.toString()+ "]";
	}

}
