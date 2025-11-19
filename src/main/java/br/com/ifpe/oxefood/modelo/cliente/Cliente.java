package br.com.ifpe.oxefood.modelo.cliente;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.SQLRestriction;

import br.com.ifpe.oxefood.modelo.acesso.Usuario;
import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


// jpa 

@Entity

// sera criado uma tabela no banco de dados com o nome Cliente

@Table(name = "Cliente")

// servi para acressentar uma restrição sql na entidade

@SQLRestriction("habilitado = true")

// lombok

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends EntidadeAuditavel  {
  

   @OneToOne // relacionamento um para um com a entidade Usuario
   @JoinColumn(nullable = false) // anotações vão ter efeitos no banco de dados
   private Usuario usuario;

   @OneToMany(mappedBy = "cliente", orphanRemoval = true, fetch = FetchType.EAGER)
      @Fetch(FetchMode.SUBSELECT)
   private List<EnderecoCliente> enderecos;


   @Column(nullable = false, length = 100)
   private String nome;

   @Column
   private LocalDate dataNascimento;
  
   @Column(unique = true) // cpf unico no banco de dados
   private String cpf;

   @Column
   private String foneCelular; // @Length(min = 8, max = 30, message = "O campo Fixo deve ter entre {min} e
 // {max} caracteres")

   @Column
   private String foneFixo;

}
