package mergeSortUsingCallables;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class MergeSort implements Callable<List<Integer>> {

    private final List<Integer> array;
    private final ExecutorService executorService;

    public MergeSort(List<Integer> array, ExecutorService executorService){
        this.array = array;
        this.executorService = executorService;
    }

    @Override
    public List<Integer> call() throws Exception {

        if(array.size()<=1) return array;

        int mid = array.size()/2;
        List<Integer> leftArray = new ArrayList<Integer>();
        List<Integer> rightArray = new ArrayList<Integer>();

        for(int i=0; i< mid; i++){
            leftArray.add(array.get(i));
        }

        for(int i=mid; i< array.size(); i++){
            rightArray.add(array.get(i));
        }

        MergeSort leftMergeSort = new MergeSort(leftArray, executorService);
        MergeSort rightMergeSort = new MergeSort(rightArray, executorService);

        Future<List<Integer>> leftSortedArrayFuture = executorService.submit(leftMergeSort);
        Future<List<Integer>> rightSortedArrayFuture = executorService.submit(rightMergeSort);

        List<Integer> leftSortedArray = leftSortedArrayFuture.get();
        List<Integer> rightSortedArray = rightSortedArrayFuture.get();


        return mergeArray(leftSortedArray, rightSortedArray);
    }

    private List<Integer> mergeArray(List<Integer> leftSortedArray, List<Integer> rightSortedArray){
        int i=0, j=0;
        List<Integer> mergedArray = new ArrayList<Integer>();

        while (i < leftSortedArray.size() && j < rightSortedArray.size()) {
            if (leftSortedArray.get(i) <= rightSortedArray.get(j)) {
                mergedArray.add(leftSortedArray.get(i));
                i++;
            } else {
                mergedArray.add(rightSortedArray.get(j));
                j++;
            }
        }

        while (i < leftSortedArray.size()) {
            mergedArray.add(leftSortedArray.get(i));
            i++;
        }

        while (j < rightSortedArray.size()) {
            mergedArray.add(rightSortedArray.get(j));
            j++;
        }

        return mergedArray;
    }
}
