
import java.util.ArrayList;
import java.util.List;

public class Ensayo {
   private String codigo;
    private Muestra muestra;
    private TipoEnsayo tipo;
    private List<Medida> medidas;
    
    public Ensayo(String codigo, Muestra muestra, TipoEnsayo tipo) {
        this.codigo = codigo;
        this.muestra = muestra;
        this.tipo = tipo;
        this.medidas = new ArrayList<>();
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public Muestra getMuestra() {
        return muestra;
    }
    
    public void setMuestra(Muestra muestra) {
        this.muestra = muestra;
    }
    
    public TipoEnsayo getTipo() {
        return tipo;
    }
    
    public void setTipo(TipoEnsayo tipo) {
        this.tipo = tipo;
    }
    
    public List<Medida> getMedidas() {
        return medidas;
    }
    
    public void agregarMedida(String nombre, double valor, String unidad) {
        Medida medida = new Medida(nombre, valor, unidad, this);
        this.medidas.add(medida);
    }
    
    public boolean cumpleEstandares() {
        return tipo.validarResultados(medidas);
    }
    
    @Override
    public String toString() {
        return "Ensayo [codigo=" + codigo + ", fecha="+
               ", muestra=" + muestra.getCodigo() + ", tipo=" + tipo.getNombre() + 
               ", medidas=" + medidas.size() + "]";
    }
}
