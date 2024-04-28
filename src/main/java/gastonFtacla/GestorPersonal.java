package gastonFtacla;

import gastonFtacla.personal.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorPersonal implements Supervisable {

    List<Empleado> empleadoList;  //Supervisor lo considero como un empleado mas del personal
    //Otra forma de realizarlo era con otro gestor de supervisores. y una lista mas

    public GestorPersonal() {
        this.empleadoList = new ArrayList<>();
    }

    public void crearPersonal() {  //Metodo para crear personal de todos los tipos
        try {
            Empleado empleado1 = new Vendedor("Carlitos Tevez", 15, 900000);
            empleadoList.add(empleado1);
            Empleado empleado2 = new Vendedor("Pechito Lopez", 17, 1130000);
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
            Empleado empleado8 = new Administrador("The Weeknd", AreaAdministrador.VENTAS);
            empleadoList.add(empleado8);
            Empleado empleado9 = new Vendedor("Niko Hülkenberg", 4, 400000);
            empleadoList.add(empleado9);
            Empleado empleado10 = new Administrador("Pity Martinez", AreaAdministrador.LOGISTICA);
            empleadoList.add(empleado10);
            Empleado empleado11 = new Supervisor("Gaston Ftacla");
            empleadoList.add(empleado11);
            Empleado empleado12 = new Supervisor("Mai Berterreche");
            empleadoList.add(empleado12);
            Empleado empleado13 = new Vendedor("Carlos Sainz", 10, 650000);
            empleadoList.add(empleado13);
            Empleado empleado14 = new Vendedor("Mario Bros", 23, 1220000);
            empleadoList.add(empleado14);
            Empleado empleado15 = new Vendedor("Checo Perez", 6, 450000);
            empleadoList.add(empleado15);

        } catch (Exception e) {
            System.out.println("Error en funcion Crear " + e);
        }
    }

    public Empleado buscar() {  //Busca un empleado de cualquier instancia
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
        return empleadoABuscar; //Devuelve la instancia de la clase encontrada o null si no la encontro
    }

    public void eliminar() {
        try {
            mostrar();
            Empleado empleadoAEliminar = buscar();
            if (empleadoAEliminar != null) {
                empleadoList.remove(empleadoAEliminar);
                System.out.println("Empleado eliminado con Exito");
            } else System.out.println("Empleado no encontrado");
        } catch (Exception e) {
            System.out.println("Error Excepcion " + e);
        }
    }

    public void editar() {
        mostrar();
        Empleado empleadoAEditar = buscar();
        try {
            if (empleadoAEditar != null) {
                System.out.println("Ingrese nuevo nombre");
                Scanner scanner = new Scanner(System.in);
                String nuevoNombre = scanner.nextLine();
                if (empleadoAEditar instanceof Repartidor repartidor) {
                    System.out.println("Ingrese Kilometros ");
                    repartidor.setKilometrosRecorridos(scanner.nextDouble());
                    repartidor.calcularSueldoMensual();
                    repartidor.setNombre(nuevoNombre);
                } else if (empleadoAEditar instanceof Vendedor vendedor) {
                    System.out.println("Ingrese nueva cantidad de ventas");
                    vendedor.setCantVentas(scanner.nextInt());
                    System.out.println("INGRESE NUEVO MONTO TOTAL DE VENTAS");
                    vendedor.setMontoTotalPorVentas(scanner.nextDouble());
                    vendedor.setNombre(nuevoNombre);
                    vendedor.calcularSueldoMensual();
                } else if (empleadoAEditar instanceof Administrador administrador) {
                    System.out.println("Ingrese nueva aerea 1- ventas, 2-Logistica o 3-Finanzas");
                    String o = scanner.nextLine().toUpperCase();
                    // do {
                    //  System.out.println("Ingrese nueva aerea 1- ventas, 2-Logistica o 3-Finanzas");
                    //o=scanner.nextLine();
                        switch (o) {
                            case "1" -> administrador.setArea(AreaAdministrador.VENTAS);
                            case "2" -> administrador.setArea(AreaAdministrador.LOGISTICA);
                            case "3" -> administrador.setArea(AreaAdministrador.FINANZAS);
                            default -> System.out.println("Ingreso opcion incorrecta");
                        }
                //ESTA MAL EL DO-WHILE    } while (o.equals("1") || o.equals("2") || o.equals("3"));
                    //Si se usa do while entonces es } while (!o.equals("1") || !o.equals("2") || !o.equals("3"));
                    administrador.setNombre(nuevoNombre);
                }
            }
        } catch (Exception e) {
            System.out.println("Algo salio mal " + e);
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
                else if (empleado instanceof Supervisor supervisor)
                    System.out.println(supervisor.toString());

            }
        } catch (Exception e) {
            System.out.println("Algo salio mal " + e);
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
                else if (empleado instanceof Supervisor supervisor)
                    System.out.println(supervisor.toString());

            } else System.out.println("No se encontro el empleado o lo escribio mal");
        } catch (Exception e) {
            System.out.println("Algo salio mal + " + e);
        }
    }

    public void calcularsueldoAUnEmpleado() {
        try {
            mostrar();
            Scanner scanner = new Scanner(System.in);
            Empleado empleadoACalcular = buscar();
            if (empleadoACalcular != null) { //Busca un empleado si devuelve la instancia de esa clase
                if (empleadoACalcular instanceof Vendedor vendedor) { //Si es vendedor
                    System.out.println("\n\nIngrese nuevo monto total de ventas");
                    vendedor.setMontoTotalPorVentas(scanner.nextDouble()); //Pide nuevo monto de vendedor
                    vendedor.calcularSueldoMensual();   //Calcula el nuevo sueldo mensual
                    System.out.println(empleadoACalcular.toString());  //Muestro de esa instancia
                } else if (empleadoACalcular instanceof Repartidor repartidor) { //Si es instancia de Repartidor
                    System.out.println("\n\nIngrese nueva cantidad de Kilometros recorridos");
                    repartidor.setKilometrosRecorridos(scanner.nextInt());  //Pide Kilometros recorridos
                    repartidor.calcularSueldoMensual(); // llama metodo para calcular nuevo sueldo
                    System.out.println(empleadoACalcular.toString()); //Muestra la instancia actualizada
                } else {
                    empleadoACalcular.calcularSueldoMensual();  //Si pertenece a administrador o supervisor, solo lo calcula
                    //Si supervisor no tiene empleados en su lista solo devuelve el sueldo final = al sueldo base
                    System.out.println(empleadoACalcular.toString());
                }

            } else System.out.println("No se encontro el empleado solicitado o esta mal escrito");
        } catch (Exception e) {
            System.out.println("Algo salio mal " + e);
        }
    }

    public void calcularSueldosATodos() { //Calcula sueldos a todos los empleados
        try {
            for (Empleado empleado : empleadoList) {
                empleado.calcularSueldoMensual(); //Llamo al  metodo de cada instancia sobrescrito con sus respectivas
                //condiciones de cobro
            }
            mostrar();
        } catch (Exception e) {
            System.out.println("Algo salio mal " + e);
        }
    }

    public void mostrarSupervisores() {
        for (Empleado empleado : empleadoList) {  //Muestro SUPERVISORES solamente
            if (empleado instanceof Supervisor supervisor) {
                System.out.println(supervisor.toString());// VEr
            }
        }
    }

    public Supervisor buscarSupervisor() {
        Scanner scanner = new Scanner(System.in);
        Supervisor supervisorABuscar = null;
        try {
            System.out.println("\n\n Elija supervisor por nombre");
            String nombre = scanner.nextLine();

            for (Empleado empleado : empleadoList) {       //Si elige bien el supervisor entra al if y llamo al metodo iniciarSupervision de la interfaz Supervisable
                if (empleado instanceof Supervisor supervisor && supervisor.getNombre().equals(nombre)) {
                    supervisorABuscar = supervisor; //Asigno la instancia a supervisorABuscar para que devuelva
                }
            }
            return supervisorABuscar; //Devuelve instancia de supervisor
        } catch (Exception e) {
            System.out.println("Algo salio mal" + e);
        }
        return supervisorABuscar; //Devuelve null si no encontro un supervisor
    }

    public void asignarEmpleadosASupervisor() { //Asigna vendedor a un supervisor llamando a
        // mostrarSupervisores,buscarSupervisor e iniciarSupervision
        Scanner scanner = new Scanner(System.in);
        try {
            mostrarSupervisores();
            Supervisor supervisor = buscarSupervisor();
            if (supervisor != null) {
                iniciarSupervision(supervisor);
            } else System.out.println("No se encontro supervisor, intente nuevamente");
        } catch (Exception e) {
            System.out.println("Algo salio mal " + e);
        }
    }

    public void mostrarVendedores() { //Muestra lista solo de vendedores
        for (Empleado empleado : empleadoList) {
            if (empleado instanceof Vendedor vendedor) {
                System.out.println(vendedor.toString());
            }
        }
    }

    public void iniciarSupervision(Supervisor supervisor) {
        try {
            mostrarVendedores();   //Muestra todos los Vendedores
            System.out.println("\n\nElija un empleado a agregar para supervisar");
            Empleado empleadoAAsignar = buscar();
            if (empleadoAAsignar != null) { //Si el empleado es una instancia entonces entra al if
                if (empleadoAAsignar instanceof Vendedor vendedor) { //Si esa instancia pertenece a clase Vendedor entonces ejecuta
                    if (!vendedor.isSupervisable()) { //Si ese vendedor no tiene supervisor asignado entonces entra
                        supervisor.getVendedorList().add(vendedor);
                        supervisor.calcularSueldoMensual(); //Corrijo el sueldo del supervisor con la nueva supervision
                        vendedor.iniciarSupervision(supervisor); //Llamo metodo iniciar supervision
                        System.out.println("Supervision creada con exito");
                    } else System.out.println("\nEste vendedor ya se encuentra en supervision");
                } else
                    System.out.println("El emplado que proporicono no pertenecia a tipo Vendedor");
            } else System.out.println("NO SE ENCONTRO EL EMPLEADO con funcion buscar");
        } catch (Exception e) {
            System.out.println("Algo salio mal " + e);
        }
    }

    public void finalizarSupervision() {

        Scanner scanner = new Scanner(System.in);
        try {
            mostrarSupervisores();
            Supervisor supervisor = buscarSupervisor();
            if (supervisor != null) {
                if (!supervisor.getVendedorList().isEmpty()) {
                    System.out.println(supervisor.toString());
                    Empleado empleadoAAsignar = buscar();
                    if (empleadoAAsignar != null) {
                        if (empleadoAAsignar instanceof Vendedor vendedor) {
                            if (vendedor.getNombre().equals(supervisor.getVendedorList().get(supervisor.getVendedorList().indexOf(vendedor)).getNombre())) {
                                //Si el vendedor se encuentra en la lista de vendedores del supervisor se elimina
                                //Se setea la lista de empleados para dejar sin supervisor al vendedor para una nueva asignacion
                                vendedor.finalizarSupervision(); //Actualizo vendedor en lista de Empleados.
                                // supervisor.getVendedorList().set(supervisor.getVendedorList().indexOf(vendedor), vendedor);
                                supervisor.getVendedorList().remove(vendedor);
                                supervisor.calcularSueldoMensual(); //Calculo el sueldo al quitar el vendedor de la supervision

                            }else System.out.println("El vendedor no se encuentra en esta lista");
                        }else System.out.println("El empleado que busca no pertenece a vendedores");
                    } else System.out.println("No se encontro el vendedor a finalizar");
                } else System.out.println("Este supervisor no tenia empleados asignados");
            } else System.out.println("No se encontro el supervisor");
        } catch (Exception e) {
            System.out.println("Algo salio mal " + e);
        }
    }


}


