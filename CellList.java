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
        }
        public CellNode(CellPhone cr, CellNode xt)
        {
            c = cr;
            next = xt;
        }
        
        public CellNode clone()
        {
            return new CellNode(this);
        }
        
        public CellNode(CellNode cn)
        {
            c = cn.c.clone(sc);
            next = cn.next;
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
    public void insertAtIndex(CellPhone c, int i) //throws NoSuchElementException
    {

    }
}
