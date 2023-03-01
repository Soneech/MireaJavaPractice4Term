package org.soneech.practice3;

import java.util.*;
import java.util.concurrent.Semaphore;

public class SynchronizedSet<E> implements Set<E> {  // implementation with semaphore
    private final int THREADS_COUNT = 1;
    private final HashSet<E> set = new HashSet<>();
    private final Semaphore semaphore = new Semaphore(THREADS_COUNT);

    @Override
    public int size() {
        return set.size();
    }

    @Override
    public boolean isEmpty() {
        return set.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return set.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return set.iterator();
    }

    @Override
    public Object[] toArray() {
        return set.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        try {
            semaphore.acquire();
            set.add(e);
            semaphore.release();
            return true;
        } catch (InterruptedException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean remove(Object o) {
        try {
            semaphore.acquire();
            if (set.contains(o)) {
                set.remove(o);
                semaphore.release();
                return true;
            }
            else {
                semaphore.release();
                return false;
            }
        } catch (InterruptedException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return set.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        try {
            semaphore.acquire();
            set.addAll(c);
            semaphore.release();
            return true;
        } catch (InterruptedException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return set.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        try {
            semaphore.release();
            set.removeAll(c);
            semaphore.acquire();
            return true;
        } catch (InterruptedException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public void clear() {
        set.clear();
    }

    @Override
    public String toString() {
       return set.toString();
    }
}
