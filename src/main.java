public class main {
    public static void main(String [] args){
        QuimicosSensible p1 = new QuimicosSensible("EII","H2O",20.0,1,100,100);
        System.out.println(p1.getEfectividad());
        Quimico q1 = new Quimico("E44","ClHO2",40.2,4,70);

        Fabrica mcLautaro = new Fabrica();
        Area nArea = new Area("PPP");
        Quimico q = new Quimico("IBN","Cl2OH",50.50,5,89);
        Quimico q3 = new Quimico("IBN","Cl2OH",50.50,5,89);
        Quimico q2 = new Quimico("pop","ass",50.12,2,89);
        Quimico q4 = new Quimico("pip","dad",50.55,1,89);
        mcLautaro.agregarArea(nArea);
        mcLautaro.registrarQuimicoEnArea("PPP",q);
        mcLautaro.registrarQuimicoEnArea("PPP",q2);
        mcLautaro.registrarQuimicoEnArea("PPP",q4);

        mcLautaro.listaDeQuimicos();
    }
}
