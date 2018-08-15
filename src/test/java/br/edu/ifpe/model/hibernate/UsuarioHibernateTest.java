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
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Lucas Mendes <lucas.mendes147@live.com>
 */

public class UsuarioHibernateTest {

    private static final Endereco ENDERECO = new Endereco("estado", "cidade",
            "cep", "bairro", "logradouro");

    private static final Endereco ENDERECO1 = new Endereco("e", "c",
            "cc", "b", "l");

    private static final UsuarioHibernate USUARIOHIBERNATE
            = UsuarioHibernate.getInstance();

    private static Usuario usuario1 = new Usuario(
             "senha", "nome", "28961303066", "sexo",
            LocalDate.now(), ENDERECO1, "telefone", "email",
            new ArrayList<Bike>());

    private static final Usuario USUARIO2 = new Usuario(
             "senha1", "nome1", "28952871049", "sexo1",
            LocalDate.now(), ENDERECO, "telefone1", "email1",
            new ArrayList<Bike>());

    @BeforeClass
    public static void deveInserirUsuario() {
        USUARIOHIBERNATE.inserir(usuario1);
        USUARIOHIBERNATE.inserir(USUARIO2);
    }
    

    @Test
    public void deveRecuperarTodosUsuariosTest() {
        ArrayList<Usuario> usuarios = new ArrayList();
        ArrayList<Usuario> usuariosRecuperadosDoBanco
                = (ArrayList<Usuario>) USUARIOHIBERNATE.listarTodos();

        if (usuariosRecuperadosDoBanco.get(0).equals(usuario1)) {
            usuarios.add(usuario1);
            usuarios.add(USUARIO2);
        } else {
            usuarios.add(USUARIO2);
            usuarios.add(usuario1);
        }

        assertEquals("TC005", usuarios, usuariosRecuperadosDoBanco);
    }
    
    @Test
    public void deveRecuperarUsuarioPorId(){
        List<Usuario>usuarios = USUARIOHIBERNATE.listarTodos();
        
        if(usuarios.get(usuarios.size() - 1).equals(usuario1)){
            assertEquals("TC002", usuario1,usuarios.get(usuarios.size() - 1));
        }else{
            assertEquals("TC002", USUARIO2,usuarios.get(usuarios.size() - 1));
        }
    }
    
    @Test
    public void deveRecuperarPorCpfUsuarioTest() {
        assertEquals("TC003", USUARIO2,
                USUARIOHIBERNATE.recuperar("28952871049"));
    }

    @Test
    public void deveAletarUsuarioTest() {
        usuario1.setEmail("eee");
        usuario1.setSenha("llll");
        USUARIOHIBERNATE.alterar(usuario1);
        assertEquals("TC003", usuario1,
                USUARIOHIBERNATE.recuperar("28961303066"));
    }

    @AfterClass
    public static void deveLimparOBanco() {
        USUARIOHIBERNATE.deletar(usuario1);
        USUARIOHIBERNATE.deletar(USUARIO2);
    }
}
