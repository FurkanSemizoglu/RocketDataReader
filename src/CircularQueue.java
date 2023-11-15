public class CircularQueue {
    private Object [] elements;
    private int rear, front ;

    CircularQueue(int capacity){
        elements = new Object[capacity];
        rear = -1;
        front = 0;

    }


    void enqueue(Object data ) {
        if(isFull()) {
            //	System.out.println("Queue overflow for " + data);
        }else {
            rear = (rear+1)% elements.length;
            elements[rear]=data;
            //	System.out.println("added circular " + data);
        }
    }

    Object dequeue() {
        if(isEmpty()) {
            //	System.out.println("Queue is emoty");
            return null;

        }else {
            Object data = elements[front];
            elements[front] = null;
            front = (front+1)% elements.length;
            return data;

        }
    }

    Object peek() {
        if(isEmpty()) {
            //	System.out.println("Queue is emoty");
            return null;

        }else {
            Object data = elements[front];
            return data;
        }
    }

    boolean isEmpty() {
        return elements[front] == null;
    }

    boolean isFull() {
        return front == (rear+1) % elements.length &&
                elements[front] != null &&
                elements[rear] != null;

    }

    int size () {
        if(elements[front]== null) {
            return 0 ;
        }else {
            if(rear >= front) {
                return rear-front +1;
            }else {
                return elements.length - (front -rear )+1 ;
            }
        }
    }

}
