class QuickSort {
	static void swap (int[] a, int i, int j) {
		if (i == j)
			return;
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	static int partition (int[] a, int start, int end) {
			// Considering first element as the pivot
			int pivot = a[start];
			int i = start;
			int j = end;

			// We need to keep doing it until i and j crosses each other
			// NOTE: 
			// Here i is looking for the smaller values than pivot 
			// while j is looking for the values larger than the pivot
			// now if j founds such a value then which is smaller than pivot we
			// we move it to the value of the a[i]
			while (i<j) {
				// Decreasing j
				while (a[--j]>=pivot && i<j);
				// Checking if i has crossed j
				if (i<j) {
					// Putting value of i as j
					a[i] = a[j];
				}
				// Increasing i
				while (a[++i]<=pivot && i<j);
				// Checking if i has crossed j
				if (i<j) {
					a[j] = a[i]; 
				}

				
			}	
			a[j] = pivot;
			return j;		
	}

	static void quickSort (int[] a, int start, int end) {
		// Checking if there are atleast two elements present
		// So that we may begin sorting
		if (end - start < 2) {
			return;
		}
		// Otherwise we need to find the index of the pivot
		int pivotIndex = partition (a, start, end);

		quickSort(a, start, pivotIndex);
		quickSort(a, pivotIndex+1, end);
	}



	public static void main (String args []) {
			int[] array = {20, 35, -15, 7, 55, 1, -22};
			quickSort(array, 0, 7);
			for (int i=0; i<array.length; i++) {
				System.out.println(array[i]);
			}
	}
}