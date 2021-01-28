# CURRENCY CONVERTER



![GitHub Workflow Status](https://img.shields.io/github/workflow/status/thukabjj/CURRENCY-CONVERTER/CI-CD-PRODUCTION)[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=thukabjj_CURRENCY-CONVERTER&metric=coverage)](https://sonarcloud.io/dashboard?id=thukabjj_CURRENCY-CONVERTER)[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=thukabjj_CURRENCY-CONVERTER&metric=vulnerabilities)](https://sonarcloud.io/dashboard?id=thukabjj_CURRENCY-CONVERTER)[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=thukabjj_CURRENCY-CONVERTER&metric=bugs)](https://sonarcloud.io/dashboard?id=thukabjj_CURRENCY-CONVERTER)

# Introdução
Currency Converter é um projeto no qual tem como objetivo converter um valor de uma moeda a partir da identificação de sua de origem e destino. As opções de converção são:

- BRL (REAL)
- USD (DÓLAR AMERICANO)
- EUR (EURO)
- JPY (IENE JAPONÊS)

# Arquitetura
Para atender o objetivo do projeto optei por me basear na arquitetura de microserviços, no qual a principal motivação para implementar é prover escalabilidade, manutebilidade e agilidade em seu ciclo build/deploy. Para esse microserviço presando a integridade de consistência de dados foi implementado o Padrão de Projeto SAGA Orchestration, no qual a premissa é ter um gerenciador de etapas que executa solicitações saga, armazena e interpreta os estados de cada tarefa e manipula a recuperação de falha com transações de compensação.

# Design de Aplicação
O Design do código foi construindo com base na Clean Arch seguindo algumas tecnicas de DDD como Bundle-Context e a utilização de alguns principios do SOLID.

# Técnologias
* [Spring Boot Framework](https://spring.io)
* [JaCoCo Coverage Report](https://github.com/jacoco/jacoco)
* [Sonar Cloud](https://sonarcloud.io/)
* [Swagger UI](https://swagger.io)
* [Docker](https://www.docker.com)
* [Github Actions](https://docs.github.com/pt/actions)
* [Heroku: Cloud Application Platform](https://www.heroku.com)

# Como Usar
Para testar as funcionalidade de converção e listagem das converções pelo usuario pode ser efetuada em ambiente produtivo através do Swagger UI acessando a URL abaixo:

#### Em produção

* https://currency-converter-project.herokuapp.com/swagger-ui.html

#### Local

```sh
$ docker-compose up --force-recreate --build --remove-orphans
```

# Monitoramento
Para monitoramento da aplicação foi utilizado o `Actuator` que é usado principalmente para expor informações operacionais sobre a aplicação em execução através endpoints `HTTP` ou beans `JMX`.  Segue abaixo com acessar essas informações:

#### Em produção

* https://currency-converter-project.herokuapp.com/actuator

#### Local

* http://localhost:8080/actuator

### Cobertura de Teste

Como mencionado anteriormente a aplicação segue utilizando o `JaCoCo Report` para validação de cobertura de testes e geração de relatorio e em conjunto com o JaCoCo foi utilizado o `SonarCloud`, que é um serviço em nuvem oferecido pela SonarSource e baseado no `SonarQube`. O SonarQube é uma plataforma open source amplamente adotada para inspecionar continuamente a qualidade do código-fonte e detectar bugs, vulnerabilidades e "code smells" em mais de 20 linguagens de programção.

#### JaCoCo Report
Para validar o JaCoCo Report basta rodar o comando a baixo
```sh
$ mvn verify
```
Após isso irá gerar um arquivo chamdo `index.html` dentro do diretorio `target\site` basta abrir o arquivo em qualquer browser de sua preferencia.

#### SonarCloud
Para acessar a informações basta acessar:
* https://sonarcloud.io/dashboard?id=thukabjj_CURRENCY-CONVERTER

### Pipeline de CI / CD
Para CI/CD escolhi o `Github Actions` nada mais é do que um orquestrador de workflow. Para esse projeto foi configurado dois workflows que serão descritos a seguir:


##### CI-CD-DEVELOPMENT
Neste workflow tem como resposabilidade executar dois `jobs` sendo eles:
* `Test - Units & Integrations`: responsável por rodar os testes unitarios e integração em conjunto com o JaCoCo para validação de cobertura de testes.
* `Test - Units & Test - SonarCloud Scan`: reponsável por inspecionar continuamente a qualidade do código-fonte e detectar bugs, vulnerabilidades e "code smells".
*
##### CI-CD-PRODUCTION
Neste workflow ele re-executa os passos do `CI-CD-DEVELOPMENT` e executa mais duas tarefas, sendo elas:
* `Publish - GitHub Packages`: responsável por compilar o artefato e fazer o upload do mesmo no `Github Packages`.
* `Deploying Artefact`: responsavel por pegar o artefato compilado e efetuar o deploy no `Heroku: Cloud Application Platform`.

Ambos workflows pode ser vizualizado na URL a seguir:
* https://github.com/thukabjj/CURRENCY-CONVERTER/actions