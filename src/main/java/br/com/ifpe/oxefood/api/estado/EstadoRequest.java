package br.com.ifpe.oxefood.api.estado;

import br.com.ifpe.oxefood.modelo.estado.Estado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // gera os metodos getters e setters
@Builder // gera o padrao de projeto builder para facilitar a criacao de objetos
@NoArgsConstructor // gera o construtor sem argumentos
@AllArgsConstructor // gera o construtor com todos os argumentos

public class EstadoRequest {

    private String nome;

    private String sigla;

    public Estado build() {

        return Estado.builder()
                .nome(nome)
                .sigla(sigla)
                .build();
    }

}
