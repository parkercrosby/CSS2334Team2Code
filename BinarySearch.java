
public class BinarySearch 
{

    public static int binarySearchRecursive(int[] arr, int target, int low, int high)
    {
        if (low > high) 
        {
            return -1;
        }
        int mid = (low + high) / 2;
        if (arr[mid] == target) 
        {
            return mid;
        } else if (arr[mid] < target) {
        	
            return binarySearchRecursive(arr, target, mid + 1, high);
            
        } else {
        	
            return binarySearchRecursive(arr, target, low, mid - 1);
        }
    }

    public static int binarySearchIterative(int[] arr, int target) 
    {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) 
            {
                return mid;
            } else if (arr[mid] < target) {
            	
                low = mid + 1;
                
            } else {
            	
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) 
    {
        int[] inputSizes = {5000, 10000, 30000, 50000, 70000, 100000};
        int runs = 10;

        for (int size : inputSizes) 
        {
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) 
            {
                arr[i] = i * 2;
            }
            int target = arr[size / 2];

            // recursive timing
            long recursiveTotal = 0;
            boolean overflow = false;
            for (int i = 0; i < runs; i++) 
            {
                try 
                {
                    long start = System.nanoTime();
                    binarySearchRecursive(arr, target, 0, arr.length - 1);
                    long end = System.nanoTime();
                    recursiveTotal += (end - start);
                } catch (StackOverflowError e) {
                	
                    overflow = true;
                    break;
                }
            }

            // iterative timing
            long iterativeTotal = 0;
            for (int i = 0; i < runs; i++) 
            {
                long start = System.nanoTime();
                binarySearchIterative(arr, target);
                long end = System.nanoTime();
                iterativeTotal += (end - start);
            }

            long recursiveAvg;
            if (overflow) 
            {
                recursiveAvg = -1;
            } else {
            	
                recursiveAvg = recursiveTotal / runs;
            }
            long iterativeAvg = iterativeTotal / runs;

            System.out.println("Size: " + size);
            if (overflow) 
            {
                System.out.println("Recursive: STACKOVERFLOW");
            } else {
            	
                System.out.println("Recursive: " + recursiveAvg + " ns");
            }
            System.out.println("Iterative: " + iterativeAvg + " ns");
            System.out.println();
        }
    }
}