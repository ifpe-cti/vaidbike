/*MIT License

Copyright (c) 2018 Milena dos Santos Macedo, Carlos André Cordeiro da Silva, 
Adrielly Calado Sales, Lucas Mendes Cavalcanti.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated docuhentation files (the "Software"), to deal
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

package br.edu.ifpe.view;

import br.edu.ifpe.model.classes.Bike;
import br.edu.ifpe.model.classes.Endereco;
import br.edu.ifpe.model.classes.Locacao;
import br.edu.ifpe.model.hibernate.LocacaoHibernate;
import br.edu.ifpe.model.classes.Pagamento;
import br.edu.ifpe.model.classes.Usuario;
import br.edu.ifpe.model.hibernate.PagamentoHibernate;
import br.edu.ifpe.model.hibernate.UsuarioHibernate;
import br.edu.ifpe.model.validation.PagamentoModel;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Carlos Cordeiro - carloscordeiroconsultor@gmail.com
 */

public class TesteMain {

    public static void main(String args[]) throws Exception {

        UsuarioHibernate uh = new UsuarioHibernate();
        List<Bike> bikes = new ArrayList<>();
        
        
        Endereco end = new Endereco("estado", "cidade", "cep", "bairro","logradouro");
        Endereco end2 = new Endereco("estado", "cidade", "cep", "bairro","logradouro");

        Usuario u = new Usuario("MilenaCliente", "mirassica", "12345", "cpfnovo",
               "sexo", new Date(), end, "telefone", "email", bikes);
        Bike bike = new Bike("bmx", "gaytipo", "verdecor", u);
        bikes.add(bike);
        
        uh.inserir(u);


        Usuario cliente = uh.recuperar(1);
        Usuario locatario = uh.recuperar("cpfnovo");
        LocacaoHibernate lh = new LocacaoHibernate();
        Locacao locacao = new Locacao(cliente, locatario, new Date(), new Date());
        
        lh.inserir(locacao);
        
        
        locacao = lh.recuperar(4);
        
        PagamentoHibernate ph = new PagamentoHibernate();
        Pagamento pagamento = new Pagamento("com a bunda", BigDecimal.ZERO, locacao);
        ph.inserir(pagamento);
        
        
        

       

        uh.inserir(usuario);
*/

    }
}
