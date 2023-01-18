/* Christian Znidarsic
 * Lab 4
 * EN.605.202.86.SP22 Data Structures
 * 
 * The Main Class.
 * 
 * 	Main is the driver class of this project. It reads input files
 * and sorts the data that is read in. */

import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		// holds file names for the small input files
		String[] fileNames50 = {"random_50.txt", "reverse_50.txt", "ascending_50.txt"};
		
		// holds file names for the large input files
		String[] fileNamesLarge = {"random_1000.txt", "reverse_1000.txt", "ascending_1000.txt", 
											"random_2000.txt", "reverse_2000.txt", "ascending_2000.txt", 
											"random_5000.txt", "reverse_5000.txt", "ascending_5000.txt", 
											"random_10000.txt", "reverse_10000.txt", "ascending_10000.txt"};
		
		// holds input lengths. To be iterated through in main.
		int[] lenArray = {1000, 1000, 1000, 2000, 2000, 2000, 5000, 5000, 5000, 10000, 10000, 10000};
		
		
		
		// sorting the small size 50 files:
		
		for (int i = 0; i < 3; i++) {
			
			String inString = "";
			int inVal;
			int[] inputArray = new int[50];
			
			File inputFile = new File(fileNames50[i]);
			
			FileReader fr = new FileReader(inputFile);
			
			//create bufferedReader object
			BufferedReader br = new BufferedReader(fr);
			
			int c = 0;
			int inputArrayIndex = 0;
			
			//iterate through whole .txt file
			while((c = br.read()) != -1) {
				
				char character = (char) c;
				
				if (Character.isDigit(character)) {
					inString += Character.toString(character);
				}
				else if (character == '\n') {
					inVal = Integer.parseInt(inString);
					inputArray[inputArrayIndex] = inVal;
					
					// reset inString
					inString = "";
					
					inputArrayIndex++;
				}
				
				
			}

			br.close();
			

			/* 
			 * CREATE 5 COPIES OF inputArray
			 */
			int[] inputArray1 = new int[inputArray.length];
			for (int x = 0; x < inputArray.length; x++) {
				inputArray1[x] = inputArray[x];
			}
			
			int[] inputArray2 = new int[inputArray.length];
			for (int x = 0; x < inputArray.length; x++) {
				inputArray2[x] = inputArray[x];
			}
			
			int[] inputArray3 = new int[inputArray.length];
			for (int x = 0; x < inputArray.length; x++) {
				inputArray3[x] = inputArray[x];
			}
			
			int[] inputArray4 = new int[inputArray.length];
			for (int x = 0; x < inputArray.length; x++) {
				inputArray4[x] = inputArray[x];
			}
			
			int[] inputArray5 = new int[inputArray.length];
			for (int x = 0; x < inputArray.length; x++) {
				inputArray5[x] = inputArray[x];
			}

			

			
			/* 
			 * SORT THE INPUT ARRAY USING ALL SORTS:
			 */
			
			// quicksort median three
			PrintWriter outputFile_med_three = new PrintWriter ("output_medThree_" + fileNames50[i]);
			
			// call to printUnsorted method to print the unsorted input to the output file
			printUnsorted(inputArray1, outputFile_med_three);
			
			QuickSort_MedianThree sortObject_med_three = new QuickSort_MedianThree();
			
			// sort the input
			sortObject_med_three.quickSort(inputArray1, 0, inputArray1.length - 1);
			
			printSorted(inputArray1, sortObject_med_three, outputFile_med_three);
			
			
			
			
			// quicksort low pivot (insertion sort for partitions size 100 or less)
			PrintWriter outputFile_low_100 = new PrintWriter ("output_low_100_" + fileNames50[i]);
			
			// print the unsorted array
			printUnsorted(inputArray2, outputFile_low_100);
			
			QuickSort_LowPivot_Insertion_100 sortObject_low_100 = new QuickSort_LowPivot_Insertion_100();
			
			// sort the input
			sortObject_low_100.quickSort(inputArray2, 0, inputArray2.length - 1);
			

			printSorted(inputArray2, sortObject_low_100, outputFile_low_100);
			

			
			
			// quicksort low pivot (insertion sort for partitions size 50 or less)
			PrintWriter outputFile_low_50 = new PrintWriter ("output_low_50_" + fileNames50[i]);
			
			// print the unsorted array
			printUnsorted(inputArray3, outputFile_low_50);
			
			QuickSort_LowPivot_Insertion_50 sortObject_low_50 = new QuickSort_LowPivot_Insertion_50();
			
			// sort the input	
			sortObject_low_50.quickSort(inputArray3, 0, inputArray3.length - 1);

			printSorted(inputArray3, sortObject_low_50, outputFile_low_50);
			
			
			
			// quicksort low pivot
			PrintWriter outputFile_low = new PrintWriter ("output_low_" + fileNames50[i]);
			
			// print the unsorted array
			printUnsorted(inputArray4, outputFile_low);
			
			QuickSort_LowPivot sortObject_low = new QuickSort_LowPivot();
			
			// sort the input
			sortObject_low.quickSort(inputArray4, 0, inputArray4.length - 1);

			printSorted(inputArray4, sortObject_low, outputFile_low);
			
			
			
			// natural merge sort
			PrintWriter outputFile_merge = new PrintWriter ("output_merge_" + fileNames50[i]);
			
			// print the unsorted array
			printUnsorted(inputArray5, outputFile_merge);
			
			linkedList li = new linkedList();
			
			for (int x = inputArray5.length - 1; x >= 0; x--) {
	      	li.push(inputArray5[x]);
	      }
			
			MergeSort sortObject_merge = new MergeSort();
			
			// sort the input
			li.head = sortObject_merge.mergeSort(li.head).nodeVal;
	      
	      printSorted(li, sortObject_merge, outputFile_merge);
			
			
		}
		
		
		
		
		
		

		
		
		
		
		
		// sort the large files
		
		// counter used to iterate through input size array. 
		// used to determine how much memory to allocate for
		// the arrays.
		int lengthCounter = 0;
		for (int i = 0; i < 12; i++) {
			
			String inString = "";
			int inVal;
			
			int[] inputArray = new int[lenArray[lengthCounter]];
			
			File inputFile = new File(fileNamesLarge[i]);
			
			FileReader fr = new FileReader(inputFile);
			
			//create bufferedReader object
			BufferedReader br = new BufferedReader(fr);
			
			int c = 0;
			int inputArrayIndex = 0;
			
			//iterate through whole .txt file
			while((c = br.read()) != -1) {
				
				char character = (char) c;
				
				if (Character.isDigit(character)) {
					inString += Character.toString(character);
				}
				else if (character == '\n') {
					inVal = Integer.parseInt(inString);
					inputArray[inputArrayIndex] = inVal;
					
					// reset inString
					inString = "";
					
					inputArrayIndex++;
				}
				
				
			}

			br.close();
			

			/* 
			 * CREATE 5 COPIES OF inputArray
			 */
			int[] inputArray1 = new int[inputArray.length];
			for (int x = 0; x < inputArray.length; x++) {
				inputArray1[x] = inputArray[x];
			}
			
			int[] inputArray2 = new int[inputArray.length];
			for (int x = 0; x < inputArray.length; x++) {
				inputArray2[x] = inputArray[x];
			}
			
			int[] inputArray3 = new int[inputArray.length];
			for (int x = 0; x < inputArray.length; x++) {
				inputArray3[x] = inputArray[x];
			}
			
			int[] inputArray4 = new int[inputArray.length];
			for (int x = 0; x < inputArray.length; x++) {
				inputArray4[x] = inputArray[x];
			}
			
			int[] inputArray5 = new int[inputArray.length];
			for (int x = 0; x < inputArray.length; x++) {
				inputArray5[x] = inputArray[x];
			}

			

			
			/* 
			 * SORT THE INPUT ARRAY USING ALL SORTS
			 */
			
			
			// natural merge sort
			PrintWriter outputFile_merge = new PrintWriter ("output_merge_" + fileNamesLarge[i]);
			
//			printUnsorted(inputArray5, outputFile_merge);
			
			linkedList li = new linkedList();
			
			for (int x = inputArray5.length - 1; x >= 0; x--) {
	      	li.push(inputArray5[x]);
	      }
			
			MergeSort sortObject_merge = new MergeSort();
			
			li.head = sortObject_merge.mergeSort(li.head).nodeVal;
	      
	      printVals(sortObject_merge, outputFile_merge);
			      
			      
			      
			// quicksort median three
			PrintWriter outputFile_med_three = new PrintWriter ("output_medThree_" + fileNamesLarge[i]);
			
			QuickSort_MedianThree sortObject_med_three = new QuickSort_MedianThree();
			
			sortObject_med_three.quickSort(inputArray1, 0, inputArray1.length - 1);
			
			printVals(sortObject_med_three, outputFile_med_three);
			
			
			
			
			// quicksort low pivot (insertion sort for partitions size 100 or less)
			PrintWriter outputFile_low_100 = new PrintWriter ("output_low_100_" + fileNamesLarge[i]);
			
			QuickSort_LowPivot_Insertion_100 sortObject_low_100 = new QuickSort_LowPivot_Insertion_100();
			
			sortObject_low_100.quickSort(inputArray2, 0, inputArray2.length - 1);
			

			printVals(sortObject_low_100, outputFile_low_100);
			

			
			
			// quicksort low pivot (insertion sort for partitions size 50 or less)
			PrintWriter outputFile_low_50 = new PrintWriter ("output_low_50_" + fileNamesLarge[i]);
			
			QuickSort_LowPivot_Insertion_50 sortObject_low_50 = new QuickSort_LowPivot_Insertion_50();
			
			sortObject_low_50.quickSort(inputArray3, 0, inputArray3.length - 1);

			printVals(sortObject_low_50, outputFile_low_50);
			
			
			
			// quicksort low pivot
			PrintWriter outputFile_low = new PrintWriter ("output_low_" + fileNamesLarge[i]);
			
			QuickSort_LowPivot sortObject_low = new QuickSort_LowPivot();
			
			sortObject_low.quickSort(inputArray4, 0, inputArray4.length - 1);

			printVals(sortObject_low, outputFile_low);

	      
	      
	      
	      lengthCounter++;
	      
		}


	}
	
	
	/*
	 * The printSorted methods take a sorted array, a sortObject and a printwriter
	 * object as input. They write to the printwriter objects using the sorted
	 * arrays and the sortObjects. There are five overloaded versions, each one
	 * takes a different sortObject type.
	 */
	private static void printSorted(int[] inputArray, QuickSort_MedianThree sortObject, PrintWriter output) {
		
		output.println("Sorted array: ");
		
		for (int x = 0; x < inputArray.length; x++) {
			output.print(inputArray[x] + " ");
		}
		
		output.println("\n");
		
		output.print("Number of comparisons: ");
		output.println(sortObject.comparisons);
		
		output.print("Number of swaps: ");
		output.println(sortObject.swaps);
		
		
		output.close();
		
	}
	
	private static void printSorted(int[] inputArray, QuickSort_LowPivot_Insertion_100 sortObject, PrintWriter output) {
		
		output.println("Sorted array: ");
		
		for (int x = 0; x < inputArray.length; x++) {
			output.print(inputArray[x] + " ");
		}
		
		output.println("\n");
		
		output.print("Number of comparisons: ");
		output.println(sortObject.comparisons);
		
		output.print("Number of swaps: ");
		output.println(sortObject.swaps);
		
		
		output.close();
		
	}

	private static void printSorted(int[] inputArray, QuickSort_LowPivot_Insertion_50 sortObject, PrintWriter output) {
		
		output.println("Sorted array: ");
		
		for (int x = 0; x < inputArray.length; x++) {
			output.print(inputArray[x] + " ");
		}
		
		output.println("\n");
		
		output.print("Number of comparisons: ");
		output.println(sortObject.comparisons);
		
		output.print("Number of swaps: ");
		output.println(sortObject.swaps);
		
		
		output.close();
		
	}

	private static void printSorted(int[] inputArray, QuickSort_LowPivot sortObject, PrintWriter output) {
		
		output.println("Sorted array: ");
		
		for (int x = 0; x < inputArray.length; x++) {
			output.print(inputArray[x] + " ");
		}
		
		output.println("\n");
		
		output.print("Number of comparisons: ");
		output.println(sortObject.comparisons);
		
		output.print("Number of swaps: ");
		output.println(sortObject.swaps);
		
		
		output.close();
		
	}
	
	private static void printSorted(linkedList inputList, MergeSort sortObject, PrintWriter output) {
		ListNode headref = inputList.head;
		
		output.println("Sorted array: ");
		
		while (headref != null) {
         output.print(headref.val + " ");
         headref = headref.next;
      }
		
		output.println("\n");
		
		output.print("Number of comparisons: ");
		output.println(sortObject.comparisons);
		
		output.print("Number of swaps: ");
		output.println(sortObject.swaps);
		
		
		output.close();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * The printVals methods are used for the large input files, because
	 * the large input files do not require input and output to be printed
	 * in addition to the swaps and comparisons. Thus, these methods only
	 * print swaps and comparisons.
	 */

private static void printVals(QuickSort_MedianThree sortObject, PrintWriter output) {
		
		output.print("Number of comparisons: ");
		output.println(sortObject.comparisons);
		
		output.print("Number of swaps: ");
		output.println(sortObject.swaps);
		
		
		output.close();
		
	}
	
	private static void printVals(QuickSort_LowPivot_Insertion_100 sortObject, PrintWriter output) {
		
		output.print("Number of comparisons: ");
		output.println(sortObject.comparisons);
		
		output.print("Number of swaps: ");
		output.println(sortObject.swaps);
		
		
		output.close();
		
	}

	private static void printVals(QuickSort_LowPivot_Insertion_50 sortObject, PrintWriter output) {
		
		output.print("Number of comparisons: ");
		output.println(sortObject.comparisons);
		
		output.print("Number of swaps: ");
		output.println(sortObject.swaps);
		
		
		output.close();
		
	}

	private static void printVals(QuickSort_LowPivot sortObject, PrintWriter output) {
		
		output.print("Number of comparisons: ");
		output.println(sortObject.comparisons);
		
		output.print("Number of swaps: ");
		output.println(sortObject.swaps);
		
		
		output.close();
		
	}
	
	private static void printVals(MergeSort sortObject, PrintWriter output) {
		
		output.print("Number of comparisons: ");
		output.println(sortObject.comparisons);
		
		output.print("Number of swaps: ");
		output.println(sortObject.swaps);
		
		
		output.close();
		
	}
	
	private static void printUnsorted(int[] input, PrintWriter output) {
		output.println("Unsorted array: ");
		// print the unsorted array
		for (int x = 0; x < input.length; x++) {
			output.print(input[x] + " ");
		}
		output.println("\n");
	}
	
	
	
	

}
