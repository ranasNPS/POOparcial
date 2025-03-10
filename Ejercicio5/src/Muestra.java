
public class Muestra {
     private String codigo;
    private Lote lote;
    
    public Muestra(String codigo, Lote lote) {
        this.codigo = codigo;
        this.lote = lote;
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    
    public Lote getLote() {
        return lote;
    }
    
    public void setLote(Lote lote) {
        this.lote = lote;
    }
    
    @Override
    public String toString() {
        return "Muestra [codigo=" + codigo + 
               ", lote=" + lote.getCodigo() + "]";
    }
}
