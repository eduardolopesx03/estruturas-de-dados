package teste_final_final;

import java.util.Random;

public class BoxGenerica {
	
	private Object[] elements;
	private int capacity; 
	private int size;
	
	public BoxGenerica() {
		size = 0;
		capacity = 5;
		elements = new Object[capacity];
	}
	
	public BoxGenerica(int capacity) {
		size = 0;
		this.capacity = capacity;
		elements = new Object[capacity];
	}
	
	public boolean estaVazia() {
		return (size == 0);
	}
	
	public void guardarUmElemento(Object elem) {
		aumentarCapacidadeSeNecessario();
		
		elements[size] = elem;
		size++;
	}
	
	private void aumentarCapacidadeSeNecessario() {
		if (size == capacity) {
			Object[] newElement = new Object[capacity *= 2];
			for (int i = 0; i < size; i++) {
				newElement[i] = elements[i];
			}
			elements = newElement;
		}
	}
	
	public Object meDeUmElemento() {
		Random ran = new Random();
		return elements[ran.nextInt(size)];
	}
}
