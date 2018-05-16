package br.com.agendaeventos.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.agendaeventos.models.Convidado;

public interface ConvidadoRepository extends CrudRepository<Convidado, String> {

}
