package model;

public class Nomina {

    private int id;
    private Empleado empleado;
    private double bonificaciones;
    private double deducciones;

    public Nomina(int id, Empleado empleado, double bonificaciones, double deducciones) {
        this.id = id;
        this.empleado = empleado;
        this.bonificaciones = bonificaciones;
        this.deducciones = deducciones;
    }
    public double calcularPagoHorasExtras() {
        if (empleado.getHorasTrabajadas() == 0) {
            return 0;
        }
        double valorHora = empleado.getSueldoBase() / empleado.getHorasTrabajadas();
        return valorHora * 1.5 * empleado.getHorasExtras();
    }
    public double calcularSalarioBruto() {
        return empleado.getSueldoBase() + calcularPagoHorasExtras() + bonificaciones;
    }
    public double calcularSalarioNeto() {
        return calcularSalarioBruto() - deducciones;
    }
    @Override
    public String toString() {
        return "Nomina [id=" + id
                + ", empleado=" + empleado.getNombre()
                + ", bonificaciones=" + bonificaciones
                + ", deducciones=" + deducciones
                + ", salarioNeto=" + calcularSalarioNeto() + "]";
    }
}
