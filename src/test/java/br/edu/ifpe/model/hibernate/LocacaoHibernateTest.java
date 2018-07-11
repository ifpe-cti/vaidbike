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

    LocacaoHibernate lh = new LocacaoHibernate();
    
    
    @Test
    public void deveRecuperarLocacaoDoBanco() {
        
        Assert.assertNotNull(lh.recuperar(1));
    }

    @Test

    public void deveAlterarLocacaoDoBanco() {
        Locacao locacaoAlterada = lh.recuperar(1);
        Locacao locacaoAntiga = locacaoAlterada;
        locacaoAlterada.setDevolucao(new Date());
        lh.alterar(locacaoAlterada);
        Assert.assertNotEquals(locacaoAntiga, lh.recuperar(1));
    }

    @Test
    public void deveDeletarDoBanco() {
        Locacao locacaoDeletada = lh.recuperar(3);
        lh.deletar(locacaoDeletada);
        Assert.assertNull(lh.recuperar(3));
    }

}
