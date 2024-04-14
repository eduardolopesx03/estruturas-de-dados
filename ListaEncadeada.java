package teste_final_final;

public class ListaEncadeada {

	private ListNode head;
	private ListNode tail;
	private ListNode previous;
	private int size;

	private class ListNode {

		private Object element;
		private ListNode next;

		private ListNode(Object e, ListNode n) {
			element = e;
			next = n;
		}
	}

	public ListaEncadeada() {
		size = 0;
		head = tail = previous = null;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return (head == null);
	}

	public void clear() {
		head = tail = null;
		size = 0;
	}

	public int indexOf(Object elem) {
		ListNode itr = head;
		previous = null;
		for (int i = 0; i < size; i++) {
			if (itr.element.equals(elem)) {
				return i;
			}
			else {
				previous = itr;
				itr = itr.next;
			}
		}
		return -1;
	}

	public Object get(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index: " + index + " size: " + size);
		}
		else {
			if (index == 0) {
				return head.element;
			}
		}
		findPrevious(index);
		return previous.next.element;
	}

	private void findPrevious(int index) {
		ListNode itr = head;
		previous = null;
		for (int i = 0; i < size; i++) {
			if (i == index) {
				return;
			}
			previous = itr;
			itr.next = itr;
		}
		return;
	}

	public void print() {
		if (head == null) {
			System.out.println("<----Lista Vazia---->");
		}
		else {
			System.out.println("<----Início---->");
			ListNode itr = head;
			while (itr != null) {
				System.out.println(itr.element);
				itr = itr.next;
			}
			System.out.println("<----Fim---->");
		}
	}

	public boolean add(Object elem) {
		ListNode newElement = new ListNode(elem, null);
		if (head == null) {
			head = tail = newElement;
		}
		else {
			tail.next = newElement;
		}
		tail = newElement;
		size++;
		return true;
	}

	public void add(int index, Object elem) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index: " + index + " size: " + size);
		}
		else {
			if (index == 0) {
				if (head == null) {
					ListNode newElement = new ListNode(elem, null);
					head = tail = newElement;
				}
				else {
					ListNode newElement = new ListNode(elem , head);
					head = newElement;
				}
			}
			else {
				findPrevious(index);
				ListNode newElement = new ListNode(elem, previous.next);
				previous.element = newElement;
				if (newElement.next == null) {
					tail = newElement;
				}
			}
		}
		size++;
	}

	public Object remove(int index) {
		Object toBeDeleted;
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index: " + index + " size: " + size);
		}
		else {
			if (index == 0) {
				toBeDeleted = head.element;
				if (head == tail) {
					head = tail = null;
				}
				else {
					head = head.next;
				}
			}
			else {
				findPrevious(index);
				toBeDeleted = previous.element;
				if (previous.element == tail) {
					tail = previous;
				}
				previous.next = previous.next.next;
			}
			size--;
		}
		return toBeDeleted;
	}

	public boolean remove(Object elem) {
		int index = indexOf(elem);
		if (index < 0 ) {
			return false;
		}
		remove(index);
		return true;
	}
}