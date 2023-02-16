package org.soneech.practice3;

import java.util.*;
import java.util.concurrent.Semaphore;

public class SynchronizedSet<E> implements Set<E> {  // implementation with semaphore
    private final int THREADS_COUNT = 1;
    private final HashSet<E> SET = new HashSet<>();
    private final Semaphore SEMAPHORE = new Semaphore(THREADS_COUNT);

    @Override
    public int size() {
        return SET.size();
    }

    @Override
    public boolean isEmpty() {
        return SET.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return SET.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return SET.iterator();
    }

    @Override
    public Object[] toArray() {
        return SET.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        try {
            SEMAPHORE.acquire();
            SET.add(e);
            SEMAPHORE.release();
            return true;
        } catch (InterruptedException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean remove(Object o) {
        try {
            SEMAPHORE.acquire();
            if (SET.contains(o)) {
                SET.remove(o);
                SEMAPHORE.release();
                return true;
            }
            else {
                SEMAPHORE.release();
                return false;
            }
        } catch (InterruptedException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return SET.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        try {
            SEMAPHORE.acquire();
            SET.addAll(c);
            SEMAPHORE.release();
            return true;
        } catch (InterruptedException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return SET.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        try {
            SEMAPHORE.release();
            SET.removeAll(c);
            SEMAPHORE.acquire();
            return true;
        } catch (InterruptedException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public void clear() {
        SET.clear();
    }

    @Override
    public String toString() {
       return SET.toString();
    }
}
