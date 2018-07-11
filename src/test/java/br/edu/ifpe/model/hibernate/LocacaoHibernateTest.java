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

import br.edu.ifpe.model.classes.Bike;
import br.edu.ifpe.model.classes.Locacao;
import br.edu.ifpe.model.classes.Usuario;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.runners.MethodSorters;

/**
 *
 * @author Carlos André <carloscordeiroconsultor@gmail.com>
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class LocacaoHibernateTest {

    public static final Usuario cliente
            = new Usuario("login", "senha", "nome", "91492519022", "sexo",
                    null, null, "telefone", "email", new ArrayList<Bike>());
    public static final Usuario locatario
            = new Usuario("login1", "senha1", "nome1", "93708394020", "sexo1",
                    null, null, "telefone1", "email1", new ArrayList<Bike>());
    public static final Locacao locacao = new Locacao(cliente, locatario, null,
            null);

    public static final LocacaoHibernate locacaoHibernate = new LocacaoHibernate();

    @BeforeClass
     @Ignore
    public static void deveInserirLocacaoNoBanco() {
        UsuarioHibernate usuarioHibernate = UsuarioHibernate.getInstance();
        LocacaoHibernateTest.locacaoHibernate.inserir(locacao);
    }

    @Test
     @Ignore
    public void deveRecuperarLocacaoDoBanco() {
        Assert.assertNotNull(locacaoHibernate.recuperar(1));
    }

    @Test
     @Ignore
    public void deveAlterarLocacaoDoBanco() {
        Locacao locacaoAlterada = locacaoHibernate.recuperar(1);
        locacaoAlterada.setDevolucao(new Date());
        locacaoHibernate.alterar(locacaoAlterada);
        Assert.assertNotEquals(locacaoAlterada, locacaoHibernate.recuperar(1));
    }

    @Test
     @Ignore
    public void deveDeletarDoBanco() {
        Locacao locacaoDeletada = locacaoHibernate.recuperar(1);
        locacaoHibernate.deletar(locacaoDeletada);
        Assert.assertNull(locacaoHibernate.recuperar(1));
    }

}
