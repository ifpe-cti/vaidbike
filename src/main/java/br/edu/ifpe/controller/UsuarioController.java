package br.edu.ifpe.controller;

import br.edu.ifpe.model.classes.Endereco;
import br.edu.ifpe.model.classes.Usuario;
import br.edu.ifpe.model.validation.UsuarioModel;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class UsuarioController{
    
    private Usuario cadUsuario;
    private Endereco end;
    private final UsuarioModel USUARIOMODEL;
    
    public UsuarioController() {
        this.end = new Endereco();
        cadUsuario = new Usuario();
        this.USUARIOMODEL = new UsuarioModel();
    }
    
    public void registrarUsuario() throws Exception{
        cadUsuario.setEndereco(end);
        this.USUARIOMODEL.inserir(this.cadUsuario);
        this.end = new Endereco();
        this.cadUsuario = new Usuario();
    }

    public Usuario getCadUsuario() {
        return cadUsuario;
    }

    public void setCadUsuario(Usuario cadUsuario) {
        this.cadUsuario = cadUsuario;
    }

    public Endereco getEnd() {
        return end;
    }

    public void setEnd(Endereco end) {
        this.end = end;
    }

    
}
