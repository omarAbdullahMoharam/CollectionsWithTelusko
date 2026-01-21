import java.util.Iterator;

public class GenericList <T>implements Iterable<T> {
    private T[] items = (T[]) new Object[10];
    private int count ;
    public void add(T item){
        if (count == items.length){
            T[] newItems = null;
            try {
                newItems = (T[]) new Object[items.length * 2];
                System.arraycopy(items, 0, newItems, 0, items.length);
                items = newItems;
                items[count++] = item;

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public T get(int index){
        if (index < 0 || index >= count){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + count);
        }
        return items[index];
    }


    public boolean hasNext() {
        return false;
    }

    public T next() {
        return null;
    }
    @Override
    public Iterator<T> iterator() {
        return new ListIterator(this);
    }


    private class ListIterator implements Iterator<T>{
        private GenericList<T> list;
        private int index;
        public ListIterator(GenericList<T> list){
            this.list = list;
        }
        @Override
        public boolean hasNext() {
            return index < list.count;
        }
        @Override
        public T next() {
            return list.get(index++);
        }
    }
}
