/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author BRAYAN
 */
public class Usuario {
    
    public String nombres, apellidos, numDocumento, clave;
    
    /*
     public static void main(String[] args) {
        // builder
        
        Usuario usuario = new Usuario.Builder("1032565672")
                .conNombres("Brayan Steven")
                .conApellidos("Matallana Joya")
                .conClave("12345")
                .build();
        
        System.out.println(usuario.getNombres());
        System.out.println(usuario.getApellidos());
           
    }
    
    private String nombres, apellidos, numDocumento, clave;
    
    
    //BUILDER
    public static class Builder{
        
        private String nombres;
        private String apellidos;
        private String numDocumento;
        private String clave;
        
        public Builder(String numDocumento){
        this.numDocumento = numDocumento;
        }
        
        public Builder conNombres(String nombres){
        this.nombres = nombres;
        return this;
        }
        
        public Builder conApellidos(String apellidos){
        this.apellidos = apellidos;
        return this;
        }
        
        public Builder conClave(String clave){
        this.clave = clave;
        return this;
        }
        
        public Usuario build(){
        Usuario usuario = new Usuario();
        usuario.nombres = this.nombres; 
        usuario.apellidos = this.apellidos;
        usuario.numDocumento = this.numDocumento;
        usuario.clave = this.clave;
        return usuario;
        }

        
    
    }*/
    
    
  
    private Usuario(){
        
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }
    
    public String getClave() {
            return clave;
        }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    
}
