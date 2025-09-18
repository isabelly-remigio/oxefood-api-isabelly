package br.com.ifpe.oxefood.modelo.produto;
import org.hibernate.annotations.SQLRestriction;
import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Entity

// sera criado uma tabela no banco de dados com o nome Cliente

@Table(name = "Produto")

// servi para acressentar uma restrição sql na entidade

@SQLRestriction("habilitado = true")

// lombok

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class Produto extends EntidadeAuditavel{
    @Column
    private String codigo;

    @Column
    private String titulo;

    @Column
    private String descricao;

    @Column
    private double valorUnitario;

    @Column
    private Integer tempoEntregaMinimo;

    @Column
    private Integer tempoEntregaMaximo;
}
