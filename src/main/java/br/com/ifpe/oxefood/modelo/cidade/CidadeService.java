package br.com.ifpe.oxefood.modelo.cidade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CidadeService {
    @Autowired
    private CidadeReposity reposity;

    @Transactional
    public Cidade save(Cidade cidade) {
       cidade.setHabilitado(Boolean.TRUE);
        return reposity.save(cidade);
    }

    public List<Cidade> listarTodos() {

        return reposity.findAll(); // SELECT * FROM cliente;
    }

    public Cidade obterPorID(Long id) {

        return reposity.findById(id).get(); // SELECT * FROM cliente WHERE id = ?
    }

    

  @Transactional
    public void update(Long id, Cidade cidadeAlterado) {

        Cidade cidade = reposity.findById(id).get();
        cidade.setEstado(cidadeAlterado.getEstado());
;

        cidade.setNome(cidadeAlterado.getNome());
        cidade.setQtdPopulacao(cidadeAlterado.getQtdPopulacao());
        cidade.setEhCapital(cidadeAlterado.getEhCapital());
        cidade.setDataFundacao(cidadeAlterado.getDataFundacao());
       

        reposity.save(cidade);
    }



  @Transactional
    public void delete(Long id) {

        Cidade cidade = reposity.findById(id).get();
        cidade.setHabilitado(Boolean.FALSE);

        reposity.save(cidade);
    }

}
