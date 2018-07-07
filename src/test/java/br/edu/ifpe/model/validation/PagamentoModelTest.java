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

package br.edu.ifpe.model.validation;

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
public class PagamentoModelTest {
    
    private PagamentoModel pagamentoModel;
    private Pagamento pagamento;
    
    public PagamentoModelTest() {
        pagamentoModel = new PagamentoModel();
        pagamento = new Pagamento("tipo",new BigDecimal (10.5) , new Locacao());  
    }
    
    
    @Test
    public void testInserir() throws Exception{
        pagamento = new Pagamento("tipo",new BigDecimal (10.5) , new Locacao());
        pagamentoModel = new PagamentoModel();
        pagamentoModel.inserir(pagamento);
       
    }

    @Test
    public void testRecuperar() throws Exception {
        
        pagamento = new Pagamento("tipo",new BigDecimal (10.5) , new Locacao());
        pagamentoModel.inserir(pagamento);
        Pagamento result = pagamentoModel.recuperar(pagamento.getCodigo());
        assertEquals(pagamento, result);
       
    }

    @Test
    @Ignore
    public void testListarTodos() throws Exception {
         List<Pagamento> pagamentos = new ArrayList();
        pagamento = new Pagamento("tipo",new BigDecimal (10.5) , new Locacao());
        pagamentoModel.inserir(pagamento);
        pagamentos.add(pagamento);
        assertEquals( pagamentos, pagamentoModel.listarTodos());
    }
    
    @Test(expected = Exception.class)
    @Ignore
    public void inserirUsuarioCpfIncorretoTest() throws Exception{
        pagamentoModel.inserir
            (new Pagamento("tipo",new BigDecimal (10.5) , null));
    }
}
