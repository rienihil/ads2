import java.util.Arrays;
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
        size++;
        if(size>=arr.length){
            increaseBuffer();
        }
        arr[size-1] = (T) item;
    }

    // increases space for elements
    private void increaseBuffer(){
        T[] newArr = (T[]) new Object[arr.length*2];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        arr=newArr;
    }

    //throws exception if index is wrong
    private void checkIndex(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("index not correct");
        }
    }

    // changes value at the index
    @Override
    public void set(T item, int index) {
        checkIndex(index);
        arr[index]=item;
    }

    // adds element in any place
    @Override
    public void add(T item, int index) {
        size++;
        if(size>=arr.length){
            increaseBuffer();
        }
        for (int i=size-1; i>index; i--){
            arr[i]=arr[i-1];
        }
        set(item, index);
    }

    // adds element to the beginning
    @Override
    public void addFirst(T item) {
        size++;
        if(size>=arr.length){
            increaseBuffer();
        }
        for (int i=size-1; i>0; i--){
            arr[i]=arr[i-1];
        }
        set(item, 0);
    }

    @Override
    public T get(int index) {
        return arr[index];
    }

    @Override
    public T getFirst() {
        return arr[0];
    }

    @Override
    public T getLast() {
        return arr[size-1];
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        for (int i=index; i<size; i++){
            arr[i]=arr[i+1];
        }
        removeLast();
    }

    @Override
    public void removeFirst() {
        for (int i=0; i<size; i++){
            arr[i]=arr[i+1];
        }
        removeLast();
    }

    @Override
    public void removeLast() {
        arr[size-1]=null;
        size--;
    }

    @Override
    public void sort() {

    }

    @Override
    public int indexOf(Object object) {
        int res=-1;
        for (int i=0; i<size; i++){
            if (arr[i]==object){
                res=i;
                break;
            }
        }
        return res;
    }

    @Override
    public int lastIndexOf(Object object) {
        int res=-1;
        for (int i=size-1; i>0; i--){
            if (arr[i]==object){
                res=i;
                break;
            }
        }
        return res;
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
        arr = (T[]) new Object[5];
        size=0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    public void print(){
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print('\n');
    }
}