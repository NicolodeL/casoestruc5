package GestionInformacion;

public class OrganizacionDocumentos<T extends Comparable<T>> {

    public void sort(T[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(T[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private int partition(T[] array, int low, int high) {
        T pivot = array[low];
        int left = low + 1;
        int right = high;
        while (true) {
            while (left <= right && array[left].compareTo(pivot) <= 0) {
                left++;
            }
            while (left <= right && array[right].compareTo(pivot) > 0) {
                right--;
            }
            if (left <= right) {
                swap(array, left, right);
            } else {
                swap(array, low, right);
                return right;
            }
        }
    }

    private void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}