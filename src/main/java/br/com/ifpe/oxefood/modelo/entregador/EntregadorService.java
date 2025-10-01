package br.com.ifpe.oxefood.modelo.entregador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class EntregadorService {

    @Autowired
    private EntregadorReposity reposity;

    @Transactional
    public Entregador save(Entregador entregador) {
        entregador.setHabilitado(Boolean.TRUE);
        return reposity.save(entregador);
    }

    public List<Entregador> listarTodos() {

        return reposity.findAll(); // SELECT * FROM cliente;
    }

    public Entregador obterPorID(Long id) {

        return reposity.findById(id).get(); // SELECT * FROM cliente WHERE id = ?
    }

    @Transactional
    public void update(Long id, Entregador entregadorAlterado) {

       Entregador entregador = reposity.findById(id).get();
       entregador.setNome(entregadorAlterado.getNome());
       entregador.setCpf(entregadorAlterado.getCpf());
       entregador.setRg(entregadorAlterado.getRg());
         entregador.setDataNascimento(entregadorAlterado.getDataNascimento());
         entregador.setFoneCelular(entregadorAlterado.getFoneCelular());
        entregador.setFoneFixo(entregadorAlterado.getFoneFixo());
        entregador.setQtdEntregasRealizadas(entregadorAlterado.getQtdEntregasRealizadas());
        entregador.setValorFrete(entregadorAlterado.getValorFrete());
        entregador.setEnderecoRua(entregadorAlterado.getEnderecoRua());
        entregador.setEnderecoNumero(entregadorAlterado.getEnderecoNumero());
        entregador.setEnderecoBairro(entregadorAlterado.getEnderecoBairro());
        entregador.setEnderecoCidade(entregadorAlterado.getEnderecoCidade());
        entregador.setEnderecoCep(entregadorAlterado.getEnderecoCep());
        entregador.setEnderecoComplemento(entregadorAlterado.getEnderecoComplemento());
        entregador.setAtivo(entregadorAlterado.getAtivo());
         reposity.save(entregador);
              

    }

    @Transactional
    public void delete(Long id) {

        Entregador entregador = reposity.findById(id).get();
        entregador.setHabilitado(Boolean.FALSE);

        reposity.save(entregador);
    }
}
