public class Fabrica {
    // creamos los head para la cracion de las Areas y otro head para el listado de los productos quimicos sin repetirn
    private NodoQuimicos headQuimicos; // este head es para crear la lista de los productos
    private NodoArea headArea; // las areas de produccion de los quimicos (pila de quimicos fabricados)

    private boolean verficarProducto(Quimico q) // este metodo nos ayuda a verificar si ya esta el elemeto registrado
    {
        NodoQuimicos aux = headQuimicos;
        while(aux != null)
        {
            if(aux.getData().equals(q))
                return true;
            aux = aux.getNext();
        }
        return false;
    }
    private void agregarProducto(Quimico q)
    {
        if (!verficarProducto(q)){ // el producto quimico no se encuntra
            NodoQuimicos nuevo = new NodoQuimicos(q); // se crea el nodo que contien la data
            if(headQuimicos == null) // si es que el listado de se encuentra vacio
            {
                headQuimicos = nuevo;
                return; // termina el metodo, es un break
            }
            NodoQuimicos aux = headQuimicos; // recorrer hasta el finla para agregar y tener un orden
            while(aux.getNext() != null)
                aux = aux.getNext(); // llega al final

            aux.setNext(nuevo);  // inserta al final
        }

    }

    // tenemos que agrar las areas de produccion de los quimicos
    public boolean agregarArea(Area a)
    {
        // creamos el neuvo nodo de Area
        NodoArea nuevo = new NodoArea(a);
        if(headArea == null) // cuando esta vacio, ingresa de una y el return es para terminar el metodo
        {
            headArea = nuevo;
            return true;
        }
        //verificar si el nodo que vamos a agregar esta repetido
        NodoArea aux = headArea;
        while(aux.getNext() != null)
        {
            if(aux.getData().getCodigo().equals(a.getCodigo())) return  false;
            aux = aux.getNext();
        }
        //verificar el ultimo nodo
        if(aux.getData().getCodigo().equals(a.getCodigo())) return false;

        aux.setNext(nuevo);
        return true;
    }
    public boolean registrarQuimicoEnArea(String idArea, Quimico q)
    {
        NodoArea aux = headArea;
        while(aux != null)
        {
            if (aux.getData().getCodigo().equals(idArea)){
                aux.getData().pushQuimico(q);
                agregarProducto(q);
                return true;
            }
            aux = aux.getNext();
        }
        return false;
    }

    public void listaDeQuimicos()
    {

    }

}
