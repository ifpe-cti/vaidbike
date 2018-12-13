package br.edu.ifpe.controller;

import br.edu.ifpe.controller.md5.CriptografiaMD5;
import br.edu.ifpe.model.classes.Bike;
import br.edu.ifpe.model.classes.Endereco;
import br.edu.ifpe.model.classes.Usuario;
import br.edu.ifpe.model.validation.UsuarioModel;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class UsuarioController {

    private Usuario cadUsuario;
    private Endereco end;
    private Bike bike;
    private List<Bike> bikes;
    private final UsuarioModel instaceUSUARIOMODEL;

    public UsuarioController() {
        this.bike = new Bike();
        this.end = new Endereco();
        this.cadUsuario = new Usuario();
        this.bikes = new ArrayList<>();
        this.instaceUSUARIOMODEL = new UsuarioModel();
    }

    public Usuario getUsuarioLogado() {
        return (Usuario) FacesContext.getCurrentInstance().getExternalContext()
                .getSessionMap().get("usuarioLogado");
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        FacesContext.getCurrentInstance().getExternalContext()
                .getSessionMap().put("usuarioLogado", usuarioLogado);
    }

    public String realizarLogin(String senha, String email) {
        Usuario user = null;
        String rediricionarPagina = "";

        try {
            senha = CriptografiaMD5.md5(senha);
            user = instaceUSUARIOMODEL.recuperar(email, senha);

            if (user != null) {

                if (user.getSenha().equals(senha)) {
                    this.setUsuarioLogado(user);
                    rediricionarPagina = "menuUsuario.xhtml";

                } else {
                    rediricionarPagina = "telaInicial.xhtml";
                }
            }
        } catch (Exception realizarLoginException) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Falha no Login!", "Senha ou Login Inválidos"));
            rediricionarPagina = "telaInicial.xhtml";

        } finally {
            return rediricionarPagina;
        }

    }

    public String registrarUsuario() throws Exception {
        String ret = "";
        try {
            cadUsuario.setSenha(CriptografiaMD5.md5(cadUsuario.getSenha()));
            cadUsuario.setEndereco(end);
            this.instaceUSUARIOMODEL.inserir(this.cadUsuario);
            this.end = new Endereco();
            this.cadUsuario = new Usuario();
            ret = "login.xhtml";
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha!",
                            "Dados Inválidos"));
        }

        return ret;

    }

    public String alterarUsuario() {
        try {
            getUsuarioLogado().setSenha
                    (CriptografiaMD5.md5(getUsuarioLogado().getSenha()));
            instaceUSUARIOMODEL.alterar(getUsuarioLogado());

        } catch (Exception alterarUsuarioException) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha!",
                            "Dados Inválidos"));
        } finally {
            return "mostrarDadosUsuario.xhtml";
        }
    }

    public String alterarBike() {
        try {
            int index = -1;
            for (int i = 0; i < getUsuarioLogado().getBikes().size(); i++) {
                if (getUsuarioLogado().getBikes().get(i).getCodigo() 
                            == bike.getCodigo()) {
                    index = i;
                }
            }
            if (index != -1) {
                getUsuarioLogado().getBikes().set(index, bike);

                //getUsuarioLogado().setBikes(bikes);
                instaceUSUARIOMODEL.alterar(getUsuarioLogado());
            }

        } catch (Exception alterarBikeException) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha!",
                            "Dados Inválidos"));
        } finally {
            return "listarBike.xhtml";
        }
    }

    public String cadastrarBike() {
        String ret = "";
        try {
//            this.bike.setUsuario(getUsuarioLogado());
            bike.setUsuario(this.getUsuarioLogado());
            bikes.add(this.bike);

            getUsuarioLogado().setBikes(bikes);

            instaceUSUARIOMODEL.alterar(getUsuarioLogado());

            bike = new Bike();
            ret = "menuUsuario.xhtml";
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha!",
                            "Dados Inválidos"));
        }

        return ret;

    }
    
    public String logout() {
        
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        
        return "login.xhtml?faces-redirect=true";
    }

    public List<Bike> listarBikes() {
         List<Bike> bikes = new ArrayList();
        try{
            bikes = this.instaceUSUARIOMODEL.listarBikes(getUsuarioLogado());
            
        }catch(Exception listarBikeException){
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha!",
                            "Algo inesperado ocorreu ao recuperar as bikes"));
        }finally{
            return bikes;
        }
        /*  List<Bike> bikesUsuarioLogado = getUsuarioLogado().getBikes();
        
        for(Bike bik : bikesUsuarioLogado){
            if(bik.hashCode() == bike.hashCode()){
                this.bike = bik;
            }
        }*/
        
    }

     public List<Bike> listarTodasBikes() {
         List<Bike> bikes = new ArrayList();
        try{
            bikes = this.instaceUSUARIOMODEL.listarTodasAsBikes(getUsuarioLogado());
            
        }catch(Exception listarBikeException){
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha!",
                            "Algo inesperado ocorreu ao recuperar as bikes"));
        }finally{
            return bikes;
        }
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

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }

}
