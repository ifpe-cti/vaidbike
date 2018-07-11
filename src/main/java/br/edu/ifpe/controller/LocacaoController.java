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

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import br.edu.ifpe.model.classes.Locacao;
import br.edu.ifpe.model.classes.Usuario;
import br.edu.ifpe.model.validation.LocacaoModel;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Milena Macedo <milenasantosmcd@gmail.com>
 */
@ManagedBean
@SessionScoped
public class LocacaoController {

    private LocacaoModel instance;
    private Locacao cadLocacao;
    private Locacao selectedLocacao;

    public LocacaoController() {
        this.instance = new LocacaoModel();
        this.cadLocacao = new Locacao();

    }

    public String inserir() throws Exception {
        try {
            this.instance.inserir(this.cadLocacao);
            this.cadLocacao = new Locacao();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Pagamento cadastrado com sucesso"));
            return "";
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Pagamento cadastrado com sucesso"));
            return "";
        }

    }

    public void alterar() {
    }

    public Locacao recuperar(Integer codigo) {
        return null;
    }

    public void deletar() {

    }

    public List<Locacao> listarTodos() {
        return null;
    }

    public List<Locacao> retornarListaLocacao(Usuario cliente) {
        return null;
    }

    public List<Locacao> retornarListaLocatario(Usuario locatario) {
        return null;
    }

    public LocacaoModel getInstance() {
        return instance;
    }

    public void setInstance(LocacaoModel instance) {
        this.instance = instance;
    }

    public Locacao getCadLocacao() {
        return cadLocacao;
    }

    public void setCadLocacao(Locacao cadLocacao) {
        this.cadLocacao = cadLocacao;
    }

    public Locacao getSelectedLocacao() {
        return selectedLocacao;
    }

    public void setSelectedLocacao(Locacao selectedLocacao) {
        this.selectedLocacao = selectedLocacao;
    }
}
