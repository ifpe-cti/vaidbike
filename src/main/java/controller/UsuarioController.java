/*MIT License

Copyright (c) 2018 Milena dos Santos Macedo, Carlos André Cordeiro da Silva, 
Adrielly Calado Sales, Luciano Campos de Lima Júnior.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

package controller;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.classes.Usuario;
import model.hibernate.UsuarioHibernate;

/**
 *
 * @author Carlos Cordeiro - carloscordeiroconsultor@gmail.com
 */

@ManagedBean(name = "usuarioController")
//@ViewScoped
@SessionScoped
public class UsuarioController {
    
    private UsuarioHibernate usuarioHibernate;
    private Usuario cadUsuario;
    private Usuario selectedUsuario = (Usuario) FacesContext.
            getCurrentInstance().getExternalContext().getSessionMap().
            get("usuarioLogado");

    public UsuarioController() {
        this.usuarioHibernate = new UsuarioHibernate();
        this.cadUsuario = new Usuario();
    }
    
    
    public String inserir(){
        this.usuarioHibernate.inserir(this.cadUsuario);
        
        this.cadUsuario = new Usuario();
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage
        ("Usuario cadastrado com sucesso!"));    
        
        return ".xhtml";
    }
    
     public String alterar(){
        this.usuarioHibernate.alterar(this.selectedUsuario);
        
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage
        ("Usuario alterado com sucesso!"));
        this.cadUsuario = new Usuario();
        
        return ".xhtml";
        
    }
    
    
     public String deletar(){
        this.usuarioHibernate.deletar(this.selectedUsuario);
        
        this.cadUsuario = new Usuario();
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage
        ("Usuario deletado com sucesso!"));
        
        return "index.xhtml";
    
     }
    
     
      public String recuperar(){
        this.usuarioHibernate.recuperar(this.selectedUsuario.getCodigo());
        this.cadUsuario = new Usuario();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage
        ("Usuario alterado com sucesso!"));
        return ".xhtml";   
      }
      
      public String recuperarCpf(){
        this.usuarioHibernate.recuperar(this.selectedUsuario.getCpf());
        this.cadUsuario = new Usuario();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage
        ("Usuario alterado com sucesso!"));
        return ".xhtml";   
      }
      
      
       public List<Usuario> recuperarTodos(){
        return this.usuarioHibernate.listarTodos(); 
       }
       
       
//       Verificar se é necessario geters an setters
       
       
    public UsuarioHibernate getUsuarioHibernate() {
        return usuarioHibernate;
    }

    public void setUsuarioHibernate(UsuarioHibernate usuarioHibernate) {
        this.usuarioHibernate = usuarioHibernate;
    }

    public Usuario getCadUsuario() {
        return cadUsuario;
    }

    public void setCadUsuario(Usuario cadUsuario) {
        this.cadUsuario = cadUsuario;
    }

    public Usuario getSelectedUsuario() {
        return selectedUsuario;
    }

    public void setSelectedUsuario(Usuario selectedUsuario) {
        this.selectedUsuario = selectedUsuario;
    }
    
       
       
       

}
