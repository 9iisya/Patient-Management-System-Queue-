public class LinkedList 
{
    private Node first;     // Reference to the first node in the list
    private Node last;      // Reference to the last node in the list
    private Node current;   // Reference to the current node for iteration
    private int size;       // Number of nodes in the list

    // Constructor to initialize an empty list
    public LinkedList() 
    {
        first = null;       // Set the first node to null (empty list)
        last = null;        // Set the last node to null (empty list)
        current = null;     // Set the current node to null (no iteration yet)
        size = 0;           // Initialize the size of the list to 0
    }

    // Check if the list is empty
    public boolean isEmpty() 
    {
        return first == null;   // Return true if the first node is null
    }

    // Insert a new item at the front of the list
    public void insertAtFront(Object insertItem) 
    {
        Node newNode = new Node(insertItem);  // Create a new node with the given item

        if (isEmpty()) 
        {
            first = last = newNode;  // If the list is empty, set both first and last to the new node
        } 
        else 
        {
            newNode.next = first;    // Point the new node to the current first node
            first = newNode;         // Update the first node to the new node
        }
        size++;  // Increment the size of the list
    }

    // Insert a new item at the back of the list
    public void insertAtBack(Object insertItem) 
    {
        Node newNode = new Node(insertItem);  // Create a new node with the given item

        if (isEmpty()) 
        {
            first = last = newNode;  // If the list is empty, set both first and last to the new node
        } 
        else 
        {
            last.next = newNode;     // Point the current last node to the new node
            last = newNode;          // Update the last node to the new node
        }
        size++;  // Increment the size of the list
    }

    // Insert a new item at the second position
    public void insertAtSecond(Object insertItem) 
    {
        if (size < 2) 
        {
            insertAtBack(insertItem);  // If less than 2 nodes, insert at the back
        } 
        else 
        {
            Node newNode = new Node(insertItem);  // Create a new node
            newNode.next = first.next;            // Point new node to the second node
            first.next = newNode;                 // Update first's next to the new node
            size++;  // Increment the size of the list
        }
    }

    // Insert at a specific position
    public void insertAtPosition(int position, Object insertItem) 
    {
        if (position < 0 || position > size) 
        {
            throw new IndexOutOfBoundsException("Position out of bounds.");  // Invalid position
        }

        if (position == 0) 
        {
            insertAtFront(insertItem);  // Insert at the front if position is 0
        } 
        else if (position == size) 
        {
            insertAtBack(insertItem);   // Insert at the back if position is the last
        } 
        else 
        {
            Node newNode = new Node(insertItem);  // Create a new node
            Node prev = first;                    // Start at the first node
            for (int i = 1; i < position; i++) 
            {
                prev = prev.next;  // Traverse to the node before the insertion point
            }
            newNode.next = prev.next;  // Point the new node to the next node
            prev.next = newNode;       // Link the previous node to the new node
            size++;  // Increment the size of the list
        }
    }

    // Remove a node from the front
    public Object removeFromFront() 
    {
        if (isEmpty()) return null;  // Return null if the list is empty

        Object removedData = first.data;  // Store the data of the first node
        if (first == last) 
        {
            first = last = null;  // If only one node, set both first and last to null
        } 
        else 
        {
            first = first.next;   // Update the first node to the next node
        }
        size--;  // Decrement the size of the list
        return removedData;  // Return the removed data
    }

    // Remove a node from the back
    public Object removeFromBack() 
    {
        if (isEmpty()) return null;  // Return null if the list is empty
        Object removedData = last.data;  // Store the data of the last node

        if (first == last) 
        {
            first = last = null;  // If only one node, set both first and last to null
        } 
        else 
        {
            Node prev = first;  // Start at the first node
            while (prev.next != last) 
            {
                prev = prev.next;  // Traverse to the second-to-last node
            }
            last = prev;  // Update last to the second-to-last node
            last.next = null;  // Set the last node's next to null
        }
        size--;  // Decrement the size of the list
        return removedData;  // Return the removed data
    }

    // Search for a specific node
    public boolean searchNode(Node targetNode) 
    {
        Node current = first;  // Start at the first node
        while (current != null) 
        {
            if (current == targetNode) 
            {
                return true;  // Return true if the target node is found
            }
            current = current.next;  // Move to the next node
        }
        return false;  // Return false if the node is not found
    }

    // Remove a node by its position
    public boolean removeNodeByPosition(int position) 
    {
        if (position < 0 || position >= getSize()) 
        {
            return false;  // Return false if the position is invalid
        }

        if (position == 0) 
        {
            first = first.next;  // Remove the first node
            if (first == null) last = null;  // Update last if the list becomes empty
            size--;
            return true;
        }

        Node current = first;  // Start at the first node
        for (int i = 0; i < position - 1; i++) 
        {
            current = current.next;  // Traverse to the node before the target position
        }
        if (current.next != null) 
        {
            current.next = current.next.next;  // Bypass the node to be removed
            if (current.next == null) last = current;  // Update last if removing the last node
            size--;
            return true;
        }
        return false;  // Should not happen if position is valid
    }

    // Get the first item in the list
    public Object getFirst() 
    {
        if (isEmpty()) return null;  // Return null if the list is empty
        current = first;  // Set current to the first node
        return current.data;  // Return the data of the first node
    }

    // Get the next item in the list
    public Object getNext() 
    {
        if (current == null || current.next == null) return null;  // Return null if no next node
        current = current.next;  // Move current to the next node
        return current.data;  // Return the data of the current node
    }

    // Get the size of the list
    public int getSize() 
    {
        return size;  // Return the size of the list
    }

    // Inner Node class to represent each node in the list
    private class Node 
    {
        Object data;  // Data stored in the node
        Node next;    // Reference to the next node

        public Node(Object data) 
        {
            this.data = data;  // Initialize the node with data
            this.next = null;  // Set the next node reference to null
        }
    }
}