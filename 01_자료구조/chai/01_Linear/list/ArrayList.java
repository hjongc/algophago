package list;

import java.util.Arrays;

public class ArrayList<E> implements List<E>{
	
	private static final int DEFAULT_CAPACITY = 10;	// 최소(기본) 용적 크기 
	private static final Object[] EMPTY_ARRAY = {};	// 빈 배열
    
	private int size;	// 요소 개수 
 
	Object[] array;	// 요소를 담을 배열 
	
	// 생성자1 (초기 공간 할당 X)
	public ArrayList() {
		this.array = EMPTY_ARRAY;
		this.size = 0;
 
	}
 
	// 생성자2 (초기 공간 할당 O)
	public ArrayList(int capacity) {
		this.array = new Object[capacity];
		this.size = 0;
	}
	
	// 동적할당을 위한 resize method
	private void resize() {
		int array_capacity = array.length;
	 
		// if array's capacity is 0
		if (Arrays.equals(array, EMPTY_ARRAY)) {
			array = new Object[DEFAULT_CAPACITY];
			return;
		}
	 
		// 용량이 꽉 찰 경우  
		if (size == array_capacity) {
			int new_capacity = array_capacity * 2;
	 
			// copy
			array = Arrays.copyOf(array, new_capacity);
			return;
		}
		// 용적의 절반 미만으로 요소가 차지하고 있을 경우 
		if (size < (array_capacity / 2)) {
			int new_capacity = array_capacity / 2;
	 
			// copy
			array = Arrays.copyOf(array, Math.max(new_capacity, DEFAULT_CAPACITY));
			return;
		}
	}
	
	@Override
	public boolean add(E value) {
		addLast(value);
		return true;
	}
	
	public void addFirst(E value) {
		add(0, value);
	}
	
	public void addLast(E value) {
		if (size == array.length) {
			resize();
		}
		array[size++] = value;
	}
	
	@Override
	public void add(int index, E value) {
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (index == size) { // index가 마지막 위치라면 
			addLast(value);
		}
		else {
			if (size == array.length) {
				resize();
			}
			
			for (int i = size; i > index; i--) {
				array[i] = array[i-1];
			}
			
			array[index] = value;
			size++;
		}
	}

	@Override
	public E remove(int index) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
	 
		E element = (E) array[index];	// 삭제될 요소를 반환하기 위해 임시로 담아둠
		array[index] = null;
	    
		// 삭제한 요소의 뒤에 있는 모든 요소들을 한 칸씩 당겨옴
		for (int i = index; i < size - 1; i++) {
			array[i] = array[i + 1];
			array[i + 1] = null;
		}
		size--;
		resize();
		return element;
	}

	@Override
	public boolean remove(Object value) {
		
		// 삭제하고자 하는 요소의 인덱스 찾기
		int index = indexOf(value);
	 
		// -1이라면 array에 요소가 없다는 의미이므로 false 반환
		if (index == -1) {
			return false;
		}
	 
		// index 위치에 있는 요소를 삭제
		remove(index);
		return true;
	}

	@Override
	public E get(int index) {
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		
		return (E) array[index];
	}

	@Override
	public void set(int index, E value) {
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		else {
			array[index] = value;
		}
	}

	@Override
	public boolean contains(Object value) {
		 
		// 0 이상이면 요소가 존재한다는 뜻
		if(indexOf(value) >= 0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int indexOf(Object value) {		
		for (int i = 0; i < size; i++) {
			if (array[i].equals(value)) {
				return i;
			}
		}
		return -1;
	}
	
	public int lastIndexOf(Object value) {
		for(int i = size - 1; i >= 0; i--) {
			if(array[i].equals(value)) {
				return i;
			}
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
		// 모든 공간을 null 처리 해준다. 
		for (int i = 0; i < size; i++) {
			array[i] = null;
		}
		size = 0;
		resize();
	}

}
