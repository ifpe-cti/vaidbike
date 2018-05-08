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
package model.hibernate;

import java.util.List;
import model.classes.Usuario;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Milena Macedo
 */
public class UsuarioHibernateIT {
    
    public UsuarioHibernateIT() {
    }

    /**
     * Test of getInstance method, of class UsuarioHibernate.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        UsuarioHibernate expResult = null;
        UsuarioHibernate result = UsuarioHibernate.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of recuperar method, of class UsuarioHibernate.
     */
    @Test
    public void testRecuperar_String() {
        System.out.println("recuperar");
        String cpf = "";
        UsuarioHibernate instance = new UsuarioHibernate();
        Usuario expResult = null;
        Usuario result = instance.recuperar(cpf);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of recuperar method, of class UsuarioHibernate.
     */
    @Test
    public void testRecuperar_String_String() {
        System.out.println("recuperar");
        String login = "";
        String senha = "";
        UsuarioHibernate instance = new UsuarioHibernate();
        Usuario expResult = null;
        Usuario result = instance.recuperar(login, senha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inserir method, of class UsuarioHibernate.
     */
    @Test
    public void testInserir() {
        System.out.println("inserir");
        Usuario usuario = null;
        UsuarioHibernate instance = new UsuarioHibernate();
        instance.inserir(usuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alterar method, of class UsuarioHibernate.
     */
    @Test
    public void testAlterar() {
        System.out.println("alterar");
        Usuario usuario = null;
        UsuarioHibernate instance = new UsuarioHibernate();
        instance.alterar(usuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of recuperar method, of class UsuarioHibernate.
     */
    @Test
    public void testRecuperar_int() {
        System.out.println("recuperar");
        int codigo = 0;
        UsuarioHibernate instance = new UsuarioHibernate();
        Usuario expResult = null;
        Usuario result = instance.recuperar(codigo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletar method, of class UsuarioHibernate.
     */
    @Test
    public void testDeletar() {
        System.out.println("deletar");
        Usuario usuario = null;
        UsuarioHibernate instance = new UsuarioHibernate();
        instance.deletar(usuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarTodos method, of class UsuarioHibernate.
     */
    @Test
    public void testListarTodos() {
        System.out.println("listarTodos");
        UsuarioHibernate instance = new UsuarioHibernate();
        List<Usuario> expResult = null;
        List<Usuario> result = instance.listarTodos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
