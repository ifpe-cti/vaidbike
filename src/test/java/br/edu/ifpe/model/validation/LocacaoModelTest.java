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
package br.edu.ifpe.model.validation;

import br.edu.ifpe.model.classes.Bike;
import br.edu.ifpe.model.classes.Endereco;
import br.edu.ifpe.model.classes.Locacao;
import br.edu.ifpe.model.classes.Usuario;
import br.edu.ifpe.model.hibernate.UsuarioHibernate;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Lucas Mendes <lucas.mendes147@live.com>
 */
public class LocacaoModelTest {

    private static final LocacaoModel LOCACAOMODEL
            = new LocacaoModel();

    private static final Endereco ENDERECO = new Endereco("estado", "cidade",
            "cep", "bairro", "logradouro");

    private static final Endereco ENDERECO1 = new Endereco("e", "c",
            "cc", "b", "l");

    private static final Usuario USUARIO1 = new Usuario(
            "senha", "nome", "52616152088", "sexo",
            LocalDate.now(), ENDERECO1, "telefone", "email",
            new ArrayList<Bike>());

    private static final Usuario USUARIO2 = new Usuario(
            "senha1", "nome1", "87648556006", "sexo1",
            LocalDate.now(), ENDERECO, "telefone1", "email1",
            new ArrayList<Bike>());

    private static final Locacao LOCACAO
            = new Locacao(USUARIO1, USUARIO2,
                    LocalDateTime.now(), LocalDateTime.now());

    @BeforeClass
    public static void LocacaoModelTest() throws Exception {
        UsuarioHibernate.getInstance().inserir(USUARIO1);
        UsuarioHibernate.getInstance().inserir(USUARIO2);
        LOCACAOMODEL.inserir(LOCACAO);
    }

    /**
     * Test of alterar method, of class LocacaoModel.
     */
    @Test
    public void testAlterar() throws Exception {
        LOCACAO.setDevolucao(
                LocalDateTime.of(LocalDate.of(2013, Month.JUNE, 20),
                        LocalTime.of(10, 10)));
        LOCACAO.setRetirada(LocalDateTime.of(LocalDate.of(2013, Month.JUNE, 20),
                LocalTime.of(13, 13)));

        LOCACAOMODEL.alterar(LOCACAO);
        List<Locacao> locacoes = LOCACAOMODEL.listarTodos();
        assertEquals("TC001", LOCACAO, locacoes.get(locacoes.size() - 1));
    }

    /**
     * Test of recuperar method, of class LocacaoModel.
     */
    @Test
    public void testRecuperar() throws Exception {
        List<Locacao> locacoes = LOCACAOMODEL.listarTodos();
        assertEquals("TC002", LOCACAO, locacoes.get(locacoes.size() - 1));
    }

    @Test(expected = java.lang.Exception.class)
    public void naoDeveRecuperarLocacao() throws Exception {
        LOCACAOMODEL.recuperar(null);
    }

    @Test
    public void naoDeveInserirLocacao() throws Exception {
        Locacao locacao = new Locacao(null, null, null, null);
        LOCACAOMODEL.inserir(locacao);
    }

    @Test(expected = java.lang.Exception.class)
    public void naoDeveAlterarLocacao() throws Exception {
        LOCACAOMODEL.alterar(new Locacao());
    }

    @Test(expected = java.lang.Exception.class)
    public void naoDeveDeletarLocacao() throws Exception {
        LOCACAOMODEL.deletar(new Locacao());
    }
    
    @AfterClass
    public static void deveDeletarLocacaoDoBD() throws Exception{
        LOCACAOMODEL.deletar(LOCACAO);
    }
}
