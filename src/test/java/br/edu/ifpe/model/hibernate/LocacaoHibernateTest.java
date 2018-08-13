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
import br.edu.ifpe.model.classes.Endereco;
import br.edu.ifpe.model.classes.Locacao;
import br.edu.ifpe.model.classes.Usuario;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Carlos André <carloscordeiroconsultor@gmail.com>
 */
public class LocacaoHibernateTest {

    private static final LocacaoHibernate LOCACAOHIBERNATE
            = LocacaoHibernate.getInstance();

    private static final Endereco ENDERECO = new Endereco("estado", "cidade",
            "cep", "bairro", "logradouro");

    private static final Endereco ENDERECO1 = new Endereco("e", "c",
            "cc", "b", "l");

    private static final Usuario USUARIO1 = new Usuario(
            "senha", "nome", "28961303066", "sexo",
            LocalDate.now(), ENDERECO1, "telefone", "email",
            new ArrayList<Bike>());

    private static final Usuario USUARIO2 = new Usuario(
            "senha1", "nome1", "28952871049", "sexo1",
            LocalDate.now(), ENDERECO, "telefone1", "email1",
            new ArrayList<Bike>());

    private static final Locacao LOCACAO
            = new Locacao(USUARIO1, USUARIO2, LocalDate.now(), LocalDate.now());

    @BeforeClass
    public static void deveInserirLocacaoEUsuariosNoBanco() {
        UsuarioHibernate.getInstance().inserir(USUARIO1);
        UsuarioHibernate.getInstance().inserir(USUARIO2);
        LOCACAOHIBERNATE.inserir(LOCACAO);
    }

    @Test
    public void deveRecuperarLocacaoDoBanco() {
        List<Locacao> locacoes = LOCACAOHIBERNATE.listarTodos();
        assertEquals("TC001", LOCACAO,locacoes.get(locacoes.size() - 1));
    }

    @Test
    public void deveAlterarLocacaoDoBanco() {
        LOCACAO.setDevolucao(LocalDate.of(2013, Month.JUNE, 20));
        LOCACAO.setRetirada(LocalDate.of(2013, Month.APRIL, 20));
        LOCACAOHIBERNATE.alterar(LOCACAO);
        List<Locacao> locacoes = LOCACAOHIBERNATE.listarTodos();
        assertEquals("TC002", LOCACAO, locacoes.get(locacoes.size() - 1));        
    }

    @Test
    public void deveRecuperarTodasAsLocacoesDoBanco() {
        List<Locacao> locacacoes = new ArrayList();
        locacacoes.add(LOCACAO);

        assertEquals("TC003", locacacoes, LOCACAOHIBERNATE.listarTodos());
    }

    @AfterClass
    public static void deveDeletarDoBanco() {
        LOCACAOHIBERNATE.deletar(LOCACAO);
    }
}
