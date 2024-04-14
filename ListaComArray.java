package teste_final_final;

public class ListaComArray {
	
	private Object[] elements;
	private int capacity; 
	private int size;
	
	public ListaComArray() {
		size = 0;
		capacity = 5;
		elements = new Object[capacity];
	}
	
	public ListaComArray(int capacity) {
		size = 0;
		this.capacity = capacity;
		elements = new Object[capacity];
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return (size == 0);
	}
	
	public void clear() {
		size = 0;
	}
	
	public int indexOf(Object elem) {
		for (int i = 0; i < size; i++) {
			if (elements[i].equals(elem)) {
				return i;
			}
		}
		return -1;
	}
	
	public Object get(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index: " + index + " size: " + size);
		}
		else {
			return elements[index];
		}
	}
	
	public void print() {
		if (size == 0) {
			System.out.println("<----Lista Vazia---->");
		}
		else {
			System.out.println("<----Início---->");
			for (int i = 0; i < size; i++) {
				System.out.println(elements[i]);
			}
			System.out.println("<----Fim---->");
		}
	}
	
	public boolean add(Object elem) {
		aumentarCapacidadeSeNecessario();
		
		elements[size] = elem;
		size++;
		return true;
	}
	
	public void add(int index, Object elem) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index: " + index + " size: " + size);
		}
		else {
			aumentarCapacidadeSeNecessario();
			
			for (int i = size; i < index; i--) {
				elements[i] = elements[i - 1];
			}
			
			elements[index] = elem;
			size++;
		}
	}
	
	private void aumentarCapacidadeSeNecessario() {
		if (size == capacity) {
			Object[] newElements = new Object[capacity * 2];
			for (int i = 0; i < size; i++) {
				newElements[i] = elements[i];
			}
			elements = newElements;
			capacity *= 2;
		}
	}
	
	public Object remove(int index) {
		Object toBeDeleted;
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		else {
			toBeDeleted = elements[index];
			size--;
			
			for (int i = index; i < size; i++) {
				elements[i] = elements[i + 1];
			}
		}
		return toBeDeleted;
	}
	
	public boolean remove(Object elem) {
		int index = indexOf(elem);
		if (index < 0) {
			return false;
		}
		remove(index);
		return true;
	}
}
