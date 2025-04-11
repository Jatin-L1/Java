class reverse{

    Node rev(Node head){
        if(head==null || head.next==null) return null;
        Node temp = rev(head.next);
        head.next.next = head;
        head.next = null;
        return temp;

    }
}