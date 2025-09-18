package br.com.ifpe.oxefood.modelo.produto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProdutoReposity extends JpaRepository<Produto, Long> {
    
}
