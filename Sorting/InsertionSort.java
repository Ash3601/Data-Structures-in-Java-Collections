class InsertionSort {
	static void insertionSort (int [] a ) {
		for (int firstunsortedIndex=1; firstunsortedIndex<a.length; firstunsortedIndex++){
			int newElement = a[firstunsortedIndex];
			int i;
			for (i = firstunsortedIndex; i>0 && a[i-1]>newElement; i--) {
				a[i] = a[i-1];
			}
			a[i] = newElement;
		}
	}
	public static void main (String args []) {
		int[] array = {20, 35, -15, 7, 55, 1, -22};
		insertionSort(array);
		for (int i=0; i<array.length; i++) {
			System.out.println(array[i]);
		}
	}
}