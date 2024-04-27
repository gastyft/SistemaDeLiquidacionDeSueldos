package gastonFtacla.personal;

import java.util.ArrayList;
import java.util.List;

public class Supervisor extends Empleado {
    private List<Vendedor> vendedorList;
    private double sueldoBasico;

    public Supervisor(String nombre) {
        super(nombre);
        super.setLegajo("S");
        this.vendedorList = new ArrayList<>();
        this.sueldoBasico = 600000;

    }

    @Override
    public String toString() {
        return super.toString() +
                "\nTipo de empleado: Supervisor" +
                "\nSueldo basico=" + sueldoBasico+
                "\nLista de vendedores\n" + vendedorList +

                "\n-----------------------------------------------";
    }

    public List<Vendedor> getVendedorList() {
        return vendedorList;
    }

    public void setVendedorList(List<Vendedor> vendedorList) {
        this.vendedorList = vendedorList;
    }

    @Override
    public void calcularSueldoMensual() {
        double ventasDeVendedores = 0;
        for (Vendedor vendedor : vendedorList) {  //Recorre la lista de vendedores para sumar los montos totales de ventas
            //de cada empleado para luego calcularle el porcentaje y se lo suma al sueldo base y con eso obtiene el sueldo final o sueldo del mes del supervisor
            ventasDeVendedores += vendedor.getMontoTotalPorVentas();
        }
        super.setSueldoFinal(this.sueldoBasico + (ventasDeVendedores * 0.03));
    }
}
