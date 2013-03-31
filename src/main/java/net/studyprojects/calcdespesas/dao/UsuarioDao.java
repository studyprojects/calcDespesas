package net.studyprojects.calcdespesas.dao;

import java.util.List;

import net.studyprojects.calcdespesas.model.Usuario;

public interface UsuarioDao {

	public void adiciona(Usuario usuario);

	public void remove(Usuario usuario);

	public void altera(Usuario usuario);

	public Usuario buscaPorId(Long id);

	public List<Usuario> lista();
}
