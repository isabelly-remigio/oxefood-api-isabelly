package br.com.ifpe.oxefood.modelo.estado;

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

// sera criado uma tabela no banco de dados com o nome ESTADO

@Table(name = "Estado")

// servi para acressentar uma restrição sql na entidade

@SQLRestriction("habilitado = true")

// lombok

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Estado extends EntidadeAuditavel {


    @Column
    private String nome;

    @Column
    private String sigla;

}
