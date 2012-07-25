/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mlr_rest;

/**
 *
 * @author krishna
 */
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MLR_Consumer {

    private final Queue<MLR_Message> queue;

    public MLR_Consumer(Queue<MLR_Message> queue) {
        this.queue = queue;
    }

    //  @Override
    public void run() {
        while (true) {
            consume();
            try {
                synchronized (queue) {
                    queue.wait();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(MLR_Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void consume() {
        while (!queue.isEmpty()) {
            MLR_Message m = queue.poll();
            if (m != null) {
                System.out.println("Consumer: " + m.toString());
            }
        }
    }
// initial loader
    public static void main(String[] args) throws Exception {
        Queue<MLR_Message> queue = new ConcurrentLinkedQueue<MLR_Message>();
        MLR_Consumer instance = new MLR_Consumer(queue);
        instance.run();
    }
}
