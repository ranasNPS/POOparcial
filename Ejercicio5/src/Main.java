
import javax.swing.JOptionPane;


public class Main {
     
    
    public static void main(String[] args) {
        try {
            // Menú principal
            boolean salir = false;
            Producto producto = null;
            Lote lote = null;
            Muestra muestra = null;
            TipoEnsayo tipoEnsayo = null;
            Ensayo ensayo = null;
            Certificado certificado = null;
            
            while (!salir) {
                String[] opciones = {
                    "Crear Producto", 
                    "Crear Lote", 
                    "Crear Muestra",
                    "Crear Tipo de Ensayo",
                    "Crear Ensayo",
                    "Agregar Medida a Ensayo",
                    "Verificar Estándares y Certificar",
                    "Mostrar Información",
                    "Salir"
                };
                
                int opcion = JOptionPane.showOptionDialog(
                    null, 
                    "Seleccione una operación:", 
                    "Sistema de Control de Calidad", 
                    JOptionPane.DEFAULT_OPTION, 
                    JOptionPane.QUESTION_MESSAGE, 
                    null, 
                    opciones, 
                    opciones[0]
                );
                
                switch (opcion) {
                    case 0: // Crear Producto
                        producto = crearProducto();
                        break;
                    case 1: // Crear Lote
                        if (producto == null) {
                            JOptionPane.showMessageDialog(null, "Primero debe crear un producto");
                        } else {
                            lote = crearLote(producto);
                        }
                        break;
                    case 2: // Crear Muestra
                        if (lote == null) {
                            JOptionPane.showMessageDialog(null, "Primero debe crear un lote");
                        } else {
                            muestra = crearMuestra(lote);
                        }
                        break;
                    case 3: // Crear Tipo de Ensayo
                        tipoEnsayo = crearTipoEnsayo();
                        break;
                    case 4: // Crear Ensayo
                        if (muestra == null || tipoEnsayo == null) {
                            JOptionPane.showMessageDialog(null, "Primero debe crear una muestra y un tipo de ensayo");
                        } else {
                            ensayo = crearEnsayo(muestra, tipoEnsayo);
                        }
                        break;
                    case 5: // Agregar Medida a Ensayo
                        if (ensayo == null) {
                            JOptionPane.showMessageDialog(null, "Primero debe crear un ensayo");
                        } else {
                            agregarMedida(ensayo);
                        }
                        break;
                    case 6: // Verificar Estándares y Certificar
                        if (ensayo == null || lote == null) {
                            JOptionPane.showMessageDialog(null, "Primero debe crear un ensayo y un lote");
                        } else {
                            verificarYCertificar(ensayo, lote);
                            certificado = lote.obtenerCertificado();
                        }
                        break;
                    case 7: // Mostrar Información
                        mostrarInformacion(producto, lote, muestra, tipoEnsayo, ensayo, certificado);
                        break;
                    case 8: // Salir
                    default:
                        salir = true;
                        break;
                }
            }
            
            JOptionPane.showMessageDialog(null, "¡Gracias por utilizar el Sistema de Control de Calidad!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la aplicación: " + e.getMessage(), 
                                         "Error", JOptionPane.ERROR_MESSAGE);
           
        }
    }
    
    private static Producto crearProducto() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto:");
        String descripcion = JOptionPane.showInputDialog("Ingrese la descripción del producto:");
        
        Producto producto = new Producto(nombre, descripcion);
        JOptionPane.showMessageDialog(null, "Producto creado correctamente:\n" + producto);
        return producto;
    }
    
    private static Lote crearLote(Producto producto) {
        String codigo = JOptionPane.showInputDialog("Ingrese el código del lote:");
        
        
        Lote lote = new Lote(codigo, producto);
        JOptionPane.showMessageDialog(null, "Lote creado correctamente:\n" + lote);
        return lote;
    }
    
    private static Muestra crearMuestra(Lote lote) {
        String codigo = JOptionPane.showInputDialog("Ingrese el código de la muestra:");
        
        
        
        Muestra muestra = new Muestra(codigo, lote);
        JOptionPane.showMessageDialog(null, "Muestra creada correctamente:\n" + muestra);
        return muestra;
    }
    
    private static TipoEnsayo crearTipoEnsayo() {
        String codigo = JOptionPane.showInputDialog("Ingrese el código del tipo de ensayo:");
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del tipo de ensayo:");
        String descripcion = JOptionPane.showInputDialog("Ingrese la descripción del tipo de ensayo:");
        
        TipoEnsayo tipoEnsayo = new TipoEnsayo(codigo, nombre, descripcion);
        
        boolean agregarCondiciones = true;
        while (agregarCondiciones) {
            String condicion = JOptionPane.showInputDialog("Ingrese una condición mínima (deje en blanco para terminar):");
            if (condicion != null && !condicion.trim().isEmpty()) {
                tipoEnsayo.agregarCondicion(condicion);
            } else {
                agregarCondiciones = false;
            }
        }
        JOptionPane.showMessageDialog(null, "Tipo de ensayo creado correctamente:\n" + tipoEnsayo + 
                                     "\nCondiciones: " + tipoEnsayo.getCondicionesMinimas().size());
        return tipoEnsayo;
    }
    
    private static Ensayo crearEnsayo(Muestra muestra, TipoEnsayo tipoEnsayo) {
        String codigo = JOptionPane.showInputDialog("Ingrese el código del ensayo:");
        
        Ensayo ensayo = new Ensayo(codigo, muestra, tipoEnsayo);
        JOptionPane.showMessageDialog(null, "Ensayo creado correctamente:\n" + ensayo);
        return ensayo;
    }
    
    private static void agregarMedida(Ensayo ensayo) {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la medida:");
        double valor = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor de la medida:"));
        String unidad = JOptionPane.showInputDialog("Ingrese la unidad de medida:");
        
        ensayo.agregarMedida(nombre, valor, unidad);
        JOptionPane.showMessageDialog(null, "Medida agregada correctamente al ensayo.");
    }
    
    private static void verificarYCertificar(Ensayo ensayo, Lote lote) {
        if (ensayo.cumpleEstandares()) {
            lote.setCertificado(true);
            JOptionPane.showMessageDialog(null, "El lote cumple los estándares de calidad.");
            
            Certificado certificado = lote.obtenerCertificado();
            if (certificado != null) {
                String director = JOptionPane.showInputDialog("Ingrese el nombre del director para firmar el certificado:");
                certificado.firmar(director);
                JOptionPane.showMessageDialog(null, "Certificado emitido y firmado correctamente:\n" + certificado);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El lote NO cumple los estándares de calidad.", 
                                         "No Certificado", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private static void mostrarInformacion(Producto producto, Lote lote, Muestra muestra, 
                                          TipoEnsayo tipoEnsayo, Ensayo ensayo, Certificado certificado) {
        StringBuilder info = new StringBuilder("Información del Sistema:\n\n");
        
        if (producto != null) {
            info.append("PRODUCTO:\n").append(producto).append("\n\n");
        } else {
            info.append("No hay producto creado.\n\n");
        }
        
        if (lote != null) {
            info.append("LOTE:\n").append(lote).append("\n\n");
        } else {
            info.append("No hay lote creado.\n\n");
        }
        
        if (muestra != null) {
            info.append("MUESTRA:\n").append(muestra).append("\n\n");
        } else {
            info.append("No hay muestra creada.\n\n");
        }
        
        if (tipoEnsayo != null) {
            info.append("TIPO DE ENSAYO:\n").append(tipoEnsayo).append("\n");
            info.append("Condiciones: ").append(tipoEnsayo.getCondicionesMinimas()).append("\n\n");
        } else {
            info.append("No hay tipo de ensayo creado.\n\n");
        }
        
        if (ensayo != null) {
            info.append("ENSAYO:\n").append(ensayo).append("\n");
            info.append("Medidas:\n");
            for (Medida medida : ensayo.getMedidas()) {
                info.append("- ").append(medida).append("\n");
            }
            info.append("\n");
        } else {
            info.append("No hay ensayo creado.\n\n");
        }
        
        if (certificado != null) {
            info.append("CERTIFICADO:\n").append(certificado).append("\n\n");
        } else {
            info.append("No hay certificado emitido.\n\n");
        }
        
        JOptionPane.showMessageDialog(null, info.toString(), "Información del Sistema", JOptionPane.INFORMATION_MESSAGE);
    }
}
