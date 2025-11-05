package br.com.ifpe.oxefood.modelo.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.util.exception.ProdutoException;
import jakarta.transaction.Transactional;


@Service
public class ProdutoService {
    @Autowired
    private ProdutoReposity reposity;

    @Transactional
    public Produto save(Produto produto) {

        if (produto.getValorUnitario() < 10) {
	    throw new ProdutoException(ProdutoException.MSG_VALOR_MINIMO_PRODUTO);
	}

        produto.setHabilitado(Boolean.TRUE);
        return reposity.save(produto);
    }

    public List<Produto> listarTodos() {

        return reposity.findAll(); // SELECT * FROM cliente;
    }

    public Produto obterPorID(Long id) {

        return reposity.findById(id).get(); // SELECT * FROM cliente WHERE id = ?
    }


    public List<Produto> filtrar(String codigo, String titulo, Long idCategoria) {

       List<Produto> listaProdutos = reposity.findAll();

       if ((codigo != null && !"".equals(codigo)) &&
           (titulo == null || "".equals(titulo)) &&
           (idCategoria == null)) {
               listaProdutos = reposity.consultarPorCodigo(codigo);
       } else if (
           (codigo == null || "".equals(codigo)) &&
           (titulo != null && !"".equals(titulo)) &&
           (idCategoria == null)) {    
               listaProdutos = reposity.findByTituloContainingIgnoreCaseOrderByTituloAsc(titulo);
       } else if (
           (codigo == null || "".equals(codigo)) &&
           (titulo == null || "".equals(titulo)) &&
           (idCategoria != null)) {
               listaProdutos = reposity.consultarPorCategoria(idCategoria); 
       } else if (
           (codigo == null || "".equals(codigo)) &&
           (titulo != null && !"".equals(titulo)) &&
           (idCategoria != null)) {
               listaProdutos = reposity.consultarPorTituloECategoria(titulo, idCategoria); 
       }

       return listaProdutos;
}


    @Transactional
    public void update(Long id, Produto produtoAlterado) {

        Produto produto = reposity.findById(id).get();
              produto.setCategoria(produtoAlterado.getCategoria());
;

        produto.setTitulo(produtoAlterado.getTitulo());
        produto.setCodigo(produtoAlterado.getCodigo());
        produto.setDescricao(produtoAlterado.getDescricao());
        produto.setValorUnitario(produtoAlterado.getValorUnitario());
        produto.setTempoEntregaMinimo(produtoAlterado.getTempoEntregaMinimo());
        produto.setTempoEntregaMaximo(produtoAlterado.getTempoEntregaMaximo());

        reposity.save(produto);
    }

    @Transactional
    public void delete(Long id) {

        Produto produto = reposity.findById(id).get();
        produto.setHabilitado(Boolean.FALSE);

        reposity.save(produto);
    }

}
