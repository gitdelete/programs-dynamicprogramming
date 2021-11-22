
public class KthSmallestElementInArray
    {
        int[] harr; // pointer to array of elements in heap
        int capacity; // maximum possible size of min heap
        int heap_size; // Current number of elements in min heap

        int parent(int i) { return (i - 1) / 2; }
        int left(int i) { return ((2 * i )+ 1); }
        int right(int i) { return ((2 * i) + 2); }
        int getMin() { return harr[0]; } // Returns minimum

        // to replace root with new node x and heapify() new root
        void replaceMax(int x)
        {
            this.harr[0] = x;
            minHeapify(0);
        }
        KthSmallestElementInArray(int a[], int size)
        {
            heap_size = size;
            harr = a; // store address of array
            int i = (heap_size - 1) / 2;
            while (i >= 0)
            {
                minHeapify(i);
                i--;
            }
        }

        // Method to remove maximum element (or root) from min heap
        int extractMin()
        {
            if (heap_size == 0)
                return Integer.MAX_VALUE;

            int root = harr[0];

            if (heap_size > 1)
            {
                harr[0] = harr[heap_size - 1];
                minHeapify(0);
            }
            heap_size--;
            return root;
        }


        void minHeapify(int i)
        {
            int l = left(i);
            int r = right(i);
            int smallest = i;
            if (l < heap_size && harr[l] < harr[i])
                smallest = l;
            if (r < heap_size && harr[r] < harr[smallest])
                smallest = r;
            if (smallest != i)
            {
                int t = harr[i];
                harr[i] = harr[smallest];
                harr[smallest] = t;
                minHeapify(smallest);
            }
        }
    // Function to return k'th largest element in a given array
    int kthSmallest(int arr[], int n, int k)
    {

        for (int i = 0; i < k - 1; i++)
            extractMin();

        // Return root
        return getMin();
    }

    // Driver program to test above methods
    public static void main(String[] args)
    {
        int arr[] = {1,23,45,34,2,9,6,14,18,11, 12, 3, 5, 7, 19 };
        int n = arr.length, k = 6;
        KthSmallestElementInArray find = new KthSmallestElementInArray(arr,n);
        System.out.print("K'th smallest element is " +
        find.kthSmallest(arr, n, k));
    }
}