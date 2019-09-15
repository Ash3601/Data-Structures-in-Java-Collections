import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


class BucketSort {
	public static void main(String args[]) {
		int [] a = {56, 46, 83, 66, 95, 92, 43};
		bucketSort(a);
		for (int item : a){
			System.out.println(item);
		}
	}

	public static void bucketSort(int[] input) {
		// create buckets 
		// we created 10 buckets since we only have values from 
		// 0 to 9
		List<Integer>[] buckets = new List[10];

		// create buckets backed by array
		for (int i=0; i<buckets.length; i++) {
			buckets[i] = new ArrayList<Integer>();
		}

		// NOTE : In putting the values into the bucket make sure that 
		// the buckets those are ahead of the other ones should 
		// contain all the lower values
		// lets add the hashed value into the bucket		
		for (int i=0; i<input.length; i++) {
			int hashedIndex = hashKey(input[i]);
			buckets[hashedIndex].add(input[i]);
		}

		// lets sort these buckets 
		for (List bucket : buckets) {
			Collections.sort(bucket);
		}

		// now copy and thus merge all these sorted values
		int k = 0;
		for (int i=0; i<buckets.length; i++) {
			// for (int j=0; j<buckets[i].size(); j++){
			// 	input[k++] = buckets[i].get(j);
			// }
			for (int value : buckets[i]){
				input[k++] = value;
			}
		}
	}

	private static int hashKey(int key) {
		return key / (int)10;
	}
}