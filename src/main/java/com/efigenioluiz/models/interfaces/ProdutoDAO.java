package com.efigenioluiz.models.interfaces;

import com.efigenioluiz.models.Produto;
import com.efigenioluiz.models.Produto;
import java.util.List;

public interface ProdutoDAO {
    void salvar(Produto produto);

    Produto buscarById(int id);

    List<Produto> buscarAll();

    void atualizar(Produto produto);

    void deletar(int id);

}