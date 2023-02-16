package org.soneech.practice3;

import java.util.*;

public class SynchronizedList<E> implements List<E> {  // implementation with synchronized
    private volatile ArrayList<E> LIST = new ArrayList<>();

    @Override
    public int size() {
        return LIST.size();
    }

    @Override
    public boolean isEmpty() {
        return LIST.isEmpty();
    }

    @Override
    synchronized public boolean contains(Object o) {
        return LIST.contains(o);
    }

    @Override
    synchronized public Iterator<E> iterator() {
        return LIST.iterator();
    }

    @Override
    public Object[] toArray() {
        return LIST.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return a;
    }

    @Override
    synchronized public boolean add(E e) {
        return LIST.add(e);
    }

    @Override
    synchronized public boolean remove(Object o) {
        return LIST.remove(o);
    }

    @Override
    synchronized public boolean containsAll(Collection<?> c) {
        return LIST.containsAll(c);
    }

    @Override
    synchronized public boolean addAll(Collection<? extends E> c) {
        return LIST.addAll(c);
    }

    @Override
    synchronized public boolean addAll(int index, Collection<? extends E> c) {
        return LIST.addAll(index, c);
    }

    @Override
    synchronized public boolean removeAll(Collection<?> c) {
        return LIST.removeAll(c);
    }

    @Override
    synchronized public boolean retainAll(Collection<?> c) {
        return LIST.retainAll(c);
    }

    @Override
    synchronized public void clear() {
        LIST.clear();
    }

    @Override
    synchronized public E get(int index) {
        return LIST.get(index);
    }

    @Override
    synchronized public E set(int index, E element) {
        return LIST.set(index, element);
    }

    @Override
    synchronized public void add(int index, E element) {
        LIST.add(index, element);
    }

    @Override
    synchronized public E remove(int index) {
        return LIST.remove(index);
    }

    @Override
    synchronized public int indexOf(Object o) {
        return LIST.indexOf(o);
    }

    @Override
    synchronized public int lastIndexOf(Object o) {
        return LIST.lastIndexOf(o);
    }

    @Override
    synchronized public ListIterator<E> listIterator() {
        return LIST.listIterator();
    }

    @Override
    synchronized public ListIterator<E> listIterator(int index) {
        return LIST.listIterator(index);
    }

    @Override
    synchronized public List<E> subList(int fromIndex, int toIndex) {
        return (LIST.subList(fromIndex, toIndex));
    }

    @Override
    public String toString() {
        return LIST.toString();
    }
}
