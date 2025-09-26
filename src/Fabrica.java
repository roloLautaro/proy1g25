public class Fabrica {
    // creamos los head para la cracion de las Areas y otro head para el listado de los productos quimicos sin repetirn
    private NodoQuimicos headQuimicos;
    private NodoArea headArea;

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
}
