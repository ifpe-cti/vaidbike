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

package view;

import java.util.Date;
import model.classes.Endereco;
import model.classes.Pagamento;
import model.classes.Usuario;
import model.hibernate.PagamentoHibernate;
import model.hibernate.UsuarioHibernate;

/**
 *
 * @author Carlos Cordeiro - carloscordeiroconsultor@gmail.com
 */
public class TesteMain {
    public static void main (String args[]){     
     
    Endereco end = new Endereco("casa","casa","casa","casa","casa","cas");    
    UsuarioHibernate uh = new UsuarioHibernate();
    Usuario u = new Usuario("Milena", "mirassica", "123", "cpf", "sexo", new Date(), end, "telefone", "email", null);
    uh.inserir(u);
    
    
    PagamentoHibernate ph = new PagamentoHibernate();
    Pagamento p = new Pagamento("tipo Fiado", 100.0);
    ph.inserir(p);
    
    
   }
}
