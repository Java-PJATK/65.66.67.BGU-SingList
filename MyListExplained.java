public class MyList {
    // 'MyList' is a custom class that represents a linked list.
    private Node head; // 'head' is a private variable that holds a reference to the first node in the list.

    public MyList() {
        head = null; // Constructor initializes 'head' to null, indicating the list is empty.
    }

    public void addFront(int data) {
        head = new Node(data, head); // This method creates a new node with 'data' and places it at the front of the list.
    }

    public void addBack(int data) {
        if (head == null) { // If the list is empty, 'addFront' is called to add the new node at the front.
            addFront(data);
            return;
        }
        Node tmp = head; // Temporary node to traverse the list.
        while(tmp.next != null) // Loop until the end of the list is reached.
            tmp = tmp.next;
        tmp.next = new Node(data); // Add the new node at the end of the list.
    }

    public void showList() {
        System.out.print("[ "); // Prints the opening bracket for the list representation.
        Node tmp = head; // Temporary node to traverse the list.
        while(tmp != null) { // Loop through each node in the list.
            System.out.print(tmp.data + " "); // Print the data of each node followed by a space.
            tmp = tmp.next; // Move to the next node.
        }
        System.out.println("]"); // Prints the closing bracket after all nodes are printed.
    }

    public void showListReversed() {
        System.out.print("[ "); // Prints the opening bracket for the reversed list representation.
        showRev(head); // Calls a private recursive method to print the list in reverse.
        System.out.print("]"); // Prints the closing bracket after the reversed list is printed.
    }

    private void showRev(Node h) {
        if (h.next != null) showRev(h.next); // Recursive call to reach the end of the list.
        System.out.print(h.data + " "); // Prints the data of each node starting from the end.
    }

    public int size() {
        // inefficient!
        int count = 0; // Counter to keep track of the number of nodes.
        Node tmp = head; // Temporary node to traverse the list.
        while(tmp != null) { // Loop through each node in the list.
            ++count; // Increment the counter for each node encountered.
            tmp = tmp.next; // Move to the next node.
        }
        return count; // Return the total count of nodes as the size of the list.
    }

    public boolean empty() {
        return head == null; // Returns true if the list is empty (head is null), otherwise false.
    }
}
