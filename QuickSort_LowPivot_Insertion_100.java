/* Christian Znidarsic
 * Lab 4
 * EN.605.202.86.SP22 Data Structures
 * 
 * The QuickSort_LowPivot_Insertion_100 class.
 * 
 * 	That's a mouthful. This class performs a quicksort
 * using the lowest element in the input array as the pivot,
 * and uses an insertion sort on partitions less than or equal to
 * 100 elements long.
 *  */

public class QuickSort_LowPivot_Insertion_100 {
	public int comparisons = 0;
	public int swaps = 0;
	
	
	/*
	 * The quickSort method takes an unsorted array as input
	 * and sorts it recursively. It calls insertionSort
	 * for partitions less than or equal to 100 items. It
	 * calls partition() to partition the list.
	 */
	public void quickSort(int[] arr, int low, int high) {
		comparisons++;
		if (low < high) {
			
			// pi is partitioning index, arr[p]
			// is now at right place
			int pi = partition(arr, low, high);
		
			// Separately sort elements before
			// partition and after partition
			
			// if the lower partition size is greater than 100, then sort with quickSort
			comparisons++;
			if (pi - 1 - low > 100) {
				quickSort(arr, low, pi - 1);
			}
			// else, sort with insertionSort
			else {
				insertionSort(arr, low, pi - 1);
			}
			
			// if the upper partition size is greater than 100, then sort with quickSort
			comparisons++;
			if (high - (pi + 1) > 100) {
				quickSort(arr, pi + 1, high);
			}
			else {
				insertionSort(arr, pi + 1, high);
			}
		}
	}

	// this method performs an insertion sort on the input array.
	private void insertionSort(int[] arr, int low, int high) {
		int j;
		int temp;
		for (int i = low + 1; i <= high; i++) {
			j = i;
			while (j > 0 && arr[j] < arr[j - 1]) {
				comparisons ++;
				temp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = temp;
				--j;
			}
			
		}
	}
	
	
		
	
	/* This function takes last element as pivot, places
	the pivot element at its correct position in sorted
	array, and places all smaller (smaller than pivot)
	to left of pivot and all greater elements to right
	of pivot */
	
	// returns 
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
