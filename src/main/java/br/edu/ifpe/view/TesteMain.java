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

import br.edu.ifpe.controller.UsuarioController;
import br.edu.ifpe.model.classes.Bike;
import br.edu.ifpe.model.classes.Endereco;
import br.edu.ifpe.model.classes.Locacao;
import br.edu.ifpe.model.classes.Pagamento;
import br.edu.ifpe.model.classes.Usuario;
import br.edu.ifpe.model.hibernate.UsuarioHibernate;
import br.edu.ifpe.model.validation.UsuarioModel;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Carlos Cordeiro - carloscordeiroconsultor@gmail.com
 */
public class TesteMain {

    public static void main(String args[]) throws Exception {

        /*
        Usuario u = new Usuario("MilenaCliente", "mirassica", "12345", "cpfnovo",
               "sexo", new Date(), end, "telefone", "email", bikes);
        Usuario u2 = new Usuario("MilenaCliente", "mirassica", "12345", "cpfnovo",
               "sexo", new Date(), end2, "telefone", "email", bikes);
        Bike bike = new Bike("bmx", "gaytipo", "verdecor", u);
        bikes.add(bike);
        
        uh.inserir(u);
        uh.inserir(u2);


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

        Endereco ENDERECO = new Endereco("estado", "cidade",
            "cep", "bairro", "logradouro");
        ArrayList<Bike> bikes = new ArrayList();
        bikes.add(new Bike("modelo", "tipo", "cor", null));
      Usuario usuario = new Usuario(
            "login", "senha", "nome", "08558176400", "sexo",
            LocalDate.now(), ENDERECO, "telefone", "email", 
              bikes);
      
      UsuarioHibernate.getInstance().inserir(usuario);
      Usuario us = (Usuario) UsuarioHibernate.getInstance().recuperar("08558176400");
        System.out.println(us.getBikes().equals(bikes));
         */
 /* 
        Endereco ENDERECO = new Endereco("estado", "cidade",
                "cep", "bairro", "logradouro");
        
        Usuario USUARIO1 = new Usuario(
                "1", "1", "2", "08558176400", "4",
                LocalDate.now(), ENDERECO, "6", "7",
                new ArrayList<Bike>());
        
        Usuario USUARIO2 = new Usuario(
                "login1", "senha1", "nome1", "28952871049", "sexo1",
                LocalDate.now(), ENDERECO, "telefone1", "email1",
                new ArrayList<Bike>());
        
        Locacao LOCACAO
                = new Locacao(USUARIO1, USUARIO2, LocalDate.now(), LocalDate.now());
        
         Pagamento pagamento = 
            new Pagamento("tipo", new BigDecimal("20.00"),LOCACAO);
         

        UsuarioController uc = new UsuarioController();
        uc.setEnd(ENDERECO);
        uc.setCadUsuario(USUARIO1);
        System.out.println(uc.getCadUsuario());
        uc.registrarUsuario();
     
       
       Usuario us = (Usuario) UsuarioHibernate.getInstance().recuperar("4", "aa6abe049e8d78001ead578c62426901");
       UsuarioModel um = new UsuarioModel();
       UsuarioController uc = new UsuarioController();
       String us = uc.realizarLogin("4", "4");
       System.out.println(us);*/
    }
}
