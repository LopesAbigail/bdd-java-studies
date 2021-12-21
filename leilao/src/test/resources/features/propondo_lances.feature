# language: pt

Funcionalidade: Propondo lances ao leilao

Cenario: Propondo um unico lance valido
 Dado um lance valido
 Quando propoe ao leilao
 Entao o lance e aceito
 
Cenario: Propondo varios lances validos
 Dado um lance de 10.0 reais do usuario "roberio"
 E um lance de 15.0 reais do usuario "rodolfo"
 E um lance de 20.0 reais do usuario "raimundo"
 Quando propostos ao leilao
 Entao os lances sao aceitos
 
Esquema do Cenario: Propondo um lance invalido
 Dado um lance invalido de <valor> reais do usuario '<nomeUsuario>'
 Quando propoe ao leilao
 Entao o lance nao e aceito
 
 Exemplos:
 	| valor | nomeUsuario |
 	| 0     | roberio     |
 	| -1    | rodolfo     |
 	| -100  | raimundo    |