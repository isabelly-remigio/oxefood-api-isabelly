

package br.com.ifpe.oxefood.api.cliente;


import br.com.ifpe.oxefood.modelo.cliente.EnderecoCliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // gera os metodos getters e setters
@Builder // gera o padrao de projeto builder para facilitar a criacao de objetos 
@NoArgsConstructor // gera o construtor sem argumentos
@AllArgsConstructor 


public class EnderecoClienteRequest {

   private String rua;

   private String numero;

   private String bairro;

   private String cep;

   private String cidade;

   private String estado;

   private String complemento;

   public EnderecoCliente build() {

       return EnderecoCliente.builder()
               .rua(rua)
               .numero(numero)
               .bairro(bairro)
               .cep(cep)
               .cidade(cidade)
               .estado(estado)
               .complemento(complemento)
               .build();
   }
}
