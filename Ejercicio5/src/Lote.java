
public class Lote {
    private String codigo;
    private Producto producto;
    private boolean certificado;
    
    public Lote(String codigo, Producto producto) {
        this.codigo = codigo;
       
        this.producto = producto;
        this.certificado = false;
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public void setCodigo(String codigo) { 
        this.codigo = codigo;
    }
    
    
    public Producto getProducto() {
        return producto;
    }
    
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    public boolean isCertificado() {
        return certificado;
    }
    
    public void setCertificado(boolean certificado) {
        this.certificado = certificado;
    }
    
    public Certificado obtenerCertificado() {
        if (certificado) {
            return new Certificado("CERT-" + codigo, this);
        }
        return null;
    }
    
    @Override
    public String toString() {
        return "Lote [codigo=" + codigo +  
               ", producto=" + producto.getNombre() + ", certificado=" + certificado + "]";
    }
}


