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

    public void Addfirst(int data){
        //1 - Create new node
        Node newNode = new Node(data);

        if(head == null){
            head = tail = newNode;
            return;
        }

        //2 - newNode next = Head
        newNode.next = head; //link

        //3 - head = newNode
        head = newNode;
    }
    public static void main(String args[]){
        LinkedList ll = new LinkedList();
        ll.Addfirst(1);
        ll.Addfirst(2);
        System.out.println(ll);
    }
}