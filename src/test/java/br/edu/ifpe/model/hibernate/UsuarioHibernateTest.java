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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Lucas Mendes <lucas.mendes147@live.com>
 */
public class UsuarioHibernateTest {

    private static Endereco endereco;
    private static UsuarioHibernate usuarioHibernate;

    public UsuarioHibernateTest() {
        UsuarioHibernateTest.endereco = new Endereco("estado", "cidade",
                "cep", "bairro", "logradouro");
        UsuarioHibernateTest.usuarioHibernate = new UsuarioHibernate();
    }

    @BeforeClass
    public static void inserirUsuario() {
        try {
            DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
            String sdata = "28-04-2018";
            Date data = df1.parse(sdata);

            Usuario usuario1 = new Usuario(
                    "login", "senha", "nome", "cpf", "sexo",
                    data, endereco, "telefone", "email",
                    new ArrayList<Bike>());

            Usuario usuario2 = new Usuario(
                    "login1", "senha1", "nome1", "cpf1", "sexo1",
                    data, endereco, "telefone1", "email1",
                    new ArrayList<Bike>());

            usuarioHibernate.inserir(usuario1);
            usuarioHibernate.inserir(usuario2);
        } catch (ParseException parse) {

        }
    }

    @Test
    public void recuperarUsuarioTest() {
        try {
            DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
            String sdata = "28-04-2008";
            Date data = df1.parse(sdata);

            Usuario usuario = new Usuario(
                    "login", "senha", "nome", "cpf", "sexo",
                    data, endereco, "telefone", "email",
                    new ArrayList<Bike>());

            Assert.assertEquals
                ("TC001", usuario, usuarioHibernate.recuperar("cpf"));
        } catch (ParseException parse) {
        }

    }

    @Test
    public void alterarUsuarioTest() {
        try {
            DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
            String sdata = "29-04-2008";
            Date data = df1.parse(sdata);

            Usuario usuarioOld = usuarioHibernate.recuperar("cpf");
            usuarioOld.setEmail("ALTERADO");
            usuarioOld.setLogin("ALTERADO");
            usuarioOld.setSenha("ALTERADO");

            usuarioHibernate.alterar(usuarioOld);
            Assert.assertEquals("TC002", usuarioOld,
                    usuarioHibernate.recuperar("cpf"));
        } catch (ParseException parse) {
        }
    }

    @Test
    public void recuperarPorCpfUsuarioTest() {
        try {
            DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
            String sdata = "29-04-2008";
            Date data = df1.parse(sdata);

            Usuario usuarioOld = new Usuario(
                    "login1", "senha1", "nome", "cpf", "sexo",
                        data, endereco, "telefone", "email",
                            new ArrayList<Bike>());
            
            Assert.assertEquals
                ("TC003", usuarioOld, 
                            usuarioHibernate.recuperar("login1", "senha1"));
        } catch (ParseException parse) {
        }
    }

    @Test
    public void recuperarTodosUsuariosTest() {
        List<Usuario> usuarios = new ArrayList();
        
        try {
            DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
            String sdata = "28-04-2018";
            Date data = df1.parse(sdata);

            Usuario usuario1 = new Usuario(
                    "login", "senha", "nome", "cpf", "sexo",
                    data, endereco, "telefone", "email",
                    new ArrayList<Bike>());

            Usuario usuario2 = new Usuario(
                    "login1", "senha1", "nome1", "cpf1", "sexo1",
                    data, endereco, "telefone1", "email1",
                    new ArrayList<Bike>());

            usuarios.add(usuario1);
            usuarios.add(usuario2);
            Assert.assertEquals
                ("TC004", usuarios, usuarioHibernate.listarTodos());
        } catch (ParseException parse) {
        }
    }

    @Test
    public void deletarUsuarioTest() {
        List<Usuario> usuarios = new ArrayList();
        
        try {
            DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
            String sdata = "28-04-2018";
            Date data = df1.parse(sdata);

            Usuario usuario1 = new Usuario(
                    "login", "senha", "nome", "cpf", "sexo",
                    data, endereco, "telefone", "email",
                    new ArrayList<Bike>());

            Usuario usuario2 = new Usuario(
                    "login1", "senha1", "nome1", "cpf1", "sexo1",
                    data, endereco, "telefone1", "email1",
                    new ArrayList<Bike>());

            usuarios.add(usuario1);
            usuarios.add(usuario2);

            usuarioHibernate.deletar(usuario2);
            Assert.assertNotEquals
                ("TC005", usuarios, usuarioHibernate.listarTodos());
        } catch (ParseException parse) {
        }
    }

    @AfterClass
    public static void limparBD() {
        try {
            DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
            String sdata = "28-04-2018";
            Date data = df1.parse(sdata);

            Usuario usuario1 = new Usuario(
                    "login", "senha", "nome", "cpf", "sexo",
                    data, endereco, "telefone", "email",
                    new ArrayList<Bike>());

            Usuario usuario2 = new Usuario(
                    "login1", "senha1", "nome1", "cpf1", "sexo1",
                    data, endereco, "telefone1", "email1",
                    new ArrayList<Bike>());
            
            usuarioHibernate.deletar(usuario1);
            usuarioHibernate.deletar(usuario2);
        } catch (ParseException parse) {
        }
    }
}
