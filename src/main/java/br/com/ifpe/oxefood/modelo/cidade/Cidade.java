package br.com.ifpe.oxefood.modelo.cidade;

import java.time.LocalDate;

import org.hibernate.annotations.SQLRestriction;

import br.com.ifpe.oxefood.modelo.estado.Estado;
import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

// sera criado uma tabela no banco de dados com o nome Cliente

@Table(name = "Cidade")

// servi para acressentar uma restrição sql na entidade

@SQLRestriction("habilitado = true")

// lombok

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Cidade extends EntidadeAuditavel {

    @ManyToOne
    private Estado estado;

    @Column
    private String nome;

    @Column
    private Integer qtdPopulacao;

    @Column
    private Boolean ehCapital;

    @Column
    private LocalDate dataFundacao;
}
