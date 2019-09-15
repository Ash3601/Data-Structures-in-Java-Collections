class PracSelectionSort {

	static void swap (int [] a, int i, int j) {
		if (i == j) 
			return;
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	static void selectionSort (int [] a) {
		for (int unsortedArray = a.length-1; unsortedArray>0; unsortedArray--) {
			int largest_idx = 0;
			for (int i=1; i<=unsortedArray; i++) {
				if (a[i] > a[largest_idx]) {
					largest_idx = i;
				}
			}
			swap(a, largest_idx, unsortedArray);
		}
	}
	public static void main(String args[]) {
		int [] a = {3,1,4,2,5};
		selectionSort(a);
		for (int i : a) {
			System.out.println(i);
		}
	}
}