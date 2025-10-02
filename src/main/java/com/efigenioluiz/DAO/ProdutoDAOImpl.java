package com.efigenioluiz.DAO;

import java.sql.Connection;
import com.efigenioluiz.db.FabricaDeConexoes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.efigenioluiz.models.Produto;
import java.util.List;

import com.efigenioluiz.models.interfaces.ProdutoDAO;

// Implementação dos métodos da interface ProdutoDAO
// as regras do SQL permanece aqui, a ProdutoDAOImpl sabe se resolver
public class ProdutoDAOImpl implements ProdutoDAO {

    private Connection connection;

    public ProdutoDAOImpl() {
        this.connection = FabricaDeConexoes.getInstance().getConnection();
    }

    public ProdutoDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void salvar(Produto produto) {
        String query = "INSERT INTO produtos (`nome`, `preco`, `estoque`) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, 12);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao salvar produto", e);
        }
    }

    @Override
    public Produto buscarById(int id) {
        return null;
    }

    @Override
    public List<Produto> buscarAll() {
        return null;
    }

    @Override
    public void atualizar(Produto produto) {
    }

    @Override
    public void deletar(int id) {
    }

}
