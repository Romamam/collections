package collections;

import interfaces.MyCollection;

public class MyArrayList<T> implements MyCollection<T> {
    private Object[] array;
    private int size;


    public MyArrayList(){
        array = new Object[10];
        size = 0;
    }
    @Override
    public boolean add(T element) {
        if(size == array.length) {
            increaseCapacity();
        }
        array[size] = element;
        size++;
        return true;
    }

    private void increaseCapacity() {
        int newCapacity = array.length * 2; // Збільшення розміру масиву удвічі
        Object[] newArray = new Object[newCapacity];

        // Копіювання елементів зі старого масиву до нового
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }

        array = newArray; // Переназначення посилання на новий масив
    }

    @Override
    public boolean remove(T element) {
        for(int i = 0; i < array.length; i++){
            if(array[i].equals(element)){
                for(int k = i; k < array.length-1; k++){
                    array[k] = array[k+1];
                }
                array[size - 1] = null;
                size--;
                return true;
            }
            else return false;
        }
        return false;
    }

    @Override
    public boolean contains(T element) {
        for(int i = 0; i < array.length; i++){
            if(array[i].equals(element)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(size == 0){
            return true;
        }
        return false;
    }

    @Override
    public T get(int index) {
        T element = null;
        for(int i = 0; i < array.length; i++){
            if(i == index){
                element = (T) array[i];
            }
        }
        return element;
    }
}
