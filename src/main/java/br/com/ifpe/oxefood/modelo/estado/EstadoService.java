package br.com.ifpe.oxefood.modelo.estado;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;


@Service
public class EstadoService {
    @Autowired
    private EstadoReposity reposity;

    @Transactional
    public Estado save(Estado estado) {
        estado.setHabilitado(Boolean.TRUE);
        return reposity.save(estado);
    }

    public List<Estado> listarTodos() {

        return reposity.findAll(); // SELECT * FROM cliente;
    }

    public Estado obterPorID(Long id) {

        return reposity.findById(id).get(); // SELECT * FROM cliente WHERE id = ?
    }


    @Transactional
    public void update(Long id, Estado estadoAlterado) {
        Estado estado = reposity.findById(id).get();
    	estadoAlterado.getNome();
	estadoAlterado.getSigla();

        reposity.save(estado);
    }

    @Transactional
    public void delete(Long id) {

        Estado estado = reposity.findById(id).get();
     estado.setHabilitado(Boolean.FALSE);

        reposity.save(estado);
    }
}