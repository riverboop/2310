import library.IntNode;
public class testerClass{
	public static void main (String[] args){
		IntNode head = null;
		head = new IntNode(1,1234,head);
		head.displayNodeData(head);

		head.addNodeAfter(2, 2345);
		head.displayNodeData(head);

		head.getLink().addNodeAfter(3, 3456);
		head.displayNodeData(head);

		head.removeNodeAfter();
		head.displayNodeData(head);

		head.findTail(head).addNodeAfter(4,4567);
		head.displayNodeData(head);

		head.findTail(head).addNodeAfter(5,5678);
		head.displayNodeData(head);

		head.displayNodeData(head.findPrevious(head, 4));

		head.findTail(head).addNodeAfter(9,9999);
		head.displayNodeData(head.locatePredecessor(head, 8));
	}	
}
