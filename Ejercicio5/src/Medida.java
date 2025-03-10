
public class Medida {
    private String nombre;
    private double valor;
    private String unidad;
    private Ensayo ensayo;
    
    public Medida(String nombre, double valor, String unidad, Ensayo ensayo) {
        this.nombre = nombre;
        this.valor = valor;
        this.unidad = unidad;
        this.ensayo = ensayo;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public double getValor() {
        return valor;
    }
    
    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public String getUnidad() {
        return unidad;
    }
    
    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }
    
    public Ensayo getEnsayo() {
        return ensayo;
    }
    
    public void setEnsayo(Ensayo ensayo) {
        this.ensayo = ensayo;
    }
    
    @Override
    public String toString() {
        return "Medida [nombre=" + nombre + ", valor=" + valor + ", unidad=" + unidad + "]";
    }

}
