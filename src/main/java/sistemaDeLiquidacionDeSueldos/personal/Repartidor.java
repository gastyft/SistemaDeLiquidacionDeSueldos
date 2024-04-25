package sistemaDeLiquidacionDeSueldos.personal;

public class Repartidor extends Empleado {

    private double sueldoBase;
    private double kilometrosRecorridos;
    private static double precioPorKilometro = 5000;

    public Repartidor(String nombre,double kilometrosRecorridos) {
        super(nombre);
        super.setLegajo("R");
        this.sueldoBase = 200000;
        this.kilometrosRecorridos = kilometrosRecorridos;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public double getKilometrosRecorridos() {
        return kilometrosRecorridos;
    }

    public void setKilometrosRecorridos(double kilometrosRecorridos) {
        this.kilometrosRecorridos = kilometrosRecorridos;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\ntipo de empleado: Repartidor" +
                "sueldoBase: " + sueldoBase +
                "\nkilometrosRecorridos: " + kilometrosRecorridos;
    }

    public void calcularSueldoMensual() {
        super.setSueldoFinal(this.sueldoBase + (this.kilometrosRecorridos * precioPorKilometro));
    }
}
