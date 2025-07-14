public class Queue extends LinkedList 
{
    public Queue() 
    {
        super();  // Optional if LinkList has no constructor logic
    }

    public void enqueue(Object obj) 
    {
        super.insertAtBack(obj);  // Call the parent class method to insert at the back
    }

    public Object dequeue() 
    {
        return super.removeFromFront();  // Call the parent class method to remove from the front
    }

    public boolean isEmpty() 
    {
        return super.isEmpty();  // Correctly call the parent class's isEmpty method
    }

    public Object getFront() 
    {
        return super.getFirst();  // Return the first element without removing it
    }
}

