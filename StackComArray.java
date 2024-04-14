package teste_final_final;

import java.util.EmptyStackException;

public class StackComArray {
	
	private Object[] elements;
	private int capacity = 100;
	private int topOfStack;
	
	public StackComArray() {
		topOfStack = -1;
		elements = new Object[capacity];
	}
	
	public boolean empty() {
		return (topOfStack == -1);
	}
	
	public void push(Object elem) {
		aumentarCapacidadeSeNecessario();
		
		elements[topOfStack] = elem;
		topOfStack++;
	}
	
	public void pop() {
		if (empty()) {
			throw new EmptyStackException();
		}
		topOfStack--;
	}
	
	public Object peek() {
		if (empty()) {
			throw new EmptyStackException();
		}
		return elements[topOfStack];
		
	}
	
	private void aumentarCapacidadeSeNecessario() {
		if (topOfStack == capacity) {
			Object[] newElements = new Object[capacity * 2];
			for (int i = 0; i < capacity; i++) {
				newElements[i] = elements[i];
			}
			elements = newElements;
			capacity *= 2;
		}
	}
	
	public void print() {
		if (this.empty()) {
			System.out.println("Pilha Vazia");
		}
		else {
			System.out.println("Início");
			for (int i = 0; i <= topOfStack; i++) {
				System.out.println(elements[topOfStack].toString());
			}
			System.out.println("Fim");
		}
	}
}
