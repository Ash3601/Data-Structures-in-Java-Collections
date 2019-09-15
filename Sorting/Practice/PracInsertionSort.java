class PracInsertionSort{
	static void insertionSort(int [] a)  {
		for (int firstUnsortedArray = 1; firstUnsortedArray<a.length; firstUnsortedArray++) {
			int newElement = a[firstUnsortedArray];
			int i;
			for (i=firstUnsortedArray; i>0 && a[i-1]>newElement; i--) {
				a[i] = a[i-1];
			}
			a[i] = newElement;
		}
	}
	public static void main (String args[]) {
		int[] array = {2, -1, 4, 3, 5};
		insertionSort(array);
		for (int i=0; i<array.length; i++) {
			System.out.println(array[i]);
		}
	}
}