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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import br.edu.ifpe.model.classes.Pagamento;
import br.edu.ifpe.model.validation.PagamentoModel;

/**
 *
 * @author Adrielly Calado <adriellysales015@outlook.com>
 */
public class PagamentoController {

    private PagamentoModel instance;
    private Pagamento cadPagamento;
    private Pagamento selectPagamento;

    public PagamentoController() {
        this.instance = new PagamentoModel();
        this.cadPagamento = new Pagamento();
        this.selectPagamento = new Pagamento();

    }

    public String inserir() throws Exception {
        this.instance.inserir(this.cadPagamento);
        this.cadPagamento = new Pagamento();
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Pagamento cadastrado com sucesso"));

        return "";
    }

    public PagamentoModel getInstance() {
        return instance;
    }

    public void setInstance(PagamentoModel instance) {
        this.instance = instance;
    }

    public Pagamento getCadPagamento() {
        return cadPagamento;
    }

    public void setCadPagamento(Pagamento cadPagamento) {
        this.cadPagamento = cadPagamento;
    }

    public Pagamento getSelectPagamento() {
        return selectPagamento;
    }

    public void setSelectPagamento(Pagamento selectPagamento) {
        this.selectPagamento = selectPagamento;
    }

    public Pagamento recuperar(Integer codigo) throws Exception {
        return this.instance.recuperar(codigo);
    }

    public List<Pagamento> ListarTodos() throws Exception {
        return this.instance.listarTodos();
    }

}
