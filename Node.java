class Node 
{
    Patient data; // Holds patient information
    Node next; // Points to the next node

    public Node(Patient data) 
    {
        this.data = data; // Save the patient data
        this.next = null; // Set next to nothing (end of the list)
    }
}
