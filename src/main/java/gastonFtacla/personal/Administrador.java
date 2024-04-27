package gastonFtacla.personal;

public class Administrador extends Empleado {
    private double sueldoBase;
    private AreaAdministrador area;

    public Administrador(String nombre, AreaAdministrador area) {
        super(nombre);
        super.setLegajo( "A");
        this.sueldoBase = 600000;
        this.area = area;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public AreaAdministrador getArea() {
        return area;
    }

    public void setArea(AreaAdministrador area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return super.toString() + "\n tipo de empleado: Administrador" +
                "\nsueldoBase: " + sueldoBase +
                "\n area=" + area+
                "\n-----------------------------------------------";
    }

    public void calcularSueldoMensual() {

        super.setSueldoFinal(this.sueldoBase);
    }

}
