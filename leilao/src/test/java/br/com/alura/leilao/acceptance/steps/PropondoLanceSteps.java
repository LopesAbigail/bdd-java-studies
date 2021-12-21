package br.com.alura.leilao.acceptance.steps;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class PropondoLanceSteps {
	
	private Lance lance;
	private Leilao leilao;
	private List<Lance> lista;
	
	@Before
	public void setup() {
		this.lista = new ArrayList<Lance>();
		leilao = new Leilao("Tablete XPTO");
	}
	
	@After
	public void tearDown() {
		//System.out.println("After");
	}

	@Dado("um lance valido")
	public void dado_um_lance_valido() {
	    Usuario usuario = new Usuario("roberio");
		this.lance = new Lance(usuario , BigDecimal.TEN);
	}
	
	@Quando("propoe ao leilao")
	public void quando_propoe_o_lance() {
	    leilao.propoe(lance);
	}
	
	@Entao("o lance e aceito")
	public void entao_o_lance_e_aceito() {
	    Assert.assertFalse(leilao.getLances().isEmpty());
	    Assert.assertEquals(1, leilao.getLances().size());
	    Assert.assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
	}
	
	@Dado("um lance de {double} reais do usuario {string}")
	public void um_lance_de_reais_valido_do_usuario(Double valor, String nomeUsuario) {
		Lance lanceValido = new Lance(new Usuario(nomeUsuario), new BigDecimal(valor));
		lista.add(lanceValido);
	}

	@Quando("propostos ao leilao")
	public void propostos_ao_leilao() {
	    this.lista.forEach((lance) -> {
	    	leilao.propoe(lance);
	    });
	}
	
	@Entao("os lances sao aceitos")
	public void os_lances_sao_aceitos() {
		Assert.assertFalse(leilao.getLances().isEmpty());
	    Assert.assertEquals(this.lista.size(), leilao.getLances().size());
	    Assert.assertEquals(this.lista.get(0).getValor(), leilao.getLances().get(0).getValor());
	    Assert.assertEquals(this.lista.get(1).getValor(), leilao.getLances().get(1).getValor());
	    Assert.assertEquals(this.lista.get(2).getValor(), leilao.getLances().get(2).getValor());
	}
	
	@Dado("um lance invalido de {double} reais do usuario {string}")
	public void um_lance_invalido_de_reais(Double valor, String nomeUsuario) {
	   this.lance = new Lance(new BigDecimal(valor));
	}
	
	@Entao("o lance nao e aceito")
	public void entao_o_lance_nao_e_aceito() {
	    Assert.assertTrue(leilao.getLances().isEmpty());
	}
	
	@Dado("um conjunto de dois lances")
	public void um_conjunto_de_dois_lances(io.cucumber.datatable.DataTable dataTable) {
	    List<Map<String, String>> valores = dataTable.asMaps();
	    
	    valores.forEach((valor) -> {
	    	Lance lance = new Lance(new Usuario(valor.get("nome")), new BigDecimal(valor.get("valor")));
	    	lista.add(lance);
	    });
	}
	
	@Entao("o segundo lance nao eh aceito")
	public void o_segundo_lance_nao_eh_aceito() {
		Assert.assertFalse(leilao.getLances().isEmpty());
	    Assert.assertEquals(1, leilao.getLances().size());
	    Assert.assertEquals(this.lista.get(0).getValor(), leilao.getLances().get(0).getValor());
	}
}
