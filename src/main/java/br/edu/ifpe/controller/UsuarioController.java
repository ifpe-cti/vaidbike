/*MIT License

Copyright (c) 2018 Milena dos Santos Macedo, Carlos André Cordeiro da Silva,
Adrielly Calado Sales, Lucas Mendes Cavalcanti. 

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
package br.edu.ifpe.controller;

import br.edu.ifpe.model.classes.Usuario;
import br.edu.ifpe.model.validation.UsuarioModel;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Milena Macedo <milenasantosmcd@gmail.com>
 */

@ManagedBean
@SessionScoped
public class UsuarioController {

    private UsuarioModel instaceUsuarioModel;
    private Usuario cadUsuario;
    private Usuario selectedUsuario;

    public UsuarioController() {
        this.instaceUsuarioModel = new UsuarioModel();
        this.cadUsuario = new Usuario();

    }

    public String adicionarUsuario() throws Exception {

        this.instaceUsuarioModel.inserir(this.cadUsuario);
        return " ";

    }

    public String deletarUsuario() throws Exception {
        this.instaceUsuarioModel.deletar(selectedUsuario);
        return "";
    }

    public String alterarUsuario() throws Exception {
        this.instaceUsuarioModel.alterar(selectedUsuario);

        return "";
    }

    public String recuperarCodigoUsuario() throws Exception {
        this.instaceUsuarioModel.recuperar(this.selectedUsuario.getCodigo());
        return "";
    }

    public String recuperarLogin() throws Exception {
        this.instaceUsuarioModel.recuperar(this.selectedUsuario.getLogin(),
                this.selectedUsuario.getSenha());
        return "";
    }

    public String recuperarCPF() throws Exception {
        this.instaceUsuarioModel.recuperar(this.selectedUsuario.getCpf());
        return "";
    }

    public UsuarioModel getInstaceUsuarioModel() {
        return instaceUsuarioModel;
    }

    public void setInstaceUsuarioModel(UsuarioModel instaceUsuarioModel) {
        this.instaceUsuarioModel = instaceUsuarioModel;
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
