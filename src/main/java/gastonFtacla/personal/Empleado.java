package gastonFtacla.personal;

public abstract class Empleado {

    private static int autoId = 0;
    private final int id;
    private String nombre;
    private String legajo;
private  double sueldoFinal;
    public Empleado(String nombre) {   ///EL LEGAJO SE SETEA CUANDO SE CREA LA INSTANCIA DE CADA CLASE.
        //Es decir que cuando se crea
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

    public void setLegajo(String legajo) {//SE SETEA LEGAJO AL CREAR LA INSTANCIA DE LA CLASE
        //Para que sea personalizable segun tipo de instancia.
        //Si es Supervisor se Asigna S + el id autoincremental
        //Si es Vendedor se asigna V + el id autoincremental
        //Si es Administrador se asigna A + el id autoincremental
        //Si es Repartidor se asigna R + el id autoincremental
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
                "\nlegajo: " + legajo+
                "\nSueldoTotal= "+ sueldoFinal;
    }
    public abstract void  calcularSueldoMensual();
}
