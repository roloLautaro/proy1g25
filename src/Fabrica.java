public class Fabrica {
    // creamos los head para la cracion de las Areas y otro head para el listado de los productos quimicos sin repetirn
    private NodoQuimicos headQuimicos; // este head es para crear la lista de los productos
    private NodoArea headArea; // las areas de produccion de los quimicos (pila de quimicos fabricados)
    private int totalQuimcSens;


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

                aux.getData().pushQuimico(q); // se agrega a la area designada en forma de pila

                agregarProducto(q); // se registra en el listado head

                if(q instanceof QuimicosSensible) // contador de quimicos sensible
                    totalQuimcSens++;

                return true;
            }
            aux = aux.getNext();
        }
        return false;
    }

    public void listaDeQuimicos()
    {
        System.out.println("Listado productos Quimicos");
        NodoQuimicos aux = headQuimicos;
        while (aux != null)
        {
            System.out.println("["+aux.getData().getCodigo()+"-"+aux.getData().getNombre()+"]");
            aux = aux.getNext();
        }
    }

    // eliminar productos --- si es que se elimina la totalidad de un producto se elimina del listado de headQuimicos
    public boolean eliminarQuimicoDelArea(String codigoArea, String codigoQuimico)
    {
        //1) buscar el área
        NodoArea aux = headArea;
        Area encontrado = null; // contenedor
        while(aux != null)
        {
            if (aux.getData().getCodigo().equals(codigoArea)){
                encontrado = aux.getData();
                break;
            }
            aux = aux.getNext();
        }
        if(encontrado == null) return false; // no se encontro
        //2) eliminar de la area designada
        Quimico eliminado = encontrado.eliminarQuimicoPorCodigo(codigoQuimico);
        if (eliminado == null)
            return false; // no se encontró el producto quimico en esa área

        if (eliminado instanceof QuimicosSensible)
            totalQuimcSens--;

        //3) verificar si exite mas producto en otras áreas
        if(!existeEnArea(codigoQuimico))
            eliminarDelListado(codigoQuimico);

        return true;
    }
    private boolean existeEnArea(String codigo)
    {
        NodoArea aux = headArea;
        while(aux != null)
        {
            Area a = aux.getData();
            if(a.contiene(codigo))
                return true;
            aux = aux.getNext();
        }
        return false;
    }
    private void eliminarDelListado(String codigo)
    {
        NodoQuimicos actual= headQuimicos;
        NodoQuimicos anterior = null;

        while (actual != null){
            if(actual.getData().getCodigo().equals(codigo)){
                if(anterior == null){
                    headQuimicos = actual.getNext();
                }else{
                    anterior.setNext(actual.getNext());
                }
                return;
            }
            anterior = actual;
            actual = actual.getNext();
        }
    }

    public int getTotalQuimcSens()
    {
        return totalQuimcSens;
    }

    public void buscarQuimico(String codigo){
        int cantidad = 0;
        Quimico busqueda = null;

        NodoArea aux = headArea;
        while (aux != null)
        {
            Area a = aux.getData();
            NodoQuimicos auxQui = a.getTop(); // accedemos al top de la pila
            //recorrer la pila
            while (auxQui != null){
                Quimico q = auxQui.getData();
                if(q.getCodigo().equals(codigo)) {
                    cantidad++;
                    if (busqueda == null)
                        busqueda = q;
                }
                auxQui = auxQui.getNext();
            }
            aux = aux.getNext();

            if(cantidad == 0){
                System.out.println("No se encontró el producto con código " + codigo);
            } else {
                System.out.println("Código: " + codigo);
                System.out.println("Nombre: " + busqueda.getNombre());


                if(busqueda instanceof QuimicosSensible){
                    QuimicosSensible sen = (QuimicosSensible) busqueda;
                    System.out.println("Duración: " + sen.getMes() + " meses");
                    System.out.println("Efectividad del producto despues de los"+ sen.getMes() +" es: "+sen.getEfectividad());
                }

                System.out.println("Cantidad total en el Área: " + cantidad);
            }
        }
    }

    public void listaProductosPorCalificacionDePeligro(int calificacion){
        if(calificacion < 1 || calificacion > 5) {
            System.out.println("La calificación debe ser un número entero entre 1 y 5.");
            return;
        }
            boolean encontrado = false ;
            NodoArea auxAr = headArea;
            while(auxAr != null){
                Area a = auxAr.getData();
                NodoQuimicos auxQui = a.getTop();

                while(auxQui != null){
                    Quimico q = auxQui.getData();
                    if(q.getPeligro() == calificacion){
                        if(!encontrado){
                            System.out.println(" Productos Quimicos con calificación " + calificacion + ":");
                            encontrado = true;
                        }
                        System.out.println(" - " + q.toString() +"| Área: "+a.getCodigo());
                    }
                    auxQui = auxQui.getNext();
                }
                auxAr = auxAr.getNext();
            }

            if(!encontrado){
                System.out.println("No se encontraron productos con calificación " + calificacion);
            }
        }
    }



