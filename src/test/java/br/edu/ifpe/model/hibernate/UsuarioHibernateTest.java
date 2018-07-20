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
import br.edu.ifpe.model.classes.Usuario;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Lucas Mendes <lucas.mendes147@live.com>
 */
public class UsuarioHibernateTest {
/*
    private static final Endereco ENDERECO = new Endereco("estado", "cidade",
            "cep", "bairro", "logradouro");
    
    private static final UsuarioHibernate USUARIOHIBERNATE
            = UsuarioHibernate.getInstance();
    
    private static final Usuario USUARIO1 = new Usuario(
            "login", "senha", "nome", "28961303066", "sexo",
            LocalDate.now(), ENDERECO, "telefone", "email",
            new ArrayList<Bike>());
    
    private static final Usuario USUARIO2 = new Usuario(
            "login1", "senha1", "nome1", "28952871049", "sexo1",
            LocalDate.now(), ENDERECO, "telefone1", "email1",
            new ArrayList<Bike>());

    @BeforeClass
    public static void deveInserirUsuario() {
        USUARIOHIBERNATE.inserir(USUARIO1);
        USUARIOHIBERNATE.inserir(USUARIO2);
    }

    @Test
    public void deveRecuperarUsuarioTest() {
        assertEquals("TC001", USUARIO1, 
                USUARIOHIBERNATE.recuperar(1));
    }

    @Test
    public void deveAlterarUsuarioTest() {
        USUARIO1.setEmail("email alterado");
        USUARIO1.setLogin("login alterado");
        USUARIOHIBERNATE.alterar(USUARIO1);
        
        assertEquals("TC002",USUARIO1,
                USUARIOHIBERNATE.recuperar("28961303066"));
    }

    @Test
    public void deveRecuperarPorCpfUsuarioTest() {
        assertEquals("TC003", USUARIO2, 
                USUARIOHIBERNATE.recuperar("28952871049"));
    }

    @Test
    @Ignore
    public void recuperarTodosUsuariosTest() {
        ArrayList<Usuario> usuarios = new ArrayList();
        usuarios.add(USUARIO1);
        usuarios.add(USUARIO2);
        
        assertEquals("TC004",usuarios,USUARIOHIBERNATE.listarTodos());   
    }

    @Test
    public void deveDeletarUsuarioDoBDTest() {
        List<Usuario> usuarios = new ArrayList();
        
        usuarios.add(USUARIO1);
        usuarios.add(USUARIO2);
        
        USUARIOHIBERNATE.deletar(USUARIO1);
        assertNotEquals("TC005",USUARIOHIBERNATE.listarTodos() , usuarios);       
    }
    
    @AfterClass
    public static void deveLimparOBanco() {
        USUARIOHIBERNATE.deletar(USUARIO2);
    }
*/
}