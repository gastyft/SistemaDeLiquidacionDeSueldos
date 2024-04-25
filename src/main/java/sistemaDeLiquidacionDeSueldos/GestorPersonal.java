package sistemaDeLiquidacionDeSueldos;

import sistemaDeLiquidacionDeSueldos.personal.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorPersonal {

    List<Empleado> empleadoList;

    public GestorPersonal() {
        this.empleadoList = new ArrayList<>();
    }

    public void crearPersonal() {
        try {
            Empleado empleado1 = new Vendedor("Carlitos Tevez", 15);
            empleadoList.add(empleado1);
            Empleado empleado2 = new Vendedor("Pechito Lopez", 17);
            empleadoList.add(empleado2);
            Empleado empleado3 = new Administrador("Roxana Pintos", AreaAdministrador.LOGISTICA);
            empleadoList.add(empleado3);
            Empleado empleado4 = new Administrador("Lucas Perez", AreaAdministrador.VENTAS);
            empleadoList.add(empleado4);
            Empleado empleado5 = new Administrador("Guri Martinez", AreaAdministrador.FINANZAS);
            empleadoList.add(empleado5);
            Empleado empleado6 = new Repartidor("Max Verstappen", 40.5);
            empleadoList.add(empleado6);
            Empleado empleado7 = new Repartidor("Mariano Werner", 50.3);
            empleadoList.add(empleado7);
            Empleado empleado8 = new Administrador("The Weekend", AreaAdministrador.VENTAS);
            empleadoList.add(empleado8);
            Empleado empleado9 = new Vendedor("Niko Hülkenberg", 4);
            empleadoList.add(empleado9);
            Empleado empleado10 = new Administrador("Pity Martinez", AreaAdministrador.LOGISTICA);
            empleadoList.add(empleado10);
        } catch (Exception e) {
            System.out.println("Error en funcion " + e);
        }
    }

    public Empleado buscar() {
        Empleado empleadoABuscar = null;
        try {
            System.out.println("Ingrese nombre a buscar");
            Scanner scanner = new Scanner(System.in);
            String nombre = scanner.nextLine();
            for (Empleado empleado : empleadoList) {
                if (empleado.getNombre().equals(nombre))
                    empleadoABuscar = empleado;
            }

        } catch (Exception e) {
            System.out.println("Algo salio mal " + e);
        }
        return empleadoABuscar;
    }

    public void eliminar() {
        try {
            Empleado empleadoAEliminar = buscar();
            if (empleadoAEliminar != null) {
                empleadoList.remove(empleadoAEliminar);
            } else System.out.println("Empleado no encontrado");
        } catch (Exception e) {
            System.out.println("Error Excepcion "
                    + e);
        }
    }

    public void editar() {

        Empleado empleadoAEditar = buscar();
        try {
            if (empleadoAEditar != null) {
                System.out.println("Ingrese nuevo nombre");
                Scanner scanner = new Scanner(System.in);
                String nuevoNombre = scanner.nextLine();
                if (empleadoAEditar instanceof Repartidor repartidor) {
                    System.out.println("Ingrese Kilometros ");
                    repartidor.setKilometrosRecorridos(scanner.nextDouble());
                    repartidor.setNombre(nuevoNombre);
                } else if (empleadoAEditar instanceof Vendedor vendedor) {
                    System.out.println("Ingrese nueva cantidad de ventas");
                    vendedor.setCantVentas(scanner.nextInt());
                    vendedor.setNombre(nuevoNombre);
                } else if (empleadoAEditar instanceof Administrador administrador) {
                    System.out.println("Ingrese nueva aerea 1- ventas, 2-Logistica o 3-Finanzas");
                    String o = scanner.nextLine().toUpperCase();
                    switch (o) {

                        case "1" -> administrador.setArea(AreaAdministrador.VENTAS);
                        case "2" -> administrador.setArea(AreaAdministrador.LOGISTICA);
                        case "3" -> administrador.setArea(AreaAdministrador.FINANZAS);
                        default -> System.out.println("Ingreso opcion incorrecta");
                    }
                }
            }
        }catch (Exception e){
            System.out.println("Algo salio mal "+e);
        }
    }

    public void mostrar() {
try {
    for (Empleado empleado : empleadoList) {
        if (empleado instanceof Vendedor vendedor)
            System.out.println(vendedor.toString());
        else if (empleado instanceof Administrador administrador)
            System.out.println(administrador.toString());
        else if (empleado instanceof Repartidor repartidor)
            System.out.println(repartidor.toString());

    }
}
catch (Exception e){
    System.out.println("Algo salio mal "+e);
}
    }
    public void mostrarUnEmpleado() {
        Empleado empleado = buscar();
        try {
            if (empleado != null) {
                if (empleado instanceof Vendedor vendedor)
                    System.out.println(vendedor.toString());
                else if (empleado instanceof Administrador administrador)
                    System.out.println(administrador.toString());
                else if (empleado instanceof Repartidor repartidor)
                    System.out.println(repartidor.toString());

            } else System.out.println("No se encontro el empleado o lo escribio mal");
        }
        catch (Exception e){
            System.out.println("Algo salio mal + "+e);
        }
    }

    public void calcularsueldoAUnEmpleado() {
        try {


            Empleado empleadoACalcular = buscar();
            if (empleadoACalcular != null) {
                empleadoACalcular.calcularSueldoMensual();
                empleadoACalcular.toString();
            } else System.out.println("No se encontro el empleado solicitado o esta mal escrito");
        }
catch (Exception e){
    System.out.println("Algo salio mal "+ e);
}
    }
    public void calcularSueldosATodos() {
        try {
            for (Empleado empleado : empleadoList) {
                empleado.calcularSueldoMensual();
            }
            mostrar();
        } catch (Exception e){
            System.out.println("Algo salio mal "+ e);
        }
    }
}


