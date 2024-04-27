package gastonFtacla.personal;

public interface Supervisable { // Se implementa en Vendedor y en Gestor de Personal
    public void iniciarSupervision(Supervisor supervisor);
    public  void finalizarSupervision();
}
