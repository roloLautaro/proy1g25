public class Area {
    public String codigo;// identidicacion del area de producción de quimicos
    public NodoQuimicos top; // pila de los productos quimcos para cada área

    public Area(String codigo)
    {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    // push para agregar el producto químico
    public void pushQuimico(Quimico q) // agregar datos
    {
        // creamos nuevo producto
        NodoQuimicos nuevo = new NodoQuimicos(q);
        nuevo.setNext(top);
        top = nuevo;
    }

    // pop Quimicos para retirar el primer elemento
    public Quimico popQuimico()
    {
        if(top == null)
            return null;
        Quimico aux = top.getData();
        top = top.getNext();
        return aux;
    }
    // mostrar datos del area
    public void mostrarQuimicos()
    {
        NodoQuimicos aux = top;
        while(aux != null){
            System.out.println(aux.getData());
            aux = top.getNext();
        }
    }

}
