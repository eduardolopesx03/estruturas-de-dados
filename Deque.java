package teste_final_final;

public class Deque extends ListaComArray {
	
	public Deque() {
		super();
	}
	
	public Deque(int capacity) {
		super(capacity);
	}
	
	public void pushFront(Object element) {
		add(0, element);
	}
	
	public void pushBack(Object element) {
		add(element);
	}
	
	public void popFront() {
		remove(0);
	}
	
	public void popBack() {
		remove(size() - 1);
	}
	
	public Object peekFront() {
		if (!isEmpty()) {
			return get(0);
		}
		return null;
	}
	
	public Object peekBack() {
		if (!isEmpty()) {
			return get(size() - 1);
		}
		return null;
	}
}