public class LinkedList{
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void Addfirst(int data){
        //1 - Create new node
        Node newNode = new Node(data);
        size++;

        if(head == null){
            head = tail = newNode;
            return;
        }
        //2 - newNode next = Head
        newNode.next = head; //link
        //3 - head = newNode
        head = newNode;
    }
    public void print(){
        if(head == null){
            System.out.println("LL is empty");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+">");
            temp = temp.next;
        }
        System.out.println("Null");
    }
    //slow fast approach
    public Node findMid(Node head){ //helper fun
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next; //+1
            fast = fast.next.next; //+2
        }
        return slow; //slow is my midNode
    }
    public boolean Palindrome(){
        //base case
        if(head == null || head.next == null){
            return true;
        }
        //step1 - find mid
        Node midNode = findMid(head);

        //step2 - reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev; //right half head
        Node left = head;

        //step3 - check left half & right half
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static void main(String args[]){
        LinkedList ll = new LinkedList();
        ll.Addfirst(8);
        ll.Addfirst(7);
        ll.Addfirst(5);
        ll.Addfirst(5);
        ll.Addfirst(7);
        ll.Addfirst(8);

        ll.print();
        System.out.println(ll.Palindrome());
    }
}