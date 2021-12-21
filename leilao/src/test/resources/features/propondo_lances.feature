# language: pt

Funcionalidade: Propondo lances ao leilao

Cenario: Propondo um unico lance valido
 Dado um lance valido
 Quando propoe ao leilao
 Entao o lance e aceito
 
Cenario: Propondo varios lances validos
 Dado um conjunto de lances validos
 Quando propostos ao leilao
 Entao os lances sao aceitos