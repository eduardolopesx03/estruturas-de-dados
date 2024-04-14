package teste_final_final;

public class Queue {
	
	private QueueNode front, rear;
	
	private class QueueNode {
		
		private Object element;
		private QueueNode next;
		
		private QueueNode(Object e, QueueNode n) {
			element = e;
			next = n;
		}
	}
	
	public Queue() {
		front = rear = null;
	}
	
	public boolean empty() {
		return (front == null);
	}
	
	public void enqueue(Object elem) {
		QueueNode newElement = new QueueNode(elem, null);
		
		if (front == null) {
			front = rear = newElement;
		}
		else {
			rear.element = newElement;
			rear = rear.next;
		}
	}
	
	public Object dequeue() {
		if (empty()) {
			return null;
		}
		Object elem = front.element;
		front = front.next;
		return elem;
	}
	
	public void print() {
		if (this.empty()) {
			System.out.println("Fila Vazia");
		}
		else {
			System.out.println("Início");
			QueueNode itr = front;
			while (itr != null) {
				System.out.println(itr.element.toString());
			}
			System.out.println("Fim");
		}
	}
}
