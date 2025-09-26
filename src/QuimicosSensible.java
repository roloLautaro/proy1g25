public class QuimicosSensible extends Quimico {
    private int mes; // fecha limite antes de deteriodo
    public QuimicosSensible(String codigo, String nombre, double peso, int peligro, int efectividad, int mes) {
        super(codigo, nombre, peso, peligro, efectividad);
        this. mes = mes;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    @Override
    public int getEfectividad() { //  muestra la efectividad del producto despues del mes
        double nueva_efectivida = super.getEfectividad()-(super.getEfectividad() * 0.1) ;// la efectividad original - la efectividad despues de los meses
        return (int)nueva_efectivida;
    }




}
