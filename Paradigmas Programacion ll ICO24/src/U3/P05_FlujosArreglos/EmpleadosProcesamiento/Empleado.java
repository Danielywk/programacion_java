package U3.P05_FlujosArreglos.EmpleadosProcesamiento;

public class Empleado {
    private String primerNombre;
    private String apellidoPaterno;
    private double salario;
    private String departamento;

    public Empleado(String primerNombre, String apellidoPaterno, double salario, String departamento) {
        this.primerNombre = primerNombre;
        this.apellidoPaterno = apellidoPaterno;
        this.salario = salario;
        this.departamento = departamento;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return String.format("%-12s %-12s %12.2f %12s", primerNombre, apellidoPaterno, salario, departamento);
    }

    // Devuelve primer nombre y apellido combinado del Empleado
    public String obtenerNombreCompleto() {
        return String.format("%s %s", primerNombre, apellidoPaterno);
    }
}
