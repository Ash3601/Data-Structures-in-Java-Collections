class QuickSort2 {
	// partition method
	public static int partition(int [] a, int start, int end) {
		int i = start;
		int j = end;
		int pi = a[start];
		while (i < j) {
			while (a[--j]>=pi && i<j);
			if (i<j) {
				a[i] = a[j];
			}
			// --i since we assumed that pi is at its correct pos
			// means initial pos is sorted
			while (a[++i]<=pi && i<j);
			if (i<j) {
				a[j] = a[i];
			}
		}
		a[j] = pi;
		return j;
	}


	public static void quickSort(int[] a, int start, int end) {
		if (end - start > 1){
			int pi = partition(a, start, end);

			quickSort(a, start, pi);
			quickSort(a, pi+1, end);

		}
	}

	public static void main (String args[]) {
		int a[] = {2,1,3,4,5};
		quickSort(a, 0, 5);
		for (int i=0; i<a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
