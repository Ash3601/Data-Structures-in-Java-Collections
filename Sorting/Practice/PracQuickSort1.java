class PracQuickSort1 {

	static int getPivot (int[] a, int start, int end) {
			int i = start;
			int j = end;
			// Consider first element as the pivot
			int pivot = a[start];
			// While i & j havent cross each other
			while (i < j) {
				while (i<j && a[--j] >= pivot);
				if (i<j){
					a[i] = a[j];
				}

				while (i<j && a[++i] <= pivot);
				if (i<j) {
					a[j] = a[i];
				}
			}
			a[i] = pivot;
			return i;
	}

	static void quickSort (int[] a, int start, int end) {
		// Checking if atleast two elements are present
		if (end-start < 2){
			return;
		}
		int pivotIndex = getPivot(a, start, end);
		quickSort (a, start, pivotIndex);
		quickSort (a, pivotIndex+1, end);
	}

	public static void main (String args []) {
		int[] array = {2, 1, 5, 4, 2};
		// int[] array = {20, 35, -15, 7, 55, 1, -22};
			quickSort(array, 0, array.length);
			for (int i=0; i<array.length; i++) {
				System.out.println(array[i]);
			}
	}
}