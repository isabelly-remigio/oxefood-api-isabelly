package br.com.ifpe.oxefood.modelo.categoria_produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CategoriaProdutoService {
    @Autowired
    private CategoriaProdutoReposity reposity;

    @Transactional
    public CategoriaProduto save(CategoriaProduto categoria_Produto) {
        categoria_Produto.setHabilitado(Boolean.TRUE);
        return reposity.save(categoria_Produto);
    }

    public List<CategoriaProduto> listarTodos() {

        return reposity.findAll(); // SELECT * FROM cliente;
    }

    public CategoriaProduto obterPorID(Long id) {

        return reposity.findById(id).get(); // SELECT * FROM cliente WHERE id = ?
    }


    @Transactional
    public void update(Long id, CategoriaProduto categoria_ProdutoAlterado) {
        CategoriaProduto categoria_Produto = reposity.findById(id).get();
     categoria_ProdutoAlterado.getDescricao();

        reposity.save(categoria_Produto);
    }

    @Transactional
    public void delete(Long id) {

        CategoriaProduto categoria_Produto = reposity.findById(id).get();
        categoria_Produto.setHabilitado(Boolean.FALSE);

        reposity.save(categoria_Produto);
    }
}
