# Section 12. Basic data structures  

Computer programs are all about processing information. The amount of information that has to be handled is very often really huge and grows rapidly from year to year. Therefore, it is very important to organize the data in such a way that processing it is fast and efficient. Generations of scientists have been working (and are still working) on that problem. Generally, designing a way in which the data is structurized is related to the way in which it will be used; both aspects are studied by the branch of computer science called Algorithms and Data Structures.  
  
  One important, and very useful, data structure is already known to us: arrays. Representing data in the form of arrays has many advantages, perhaps the most important being the speed of access to individual elements (using indices), which is “immediate” (O(1)) and does not depend on the size of the array. The downside, however, is the fact that the size of arrays must be fixed at their creation and no elements can be then “deleted” or added.  
  
  In this section, we will mention just a few most fundamental data structures based on lists (ordered sequences of elements): lists as such, queues and stacks. Of course, there are many other equally useful structures - like dictionaries (maps), trees, graphs etc. — you will study them later, although we will say a few words about maps in the section on collections in Java.  
  
## 12.1 Singly linked lists  
  
A singly linked list represents a sequence of pieces of data of a certain type (in an extreme case, references to object of type **Object** which may represent anything). Each such piece of data is “wrapped” in an object of some type (conventionally called **Node**) as its field, the other field being the reference to the next node of the list. In this way, we can build a chain of nodes, where each node contains information about the next. We need some kind of a marker which will mark the last node as being the last: for example, we can adopt the convention that the last node’s next field is **null**.

Thus, the situation looks like this:  
  
![Node](https://raw.githubusercontent.com/Java-PJATK/65.66.67.BGU-SingList/main/Node-data-next-head-null.jpg "Node")  
  
Note that having the reference to the first node (conventionally called **head**), we can access all the nodes, because in each of them we will find the reference to the next one. 
  
Let us consider an example. The class **Node** represents a node containing data - in this case just an **int** - and a reference to the next node:

# BGU-SingList

Page 109 Listing 65 BGU-SingList/Node.java  
Page 109 Listing 66 BGU-SingList/MyList.java  
Page 109 Listing 67 BGU-SingList/Main.java  
  
# [Listing 65 BGU-SingList/Node.java](https://github.com/Java-PJATK/65.66.67.BGU-SingList/blob/main/Node.java)
```java
// Listing 65
// BGU-SingList/Node.java
 
  // could be private static inner class of MyList
public class Node {
    int data;
    Node next;
    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
    Node(int data) {
        this(data,null);
    }
}

/*
Second Constructor:
The second constructor takes only one parameter: data.
It calls the first constructor (with next set to null) using the this(data, null) syntax.
This allows creating a node with only data and no next node reference. 
*/
```

The class representing the whole list will contain only one field: the head of the list, i.e., the reference to its first node. We will add methods which add new nodes at the beginning (**addFront**) and at the end (**addBack**) of the list. Notice that adding a node at the end requires traversing the whole list. Also, to count elements of the list (the **size** method), we have to traverse the whole list.  
  
The **showListReversed** method prints the list in the reverse order by calling private, _recursive_ function **showRev**. The main idea here is that the function _first_ calls itself for the next node (if it exists), and only then, when the flow of control returns to it, prints information on _this_ element.  

### **[Listing 66 BGU-SingList/MyList.java](https://github.com/Java-PJATK/65.66.67.BGU-SingList/blob/main/MyList.java)**  
```java
// Listing 66 
// BGU-SingList/MyList.java
 
public class MyList {
    private Node head;

    public MyList() {
        head = null;
    }

    public void addFront(int data) {
        head = new Node(data,head);
    }

    public void addBack(int data) {
        if (head == null) {
            addFront(data);
            return;
        }
        Node tmp = head;

        while(tmp.next != null)
            tmp = tmp.next;
        tmp.next = new Node(data);
    }
    public void showList() {
        System.out.print("[ ");
        Node tmp = head;
        while(tmp != null) {
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
        System.out.println("]");
    }
    public void showListReversed() {
        System.out.print("[ ");
        showRev(head);
        System.out.print("]");
    }
    private void showRev(Node h) {
        if (h.next != null) showRev(h.next);
        System.out.print(h.data + " ");
    }
    public int size() {
          // inefficient!
        int count = 0;
        Node tmp = head;
        while(tmp != null) {
            ++count;
            tmp = tmp.next;
        }
        return count;
    }
    public boolean empty() {
        return head == null;
    }
}
```


  
In **Main**, we build a list and then print its contents  

### **[Listing 67 BGU-SingList/Main.java](https://github.com/Java-PJATK/65.66.67.BGU-SingList/blob/main/Main.java)**  
```java
// BGU-SingList/Main.java
 
public class Main {
    public static void main(String[] args) {
        MyList list = new MyList();
        list.addBack(4);
        list.addBack(5);
        list.addFront(3);
        list.addFront(2);
        list.addFront(1);
        list.showList();
        list.showListReversed();
        System.out.println("\nsize = " + list.size());
    }
}
```
 
The program prints

```
  [ 1 2 3 4 5 ]
  [ 5 4 3 2 1 ]
  size = 5
```

Of course, for our list to be useful, we would have to add more methods: for example to insert new node in the middle of the list, to remove its elements etc.


## Youtube Videos

[Singly Linked List | Insert, Delete, Complexity Analysis @Blue Tree Code](https://youtu.be/Ovhj6qDSF9M)  

[Recursion for Beginners: A Beginner's Guide to Recursion - Al Sweigart](https://www.youtube.com/watch?v=AfBqVVKg4GE&t=649s) [🔗](https://www.amazon.co.uk/Recursive-Book-Recursion-Interview-Javascript/dp/1718502028)

When starting recursive code always ask what is the:
* base case
* recursive case

Call stack. Stack frame/Activation record.


Certainly! Let's compare the two methods: `showListReversed` with its helper `showRev`, and `showReversedRecursive` with its helper `showReversedRecursiveHelper`. Both methods aim to display the linked list in reverse order, but they have different base case validations.

### Method 1: `showListReversed`

```java
public void showListReversed() {
    System.out.print("[ ");
    showRev(head);
    System.out.print("]");
}

private void showRev(Node h) {
    if (h.next != null) {
        showRev(h.next);
    }
    System.out.print(h.data + " ");
}
```

### Method 2: `showReversedRecursive`

```java
public void showReversedRecursive() {
    showReversedRecursiveHelper(head);
    System.out.println();
}

private void showReversedRecursiveHelper(Node<T> node) {
    if (node == null) {
        return;
    }
    showReversedRecursiveHelper(node.next);
    System.out.print(node.data + " ");
}
```

### Comparison of `if` Validation

#### `showRev` in `showListReversed`

```java
private void showRev(Node h) {
    if (h.next != null) {  // Base case: if the next node is null, stop recursion.
        showRev(h.next);
    }
    System.out.print(h.data + " ");
}
```

- **Condition**: `if (h.next != null)`
  - This checks if the current node `h` has a `next` node.
  - The base case here is when `h.next` is `null`, meaning we have reached the last node in the list.

- **Behavior**:
  - If `h.next` is not `null`, it continues to call `showRev` recursively with `h.next`.
  - When the base case is reached (`h.next == null`), it stops making further recursive calls.

- **Implication**: This method does not handle an empty list directly since it assumes `head` is non-null. If `head` is `null`, a `NullPointerException` would occur.

#### `showReversedRecursiveHelper` in `showReversedRecursive`

```java
private void showReversedRecursiveHelper(Node<T> node) {
    if (node == null) {  // Base case: if the current node is null, stop recursion.
        return;
    }
    showReversedRecursiveHelper(node.next);
    System.out.print(node.data + " ");
}
```

- **Condition**: `if (node == null)`
  - This checks if the current node `node` is `null`.
  - The base case here is when `node` itself is `null`, meaning we have moved past the last node in the list.

- **Behavior**:
  - If `node` is not `null`, it continues to call `showReversedRecursiveHelper` recursively with `node.next`.
  - When the base case is reached (`node == null`), it returns and stops making further recursive calls.

- **Implication**: This method properly handles an empty list since the base case is when the current node is `null`, which will be the case when `head` is `null`.

### Key Differences in Base Case Validations

1. **Base Case for Stopping Recursion**:
   - **`showRev`:** `if (h.next != null)`
     - This stops recursion when `h.next` is `null`, meaning it checks if the next node is `null`.
     - Assumes the current node `h` is never `null`, which can be problematic for empty lists.
   - **`showReversedRecursiveHelper`:** `if (node == null)`
     - This stops recursion when `node` itself is `null`, meaning it checks if the current node is `null`.
     - Handles empty lists gracefully because it considers the possibility of the current node being `null`.

2. **Handling an Empty List**:
   - **`showRev`:** Will cause a `NullPointerException` if `head` is `null` because it blindly tries to access `head.next`.
   - **`showReversedRecursiveHelper`:** Properly handles an empty list by checking if `node` is `null` at the start.

3. **Code Readability and Safety**:
   - **`showRev`:** Slightly less safe since it assumes the presence of nodes.
   - **`showReversedRecursiveHelper`:** More readable and safer as it directly checks for a null node, making it clear that it handles empty lists properly.

### Summary

- Both methods print the elements of the linked list in reverse order.
- The `if` validation in `showRev` checks if the next node is `null`, which can lead to issues with empty lists.
- The `if` validation in `showReversedRecursiveHelper` checks if the current node is `null`, making it more robust and suitable for handling empty lists.
- Always consider edge cases like empty lists when writing recursive functions to ensure they handle all possible scenarios gracefully.
