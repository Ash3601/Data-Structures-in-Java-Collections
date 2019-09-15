class BubbleSort {

	// Its a stable sort version 
	// Means if data items are duplicate then there relative ordering will not be
	// changed
	static void swap (int[] a, int i, int j) {
		if (i == j)
			return;
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	static void bubbleSort(int[] a) {
		// k can be considered as the last unsorted partition
		for (int k=a.length -1; k>=0; k--) {
			for (int i=0; i<k; i++) {
				if (a[i] > a[i+1])
					swap(a, i, i+1);
			}
		}
	}
	public static void main (String args []) {
		
		int[] array = {20, 35, -15, 7, 55, 1, -22};

		bubbleSort(array);
		for (int i=0; i<array.length; i++) {
			System.out.println(array[i]);
		}
	}
}