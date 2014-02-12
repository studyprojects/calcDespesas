package net.studyprojects.calcdespesas.jpa.test;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import net.studyprojects.calcdespesas.model.Compra;
import net.studyprojects.calcdespesas.model.builder.CompraBuilder;

import org.joda.time.DateTime;

public class CompraBuilderTest {

	public static void main(String[] args) {

		CompraBuilder cbuilder = new CompraBuilder();

		DateTime dataDaCompra = new DateTime().withDate(2013, 01, 29);
		// Calendar dataDaCompra2 = dataCompra.toGregorianCalendar();

		// Calendar dataDaCompra2 = Calendar.getInstance();
		// dataDaCompra2.set(2013, 03, 30);

		Compra compra = cbuilder.comTitulo("FNAC Barra")
				.comDescricao("Apple wired keyboard")
				.comValor(new BigDecimal("179.90"))
				.comDataDaCompra(dataDaCompra.toGregorianCalendar())
				.comNumeroDeParcelas(3).geraCompra();

		// Persistindo o objeto:
		EntityManager em = JPAUtil.getEntityManager();

		em.getTransaction().begin();

		em.persist(compra);

		em.getTransaction().commit();

		em.close();

	}
}
