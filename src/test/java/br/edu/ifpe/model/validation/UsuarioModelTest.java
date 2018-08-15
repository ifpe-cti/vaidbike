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
import br.edu.ifpe.model.classes.Usuario;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Lucas Mendes <lucas.mendes147@live.com>
 */
public class UsuarioModelTest {

    private static final Endereco ENDERECO = new Endereco("estado", "cidade",
            "cep", "bairro", "logradouro");

    private static final Endereco ENDERECO1 = new Endereco("e", "c",
            "cc", "b", "l");

    private static final UsuarioModel USUARIOMODEL = new UsuarioModel();

    private static Usuario usuario1 = new Usuario(
             "senha", "nome", "28961303066", "sexo",
            LocalDate.now(), ENDERECO1, "telefone", "email",
            new ArrayList<Bike>());

    private static final Usuario USUARIO2 = new Usuario(
             "senha1", "nome1", "28952871049", "sexo1",
            LocalDate.now(), ENDERECO, "telefone1", "email1",
            new ArrayList<Bike>());

    @BeforeClass
    public static void deveInserirUsuarioNoBD() throws Exception {
        USUARIOMODEL.inserir(usuario1);
        USUARIOMODEL.inserir(USUARIO2);
    }

    @Test
    public void deveAlterarUsuarioTest() throws Exception {
        usuario1.setEmail("ALTERADO");
        usuario1.setSenha("ALTERADO");

        USUARIOMODEL.alterar(usuario1);
        Assert.assertEquals("TC001", usuario1, 
                USUARIOMODEL.recuperar(usuario1.getCpf()));
    }

    @Test
    public void deveRecuperarUsuarioCpfTest() throws Exception {
        Assert.assertEquals("TC002", usuario1,
                USUARIOMODEL.recuperar(this.usuario1.getCpf()));
    }

    @Test
    public void deveRecuperarTodosUsuariosTest() throws Exception {
        List<Usuario> usuarios = new ArrayList();
        usuarios.add(USUARIO2);
        usuarios.add(usuario1);
        assertEquals("TC003", usuarios, USUARIOMODEL.listarTodos());
    }

    @Test(expected = NullPointerException.class)
    public void naoDeveinserirUsuarioIncorretoTest() throws Exception {
        USUARIOMODEL.inserir(new Usuario( null, null, null, null, null,
                null, null, null, null));
    }

    @Test(expected = java.lang.Exception.class)
    public void naoDeveInserirUsuarioCpfIncorretoTest() throws Exception {
        USUARIOMODEL.inserir(new Usuario( "senha", "nome",
                "1234567890123", "sexo", LocalDate.now(), ENDERECO, "telefone",
                "email", new ArrayList<Bike>()));
    }

    @Test(expected = java.lang.Exception.class)
    public void naoDeveAlterarUsuarioInexistenteTest() throws Exception {
        USUARIOMODEL.alterar(new Usuario( "alt", "alt", "alt", "alt",
                null, null, "alt", "alt", null));
    }

    @Test(expected = java.lang.Exception.class)
    public void naoDeveDeletarUsuarioInexistenteTest() throws Exception {
        USUARIOMODEL.deletar(new Usuario( "del", "del", "del", "del",
                null, null, "del", "del", null));
    }

    @Test(expected = NullPointerException.class)
    public void naoDeveRecuperarUsuarioCPFInexistenteTest() throws Exception {
        USUARIOMODEL.deletar(USUARIOMODEL.recuperar("123123"));
    }

    @Test(expected = java.lang.Exception.class)
    public void naoDeveRecuperarUsuarioLoginInexistenteTest() throws Exception {
        USUARIOMODEL.deletar(
                USUARIOMODEL.recuperar("loginInexistente", "senha"));
    }

    @AfterClass
    public static void deveLimparBD() throws Exception {
        USUARIOMODEL.deletar(usuario1);
        USUARIOMODEL.deletar(USUARIO2);
    }

}
