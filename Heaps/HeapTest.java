class Heap {
    private int size;
    private int[] heap;

    Heap(int capacity) {
        heap = new int[capacity];
    }

    // insert into heap
    public void insert(int value) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Heap is full");
        }
        this.heap[size] = value;
        heapifyAbove(size);
        size++;

    }

    // heapify
    public void heapifyAbove(int index) {
        int newValue = this.heap[index];
        while ((newValue > this.heap[this.getParent(index)]) && (index > 0)) {
            this.heap[index] = this.heap[this.getParent(index)];
            index = this.getParent(index);
        }

        this.heap[index] = newValue;
    }

    // get parent index
    public int getParent(int index) {
        return (index - 1) / 2;
    }

    // is full
    public boolean isFull() {
        return (this.heap.length == size);
    }

    // is empty
    public boolean isEmpty() {
        return (this.size == 0);
    }

    // get child indices
    public int getChildIndex(int index, boolean left) {
        return ((2 * index) + (left ? 1 : 2));
    }

    // delete from heap
    public int delete(int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty!!");
        }
        int parent = getParent(index);
        int deletedValue = heap[index];

        // right most value in the array
        heap[index] = heap[size - 1];

        if (index == 0 || heap[index] < heap[parent]) {
        	heapifyBelow(index, size - 1);
        } else {
        	heapifyAbove(index);
        }

        size--;
        return deletedValue;
    }

    private void heapifyBelow(int index, int lastHeapIndex) {
        int childToSwap;
        while (index <= lastHeapIndex) {
            int leftChild = getChildIndex(index, true);
            int rightChild = getChildIndex(index, false);

            if (leftChild <= lastHeapIndex) {
                if (rightChild > lastHeapIndex) {
                    childToSwap = leftChild;
                } else {
                    childToSwap = (heap[leftChild] > heap[rightChild] ? leftChild : rightChild);
                }

                if (heap[index] < heap[childToSwap]) {
                    int temp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = temp;
                } else {
                    break;
                }

                index = childToSwap;
            } else {
            	break;
            }
        }
    }

    // sort
    public void sortHeap() {
    	int lastHeapIndex = size - 1;
    	for (int i=0; i<lastHeapIndex; i++) {
    		int temp = heap[0];
    		heap[0] = heap[lastHeapIndex - i];
    		heap[lastHeapIndex - i] = temp;
    		heapifyBelow(0, lastHeapIndex - i - 1);
    	}
    }


    // peek
    public int peek() {
    	if (isEmpty()) {
    		throw new IndexOutOfBoundsException("Heap is empty!!");
    	} 
    	return heap[0];
    }

    // print heap
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(this.heap[i]);
            System.out.print(", ");
        }
    }
}

class HeapTest {
    public static void main(String args[]) {
        Heap heap = new Heap(10);
        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);
        // heap.insert(6);
        // heap.insert(7);

        // print
        heap.print();

        // delete index 1 
        heap.delete(1);

        // print
        System.out.println("After deletion");
        heap.print();

        // print heap
        System.out.println(heap.peek());

        // lets heapsort
        heap.sortHeap();
        System.out.println("After sorting ");        
        heap.print();
    }
}