import java.util.Iterator;

public class MyMinHeap<T extends Comparable<T>> implements Iterable<T> {
    private MyArrayList<T> list;

    public MyMinHeap() {
        list = new MyArrayList<T>();
    }

    public void add(T item) {
        list.add(item);
        int index = list.size() - 1;
        while (index > 0 && list.get(parent(index)).compareTo(list.get(index)) > 0) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    public T removeMin() {
        if (list.size() == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        T min = list.get(0);
        int lastIndex = list.size() - 1;
        list.set(list.get(lastIndex),0);
        list.remove(lastIndex);
        int index = 0;
        while (true) {
            int leftChildIndex = leftChild(index);
            int rightChildIndex = rightChild(index);
            int minIndex = index;
            if (leftChildIndex < list.size() && list.get(leftChildIndex).compareTo(list.get(minIndex)) < 0) {
                minIndex = leftChildIndex;
            }
            if (rightChildIndex < list.size() && list.get(rightChildIndex).compareTo(list.get(minIndex)) < 0) {
                minIndex = rightChildIndex;
            }
            if (minIndex == index) {
                break;
            }
            swap(index, minIndex);
            index = minIndex;
        }
        return min;
    }

    public T getMin() {
        if (empty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return list.get(0);
    }

    public boolean empty() {
        return list.size() == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    private int parent(int index) {
        return (index-1)/2;
    }

    private int leftChild(int index) {
        return 2*index+1;
    }

    private int rightChild(int index) {
        return 2*index+2;
    }

    private void swap(int i, int j) {
        T temp = list.get(i);
        list.set(list.get(j), i);
        list.set(temp, j);
    }
}