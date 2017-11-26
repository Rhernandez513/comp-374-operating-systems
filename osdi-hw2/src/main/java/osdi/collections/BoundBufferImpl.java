package osdi.collections;

import osdi.locks.Semaphore;
import osdi.locks.Monitor;

/*
 * Modify this as you see fit. you may not use anything in java.util.concurrent.* you may only use locks from osdi.locks.*
 */
class BoundBufferImpl<T> implements SimpleQueue<T> {
    private final int bufferSize;
    private final java.util.Queue<T> queue;

    private final Semaphore mutex = new Semaphore(1);
    private final Semaphore empty = new Semaphore(50);
    private final Semaphore full  = new Semaphore(0);

    public BoundBufferImpl(int bufferSize) {
        this.bufferSize = bufferSize;
        queue = new java.util.ArrayDeque<>();
    }

    @Override
    public void enqueue(T item) {
            empty.down();
            mutex.down();
            queue.add(item);
            mutex.up();
            full.up();
    }

    @Override
    public T dequeue() {
        full.down();
        mutex.down();
        T item = queue.remove();
        mutex.up();
        empty.up();

        return item;
    }
}
