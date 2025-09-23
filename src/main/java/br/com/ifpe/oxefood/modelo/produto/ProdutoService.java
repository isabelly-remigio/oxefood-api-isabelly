package br.com.ifpe.oxefood.modelo.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoReposity reposity;

    @Transactional
    public Produto save(Produto produto) {
        produto.setHabilitado(Boolean.TRUE);
        return reposity.save(produto);
    }

    public List<Produto> listarTodos() {
  
        return reposity.findAll(); //SELECT * FROM cliente;
    }
    public Produto obterPorID(Long id) {

        return reposity.findById(id).get(); // SELECT * FROM cliente WHERE id = ?
    }
}
