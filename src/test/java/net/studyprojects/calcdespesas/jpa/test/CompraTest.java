package net.studyprojects.calcdespesas.jpa.test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import net.studyprojects.calcdespesas.model.Compra;
import net.studyprojects.calcdespesas.model.Parcela;

public class CompraTest {

	public static void main(String[] args) {

		Compra compra = new Compra();

		compra.setTitulo("Decathlon Barra");
		compra.setDescricao("Tenis Mizuno");

		Date dataDaCompra;
		try {
			dataDaCompra = new SimpleDateFormat("dd/MM/yyyy")
					.parse("03/01/2013");
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}

		Calendar data = Calendar.getInstance();
		data.setTime(dataDaCompra);

		compra.setData(data);

		BigDecimal valor = new BigDecimal("427.75");

		compra.setValor(valor);

		// cria uma lista de parcelas e associa com a compra

		List<Parcela> parcelas = new ArrayList<>();

		Parcela parc1 = new Parcela();
		Calendar dataParc1 = Calendar.getInstance();
		dataParc1.add(Calendar.MONTH, +1);
		parc1.setData(dataParc1);
		parc1.setValor(valor.divide(new BigDecimal(3), RoundingMode.CEILING));

		parcelas.add(parc1);

		Parcela parc2 = new Parcela();
		Calendar dataParc2 = Calendar.getInstance();
		dataParc2.add(Calendar.MONTH, +2);
		parc2.setData(dataParc2);
		parc2.setValor(valor.divide(new BigDecimal(3), RoundingMode.CEILING));

		parcelas.add(parc2);

		Parcela parc3 = new Parcela();
		Calendar dataParc3 = Calendar.getInstance();
		dataParc3.add(Calendar.MONTH, +3);
		parc3.setData(dataParc3);
		parc3.setValor(valor.divide(new BigDecimal(3), RoundingMode.CEILING));

		parcelas.add(parc3);

		// 1a. Tentativa
		// Isto somente não funcionou
		// compra.setParcelas(parcelas);

		// 2a. Tentativa
		// settar a compra em cada parcela
		parc1.setCompra(compra);

		parc2.setCompra(compra);

		parc3.setCompra(compra);

		EntityManager em = JPAUtil.getEntityManager();

		em.getTransaction().begin();

		em.persist(compra);

		em.persist(parc1);

		em.persist(parc2);

		em.persist(parc3);

		em.getTransaction().commit();

		em.close();

		EntityManager emr = JPAUtil.getEntityManager();

		Compra encontrada = emr.find(Compra.class, 3L);

		System.out.println(encontrada.getParcelas().size());

		emr.close();

	}
}
