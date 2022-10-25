package me.caribeedu.unibh.edaa.ordenacao2;

/**
 *
 * @author Edu Caribé
 */
public class MergeSort {
    public static int[] sort(int[] items) {
        if (items == null)
            return new int[0];
        else if (items.length < 2)
            return items;
        
        mergeSort(items, 0, items.length - 1);
        
        return items;
    }
    
    private static void mergeSort(int[] items, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex)
            return;
        
        if ((rightIndex - leftIndex) > 500) {
            int midIndex = (leftIndex + rightIndex) / 2;

            mergeSort(items, leftIndex, midIndex);
            mergeSort(items, midIndex + 1, rightIndex);

            merge(items, leftIndex, midIndex, rightIndex);
        }
        else {
            items = InsertionSort.sort(items, leftIndex, rightIndex);
        }
    }
    
    private static void merge(int[] items, int leftIndex, int midIndex, int rightIndex) {
        int sizeFirstSubArray = midIndex - leftIndex + 1;
        int sizeSecondSubArray = rightIndex - midIndex;

        int[] firstSubArray = new int[sizeFirstSubArray];
        int[] secondSubArray = new int[sizeSecondSubArray];

        System.arraycopy(items, leftIndex, firstSubArray, 0, sizeFirstSubArray);
        System.arraycopy(items, midIndex + 1, secondSubArray, 0, sizeSecondSubArray);

        int indexFirstArr = 0;
        int indexSecondArr = 0;

        int indexMergedArray = leftIndex;

        while(indexFirstArr < sizeFirstSubArray && indexSecondArr < sizeSecondSubArray) {
            if (firstSubArray[indexFirstArr] <= secondSubArray[indexSecondArr]) {
                items[indexMergedArray] = firstSubArray[indexFirstArr];
                indexFirstArr++;
            }
            else {
                items[indexMergedArray] = secondSubArray[indexSecondArr];
                indexSecondArr++;
            }
            
            indexMergedArray++;
        }
        
        while (indexFirstArr < sizeFirstSubArray) {
            items[indexMergedArray] = firstSubArray[indexFirstArr];
            indexFirstArr++;
            indexMergedArray++;
        }
        
        while (indexSecondArr < sizeSecondSubArray) {
            items[indexMergedArray] = secondSubArray[indexSecondArr];
            indexSecondArr++;
            indexMergedArray++;
        }
    }
}