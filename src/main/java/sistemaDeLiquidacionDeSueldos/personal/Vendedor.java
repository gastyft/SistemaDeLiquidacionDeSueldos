package sistemaDeLiquidacionDeSueldos.personal;

public class Vendedor extends Empleado {

    private double sueldoBase;
    private static double comisionPorVentas = 0.15;
    private int cantVentas;

    public Vendedor(String nombre, int cantVentas) {
        super(nombre);
        super.setLegajo("V");
        this.sueldoBase = 400000;
        this.cantVentas=cantVentas;
    }

    public static double getComisionPorVentas() {
        return comisionPorVentas;
    }

    public static void setComisionPorVentas(double comisionPorVentas) {
        Vendedor.comisionPorVentas = comisionPorVentas;
    }

    public int getCantVentas() {
        return cantVentas;
    }

    public void setCantVentas(int cantVentas) {
        this.cantVentas = cantVentas;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTipo de empleado: Vendedor" +
                "\nsueldoBase:" + sueldoBase +
                "\ncomisionPorVentas: " + comisionPorVentas +
                "\ncantVentas: " + cantVentas;
    }

    public void calcularSueldoMensual() {
        super.setSueldoFinal(this.sueldoBase * comisionPorVentas);
    }

}
