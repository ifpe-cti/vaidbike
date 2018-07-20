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

import java.util.List;
import br.edu.ifpe.model.classes.Usuario;
import br.edu.ifpe.model.hibernate.UsuarioHibernate;
import br.edu.ifpe.model.interfacesDao.Dao;
import br.edu.ifpe.model.interfacesDao.UsuarioDao;

/**
 *
 * @author Carlos Cordeiro <carloscordeiroconsultor@gmail.com>
 */
public class UsuarioModel {

    private static ValidarCpf VALIDACAOCPF;
    private static Dao<Usuario> DAO;
    private static UsuarioModel instance = null;

    public UsuarioModel() {
        this.VALIDACAOCPF = new ValidarCpf();
        DAO = UsuarioHibernate.getInstance();
    }

    public void inserir(Usuario usuario) throws Exception {
        if (VALIDACAOCPF.isCPF(usuario.getCpf())) {
            if (((UsuarioDao) DAO).recuperar(usuario.getCpf()) == null) {
                DAO.inserir(usuario);
            } else {
                throw new Exception("Erro na validação de Cpf!");
            }
        } else {
            throw new Exception("Erro na validação de Cpf!");
        }
    }

    public void alterar(Usuario usuario) throws Exception {
        if (((UsuarioDao) DAO).recuperar(usuario.getCodigo()) != null) {
            DAO.alterar(usuario);
        } else {
            throw new Exception("Erro ao alterar o usuário, no UsuarioModel!");
        }
    }

    public Usuario recuperar(Integer codigo) throws Exception {
        if (codigo == null) {
            throw new Exception
                ("Codigo do Usuário não existe, no UsuarioModel");
        }
        return ((UsuarioDao) DAO).recuperar(codigo);
    }

    public void deletar(Usuario usuario) throws Exception {
        if (((UsuarioDao) DAO).recuperar(usuario.getCodigo()) != null) {
            DAO.deletar(usuario);
        } else {
            throw new Exception("Erro ao deletar o usuário, no UsuarioModel!");
        }
    }

    public Usuario recuperar(String cpf) throws Exception {

        if (cpf == null) {
            throw new Exception("CPF não existe. Classe UsuarioModel!");
        }
        return ((UsuarioDao) DAO).recuperar(cpf);
    }

    public List<Usuario> listarTodos() throws Exception {

        List<Usuario> usuarios = ((UsuarioDao) DAO).listarTodos();

        if (usuarios == null) {
            throw new Exception
                ("Erro ao recuperar a lista de usuários no model");
        } else {
            return usuarios;
        }
    }

    public Usuario recuperar(String login, String senha) throws Exception {

        Usuario usuario = ((UsuarioDao) DAO).recuperar(login, senha);
        if (usuario == null) {
            throw new Exception("Erro ao recuperar o Login do"
                    + " usuário no UsuarioModel!");
        } else {
            return usuario;
        }
    }
}
