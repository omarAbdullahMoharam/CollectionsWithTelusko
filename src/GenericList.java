import java.util.Iterator;

public class GenericList <T>implements Iterator<T> {
    private T[] items = (T[]) new Object[10];
    private int count ;
    public void add(T item){
        if (count == items.length){
            T[] newItems = null;
            try {
                newItems = (T[]) new Object[items.length * 2];
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.arraycopy(items, 0, newItems, 0, items.length);
            items = newItems;
        }
        items[count++] = item;
    }


    public T get(int index){
        if (index < 0 || index >= count){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + count);
        }
        return items[index];
    }


    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        return null;
    }

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
