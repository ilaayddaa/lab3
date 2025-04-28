package aod.lab3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;


public class SortableListTest {

	@Test
	public void testBubbleSort() {
		SortableList<Integer> list = new SortableList<>();
		list.add(5);
		list.add(2);
		list.add(8);
		list.add(1);
		list.bubbleSort();
		assertEquals(Arrays.asList(1, 2, 5, 8), list.getStorage());
	}

	@Test
	public void testInsertionSort() {
		SortableList<Integer> list = new SortableList<>();
		list.add(3);
		list.add(1);
		list.add(4);
		list.add(2);
		list.insertionSort();
		assertEquals(Arrays.asList(1, 2, 3, 4), list.getStorage());
	}

	@Test
	public void testMergeSort() {
		SortableList<Integer> list = new SortableList<>();
		list.add(9);
		list.add(7);
		list.add(5);
		list.add(3);
		list.mergeSort();
		assertEquals(Arrays.asList(3, 5, 7, 9), list.getStorage());
	}

	@Test
	public void testQuickSort() {
		SortableList<Integer> list = new SortableList<>();
		list.add(4);
		list.add(10);
		list.add(6);
		list.add(2);
		list.quickSort();
		assertEquals(Arrays.asList(2, 4, 6, 10), list.getStorage());
	}
}
