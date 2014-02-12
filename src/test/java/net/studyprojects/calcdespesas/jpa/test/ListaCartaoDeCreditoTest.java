package net.studyprojects.calcdespesas.jpa.test;

import java.util.List;

import javax.persistence.EntityManager;

import net.studyprojects.calcdespesas.infra.JPAUtil;
import net.studyprojects.calcdespesas.model.CartaoDeCredito;

public class ListaCartaoDeCreditoTest {

	public static void main(String[] args) {

		EntityManager manager = new JPAUtil().getEntityManager();

		List<CartaoDeCredito> cartoesDeCredito = manager.createQuery(
				"Select c from CartaoDeCredito as c").getResultList();

		for (CartaoDeCredito cartao : cartoesDeCredito) {
			System.out.println("Titulo: " + cartao.getTitulo());
			System.out.println("Descricao: " + cartao.getDescricao());
			System.out.println("Bandeira: " + cartao.getBandeira());
			System.out.println("Data de Expiracao: "
					+ cartao.getDataDeExpiracao().getTime());
		}

		System.out.println(cartoesDeCredito.size());

	}

}
