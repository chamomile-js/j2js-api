package org.w3c.dom.window.timers;

/**
 * {@code WindowTimers} contains utility methods to set and clear timers.
 */
public interface WindowTimers {
   
   /**
    * This method calls the listener once after a specified number of
    * milliseconds elapses, or until canceled by a call to clearTimeout. The
    * methods returns a timerID which may be used in a subsequent call to
    * clearTimeout to cancel the interval.
    */
   public long setTimeout(TimerListener listener, long delayInMillis);
   
   /**
    * Cancels a timeout that was set with the setTimeout method.
    */
   public void clearTimeout(long timerId);
   
   /**
    * This method calls the listener every time a specified number of
    * milliseconds elapses, or until canceled by a call to clearInterval. The
    * methods returns an intervalID which may be used in a subsequent call to
    * clearInterval to cancel the interval.
    */
   public long setInterval(TimerListener listener, long delayInMillis);
   
   /**
    * Cancels a timeout that was set with the setInterval method.
    */
   public void clearInterval(long timerId);
}
