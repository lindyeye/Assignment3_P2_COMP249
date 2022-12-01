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
}
