public class NodoQuimicos {
    private Quimico data;
    private NodoQuimicos next;

    public NodoQuimicos(Quimico p){
        data = p;
    }
    public NodoQuimicos(Quimico p, NodoQuimicos n)
    {
        data = p;
        next = n;
    }

    public Quimico getData()
    {
        return data;
    }
    public NodoQuimicos getNext()
    {
        return next;
    }
    public void setNext(NodoQuimicos n)
    {
        next = n;
    }
}
