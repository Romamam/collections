package interfaces;

public interface MyCollection<T> {
     boolean add(T element);

     void add(int index, T element);

     boolean remove(T element);

     boolean contains(T element);

     int getSize();

     boolean isEmpty();

     T get(int index);
}
