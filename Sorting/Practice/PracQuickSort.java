class PracQuickSort {

	static int partition (int[] a, int start, int end) {
		int i = start;
		int j = end;
		// Considering the first element as the pivot
		int pivot = a[start];

		// Until i and j do not cross each other
		while (i<j) {
			// for j
			while (i<j && a[--j]>=pivot);
			if (i<j) {
				a[i] = a[j];
			}

			// for i
			while (i<j && a[++i]<= pivot);
			if (i<j) {
				a[j] = a[i];
			}
		}
		a[j] = pivot;
		return j;
	}

	static void quickSort (int[] a, int start, int end) {
		if (end-start < 2) {
			return;
		}
		// 
		int pi = partition (a, start, end);
		quickSort (a, start, pi);
		quickSort (a, pi+1, end);
	}

	public static void main(String args []) {
			int[] array = {20, 35, -15, 7, 55, 1, -22};
			quickSort(array, 0, 7);
			for (int i=0; i<array.length; i++) {
				System.out.println(array[i]);
			}
	}
}