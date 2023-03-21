package org.soneech.practice3;

import java.util.*;

public class SynchronizedList<E> implements List<E> {  // implementation with synchronized
    private final ArrayList<E> list = new ArrayList<>();

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return a;
    }

    @Override
    synchronized public boolean add(E e) {
        return list.add(e);
    }

    @Override
    synchronized public boolean remove(Object o) {
        return list.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return list.containsAll(c);
    }

    @Override
    synchronized public boolean addAll(Collection<? extends E> c) {
        return list.addAll(c);
    }

    @Override
    synchronized public boolean addAll(int index, Collection<? extends E> c) {
        return list.addAll(index, c);
    }

    @Override
    synchronized public boolean removeAll(Collection<?> c) {
        return list.removeAll(c);
    }

    @Override
    synchronized public boolean retainAll(Collection<?> c) {
        return list.retainAll(c);
    }

    @Override
    synchronized public void clear() {
        list.clear();
    }

    @Override
    public E get(int index) {
        return list.get(index);
    }

    @Override
    synchronized public E set(int index, E element) {
        return list.set(index, element);
    }

    @Override
    synchronized public void add(int index, E element) {
        list.add(index, element);
    }

    @Override
    synchronized public E remove(int index) {
        return list.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return list.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return list.lastIndexOf(o);
    }

    @Override
    public ListIterator<E> listIterator() {
        return list.listIterator();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return list.listIterator(index);
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return list.subList(fromIndex, toIndex);
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
