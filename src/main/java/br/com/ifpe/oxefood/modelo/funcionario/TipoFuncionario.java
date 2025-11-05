package br.com.ifpe.oxefood.modelo.funcionario;

import com.fasterxml.jackson.annotation.JsonValue;
// Tipo de funcionário no sistema.
public enum TipoFuncionario {

    ADMINISTRADOR(
            "Administrador"),
    OPERADOR(
            "Operador");

    private String tipo;

    private TipoFuncionario(String tipo) {
        this.tipo = tipo;
    }

    @JsonValue
    public String getTipo() {
        return tipo;
    }

}