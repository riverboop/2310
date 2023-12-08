package library;

public class IntNode
{
   private int sequenceNumber;
   private int data;
   private IntNode link;   

   
   // Precondition:
   // Postcondition: All instance variables of the IntNode class are initialized in order.
   public IntNode(int initialsequenceNumber, int initialdata, IntNode initialLink){
   	this.sequenceNumber = initialsequenceNumber;
   	this.data = initialdata;
   	this.link = initialLink;
   }

   
   // Precondition: This instance of the IntNode class exists.
   // In other words, the object whose method is activated exists as a node in the linked list. 
   // Postcondition: A new node with attributes item and data is created. Item serves as sequenceNumber.
   // The new node is added to the linked list at a position that comes immediately after the node whose method is activated.
   public void addNodeAfter(int item, int data){
   	if (this.link != null){
   		this.link = new IntNode(item, data, this.link);
	}
	else{
   		this.link = new IntNode(item, data, null);
	}
	//System.out.println("Created node at " + item + " with data " + data);
   }
   
   
   // Precondition: This instance of the IntNode class exists.
   // In other words, the object whose method is activated exists as a node in the linked list. 
   // Postcondition: The specific node, which comes immediately after the node whose method is activated, 
   // is removed from the linked list.
   public void removeNodeAfter( )   
   {
		if (this.link == null){
			System.out.println("removeNodeAfter: no node to remove");
		}
		else if (this.link.link == null){
			this.link = null;
		}
		else{
			this.link = this.link.link;
		}
		//System.out.println("Removed node");
   } 
   
   
   // Precondition: This instance of the IntNode class exists.
   // Postcondition: The sequenceNumber of this node is returned.
   public int getsequenceNumber( )   
   {
   	return this.sequenceNumber;
   }
   
  
   // Precondition: This instance of the IntNode class exists.
   // Postcondition: The link of this node is returned.
   public IntNode getLink( )
   {
   	return this.link;
   } 
    
   /* I implemented the last three methods recursively, first checking the precondition, then running a second method with the logic if it checks out.
   I'm not sure if it's the most efficient way, but if saving 2 or 3 processor cycles is that important we shouldn't be using java for this lol
   It was a lot more elegant to do this recursively rather than iteratively, I think that matters more than raw efficiency here -River */
   
   // Precondition: The linked list contains at least one element.
   // Postcondition: The (sequence number, data) pairs of each node in the linked list, starting with the head,
   // are displayed on the monitor. 
   public void displayNodeData(IntNode head)
   {
	if (head != null){
   		System.out.print("The (sequence number, data) pairs in the linked list are: ");
		nodeDataLoop(head);
		System.out.println("\n");
	}
   }
   private void nodeDataLoop(IntNode head){
	System.out.print("(" + head.sequenceNumber + "," + head.data + ")");
	if(head.link != null){
		System.out.print(" ");
		nodeDataLoop(head.link);
	}
   }

   // Precondition: The head of the linked list is different than null, and its sequenceNumber is different than target.
   // Postcondition: The link to the specific node, which comes before the node whose sequenceNumber is equal to target, 
   // is returned. If the linked list does not contain a node with sequenceNumber equal to target, then null is returned.   
   public IntNode findPrevious(IntNode head, int target)
   {
   	//check precondition
	if (head.sequenceNumber > target){
		System.out.println("head sequence number > target!");
		return null;
	}
   	//find node
	return findPreviousLoop(head, target);
   }
   private IntNode findPreviousLoop(IntNode head, int target){
	if(head.link != null){
   		if (head.link.sequenceNumber == target)
			return head;
		else
			return findPrevious(head.link, target);
	}
	return null;
   }

   
   // Precondition: The head of the linked list is different than null, and its sequenceNumber is smaller than target.
   // Postcondition: The link to the specific node, which comes before the node that is the first in the linked list 
   // to have a sequenceNumber greater than target, is returned. 
   // If no such node is found, the link to the last node in the linked list is returned. 
   public IntNode locatePredecessor(IntNode head, int target)
   {
   	//check precondition
	if (head.sequenceNumber > target){
		System.out.println("head sequence number > target!");
		return null;
	}
   	//find node
	else return locatePredecessorLoop(head, target);
   }
   private IntNode locatePredecessorLoop(IntNode head, int target){
	if(head.link != null){
   		if (head.link.sequenceNumber > target)
			return head;
		else
			return locatePredecessor(head.link, target);
	}
	else return head;
   }

	//little method I wrote for testing, not used by the intrusionDetectionClass but I'm leaving it here -River
   public IntNode findTail(IntNode head){
   	if (head == null)
		return null;
   	else if (head.link != null) 
		return findTail(head.link);
	else
		return head;
   }

  
}
           
