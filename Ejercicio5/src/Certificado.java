
public class Certificado {
   private String codigo;
  
    private Lote lote;
    private boolean firmado;
    private String director;
    
    public Certificado(String codigo, Lote lote) {
        this.codigo = codigo;
        
        this.lote = lote;
        this.firmado = false;
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
    
    public boolean isFirmado() {
        return firmado;
    }
    
    public String getDirector() {
        return director;
    }
    
    public void firmar(String director) {
        this.firmado = true;
        this.director = director;
    }
    
    @Override
    public String toString() {
        return "Certificado [codigo=" + codigo + ", fechaEmision=" + 
               ", lote=" + lote.getCodigo() + ", firmado=" + firmado + 
               (firmado ? ", director=" + director : "") + "]";
    }
}
