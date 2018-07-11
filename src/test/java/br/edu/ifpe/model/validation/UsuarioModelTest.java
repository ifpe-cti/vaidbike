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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Lucas Mendes <lucas.mendes147@live.com>
 */
public class UsuarioModelTest {

    private final UsuarioModel USUARIOMODEL;
    private final Endereco ENDERECO;
    private Date data;
    private Usuario usuario1;
    private Usuario usuario2;

    public UsuarioModelTest() {
        USUARIOMODEL = new UsuarioModel();
        ENDERECO = new Endereco
            ("estado", "cidade", "cep", "bairro", "logradouro");

        try {
            DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
            String sdata = "29-04-2018";
            data = df1.parse(sdata);
            
            this.usuario1 = new Usuario
                ("login", "senha", "nome", "cpf", "sexo", data, ENDERECO,
                    "telefone", "email", new ArrayList<Bike>());

            this.usuario2 = new Usuario
                ("login2", "senha2", "nome2", "cpf2", "sexo2", data, ENDERECO,
                    "telefone2", "email2", new ArrayList<Bike>());
        } catch (ParseException parse) {
        }
    }

    @BeforeClass
    public static void inserirEntidadesBD() {
        UsuarioModel usuarioModel = new UsuarioModel();
         try{
            DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
            String sdata = "29-04-2018";
            Date date = df1.parse(sdata);
            Endereco end = new Endereco
                ("estado", "cidade", "cep", "bairro", "logradouro");
            
            Usuario usuarioBD1 = new Usuario
                ("login", "senha", "nome", "cpf", "sexo", date, end,
                    "telefone", "email", new ArrayList<Bike>());

            Usuario usuarioBD2 = new Usuario
                ("login2", "senha2", "nome2", "cpf2", "sexo2", date, end,
                    "telefone2", "email2", new ArrayList<Bike>());
            
            usuarioModel.inserir(usuarioBD1);
            usuarioModel.inserir(usuarioBD2);
         }catch(Exception e){  
         }     
    }

    @Test
    public void inserirUsuarioTest() {
        try {
            USUARIOMODEL.inserir(usuario1);
            Assert.assertEquals
                ("TC001",usuario1, USUARIOMODEL.recuperar("cpf"));
        } catch (Exception exception) {
        }
    }
    
    @Test
    public void alterarUsuarioTest(){
        try{
            Usuario usuarioOld = this.usuario1;
            usuarioOld.setNome("ALTERADO");
            usuarioOld.setLogin("ALTERADO");
            usuarioOld.setSenha("ALTERADO");
        
            Assert.assertEquals
                ("TC002",usuarioOld,USUARIOMODEL.recuperar
                    (this.usuario1.getCodigo()));
        }catch(Exception exception){ 
        }
    }
    
    @Test
    public void recuperarUsuarioIdTest(){
        try{
            Assert.assertEquals
                ("TC003",this.usuario1,USUARIOMODEL.recuperar
                    (this.usuario1.getCodigo()));
        }catch(Exception e){  
        } 
    }
    
    @Test
    public void deletarUsuarioTest(){
        try{
            Usuario del = new Usuario
                    ("loginDel", "senhaDel", "nomeDel", "cpfDel", "sexoDel", 
                        data, ENDERECO, "telefoneDel", "emailDel", 
                            new ArrayList<Bike>());
            
            USUARIOMODEL.inserir(del);
            USUARIOMODEL.deletar(del);
            assertNotEquals
                ("TC004",del,USUARIOMODEL.recuperar(del.getCodigo()));
        }catch(Exception e){
        }
    }
    
    @Test
    public void recuperarUsuarioCpfTest(){
         try{
            Assert.assertEquals
                ("TC003",this.usuario1,USUARIOMODEL.recuperar
                    (this.usuario1.getCpf()));
        }catch(Exception e){  
        } 
    }
    
    @Test
    public void recuperarTodosUsuariosTest(){
        List<Usuario> usuarios = new ArrayList();
        try{
            DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
            String sdata = "29-04-2018";
            data = df1.parse(sdata);
            
            Usuario usuarioLista1 = new Usuario
                ("login", "senha", "nome", "cpf", "sexo", data, ENDERECO,
                    "telefone", "email", new ArrayList<Bike>());

            Usuario usuarioLista2 = new Usuario
                ("login2", "senha2", "nome2", "cpf2", "sexo2", data, ENDERECO,
                    "telefone2", "email2", new ArrayList<Bike>());
            
            usuarios.add(usuarioLista1);
            usuarios.add(usuarioLista2);
            
            assertEquals
                ("TC004",usuarios,(ArrayList) USUARIOMODEL.listarTodos());
        }catch(Exception e){
        }
    }
    
    @Test
    public void recuperarUsuarioLoginSenhaTest(){
        try{
            assertEquals
                ("TC005", this.usuario2,
                        USUARIOMODEL.recuperar("login2", "senha2"));
        }catch(Exception e){
        }
    }
    
    @Test(expected = NullPointerException.class)
    public void inserirUsuarioIncorretoTest() throws Exception{
        USUARIOMODEL.inserir(new Usuario
            (null, null, null, null, null, null, null,
                    null, null, null));
    }
    
    @Test(expected = Exception.class)
    public void inserirUsuarioCpfIncorretoTest() throws Exception{
        USUARIOMODEL.inserir
            (new Usuario
                ("login", "senha", "nome", "1234567890123", "sexo"
                    , data, ENDERECO,"telefone", "email"
                        , new ArrayList<Bike>()));
    }
   
    @Test(expected = NullPointerException.class)
    public void alterarUsuarioInexistenteTest() throws Exception{
        USUARIOMODEL.alterar
        (new Usuario
            ("alt", "alt", "alt", "alt", "alt", null, null,
                    "alt", "alt", null));
    }
    
    @Test(expected = NullPointerException.class)
    public void deletarUsuarioInexistenteTest() throws Exception{
        USUARIOMODEL.deletar
            (new Usuario
                ("del", "del", "del", "del", "del", null, null,
                    "del", "del", null));
    }
    
    @Test(expected = NullPointerException.class)
    public void recuperarUsuarioCPFInexistenteTest() throws Exception{
        USUARIOMODEL.deletar(USUARIOMODEL.recuperar("123123"));
    }
    
    @Test(expected = Exception.class)
    public void recuperarUsuarioLoginInexistenteTest() throws Exception{
        USUARIOMODEL.deletar(
                USUARIOMODEL.recuperar("loginInexistente","senha"));
    }
    
    @AfterClass
    public static void limparBD(){
         UsuarioModel usuarioModel = new UsuarioModel();
         try{
            DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
            String sdata = "29-04-2018";
            Date date = df1.parse(sdata);
            Endereco end = new Endereco
                ("estado", "cidade", "cep", "bairro", "logradouro");
            
            Usuario usuarioBD1 = new Usuario
                ("login", "senha", "nome", "cpf", "sexo", date, end,
                    "telefone", "email", new ArrayList<Bike>());

            Usuario usuarioBD2 = new Usuario
                ("login2", "senha2", "nome2", "cpf2", "sexo2", date, end,
                    "telefone2", "email2", new ArrayList<Bike>());
            
            usuarioModel.deletar(usuarioBD1);
            usuarioModel.deletar(usuarioBD2);
         }catch(Exception e){  
         }     
    }
}
