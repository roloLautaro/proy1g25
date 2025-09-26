public class NodoArea {
    private Area data;
    private NodoArea next;

    public NodoArea(Area data){
        this.data = data;
    }
    public NodoArea(Area data, NodoArea next)
    {
        this.data = data;
        this.next = next;
    }

    public NodoArea getNext() {
        return next;
    }

    public void setNext(NodoArea next) {
        this.next = next;
    }

    public Area getData() {
        return data;
    }
}
