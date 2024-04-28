public class Mergesort {
    public static void main(String[] args) {
		 // initialize the array to sort (16 randomized values)
        int[] arr = new int[16];
        for (int i = 0; i < arr.length; i++) {
        	arr[i] = (int)(Math.random() * 100);
        }
        // initialize the low index
        int low = 0;
        // initialize the high index
        int high = arr.length - 1;
		System.out.println("Initial array:");
	    printArray(arr);        
        System.out.println();            
        // mergeSort the array from lowest index to highest index
	    mergeSort(arr, low, high);
        System.out.println();   
	    System.out.println("Sorted array:");
        // print the final sorted array 
	    printArray(arr);	
	}

    public static void mergeSort(int arr[], int left, int right) {
        if (left < right) {
            // calculate the middle index of arr
            int mid = (left + right) / 2;
            System.out.println("mergeSort on " + left + " to " + right);
            // mergeSort left half of arr
            mergeSort(arr, left, mid);
            // mergeSort right half of arr
            mergeSort(arr, mid + 1, right);
            // merge the two split arrays together
            merge(arr, left, mid, right);
        }
    }
	
	// modular
	public static void printArray(int arr[]) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    
	public static void merge(int arr[], int low, int mid, int high) {
        // initialize the size of left half to arr
		int ln1 = mid - low + 1;
        // initialize the size of right half to arr
        int ln2 = high - mid;
        // initialize the subarray for left half of arr
        int left[] = new int[ln1]; 
        // initialize the subarray for right half of arr
        int right[] = new int[ln2];
        // fill the left half subarray with arr values
        for (int i = 0; i < ln1; i++) 
            left[i] = arr[low + i];
        // fill the right half subarray with arr values
        for (int k = 0; k < ln2; k++) 
            right[k] = arr[mid + 1 + k];
        // index for left array
        int i = 0; 
        // index for right array 
        int k = 0;
        // index for the complete array 
        int j = low;
        // merge the two subarrays back into the main array 
        while (i < ln1 && k < ln2) {
            // compare elements from the left and right subarrays
            if (left[i] <= right[k]) {
                // fill the element in the left array to the main array
                arr[j] = left[i];
                i++;
            } else {
                // fill the element in the right array to the main array
                arr[j] = right[k];
                k++;
            }
            // increment the main array index
            j++;
        } 
        // fill the remaining elements into the left subarray 
        while (i < ln1) {
            arr[j] = left[i];
            i++;
            j++;
        }
        // fill the remaining elements into the right subarray 
        while (k < ln2) {
            arr[j] = right[k];
            k++;
            j++;
        }
        System.out.print("\nMerging " + low + ", " + mid + ", " + high + "\nAfter merging: ");
        printArray(arr);
        System.out.println();
    }
}
