package br.com.ifpe.oxefood.modelo.categoria_produto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaProdutoReposity extends JpaRepository<CategoriaProduto, Long>{

    //  List<CategoriaProduto> findByChaveEmpresaOrderByDescricao(); porque esta faltando o parâmetro em 
    //findByChaveEmpresaOrderByDescricao()que seria String descricao
    

}
