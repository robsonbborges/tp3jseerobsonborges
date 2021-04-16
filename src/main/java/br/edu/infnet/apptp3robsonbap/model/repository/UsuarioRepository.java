package br.edu.infnet.apptp3robsonbap.model.repository;

import org.springframework.stereotype.Repository;

import br.edu.infnet.apptp3robsonbap.model.negocio.Usuario;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

    Usuario findByEmail(String email);

}
