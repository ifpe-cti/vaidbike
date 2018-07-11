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
import br.edu.ifpe.model.classes.Locacao;
import br.edu.ifpe.model.classes.Usuario;
import br.edu.ifpe.model.hibernate.LocacaoHibernate;
import br.edu.ifpe.model.interfacesDao.Dao;
import br.edu.ifpe.model.interfacesDao.LocacaoDao;

/**
 *
 * @author Milena Macedo <milenasantosmcd@gmail.com>
 */
public class LocacaoModel {

    private final Dao<Locacao> DAO = LocacaoHibernate.getInstance();

    public void inserir(Locacao locacao) throws Exception {

        if (((LocacaoDao) DAO).recuperar(locacao.getCodigo()) == null) {
            DAO.inserir(locacao);
        } else {
            throw new Exception("Erro ao inserir a Locação na classe"
                    + " LocacaoModel");
        }
    }

    public void alterar(Locacao locacao) throws Exception {

        if (((LocacaoDao) DAO).recuperar(locacao.getCodigo()) != null) {
            DAO.alterar(locacao);
        } else {
            throw new Exception("Erro ao alterar a Locação na classe"
                    + " LocacaoModel");
        }
    }

    public Locacao recuperar(Integer codigo) throws Exception {

        if (codigo == null) {
            throw new Exception("Codigo da Locação não existe na classe"
                    + " LocacaoModel");
        }
        return ((LocacaoDao) DAO).recuperar(codigo);
    }

    public void deletar(Locacao locacao) throws Exception {

        if (((LocacaoDao) DAO).recuperar(locacao.getCodigo()) != null) {
            DAO.deletar(locacao);
        } else {
            throw new Exception("Erro ao deletar o usuário na classe"
                    + " LocacaoModel!");
        }
    }

    public List<Locacao> listarTodos() throws Exception {

        List<Locacao> locacao = ((LocacaoDao) DAO).listarTodos();

        if (locacao == null) {
            throw new Exception("Erro ao recuperar a lista de Locação no model");
        } else {
            return locacao;
        }
    }

    public List<Locacao> retornarListaLocacao(Usuario cliente)
            throws Exception {

        List<Locacao> locacaoCliente
                = ((LocacaoDao) DAO).retornarListaLocacao(cliente);
        if (locacaoCliente == null) {
            throw new Exception("Erro ao recuperar a lista  de "
                    + "locações do cliente no model");
        } else {
            return locacaoCliente;
        }
    }

    public List<Locacao> retornarListaLocatario(Usuario locatario)
            throws Exception {

        List<Locacao> locacaoLocatario
                = ((LocacaoDao) DAO).retornarListaLocacao(locatario);

        if (locacaoLocatario == null) {
            throw new Exception("Erro ao recuperar a lista  de "
                    + "locações do locatario no model");
        } else {
            return locacaoLocatario;
        }
    }

}
