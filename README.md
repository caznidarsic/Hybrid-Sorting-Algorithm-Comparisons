# Hybrid Sorting Algorithm Comparisons
 A program that implements various sorting algorithms. Files with analysis of their performance is included. Sorting algorithms written include MergeSort, and four variations of QuickSort. These four variations are as follows:
 

QuickSort_LowPivot: Perform QuickSort using the first value from the input array as the pivot.

QuickSort_LowPivot_Insertion_50: Perform QuickSort using the first value from the input array as the pivot and do InsertionSort for partitions size 50 or less.

QuickSort_LowPivot_Insertion_100: Perform QuickSort using the first value from the input array as the pivot and do InsertionSort for partitions size 100 or less.

QuickSort_MedianThree: Perform QuickSort using the median of the first, middle and last elements from the input array as the pivot.


These various sorting algorithms are given various inputs (lists in already sorted order, reverse sorted order, random order etc.) and their runtimes are compared. Runtimes are generalized as the number of recursive calls made by the function.
