import java.io.*;

public class main {
    public static void main(String[] args) throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        // instanciar la fabria
        Fabrica fabrica = new Fabrica();
        //bandera para el menu
        boolean seguir = true;

        while (seguir) {
            mostratOpcionesMenu();
            int opcion = Integer.parseInt(leer.readLine());

            switch (opcion) {
                case 0:
                    documentacionProyecto();
                    break;

                case 1:
                    System.out.println("Ingrese el codigo de la área a crear");
                    String codigoArea = leer.readLine();
                    if (fabrica.agregarArea(new Area(codigoArea))) {
                        System.out.println("Se agregó correctamente");
                    } else {
                        System.out.println("No se pudo agragar");
                    }
                    break;

                case 2:
                    // crear la clase quimica
                    System.out.println("¿El producto es sensible al teimpo ? (S/N)");
                    String respuesta = leer.readLine();
                    if (respuesta.equals("N")) {
                        System.out.println("Ingrese el código del Químico");
                        String codigoQui = leer.readLine();
                        System.out.println("Ingrese el nombre del Químico");
                        String nombreQui = leer.readLine();
                        System.out.println("Ingrese la cantidad de Químico a producir (kg)");
                        double pesoQui = Double.parseDouble(leer.readLine());
                        System.out.println("Ingrese el nivel de peligro (1 al 5)");
                        int peligroQui = Integer.parseInt(leer.readLine());
                        System.out.println("Ingrese efectividad del Químico");
                        int efectividad = Integer.parseInt(leer.readLine());
                        // generar nuevo objeto quimico
                        Quimico nuevoQuimico = new Quimico(codigoQui, nombreQui, pesoQui, peligroQui, efectividad);
                        System.out.println("Ingrese el código del Área para registrar el Químico");
                        codigoArea = leer.readLine();
                        if (fabrica.registrarQuimicoEnArea(codigoArea, nuevoQuimico)) {
                            System.out.println("Se ingresó correctamente");
                        } else {
                            System.out.println("No se pudo agregar");
                        }
                    } else if (respuesta.equals("S")) {
                        System.out.println("Ingrese el código del Químico");
                        String codigoQui = leer.readLine();
                        System.out.println("Ingrese el nombre del Químico");
                        String nombreQui = leer.readLine();
                        System.out.println("Ingrese la cantidad de Químico a producir (kg)");
                        double pesoQui = Double.parseDouble(leer.readLine());
                        System.out.println("Ingrese el nivel de peligro (1 al 5)");
                        int peligroQui = Integer.parseInt(leer.readLine());
                        System.out.println("Ingrese efectividad del Químico");
                        int efectividad = Integer.parseInt(leer.readLine());
                        System.out.println("Ingrese los meses que funciona correctamente hasta que comience a perder efectividad");
                        int mes = Integer.parseInt(leer.readLine());
                        // generar nuevo objeto quimico
                        QuimicosSensible nuevoQuimicoS = new QuimicosSensible(codigoQui, nombreQui, pesoQui, peligroQui, efectividad, mes);
                        System.out.println("Ingrese el código del Área para registrar el Químico");
                        codigoArea = leer.readLine();
                        if (fabrica.registrarQuimicoEnArea(codigoArea, nuevoQuimicoS)) {
                            System.out.println("Se ingresó correctamente");
                        } else {
                            System.out.println("No se pudo agregar");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el codigo del Área en donde esta el producto a eliminar");
                    codigoArea = leer.readLine();
                    System.out.println("Ingrese el código del Químico a eliminar");
                    String codigoQui = leer.readLine();
                    if(fabrica.eliminarQuimicoDelArea(codigoArea,codigoQui)){
                        System.out.println("Se Elimino correctamente");
                    }else{
                        System.out.println("ERROR");
                    }
                    break;

                case 4:
                    System.out.println("Cantidad de Quimicos Sensibles = "+fabrica.getTotalQuimcSens());
                    break;

                case 5:
                    System.out.println("Ingrese el grado de peligro para crear el listado");
                    int peligro = Integer.parseInt(leer.readLine());
                    fabrica.listaProductosPorCalificacionDePeligro(peligro);
                    break;

                case 6:
                    System.out.println("Ingrese el codigo del Quimico a buscar");
                    codigoQui = leer.readLine();
                    fabrica.buscarQuimico(codigoQui);
                    break;

                case 7:
                    fabrica.listaDeQuimicos();
                    break;

                case 8:
                    System.out.println("PROCESO FINALIZADO");
                    break;

                default:
                    System.out.println("Ingrese una opción valida");
                    break;
            }
        }
    }

    private static void documentacionProyecto() {
        System.out.println("Nombre de la Clase A: Fabrica");
        System.out.println("Nombre de la Clase B: Area");
        System.out.println("Atributo identificador clase B: codigo(String)");
        System.out.println("Principio utilizado: Pila");
        System.out.println("Nombre de la Clase C: Quimico");
        System.out.println("Atributo identificador: codigo(String)");

    }

    private static void mostratOpcionesMenu() {
        System.out.println("\n0. Documentación");
        System.out.println("1. Crear nueva área");
        System.out.println("2. Agregar Quimico");
        System.out.println("3. Eliminar Químico");
        System.out.println("4. Cantidad de químicos sensibles");
        System.out.println("5. Lista de productos según su grado de peligro");
        System.out.println("6. Buscar Químicos");
        System.out.println("7. Listado de Químicos");
        System.out.println("8. Salir\n");

    }
}
