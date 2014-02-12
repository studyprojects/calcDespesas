package net.studyprojects.calcdespesas.jpa.test;

import java.util.Calendar;

import javax.persistence.EntityManager;

import net.studyprojects.calcdespesas.model.CartaoDeCredito;

import org.joda.time.DateTime;

public class FaturaTest {

	public static void main(String[] args) {

		// Dado um cartao de credito, podemos gerar as faturas deste cartao.

		// Persistence

		EntityManager em = JPAUtil.getEntityManager();

		CartaoDeCredito cc = (CartaoDeCredito) em.find(CartaoDeCredito.class,
				1L);

		System.out.println("Data de Expiracao: "
				+ cc.getDataDeExpiracao().getTime());

		DateTime dataDafaturaFinal = new DateTime(cc.getDataDeExpiracao()
				.clone());

		DateTime dataDaFaturaAtual = new DateTime(Calendar.getInstance());

		while (dataDaFaturaAtual.isBefore(dataDafaturaFinal.getMillis())) {
			System.out.println("Data Fatura Atual: "
					+ dataDaFaturaAtual.toString());
			dataDaFaturaAtual = dataDaFaturaAtual.plusMonths(1);
		}

		// Fatura fatura = new Fatura();

		// fatura.set

	}

}
