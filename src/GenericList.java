

import java.util.Iterator;

public class GenericList <T>implements Iterable<T> {
    private T[] items = (T[]) new Object[10];
    public GenericList() {
    }
    public GenericList(T[] items) {
        this.items = items;
    }
    private int count ;
    public void add(T item){
        if (count == items.length){
            T[] newItems = (T[]) new Object[items.length * 2] ;
                System.arraycopy(items, 0, newItems, 0, items.length);
                items = newItems;
                items[count++] = item;
        }
        else {
            items[count++] = item;
        }
    }

    public T get(int index){
        if (index < 0 || index >= count){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + count);
        }
        return items[index];
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

    public static void main(String[] args) {
       var stringList = new GenericList<String>();
        stringList.add("Hello");
        stringList.add("World");

        for (String s : stringList) {
            System.out.println(s);
        }

        var intList = new GenericList<Integer>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        for (Integer i : intList) {
            System.out.println(i);
        }

    }
}
