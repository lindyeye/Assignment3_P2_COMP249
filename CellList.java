import java.util.NoSuchElementException;
import java.util.Scanner;

public class CellList implements Cloneable{
    
    public class CellNode 
    {
        Scanner sc = new Scanner(System.in);
        private CellPhone c;
        private CellNode next;
        
        public CellNode()
        {
            c = null;
            next = null;
            size++;
        }
        public CellNode(CellPhone cr, CellNode xt)
        {
            c = cr;
            next = xt;
            size++;
        }
        
        public CellNode clone()
        {
            size++;
            return new CellNode(this);
        }
        
        public CellNode(CellNode cn)
        {
            c = cn.c.clone(sc);
            next = cn.next;
            size++;
        }

        public void setCellPhone(CellPhone cr)
        {
            c = cr;
        }
        public void setNext(CellNode xt)
        {
            next = xt;
        }
        
    }
    private CellNode head;
    private static int size = 0;

    public CellList()
    {
        head = null;
    }
    //copy constructor
    public CellList(CellList lt)
    {
        if(lt.head == null)
            head = null;
        else
        {
            head = null;
            CellNode t1,t2,t3;

            t1 = lt.head;
            t2 = t3 = null;
            while(t1 != null)
            {
                if (head == null)
                {
                    t2 = new CellNode(t1);
                    head = t2;
                }
                else
                {
                    t3 = new CellNode(t1);
                    t2.next = t3;
                    t2 = t3;
                }
                t1 = t1.next;
            }
            t2 = t3 = null;
        }
    }
    
    public void addToStart(CellPhone c)
    {
        head = new CellNode(c,head);
    }
    //the exception is for invalid integer, check if it works later
    public void insertAtIndex(CellPhone c, int i) //throws NoSuchElementException
    {
        CellNode node = new CellNode();
        node.c = c;
        node.next = null;
        if(i < 0 || i > CellList.size - 1)
        {
            throw new NoSuchElementException();
        }
        if (head == null)
        {
            if(i != 0)
            {
                return;
            }
            else
            {
                head = node;
            }
        }
        if(head != null && i == 0)
        {
            node.next = head;
            head = node;
            return;
        }

        CellNode current = head;
        CellNode prev = null;

        int j = 0;

        while(j < i)
        {
            prev = current;
            current = current.next;

            if(current == null)
            {
                break;
            }
            j++;
        }

        node.next = current;
        prev.next = node;
    }
    //i think this works? it should unlink the node from the list so it'll be deleted
    public void deleteFromIndex(int i) //throws NoSuchElementException
    {
        CellNode temp = head;
        if(i < 0 || i > CellList.size)
        {
            throw new NoSuchElementException();
        }
        else if(head == null)
        {
            System.out.println("nothin to delete");
            return;
        }
        else if(i == 0)
        {
            head = temp.next;
        }
        for(int j = 0; temp != null && j < i - 1; j++)
        {
            temp = temp.next;
        }
        CellNode next = temp.next.next;
        temp.next = next;

    }
}
