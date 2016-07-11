package test_package9;

import java.util.concurrent.locks.ReentrantLock;

public class NewCounterDouble {

  
    private  double c;
    //we use ReentrantLook instead of synchronizing on methods
    ReentrantLock lock = new ReentrantLock();
    /**
     * Increments the counter
     */

    public void increment() {
    	lock.lock();
        try { c++;
        } finally {
            lock.unlock();
        }
    }
    /**
     * Decrements the counter
     */

    public void decrement() {
    	lock.lock();
        try {  c--;
        } finally {
            lock.unlock();
        }
        
    }
    /**
     *
     * @return value of counter
     */
    public double value() {
        return c;
    }    
}