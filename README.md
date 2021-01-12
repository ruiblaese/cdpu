<h1 align="center">
    API Java Spring Boot - Publicação de ofertas e suas respectivas opções de compra
</h1>
<p align="center">  
  <img alt="Made by Rui" src="https://img.shields.io/badge/Made%20by-ruiblaese-%2304D361">
  
  <img alt="Made with Java" src="https://img.shields.io/badge/Made%20with-Java-%1f425f">  
  
  <img alt="Made with SpringBoot" src="https://img.shields.io/badge/Made%20with-SpringBoot-%1f425f">  

  <img alt="Project top programing language" src="https://img.shields.io/github/languages/top/ruiblaese/springboot-react-webapp-ofertas">  

  <img alt="Repository size" src="https://img.shields.io/github/repo-size/ruiblaese/springboot-react-webapp-ofertas">
  
  <img alt="travis-ci" src="https://travis-ci.org/ruiblaese/springboot-api-ofertas.svg?branch=master">
</p>

## Índice

- [Índice](#índice)
- [Contexto](#contexto)
- [Projeto](#projeto)  
  - [Tecnologias](#tecnologias-utilizadas)
  - [Instruções](#instruções)
  - [Deploy](#deploy)
  - [Melhorias](#melhorias)
- [Referencias](#referencias)
- [Autor](#autor)

## Contexto

Precisamos de uma plataforma web de vantagens simplificada do qual conta com a publicação de ofertas e suas respectivas opções de compra, representado pelo seguinte diagrama de classes:

![alt text](https://github.com/PeixeUrbano/challenge-developer/raw/master/UML-Model-2.png) 

| Deal (oferta)  | BuyOption (Opção de compra)  |
|---|---|
| Título da oferta | Título  |
| Texto de destaque | Preço de venda normal  |
| Data de criação | Preço de venda com desconto  |
| Data de publicação | Percentual de desconto |
| Validade da oferta (em dias) | Quantidade total de cupons disponíveis |
| URL da oferta | Data de entrada |
| Total geral de cupons vendidos | Data de saída | 
| Tipo (local, produto, viagem) |  |


Uma oferta possui várias opções de compra, sendo que devemos primeiramente realizar a persistência de uma oferta e após vincular as possíveis opções de compra.


**Oferta:**<br>
Frigideira de Alumínio com Revestimento Cerâmico de 20cm, 24cm ou 28cm.
 
**Opção de compra:**<br>
1. Tamanho 20cm - R$ 89,90
2. Tamanho 24cm - R$ 149,90 por R$ 99,90
3. Tamanho 28cm - R$ 169,90 por R$ 109,90
4. Kit 3 Frigideiras - R$ 249,90 

Realize a modelagem de dados e a implementação do caso de uso proposto, do qual pode ser gradualmente desenvolvido:

1. Arquitetura da aplicação web e todos os mecanismos envolvidos para suportar o desenvolvimento.
2. Modelagem e persistência de dados.
3. Interface gráfica para inserir uma oferta.
4. Interface gráfica para inserir uma opção de compra.
5. Interface gráfica para associar as opções de compra na oferta selecionada.
6. Exibição de uma oferta e suas opções de compra (veja figura 1).
7. Processar a "venda" de uma determinada opção de compra e realizar a atualização dos itens vendidos e seus totais.

**Maiores detalhes de regras de negócios**

#### Oferta

1. Para ser uma oferta válida, ou seja, que esteja publicada no website ela respeita a data de publicação (_publishDate_) que é quando a oferta entra efetivamente no ar e futuramente não é mais exibida quando atinge a data de saída (_endDate_).
2. É realizado um controle global de quantos itens já foram vendidos de determinada oferta pelo campo _"totalSold"_. Esse campo é a soma total da quantidade vendida de todas as opções de compra da oferta.
3. Para cada oferta cadastrada geramos um link (_url_) baseado em seu nome, que representa o slug para acessar a mesma dentro do website, esse slug é único.

#### Opções de compra

1. Assim como a oferta, toda opção de compra tem uma data de publicação (_startDate_) e data de retirada do ar (_endDate_).
2. Quando realizamos o cadastro de uma opção de compra, informamos o valor de mercado praticado (_normalPrice_), o percentual de desconto (caso se aplique, _percentageDiscount_) e consequentemente já armazenando o valor de venda (_salePrice_) para o usuário.
3. Inicialmente cada opção de compra tem uma determinada "quantidade de estoque" (_quantityCupom_), exemplo: OP-1 tem 100 cupons disponíveis, OP-2 tem 30 cupons disponíveis; ao realizar "a venda" através de uma opção de compra, realizamos o decremento da quantidade de cupons da opção selecionada e incrementamos a quantidade global vendida na oferta.
4. Uma opção de compra pode se esgotar e estar indisponível para a compra, mas a oferta pode permanecer no ar com outras opção de compra válidas e com "estoque disponível". Caso todas as opções de compra se esgotem, a oferta é totalmente esgotada e desabilitada para a compra.
5. Quando uma opção de compra se esgota, seu botão de compra é desabilitado.

Mais uma vez, qualquer dúvida maior pode nos perguntar, boa sorte!


## Projeto
### Tecnologias utilizadas: 
- [Spring Tool Suite]()
- [Visual Studio Code](https://code.visualstudio.com/)
- [Postman](https://www.getpostman.com/downloads/)
- [Java](https://pt.wikipedia.org/wiki/Java_(linguagem_de_programa%C3%A7%C3%A3o))
  - [Spring Boot](https://spring.io/projects/spring-boot)
  - [Lombok](https://projectlombok.org/)
  - [Flyway](https://flywaydb.org/)
- [PostgreSQL](https://www.postgresql.org/)

- [ReacJS]()
- [Bootstrap]()
- [Docker](https://www.docker.com/)
  - [Docker Compose](https://docs.docker.com/compose/)
- [AWS LightSail](https://aws.amazon.com/pt/lightsail/)
- [nginx](https://docs.nginx.com/nginx/admin-guide/web-server/reverse-proxy/)
  - [nginx reverse](https://docs.nginx.com/nginx/admin-guide/web-server/reverse-proxy/)

### Instruções
- [Instalar Git](https://www.digitalocean.com/community/tutorials/como-instalar-o-git-no-ubuntu-18-04-pt)
- [Instalar Docker](https://docs.docker.com/install/linux/docker-ce/ubuntu/)
- [Instalar Docker-Compose](https://docs.docker.com/compose/install/)
- [Instalar Java 8 \ OpenJDK 8 \ Amazon Correto 8](https://docs.aws.amazon.com/pt_br/corretto/latest/corretto-8-ug/generic-linux-install.html)
- Instalar NodeJs
- Instalar Yarn
- git clone
- criar seu .env para frontend `cd frontend & cp .env.example .env` alterar variavel
- executar Makefile para fazer build e subir docker-compose
`make run-docker-compose`

#### Dicas
*Para cadastrar um Opção de Oferta(buyOption) deve se cadastrar uma Oferta(Deal), em sequencia editar: na edição vai ser liberado formulario para cadastro de Opção(buyOption).*

### Deploy
#### AWS
- Removido do AWS

#### Heroku SpringBoot API
- https://api-ofertas.herokuapp.com/

#### Frontend ReactJs
- https://frontend-api-ofertas.netlify.com

### Melhorias
- Back-end    
  - Implementar mais testes
  - Implementar mais validações
  - JWT
  - Terminar cadastro de Usuário
  - Implementar paginação

- Front-end
  - Edição da Opção de Oferta(buyDeal)
  - Exclusão da Opção de Oferta(buyDeal)
  - Melhorar navegação da pagina(botões para voltar, organizar tudo e deixar bonito)
  - Terminar cadastro de Usuário
  - JWT (parcialmente implementado)
  - Implementar Testes
  - Implementar alteração e exclusão de Opção de Oferta
  - Implementar paginação
 
- Problemas para resolver
  - Problema com data, está cadastrando "data" -1 dia. (acontece só quando roda no docker-compose) 
  - Exclusão da Oferta(deal) quando já tem Opção(buyDeal)
  - Quando diminui a resolução o "menu" some e não aparece no botão do boostrap

## Referencias
 - https://stackoverflow.com/questions/32074631/spring-boot-application-without-a-datasource
 - https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference
 - https://stackoverflow.com/questions/604424/how-to-get-an-enum-value-from-a-string-value-in-java/604426
 - https://www.devdiaries.net/blog/Spring-Boot-2-PostgreSQL-JWT-React-Part-3/#websecurityconfigureradapter-configuration

## Autor
[Rui Richard Blaese](https://www.linkedin.com/in/ruiblaese/)   
ruiblaese@gmail.com


[(voltar)](#índice)
