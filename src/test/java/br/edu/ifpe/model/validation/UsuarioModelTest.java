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

    private static final UsuarioModel USUARIOMODEL = new UsuarioModel();

    private static final Usuario USUARIO1 = new Usuario(
            "login", "senha", "nome", "28961303066", "sexo",
            LocalDate.now(), ENDERECO, "telefone", "email",
            new ArrayList<Bike>());

    private static final Usuario USUARIO2 = new Usuario(
            "login1", "senha1", "nome1", "28952871049", "sexo1",
            LocalDate.now(), ENDERECO, "telefone1", "email1",
            new ArrayList<Bike>());

    @BeforeClass
    public static void deveInserirUsuarioNoBD() throws Exception {
        USUARIOMODEL.inserir(USUARIO1);
        USUARIOMODEL.inserir(USUARIO2);
    }

    @Test
    public void deveAlterarUsuarioTest() throws Exception {
            USUARIO1.setEmail("ALTERADO");
            USUARIO1.setLogin("ALTERADO");
            
            USUARIOMODEL.alterar(USUARIO1);
            Assert.assertEquals("TC001", USUARIO1, USUARIOMODEL.recuperar
        (USUARIO1.getCodigo()));
    }

    @Test
    public void deveRecuperarUsuarioIdTest() throws Exception {
        Assert.assertEquals("TC002", USUARIO1, 
                    USUARIOMODEL.recuperar(1));
    }
    
        @Test
    public void deveRecuperarUsuarioCpfTest() throws Exception {
            Assert.assertEquals("TC003", USUARIO1, 
                    USUARIOMODEL.recuperar(this.USUARIO1.getCpf()));
    }

    @Test
    public void deveRecuperarTodosUsuariosTest() throws Exception {
        List<Usuario> usuarios = new ArrayList();
        usuarios.add(USUARIO2);
        usuarios.add(USUARIO1);
        assertEquals("TC004",usuarios,USUARIOMODEL.listarTodos());
    }

    @Test
    public void deveRecuperarUsuarioLoginSenhaTest() throws Exception {
            assertEquals("TC005", USUARIO2,
                 USUARIOMODEL.recuperar
                        (USUARIO2.getLogin(), USUARIO2.getSenha()));
    }
    

    @Test(expected = NullPointerException.class)
    public void naoDeveinserirUsuarioIncorretoTest() throws Exception {
        USUARIOMODEL.inserir(new Usuario(null, null, null, null, null, null,
                null,null, null, null));        
    }

    @Test(expected = java.lang.Exception.class)
    public void naoDeveInserirUsuarioCpfIncorretoTest() throws Exception {
        USUARIOMODEL.inserir(new Usuario("login", "senha", "nome",
                "1234567890123", "sexo",LocalDate.now(), ENDERECO, "telefone",
                    "email",new ArrayList<Bike>()));
    }

    @Test(expected = NullPointerException.class)
    public void naoDeveAlterarUsuarioInexistenteTest() throws Exception {
        USUARIOMODEL.alterar(new Usuario("alt", "alt", "alt", "alt", "alt", 
                    null, null, "alt", "alt", null));      
    }

    @Test(expected = NullPointerException.class)
    public void naoDeveDeletarUsuarioInexistenteTest() throws Exception {
        USUARIOMODEL.deletar(new Usuario("del", "del", "del", "del", "del", 
                null, null, "del", "del", null));       
    }

    @Test(expected = NullPointerException.class)
    public void naoDeveRecuperarUsuarioCPFInexistenteTest() throws Exception {
        USUARIOMODEL.deletar(USUARIOMODEL.recuperar("123123"));
    }

    @Test(expected = java.lang.Exception.class)
    public void recuperarUsuarioLoginInexistenteTest() throws Exception {
        USUARIOMODEL.deletar(
                USUARIOMODEL.recuperar("loginInexistente", "senha"));       
    }

    @AfterClass
    public static void deveLimparBD() throws Exception {
        USUARIOMODEL.deletar(USUARIO1);
        USUARIOMODEL.deletar(USUARIO2);
    }
}
