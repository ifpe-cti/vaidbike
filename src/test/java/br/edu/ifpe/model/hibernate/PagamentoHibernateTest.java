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
package br.edu.ifpe.model.hibernate;

import br.edu.ifpe.model.classes.Locacao;
import br.edu.ifpe.model.classes.Pagamento;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Milena Macedo <milenasantosmcd@gmail.com>
 */
public class PagamentoHibernateTest {

    private static PagamentoHibernate pagamentoHibernate;
    private static Pagamento pagamento;

    public PagamentoHibernateTest() {

        this.pagamento = new Pagamento();
        this.pagamentoHibernate = new PagamentoHibernate();
    }

    @Test
    public void testDeveInserir() {
        pagamento = new Pagamento("tipo", new BigDecimal(10.5), new Locacao());
        pagamentoHibernate.inserir(pagamento);
        Pagamento result = pagamentoHibernate.recuperar(pagamento.getCodigo());
        assertEquals(pagamento, result);

    }

    @Test
    public void testDeveRecuperarCodigo() {
        pagamento = new Pagamento("tipo", new BigDecimal(10.5), new Locacao());
        pagamentoHibernate.inserir(pagamento);
        Pagamento result = pagamentoHibernate.recuperar(pagamento.getCodigo());
        assertEquals(pagamento, result);

    }

    @Test
    @Ignore
    public void testDeveRecuperarTodosPagamentos() {
        List<Pagamento> pagamentos = new ArrayList();
        pagamento = new Pagamento("tipo", new BigDecimal(10.5), new Locacao());
        pagamentoHibernate.inserir(pagamento);
        pagamentos.add(pagamento);
        assertEquals(pagamentos, pagamentoHibernate.listarTodos());
    }
    @Test
    public void testDeveLimparBancoDados() {
        Pagamento pagamento = new Pagamento("tipo", new BigDecimal(10.5), new Locacao());
        pagamentoHibernate.deletar(pagamento);
    }
     
}
