package net.studyprojects.calcdespesas.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.studyprojects.calcdespesas.dao.UsuarioDao;
import net.studyprojects.calcdespesas.model.Usuario;

import org.springframework.stereotype.Repository;

@Repository
public class JpaUsuarioDao implements UsuarioDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void adiciona(Usuario usuario) {
		em.persist(usuario);
	}

	@Override
	public void remove(Usuario usuario) {
		Usuario usuarioARemover = buscaPorId(usuario.getId());
		em.remove(usuarioARemover);
	}

	@Override
	public void altera(Usuario usuario) {
		em.merge(usuario);
	}

	@Override
	public Usuario buscaPorId(Long id) {
		return em.find(Usuario.class, id);
	}

	@Override
	public List<Usuario> lista() {
		return em.createQuery("select u from Usuario as u").getResultList();
	}

}
