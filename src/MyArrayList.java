import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {
    private T[] arr = (T[]) new Object[5];
    private int size;

    public MyArrayList() {
        size = 0;
    }

    // adds element to the end
    @Override
    public void add(T item) {
        if(size>=arr.length){
            increaseBuffer();
        }
        arr[size++] = (T) item;
    }

    // increases space for elements
    private void increaseBuffer(){
        T[] newArr = (T[]) new Object[arr.length*2];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        arr=newArr;
    }

    private void checkIndex(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("index not correct");
        }
    }

    @Override
    public void set(T item, int index) {
        checkIndex(index);
        arr[index]=item;
    }

    @Override
    public void add(T item, int index) {
        for(int i = index+1; i<size-1; i++){
            arr[i+1]=arr[i];
        }
        add(item, index);
    }

    @Override
    public void addFirst(T item) {
        size++;
        if(size>=arr.length){
            increaseBuffer();
        }
        for (int i=0; i<size; i++){
            arr[i]=arr[i-1];
        }
        set(item, 0);
    }

    @Override
    public void addLast(T item) {

    }

    @Override
    public T get(int index) {
        return arr[index];
    }

    @Override
    public T getFirst() {
        return null;
    }

    @Override
    public T getLast() {
        return null;
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void removeFirst() {

    }

    @Override
    public void removeLast() {

    }

    @Override
    public void sort() {

    }

    @Override
    public int indexOf(Object object) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object object) {
        return 0;
    }

    @Override
    public boolean exists(Object object) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}