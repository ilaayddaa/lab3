package aod.lab3;

import java.util.ArrayList;
import java.util.List;

public class SortableList<T extends Comparable<? super T>> {
    private List<T> storage;

    public SortableList() {
        this.storage = new ArrayList<>();
    }

    public void add(T item) {
        storage.add(item);
    }

    public T get(int index) {
        return storage.get(index);
    }

    public int size() {
        return storage.size();
    }

    public void clear() {
        storage.clear();
    }

    public List<T> getStorage() {
        return storage;
    }

    // Bubble Sort
    public void bubbleSort() {
        boolean swapped;
        int n = storage.size();
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (storage.get(i).compareTo(storage.get(i + 1)) > 0) {
                    T temp = storage.get(i);
                    storage.set(i, storage.get(i + 1));
                    storage.set(i + 1, temp);
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }

    // Insertion Sort
    public void insertionSort() {
        for (int i = 1; i < storage.size(); i++) {
            T key = storage.get(i);
            int j = i - 1;
            while (j >= 0 && storage.get(j).compareTo(key) > 0) {
                storage.set(j + 1, storage.get(j));
                j--;
            }
            storage.set(j + 1, key);
        }
    }

    // Merge Sort
    public void mergeSort() {
        storage = mergeSortHelper(storage);
    }

    private List<T> mergeSortHelper(List<T> list) {
        if (list.size() <= 1) return list;

        int mid = list.size() / 2;
        List<T> left = mergeSortHelper(new ArrayList<>(list.subList(0, mid)));
        List<T> right = mergeSortHelper(new ArrayList<>(list.subList(mid, list.size())));

        return merge(left, right);
    }

    private List<T> merge(List<T> left, List<T> right) {
        List<T> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).compareTo(right.get(j)) <= 0) {
                result.add(left.get(i++));
            } else {
                result.add(right.get(j++));
            }
        }

        result.addAll(left.subList(i, left.size()));
        result.addAll(right.subList(j, right.size()));
        return result;
    }

    // Quick Sort
    public void quickSort() {
        quickSortHelper(0, storage.size() - 1);
    }

    private void quickSortHelper(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            quickSortHelper(low, pi - 1);
            quickSortHelper(pi + 1, high);
        }
    }

    private int partition(int low, int high) {
        T pivot = storage.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (storage.get(j).compareTo(pivot) < 0) {
                i++;
                T temp = storage.get(i);
                storage.set(i, storage.get(j));
                storage.set(j, temp);
            }
        }
        T temp = storage.get(i + 1);
        storage.set(i + 1, storage.get(high));
        storage.set(high, temp);
        return i + 1;
    }
}
