public class MyArrayList<T> implements MyCollection<T>{
    private Object[] array;
    private int size;


    public MyArrayList(){
        array = new Object[10];
        size = 0;
    }
    @Override
    public void add(T element) {
        if(size == array.length) {
            increaseCapacity();
        }
        array[size] = element;
        size++;
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
            if(array[i] == element){
                for(int k = i; k < array.length; k++){
                    array[k] = array[k+1];
                }
            }
            array[size - 1] = null;
            size--;
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(T element) {
        for(int i = 0; i < array.length; i++){
            if(array[i] == element){
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        int size = 0;
        for(int i = 0; i < array.length; i++){
            size++;
        }
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
