/* Christian Znidarsic
 * Lab 4
 * EN.605.202.86.SP22 Data Structures
 * 
 * The QuickSort_MedianThree class.
 * 
 * 	This class performs a quicksort
 * using the lowest element in the input array as the pivot.
 *  */

public class QuickSort_MedianThree {
	public int comparisons = 0;
	public int swaps = 0;
	
	
	
	/*
	 * The quickSort method takes an unsorted array as input
	 * and sorts it recursively. It calls medThreePartition()
	 * to determine the pivot. It
	 * calls partition() to partition the list.
	 */
	public void quickSort(int[] arr, int low, int high) {
		comparisons++;
		if (low < high) {
			int pi;
			// pi is partitioning index, arr[p]
			// is now at right place
			
			// if partition is larger than 2 items, then use median of three pivot
			comparisons++;
			if (high - low > 1) {
				pi = medThreePartition(arr, low, high);
				quickSort(arr, low, pi);
				quickSort(arr, pi + 1, high);
			}
			// else if partition is 1 or 2 items, then use low pivot
			else {
				pi = partition(arr, low, high);
				quickSort(arr, low, pi - 1);
				quickSort(arr, pi + 1, high);
			}
		}
	}
	
	
		
	

	
	/*
	 * This method takes the first, middle and last elements
	 * of the input array. It sorts them from least to greatest.
	 * It then returns the middle value as the pivot, because
	 * this elements is necessarily the median of the three.
	 */
	private int medThreePartition(int[] arr, int low, int high) {
		boolean done = false;
		// calls medianThree() to determine the median of the three items
		int pivot = medianThree(arr, low, high);
		// Index of smaller element and
		// indicates the right position
		// of pivot found so far
		
		while (!done) {
			comparisons++;
			while (arr[low] < pivot) {
				comparisons++;
				low++;
			}
			comparisons++;
			while (pivot < arr[high]) {
				comparisons++;
				high--;
			}
			
			comparisons++;
			if (low >= high) {
				done = true;
			}
			else {
				swap(arr, low, high);
				low++;
				high--;
			}
		}

		return (high);	
		
	}
	
	
	/*
	 * This method partitions the input array.
	 */
	private int partition(int[] arr, int low, int high) {
		
		// pivot
		int pivot = arr[low];
		
		// Index of smaller element and
		// indicates the right position
		// of pivot found so far
		int i = (low);
	
		for(int j = low + 1; j <= high; j++) {
			
			// If current element is smaller
			// than the pivot
			comparisons++;
			if (arr[j] < pivot) {
				
				// Increment index of
				// smaller element
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i, low);
		return (i);
	}
	
	
	/* 
	 * Sorts first, middle and last element in the partition.
	 * Returns the middle because it is the median.
	 */
	private int medianThree(int[] arr, int low, int high) {
		int mid = (low + high) / 2;
		comparisons++;
		if (arr[high] < arr[low]) {
			swap(arr, low, high);
		}
		comparisons++;
		if (arr[mid] < arr[low]) {
			swap(arr, mid, low);
		}
		comparisons++;
		if (arr[high] < arr[mid]) {
			swap(arr, high, mid);
		}
		return arr[mid];
	}
	
	
	
	// A utility function to swap two elements
	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
		swaps++;
	}
	
	
	
	
	// Function to print an array
	public void printArray(int[] arr, int size) {
		for(int i = 0; i < size; i++)
			System.out.print(arr[i] + " ");
			
		System.out.println();
	}
	
	
}
