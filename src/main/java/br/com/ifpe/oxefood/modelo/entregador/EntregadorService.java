package br.com.ifpe.oxefood.modelo.entregador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.List;

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
  
        return reposity.findAll(); //SELECT * FROM cliente;
    }

    public Entregador obterPorID(Long id) {

        return reposity.findById(id).get(); // SELECT * FROM cliente WHERE id = ?
    }
    

}
