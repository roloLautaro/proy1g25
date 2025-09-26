public class Quimico {
    private String codigo;
    private String nombre;
    private double peso;
    private int peligro;
    private int efectividad;

    public Quimico(String codigo, String nombre, double peso, int peligro, int efectividad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.peso = peso;
        this.peligro = peligro;
        this.efectividad = efectividad;
    }

    public Quimico() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getPeligro() {
        return peligro;
    }

    public void setPeligro(int peligro) {
        this.peligro = peligro;
    }

    public int getEfectividad() {
        return efectividad;
    }

    public void setEfectividad(int efectividad) {
        this.efectividad = efectividad;
    }
}
