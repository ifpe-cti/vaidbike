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
package br.edu.ifpe.model.validation;

import java.util.List;
import br.edu.ifpe.model.classes.Pagamento;
import br.edu.ifpe.model.hibernate.PagamentoHibernate;
import br.edu.ifpe.model.interfacesDao.Dao;
import br.edu.ifpe.model.interfacesDao.PagamentoDao;

/**
 *
 * @author Adrielly Calado <adriellysales015@outlook.com>
 */
public class PagamentoModel {

    private final Dao<Pagamento> DAO = PagamentoHibernate.getInstance();

    public void inserir(Pagamento pagamento) throws Exception {

        if (((PagamentoDao) DAO).recuperar(pagamento.getCodigo()) == null) {
            DAO.inserir(pagamento);
        } else {
            throw new Exception("Erro ao inserir Pagamento, na classe "
                    + "PagamentoModel!");
        }

    }

    public Pagamento recuperar(Integer codigo) throws Exception {

        if (codigo == null) {
            throw new Exception("Código do Pagamento não existe, erro na classe"
                    + "PagamentoModel");
        }
        return ((PagamentoDao) DAO).recuperar(codigo);
    }

    public List<Pagamento> listarTodos() throws Exception {

        List<Pagamento> pagamentos = ((PagamentoDao) DAO).listarTodos();

        if (pagamentos == null) {
            throw new Exception("Erro ao recuperar, à lista de pagamentos na "
                    + "classe PagamentoModel.");
        } else {
            return pagamentos;
        }

    }
}
