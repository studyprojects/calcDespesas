package net.studyprojects.calcdespesas.jpa.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.EntityManager;

import net.studyprojects.calcdespesas.model.Bandeira;
import net.studyprojects.calcdespesas.model.CartaoDeCredito;

public class CartaoDeCreditoTest {

	public static void main(String[] args) {

		// EntityManagerFactory factory = Persistence
		// .createEntityManagerFactory("controledespesas");
		//
		// EntityManager em = factory.createEntityManager();

		// Criacao de um cartao de credito

		CartaoDeCredito cartao = new CartaoDeCredito();
		cartao.setTitulo("Diners Club Paul");

		try {

			Calendar dataDeExpiracao = Calendar.getInstance();

			dataDeExpiracao.setTime(new SimpleDateFormat("dd/MM/yyyy")
					.parse("01/09/2017"));

			cartao.setDataDeExpiracao(dataDeExpiracao);

		} catch (ParseException e) {
			throw new RuntimeException(e);
		}

		cartao.setDescricao("Diners do Paul vinculado a Michaela");

		cartao.setBandeira(Bandeira.DINERSCLUB);

		// Persistindo o objeto:
		EntityManager em = JPAUtil.getEntityManager();

		em.getTransaction().begin();

		em.persist(cartao);

		em.getTransaction().commit();

		em.close();

		System.out.println("Id do Cartao: " + cartao.getId());

	}
}
