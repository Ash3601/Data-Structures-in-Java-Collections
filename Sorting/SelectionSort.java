class SelectionSort {

	// Get the largest element from the unsorted array
	// Swap that element with the last element of unsorted array

	public static void selectionSort (int[] a) {
		// Get the largest element
		for (int k=a.length-1; k>=0; k--) {
			int largest_val_idx = 0;
			// Considering last item to be sorted
			for (int i=1; i<=k; i++) {
				if (a[i] > a[largest_val_idx]) {
					largest_val_idx = i;
				}
			}
			swap(a, largest_val_idx, k);
		}
	}

	public static void swap(int[] a, int i, int j) {
		if (i == j)
			return;
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main (String args []) {
		int[] array = {20, 35, -15, 7, 55, 1, -22};
		selectionSort(array);
		for (int i=0; i<array.length; i++) {
			System.out.println(array[i]);
		}
	}
}