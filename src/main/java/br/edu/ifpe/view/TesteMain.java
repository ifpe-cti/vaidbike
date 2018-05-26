/*MIT License

Copyright (c) 2018 Milena dos Santos Macedo, Carlos André Cordeiro da Silva, Adrielly Calado Sales, Luciano Campos de Lima Júnior.

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


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import br.edu.ifpe.model.classes.Bike;
import br.edu.ifpe.model.classes.Endereco;
import br.edu.ifpe.model.classes.Locacao;
import br.edu.ifpe.model.classes.Pagamento;
import br.edu.ifpe.model.classes.Usuario;
import br.edu.ifpe.model.hibernate.LocacaoHibernate;
import br.edu.ifpe.model.hibernate.PagamentoHibernate;
import br.edu.ifpe.model.hibernate.UsuarioHibernate;
import br.edu.ifpe.model.validation.LocacaoModel;


/**
 *
 * @author Carlos Cordeiro - carloscordeiroconsultor@gmail.com
 */
public class TesteMain {

    public static void main(String args[]) throws Exception {
//
//        UsuarioHibernate uh = new UsuarioHibernate();
//        List<Bike> bikes = new ArrayList<>();
//
//        Endereco end = new Endereco("casa", "casa", "casa", "casa", "casa", "cas");
//
//        Usuario u = new Usuario("Milena", "mirassica", "123", "75008513400",
//                "sexo", new Date(), end, "telefone", "email", bikes);
//
//        uh.inserir(u);
//
//        u = uh.listarTodos().get(0);
//
//        Bike bike = new Bike("cor", "tipo", "ufre", u);
//        bikes.add(bike);
//
//        u.setBikes(bikes);
//        uh.alterar(u);
//
//        Pagamento p = new Pagamento("CAsa", 56);
//
//        PagamentoHibernate ph = new PagamentoHibernate();
//
//        ph.inserir(p);

        Locacao l =null; //new Locacao(u, u, new Date(), new Date(), p);
       // LocacaoHibernate lh = new LocacaoHibernate();
        LocacaoModel lm = new LocacaoModel();
        
        
       
        l = lm.recuperar(2);
        //lm.inserir(l);
        lm.deletar(l);


           
           
    }
}
