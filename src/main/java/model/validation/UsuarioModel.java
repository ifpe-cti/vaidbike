package model.validation;

import java.util.List;
import model.classes.Usuario;
import model.hibernate.UsuarioHibernate;
import model.interfacesDao.Dao;
import model.interfacesDao.UsuarioDao;

/*MIT License

Copyright (c) 2018 Milena dos Santos Macedo, Carlos André Cordeiro da Silva, 
Adrielly Calado Sales, Luciano Campos de Lima Júnior.

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
/**
 *
 * @author Carlos Cordeiro - carloscordeiroconsultor@gmail.com
 */
public class UsuarioModel {

    ValidarCpf validacaoCpf = new ValidarCpf();
    Dao<Usuario> dao = new UsuarioHibernate();

    public void inserir(Usuario usuario) throws Exception {
        if (validacaoCpf.isCPF(usuario.getCpf()) == true) {
            if (((UsuarioDao) dao).recuperar(usuario.getCpf()) == null) {
                dao.inserir(usuario);
            } else {
                throw new Exception("Erro ao inserir o usuário, no UsuarioModel!");
            }
            //verifiar depois se essa validação está correta.
        } else {
            throw new Exception("Erro na validação de Cpf!");
        }
    }

    public void alterar(Usuario usuario) throws Exception {
        if (((UsuarioDao) dao).recuperar(usuario.getCodigo()) != null) {
            dao.alterar(usuario);
        } else {
            throw new Exception("Erro ao alterar o usuário, no UsuarioModel!");
        }
    }

    public Usuario recuperar(Integer codigo) throws Exception {
        if (codigo == null) {
            throw new Exception("Codigo do Usuário não existe, no UsuarioModel");
        }
        return ((UsuarioDao) dao).recuperar(codigo);
    }

    public void deletar(Usuario usuario) throws Exception {
        if (((UsuarioDao) dao).recuperar(usuario.getCodigo()) != null) {
            dao.deletar(usuario);
        } else {
            throw new Exception("Erro ao deletar o usuário, no UsuarioModel!");
        }
    }

    public Usuario recuperar(String cpf) throws Exception {

        if (cpf == null) {
            throw new Exception("CPF não existe. Classe UsuarioModel!");
        }
        return ((UsuarioDao) dao).recuperar(cpf);
    }

    public List<Usuario> listarTodos() throws Exception {

        List<Usuario> usuarios = ((UsuarioDao) dao).listarTodos();

        if (usuarios == null) {
            throw new Exception("Erro ao recuperar a lista de usuários no model");
        } else {
            return usuarios;
        }
    }

    public Usuario recuperar(String login, String senha) throws Exception {

        Usuario usuario = ((UsuarioDao) dao).recuperar(login, senha);

        if (usuario == null) {
            throw new Exception("Erro ao recuperar o Login do usuário no UsuarioModel!");
        } else {
            return usuario;
        }
    }
}
