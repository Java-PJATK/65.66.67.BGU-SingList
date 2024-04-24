# BGU-SingList

Page 109 Listing 65 BGU-SingList/Node.java  
Page 109 Listing 66 BGU-SingList/NIyList.java  
Page 109 Listing 67 BGU-SingList/NIain.java  

Basic data structures  

Computer programs are all about processing information. The amount of information that has to be handled is very often really huge and grows rapidly from year to year. Therefore, it is very important to organize the data in such a way that processing it is fast and efficient. Generations of scientists have been working (and are still working) on that problem. Generally, designing a way in which the data is structurized is related to the way in which it will be used; both aspects are studied by the branch of computer science called Algorithms and Data Structures.  
  
One important, and very useful, data structure is already known to us: arrays. Representing data in the form of arrays has many advantages, perhaps the most important being the speed of access to individual elements (using indices), which is “immediate” (O(1)) and does not depend on the size of the array. The downside, however, is the fact that the size of arrays must be fixed at their creation and no elements can be then “deleted” or added.  
  
In this section, we will mention just a few most fundamental data structures based on lists (ordered sequences of elements): lists as such, queues and stacks. Of course, there are many other equally useful structures - like dictionaries (maps), trees, graphs etc. — you will study them later, although we will say a few words about maps in the section on collections in Java.  
  
12.1 Singly linked lists  
  
A singly linked list represents a sequence of pieces of data of a
certain type (in an extreme case, references to object of type Object
which may represent anything). Each such piece of data is “wrapped”
in an object of some type (conventionally called Node) as its field, the
other field being the reference to the next node of the list. In this
way, we can build a chain of nodes, where each node contains
information about the next. We need some kind of a marker which
will mark the last node as being the last: for example, we can adopt
the convention that the last node’s next field is null.
Thus, the situation looks like this:
Note that having the reference to the first node (conventionally
called head), we can access all the nodes, because in each of them we
will find the reference to the next one.
Let us consider an example. The class Node represents a node
containing data -in this case just an int - and a reference to the next
node:  
  
The class representing the whole list will contain only one field: the head
of the list, i.e., the reference to its first node. We will add methods which
add new nodes at the beginning (addFront) and at the end (addBack) of
the list. Notice that adding a node at the end requires traversing the whole
list. Also, to count elements of the list (the size method), we have to
traverse the whole list.  
  
The showListReversed method prints the list in the reverse order by
calling private, recursive function showRev. The main idea here is that the
function first calls itself for the next node (if it exists), and only then, when
the flow of control returns to it, prints information on this element.  
  
In Main, we build a list and then print its contents  
  
The program prints



Of course, for our list to be useful, we would have to add more methods:  

    
for example to insert new node in the middle of the list, to remove its elements etc.
