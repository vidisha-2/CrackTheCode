/*Given two linked lists, determine if the two lists intersect.*/

import java.util.*; 

/*class Intersection { 
    public static void main(String[] args) 
    { 
        // list 1 
        Node n1 = new Node(1); 
        n1.next = new Node(2); 
        n1.next.next = new Node(3); 
        n1.next.next.next = new Node(4); 
        n1.next.next.next.next = new Node(5); 
        n1.next.next.next.next.next = new Node(6); 
        n1.next.next.next.next.next.next = new Node(7); 
        // list 2 
        Node n2 = new Node(10); 
        n2.next = new Node(9); 
        n2.next.next = new Node(8); 
        n2.next.next.next = n1.next.next.next; 
        Print(n1); 
        Print(n2); 
        System.out.println(MegeNode(n1, n2).data); 
    } 
  
    // function to print the list 
    public static void Print(Node n) 
    { 
        Node cur = n; 
        while (cur != null) { 
            System.out.print(cur.data + "  "); 
            cur = cur.next; 
        } 
        System.out.println(); 
    } 
  
    // function to find the intersection of two node 
    public static Node MegeNode(Node n1, Node n2) 
    { 
        // define hashset 
        HashSet<Node> hs = new HashSet<Node>(); 
        while (n1 != null) { 
            hs.add(n1); 
            n1 = n1.next; 
        } 
        while (n2 != null) { 
            if (hs.contains(n2)) { 
                return n2; 
            } 
            n2 = n2.next; 
        } 
        return null; 
    } 
}*/ 


  
class Intersection { 
  
    static Node head1, head2; 
  
    static class Node { 
  
        int data; 
        Node next; 
  
        Node(int d) 
        { 
            data = d; 
            next = null; 
        } 
    } 
  
    /*function to get the intersection point of two linked 
    lists head1 and head2 */
    public static int getNode() 
    { 
        int c1 = getCount(head1); 
        int c2 = getCount(head2); 
        int d; 
  
        if (c1 > c2) { 
            d = c1 - c2; 
            return _getIntesectionNode(d, head1, head2); 
        } 
        else { 
            d = c2 - c1; 
            return _getIntesectionNode(d, head2, head1); 
        } 
    } 
  
    /* function to get the intersection point of two linked 
     lists head1 and head2 where head1 has d more nodes than 
     head2 */
    public static int _getIntesectionNode(int d, Node node1, Node node2) 
    { 
        int i; 
        Node current1 = node1; 
        Node current2 = node2; 
        for (i = 0; i < d; i++) { 
            if (current1 == null) { 
                return -1; 
            } 
            current1 = current1.next; 
        } 
        while (current1 != null && current2 != null) { 
            if (current1.data == current2.data) { 
                return current1.data; 
            } 
            current1 = current1.next; 
            current2 = current2.next; 
        } 
  
        return -1; 
    } 
  
    /*Takes head pointer of the linked list and 
    returns the count of nodes in the list */
    public static int getCount(Node node) 
    { 
        Node current = node; 
        int count = 0; 
  
        while (current != null) { 
            count++; 
            current = current.next; 
        } 
  
        return count; 
    } 
  
    public static void main(String[] args) 
    { 
        Intersection list = new Intersection(); 
  
        // creating first linked list 
        list.head1 = new Node(3); 
        list.head1.next = new Node(6); 
        list.head1.next.next = new Node(9); 
        list.head1.next.next.next = new Node(15); 
        list.head1.next.next.next.next = new Node(30); 
  
        // creating second linked list 
        list.head2 = new Node(10); 
        list.head2.next = new Node(15); 
        list.head2.next.next = new Node(30); 
  
        System.out.println("The node of intersection is " + list.getNode()); 
    } 
} 
/*class Node { 
    int data; 
    Node next; 
    Node(int d) 
    { 
        data = d; 
        next = null; 
    } 
} */