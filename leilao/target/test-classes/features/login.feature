# language: pt

Funcionalidade: Apenas usuarios cadastrados podem se logar

	Cenario: Um usuario valido consegue se logar
		Dado o usuario valido
		Quando realiza login
		Entao é redirecionado para a pagina de leiloes
  
 	Cenario: um usuario invalido nao consegue se logar
 		Dado um usuario invalido
 		Quando tenta se logar
 		Entao continua na pagina de login