
import java.util.ArrayList;
import java.util.List;

public class TipoEnsayo {
     private String codigo;
    private String nombre;
    private String descripcion;
    private List<String> condicionesMinimas;
    
    public TipoEnsayo(String codigo, String nombre, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.condicionesMinimas = new ArrayList<>();
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public List<String> getCondicionesMinimas() {
        return condicionesMinimas;
    }
    
    public void agregarCondicion(String condicion) {
        this.condicionesMinimas.add(condicion);
    }
    
    public boolean validarResultados(List<Medida> medidas) {
        // Lógica para validar resultados según el tipo de ensayo
        // Esta es una implementación simple, debería adaptarse según los requisitos específicos
        return true;
    }
    
    @Override
    public String toString() {
        return "TipoEnsayo [codigo=" + codigo + ", nombre=" + nombre + 
               ", descripcion=" + descripcion + "]";
    }
}
