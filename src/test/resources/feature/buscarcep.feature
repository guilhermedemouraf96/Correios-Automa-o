#Author: guilhermedemouraf96@gmail.com

@buscarCep
Feature: Buscar CEP
Como usuario
Quero pesquisar um CEP
Para visualizar endereço correspondente ao CEP pesquisado

 @positivo
  Scenario: Buscar um Cep válido
    When pesquisar um Cep válido
    Then validar se o endereço corresponde ao Cep
    
 @positivo
 Scenario: Buscar endereco valido
  When pesquisar um endereco valido
  Then validar se o Cep corresponde ao endereco

 @negativo 
  Scenario: Buscar um CEP em branco
    But pesquisar um CEP em branco
    When visualizo mensagem de erro
   
