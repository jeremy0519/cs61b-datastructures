package deque;

public class ArrayDeque<T> {
    private int size;
    private T[] items;
    // index of next addFirst
    private int nextFirst;
    // index of next addLast
    private int nextLast;

    public ArrayDeque() {
        size = 0;
        items = (T[]) new Object[8]; // circular array
        nextFirst = 8 - 1;
        nextLast = 0;
    }

    private void resize(int target) {
        T[] newArray = (T[]) new Object[target];
        for (int i = 0; i < size; i++) {
            int realIndex = Math.floorMod(i + nextFirst + 1, items.length);
            newArray[i] = items[realIndex];
        }
        items = newArray; // 原始数据重新放在newArray开头，即index0到size-1
        nextFirst = target - 1;
        nextLast = size;
    }

    // 各种API
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] = item;
        nextFirst = Math.floorMod(nextFirst - 1, items.length);
        size += 1;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextLast] = item;
        nextLast = Math.floorMod(nextLast + 1, items.length);
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            int realIndex = Math.floorMod(i + nextFirst + 1, items.length);
            System.out.print(items[realIndex] + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        } else {
            double usageFactor = (double) (size - 1) / items.length;
            if (items.length >= 16 && usageFactor < 0.25) {
                resize(items.length / 2);
            }
            int firstIndex = Math.floorMod(nextFirst + 1, items.length);
            T val = items[firstIndex];
            items[firstIndex] = null;
            nextFirst = firstIndex;
            size -= 1;
            return val;
        }
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            double usageFactor = (double) (size - 1) / items.length;
            if (items.length >= 16 && usageFactor < 0.25) {
                resize(items.length / 2);
            }
            int lastIndex = Math.floorMod(nextLast - 1, items.length);
            T val = items[lastIndex];
            items[lastIndex] = null;
            nextLast = lastIndex;
            size -= 1;
            return val;
        }
    }

    public T get(int index) {
        if (size == 0) {
            return null;
        } else {
            int realIndex = Math.floorMod(index + nextFirst + 1, items.length);
            return items[realIndex];
        }
    }
}
