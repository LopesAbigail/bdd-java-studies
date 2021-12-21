package br.com.alura.leilao.acceptance.steps;

import java.math.BigDecimal;

import org.junit.Assert;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class PropondoLanceSteps {
	
	private Lance lance10;
	private Lance lance15;
	private Lance lance20;
	private Leilao leilao;

	@Dado("um lance valido")
	public void dado_um_lance_valido() {
	    Usuario usuario = new Usuario("roberio");
		lance10 = new Lance(usuario , BigDecimal.TEN);
		leilao = new Leilao("Tablete XPTO");
	}
	
	@Quando("propoe ao leilao")
	public void quando_propoe_o_lance() {
	    leilao.propoe(lance10);
	}
	
	@Entao("o lance e aceito")
	public void entao_o_lance_e_aceito() {
	    Assert.assertFalse(leilao.getLances().isEmpty());
	    Assert.assertEquals(1, leilao.getLances().size());
	    Assert.assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
	}
	
	@Dado("um conjunto de lances validos")
	public void um_conjunto_de_lances_validos() {
		Usuario usuario = new Usuario("roberio");
		Usuario usuario2 = new Usuario("rodolfo");
		Usuario usuario3 = new Usuario("raimundo");
		lance10 = new Lance(usuario , BigDecimal.TEN);
		lance15 = new Lance(usuario2 , new BigDecimal("15.0"));
		lance20 = new Lance(usuario3 , new BigDecimal("20.0"));
		leilao = new Leilao("Tablete XPTO");
	}

	@Quando("propostos ao leilao")
	public void propostos_ao_leilao() {
	    leilao.propoe(lance10);
	    leilao.propoe(lance15);
	    leilao.propoe(lance20);
	}
	
	@Entao("os lances sao aceitos")
	public void os_lances_sao_aceitos() {
		Assert.assertFalse(leilao.getLances().isEmpty());
	    Assert.assertEquals(3, leilao.getLances().size());
	    Assert.assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
	    Assert.assertEquals(new BigDecimal("15.0"), leilao.getLances().get(1).getValor());
	    Assert.assertEquals(new BigDecimal("20.0"), leilao.getLances().get(2).getValor());
	}


}
