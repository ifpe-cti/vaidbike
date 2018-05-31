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

import br.edu.ifpe.model.classes.Bike;
import br.edu.ifpe.model.classes.Endereco;
import br.edu.ifpe.model.classes.Usuario;
import br.edu.ifpe.model.hibernate.UsuarioHibernate;
import java.util.ArrayList;

/**
 *
 * @author Carlos Cordeiro - carloscordeiroconsultor@gmail.com
 */
public class TesteMain {

    public static void main(String args[]) throws Exception {

//        UsuarioHibernate uh = new UsuarioHibernate();
//        List<Bike> bikes = new ArrayList<>();
//
       Endereco end = new Endereco("estado", "cidade", "cep", "bairro", "logradouro");
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
//        Locacao locacao = new Locacao(u, u, new Date(), new Date());
//        Pagamento p = new Pagamento("tipo", new BigDecimal("2.33"), locacao);
//
//        PagamentoHibernate ph = new PagamentoHibernate();
//
//        ph.inserir(p);
//
//        Locacao l = new Locacao(u, u, new Date(), new Date());
//        LocacaoHibernate lh = new LocacaoHibernate();
//
//        lh.inserir(l);
        
        Usuario usuario = new Usuario("login", "senha", "nome",
                null, "sexo",null, end, "telefone", "email"
                , new ArrayList<Bike>());
        
        UsuarioHibernate uh = new UsuarioHibernate();
        uh.inserir(usuario);

    }
}
