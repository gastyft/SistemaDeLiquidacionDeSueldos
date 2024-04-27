package gastonFtacla.personal;

public class Vendedor extends Empleado implements Supervisable {
    private double sueldoBase;
    private int cantVentas;
    private double montoTotalPorVentas;
    private boolean isSupervisable; //Esta supervisado o no
    private Supervisor supervisorAsignado;

    public Vendedor(String nombre, int cantVentas, double montoTotalPorVentas) {  //Constructor
        super(nombre); //Le pasa el nombre completo a la clase Padre Empleado
        super.setLegajo("V"); //Se le pasa el tipo de empleado que es para luego en el constructor se le concatene el numero de id autoincremental
        this.sueldoBase = 400000;
        this.cantVentas = cantVentas;
        this.montoTotalPorVentas = montoTotalPorVentas;
        this.isSupervisable = false;
    }

    //Getters y setters de atributos
    public int getCantVentas() {
        return cantVentas;
    }

    public void setCantVentas(int cantVentas) {
        this.cantVentas = cantVentas;
    }


    public double getMontoTotalPorVentas() {
        return montoTotalPorVentas;
    }

    public void setMontoTotalPorVentas(double montoTotalPorVentas) {
        this.montoTotalPorVentas = montoTotalPorVentas;
    }

    public boolean isSupervisable() {
        return isSupervisable;
    }

    public void setSupervisable(boolean supervisable) {
        isSupervisable = supervisable;
    }

    public Supervisor getSupervisorAsignado() {
        return supervisorAsignado;
    }

    public void setSupervisorAsignado(Supervisor supervisorAsignado) {
        this.supervisorAsignado = supervisorAsignado;
    }

    @Override
    public String toString() { //Metodo para mostrar atributos de la instancia de esta clase
        return super.toString() + "\nTipo de empleado: Vendedor" +
                "\nsueldo Base:" + sueldoBase +
                "\nMonto Total Por Ventas: " + montoTotalPorVentas +
                "\ncantidad Ventas: " + cantVentas+
                "\n-----------------------------------------------";
    }

    public void calcularSueldoMensual() {
        try {
            if (this.montoTotalPorVentas <= 500000)// i. Ventas hasta $500.000: 10% de comisión.
                super.setSueldoFinal(this.sueldoBase + (this.montoTotalPorVentas * 0.1));
            else if (this.montoTotalPorVentas > 500000 && this.montoTotalPorVentas < 1000000) // ii. Ventas entre $500.001 y $1.000.000: 15% de comisión.
                super.setSueldoFinal(this.sueldoBase + (this.montoTotalPorVentas * 0.15));
            else if (this.montoTotalPorVentas >= 1000000)  // iii. Ventas superiores a $1.000.000: 20% de comisión
                super.setSueldoFinal(this.sueldoBase + (this.montoTotalPorVentas * 0.2));


        } catch (Exception e) {
            System.out.println("Algo salio mal " + e);
        }

    }

    @Override
    public void iniciarSupervision(Supervisor supervisor) {
        this.supervisorAsignado = supervisor;
        this.isSupervisable=true; //Pasa a estar supervisado
    }

    @Override
    public void finalizarSupervision() {
        this.isSupervisable = false; //Deja de estar supervisdo
        this.supervisorAsignado = null;
        //Seteo a null pero no me deja conforme hacer esa igualacion para saber que no tiene mas supervisor


    }
}
