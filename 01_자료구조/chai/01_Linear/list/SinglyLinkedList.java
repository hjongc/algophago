package list;

import java.util.NoSuchElementException;

public class SinglyLinkedList<E> implements List<E>{
	private Node<E> head;	// 노드의 첫 부분 
	private Node<E> tail;	// 노드의 마지막 부분
	private int size;	// 요소 개수 
 
	// 생성자
	public SinglyLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	
	// 특정 위치의 노드를 반환하는 메소드
	private Node<E> search(int index) {
			
		// 범위 밖(잘못된 위치)일 경우 예외 던지기 
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
			
		Node<E> x = head;	// head가 기리키는 노드부터 시작 
			
		for (int i = 0; i < index; i++) {
			x = x.next;	// x노드의 다음 노드를 x에 저장한다
		}
		return x;
	}
	
	@Override
	public boolean add(E value) {
		addLast(value);
		return false;
	}
	
	public void addLast(E value) {
		Node<E> newNode = new Node<E>(value);	// 새 노드 생성 
	 
		if (size == 0) {	// 처음 넣는 노드일 경우 addFisrt로 추가
			addFirst(value);
			return;
		}
	 
		tail.next = newNode;
		tail = newNode;
		size++;
	}
	
	private void addFirst(E value) {
		
		Node<E> newNode = new Node<E>(value);
		newNode.next = head;
		head = newNode;
		size++;
		
		if (head.next == null) {
			tail = head;
		}
	}


	@Override
	public void add(int index, E value) {
		// 범위 밖(잘못된 위치)일 경우 예외 던지기 
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		// index가 맨 처음 -> addFirst
		if (index == 0) {
			addFirst(value);
			return;
		}
		
		// index가 마지막자리 -> addLast
		if (index == size) {
			addLast(value);
			return;
		}
		
		// 추가하려는 위치의 이전 노드
		Node<E> prevNode = search(index-1);
		
		// 추가하려는 위치의 노드
		Node<E> nextNode = prevNode.next;
		
		// 추가하려는 노드
		Node<E> newNode = new Node<E>(value);
		
		prevNode.next = null; // 필수적인지?
		prevNode.next = newNode;
		newNode.next = nextNode;
		size++;
	}
	
	public E remove() { // 맨 앞 지우
		 
		Node<E> headNode = head;
	 
		if (headNode == null)
			throw new NoSuchElementException();
			
		// 삭제된 노드를 반환하기 위한 임시 변수
		E element = headNode.data;
			
		// head의 다음 노드 
		Node<E> nextNode = head.next;
			
		// head 노드의 데이터들을 모두 삭제
		head.data = null;
		head.next = null;
			
		// head 가 다음 노드를 가리키도록 업데이트
		head = nextNode;
		size--;
			
		/**
		 * 삭제된 요소가 리스트의 유일한 요소였을 경우
		 * 그 요소는 head 이자 tail이었으므로 
		 * 삭제되면서 tail도 가리킬 요소가 없기 때문에
		 * size가 0일경우 tail도 null로 변환
		 */
		if(size == 0) {
			tail = null;
		}
		return element;
	}
	
	@Override
	public E remove(int index) {
		
		// 삭제하려는 노드가 첫 번째 원소일 경우 
		if (index == 0) {
			return remove();
		}
	 
		// 잘못된 범위에 대한 예외 
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
			
		Node<E> prevNode = search(index - 1);	// 삭제할 노드의 이전 노드 
		Node<E> removedNode = prevNode.next;	// 삭제할 노드 
		Node<E> nextNode = removedNode.next;	// 삭제할 노드의 다음 노드 
	 
		E element = removedNode.data;	// 삭제되는 노드의 데이터를 반환하기 위한 임시변수
		
		// 이전 노드가 가리키는 노드를 삭제하려는 노드의 다음노드로 변경 
		prevNode.next = nextNode;
	 
		// 만약 삭제했던 노드가 마지막 노드라면 tail을 prevNode로 갱신
		if(prevNode.next == null) {
			tail = prevNode;
		}
		// 데이터 삭제 
		removedNode.next = null;
		removedNode.data = null;
		size--;
	 
		return element;
	}

	@Override
	public boolean remove(Object value) {
		
		Node<E> prevNode = head;
		boolean hasValue = false;
		Node<E> x = head;	// removedNode 
			
		// value 와 일치하는 노드를 찾는다.
		for (; x != null; x = x.next) {
			if (value.equals(x.data)) {
				hasValue = true; // hasValue 필수적???
				break;
			}
			prevNode = x;
		}
	 
		// 일치하는 요소가 없을 경우 false 반환
		if(x == null) {
			return false;
		}
	 
		// 만약 삭제하려는 노드가 head라면 기존 remove()를 사용 	
		if (x.equals(head)) {
			remove();
			return true;
		}
	 
		else {
			// 이전 노드의 링크를 삭제하려는 노드의 다음 노드로 연결
			prevNode.next = x.next;
	 
			// 만약 삭제했던 노드가 마지막 노드라면 tail을 prevNode로 갱신
			if(prevNode.next == null) {
				tail = prevNode;
			}
			x.data = null;
			x.next = null;
			size--;
			return true;
		}
	}

	@Override
	public E get(int index) {
		return search(index).data;
	}

	@Override
	public void set(int index, E value) {
		
		Node<E> replaceNode = search(index);
		replaceNode.data = null;
		replaceNode.data = value;
	}

	@Override
	public boolean contains(Object value) {
		return indexOf(value) >= 0;
	}

	@Override
	public int indexOf(Object value) {
		int index = 0;
		
		for (Node<E> x = head; x != null; x = x.next) {
			if (value.equals(x.data)) {
				return index;
			}
			index++;
		}
		return -1;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void clear() {
		for (Node<E> x = head; x != null;) {
			Node<E> nextNode = x.next;
			x.data = null;
			x.next = null;
			x = nextNode;
		}
		head = tail = null;
		size = 0;
	}
}
