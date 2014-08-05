//Note: The type of the elements being stored in the linked list must have
//an equals method for the "equals", "contains" and "find" methods to work.

public class GenericLinkedList<T> {

	//"Node" inner class
	private class Node<T> {
		private T data;
		private Node<T> link;
		
		public Node () {
			data = null;
			link = null;
		}
		
		public Node (T tempData, Node<T> tempLink) {
			data = tempData;
			link = tempLink;
		}
		
		public String toString () {
			String tempString = data.toString();
			return tempString;
		}
		
	}
	
	//Attributes of "GenericLinkedList"
	private Node<T> head;
	
	//Accessor method
	public Node<T> getHead () {
		return head;
	}
	
	//Mutator method
	public void setHead (T tempData) {
		head.data = tempData;
	}
	
	//Default Constructor
	public GenericLinkedList () {
		head = null;
	}

    //Deep copy clone method
    public GenericLinkedList<T> clone () {
        try {
            GenericLinkedList<T> copy = (GenericLinkedList<T>)super.clone();
            if (head == null)
                copy.head = null;
            else
                copy.head = copyOf(head);
            return copy;
        }
        catch (CloneNotSupportedException e) {
            return null;
        }
    }
    
	//Add node to start of the linked list
	public void addToStart (T tempData) {
		head = new Node<T> (tempData, head);
	}
	
	//Removes head node, second node becomes head
	public boolean deleteHeadNode () {
		if (head != null) {
			head = head.link;
			return true;
		} 
		else {
			return false;
		}
	}
	
	//Returns number of nodes in list (similar to .length)
	public int size () {
		int count = 0;
		Node<T> position = head;
		while (position != null) {
			count++;
			position = position.link;
		}
		return count;
	}
	
	//Checks if the item is one of the elements in the list
	public boolean contains (T item) {
		return (find(item) != null);
	}
	
	//Returns the first node that contains the target
	private Node find (T target) {
		Node<T> position = head;
		T positionData;
		
		while (position != null) {
			positionData = position.data;
			if (positionData.equals(target)) {
				return position;
			}
			position = position.link;
		}
		return null;
	}
	
	//Public method for returning the object that contains the target data
	public T findData (T target) {
		Node<T> result = find(target);
		
		if (result == null) 
			return null;
		else 
			return result.data;
	}
	
	//Prints all list elements
	public void outputList () {
		Node<T> position = head;
		
		while (position != null) {
			System.out.println(position.data);
			position = position.link;
		}
	}
	
	//Returns true if list is empty
	public boolean isEmpty () {
		return (head == null);
	}
	
	//"Deletes" a list, destroys head
	public void clear () {
		head = null;
	}
	
	//Lists must contain same data in same order to be equal
	public boolean equals (Object tempObj) {
		if(tempObj == null)
			return false;
		else if (getClass () != tempObj.getClass())
			return false;
		else {
			GenericLinkedList<T> tempList = (GenericLinkedList<T>)tempObj;
			if (size () != tempList.size())
				return false;
			Node<T> position1 = head;
			Node<T> position2 = tempList.head;
			while (position1 != null) {
				if (!(position1.data.equals(position2.data)))
					return false;
				position1 = position1.link;
				position2 = position2.link;
			}
			return true;
		}
	}
	
	//Returns all data from linked list as a string
	public String toString () {
		String tempString = "";
		Node<T> position = head;
		
		while(position != null) {
			tempString += position.data.toString() + " ";
			position = position.link;
		}
		return tempString;
	}
	

}
