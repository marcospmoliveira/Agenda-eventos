package br.com.agendaeventos.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.agendaeventos.models.Evento;

public interface EventoRepository extends CrudRepository<Evento, String>{
	Evento findByCodigo(Long codigo);
}
