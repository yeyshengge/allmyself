package Day01.util;

public class MyArrayList<E> {
    private Object srcArray[];
    private int size;
    private int cap = 10;

    public MyArrayList() {
        this.srcArray = new Object[10];
    }

    //增加
    public boolean add(E e) {
        if (size == cap) {
            cap = size + (size >> 1);
            Object[] newArray = new Object[cap];
            System.arraycopy(srcArray, 0, newArray, 0, srcArray.length);
            srcArray = newArray;
        }
        this.srcArray[this.size++] = e;
        return true;
    }

    //删
    public E remove(int index) {
        if (index >= 0 && index < size) {
            int movenum = size - index - 1;
            if (movenum == 0) {
                srcArray[size - 1] = null;
            } else {
                System.arraycopy(srcArray, index + 1, srcArray, index, movenum);
            }
            size--;
            return (E) this.srcArray[index];
        } else {
            throw new ArrayIndexOutOfBoundsException("草拟吗，越界了");
        }
    }

    //查
    public E get(int index) {
        if (index >= 0 && index < size) {
            return (E) this.srcArray[index];
        } else {
            throw new ArrayIndexOutOfBoundsException("草拟吗，越界了");
        }
    }

    //改
    public E set(int index, E e) {
        if (index >= 0 && index < size) {
            this.srcArray[index] = e;
            return (E) srcArray[index];
        } else {
            throw new ArrayIndexOutOfBoundsException("草拟吗，越界了");
        }
    }

    //tostring
    public String toString() {
        String str = "[";
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                str = str + srcArray[i] + "]";
            } else {
                str = str + srcArray[i] + ",";
            }
        }
        return str;
    }

    public int size() {
        return size;
    }

    public boolean clear() {
        if (srcArray.length != 0) {
            srcArray = new Object[10];
            cap = 10;
            size = 0;
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    //contains
    public boolean contains(E e) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (srcArray[i].equals(e)) {
                return true;
            } else {
                count++;
            }
        }
        if (count == size) {
            return false;
        }
        return true;
    }
}
