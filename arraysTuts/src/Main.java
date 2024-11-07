
public class Main {

    private static int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int value = array[mid];

            if (value < target)
                low = mid + 1;
            else if (value > target)
                high = mid - 1;
            else return mid;
        }

        return -1;
    }

    private static int interpolationSearch(int[] array, int target) {

        int high = array.length - 1;
        int low = 0;

        while(target >= array[low] && target <= array[high] && low <= high) {
            // formula to guess
            int probe = (high - low) * (target - array[low]) / (array[high] - array[low]);

            System.out.println("Probe " + probe);

            if (array[probe] == target) {
                return probe;
            } else if (array[probe] < target) {
                low = probe + 1;
            } else {
                high = probe - 1;
            }
        }

        return -1;
    }

    private static void bubbleSort(int[] array) {
        for (int i=0;i<array.length-1;i++) {
            for (int j=0;j<array.length - i - 1;j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

//        int[] arr = new int[100];
        int[] arr = {9 , 8 , 4 , 10 , 1 , 3 , 2 ,12, 5};

        bubbleSort(arr);

        for (int i : arr) {
            System.out.println(arr[i] + " ");
        }
//        int index = binarySearch(arr, target);
//        int index = interpolationSearch(arr, 8);

    }
}