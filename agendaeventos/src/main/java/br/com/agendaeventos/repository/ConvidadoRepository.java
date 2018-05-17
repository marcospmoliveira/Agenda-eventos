package br.com.agendaeventos.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.agendaeventos.models.Convidado;
import br.com.agendaeventos.models.Evento;

public interface ConvidadoRepository extends CrudRepository<Convidado, String> {
	Iterable<Convidado> findByEvento(Evento evento);

	Convidado findByRg(String rg);
}
