package sistemaDeLiquidacionDeSueldos.personal;

public abstract class Empleado {

    private static int autoId = 0;
    private final int id;
    private String nombre;
    private String legajo;
private  double sueldoFinal;
    public Empleado(String nombre) {
        this.nombre = nombre;

        this.id = autoId++;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo+ this.id;
    }

    public double getSueldoFinal() {
        return sueldoFinal;
    }

    public void setSueldoFinal(double sueldoFinal) {
        this.sueldoFinal = sueldoFinal;
    }

    @Override
    public String toString() {
        return "-----------------------------------------------"+
                "\nEmpleado: " +nombre+
                "\nid: " + id +
                "\nlegajo: " + legajo;
    }
    public abstract void  calcularSueldoMensual();
}
