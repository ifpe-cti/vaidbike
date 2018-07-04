/*MIT License

Copyright (c) 2018 Milena dos Santos Macedo, Carlos André Cordeiro da Silva, Adrielly Calado Sales, Luciano Campos de Lima Júnior.

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
import br.edu.ifpe.model.classes.Usuario;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Carlos André - carloscordeiroconsultor@gmail.com
 */
public class LocacaoHibernateTest {
    private  Usuario cliente;
    private  Usuario locatario;
    private  LocacaoHibernate locacaoHibernate;
    
        public LocacaoHibernateTest() {        
            cliente = new Usuario("login", "senha", "nome", "cpf", "sexo", null, null, "telefone", "email", null);
            locatario = new Usuario("1", "1", "3", "33", "sexo", null, null, "telefone", "email", null);
            locacaoHibernate = new LocacaoHibernate();
    }

        @BeforeClass
        
        public static void InserirLocacao(){
               Usuario locatario = new Usuario("1", "1", "3", "33", "sexo", null, null, "telefone", "email", null);
               Usuario cliente = new Usuario("login", "senha", "nome", "cpf", "sexo", null, null, "telefone", "email", null);
               Locacao locacao = new Locacao(cliente, locatario, null, null);
               LocacaoHibernate locacaoHibernate  = new LocacaoHibernate();
               locacaoHibernate.inserir(locacao);
        }
 
    @Test
    public void testarInsersaoLocacao(){
         Locacao locacao = new Locacao(cliente, locatario, null, null);
               locacaoHibernate.inserir(locacao);
               assertEquals(locacao, locacaoHibernate.recuperar(1));
    }
    
    
    
}





























