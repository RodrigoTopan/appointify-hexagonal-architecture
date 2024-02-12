#  appointify-hexagonal-architecture

# Appointfy: Plataforma de oferta de serviços, agendamentos e engajamento com clientes

```
NESSE REPOSITÓRIO SE ENCONTRA A API DO PROJETO APPOINTIFY SEGUINDO A PROPOSTA DA ARQUITETURA HEXAGONAL.

```

## 1. Introdução: Contexto da Solução 

Atualmente, muitos pequenos comércios, como salões de beleza e barbeiros, possuem aplicativos ou websites para agendamentos de serviços, facilitando a vida dos clientes. Esses aplicativos geralmente são simples e possuem telas para cadastro de clientes e gestão administrativa. Eles também oferecem promoções para fidelização, como serviços gratuitos após uma certa quantidade de agendamentos. No entanto, esses aplicativos podem ter custos elevados, como a contratação de desenvolvedores e manutenção de sistemas, impedindo que pequenos comércios e empreendedores individuais os utilizem. Além disso, esses aplicativos geralmente não atraem novos clientes e se restringem a fidelizar a base de clientes existente. 

Pensando nisso, propomos o desenvolvimento de uma plataforma web, similar aos grandes aplicativos de hotelaria como Airbnb e Booking, para democratizar o acesso a esses importantes aplicativos de agendamento de serviços. A plataforma permitiria o cadastro de diversos estabelecimentos e prestadores de serviços, fidelizando a base de clientes já existente e conectando esses estabelecimentos a novos clientes. Ela funcionaria como um marketplace de divulgação e agendamento de serviços.  

Os clientes teriam a facilidade de encontrar estabelecimentos bem avaliados, comparar preços e usufruir de programas de fidelidade e descontos. Já os estabelecimentos poderiam contar com a divulgação e visibilidade da plataforma para alavancar suas vendas, teriam maior facilidade na gestão de suas atividades e pagariam apenas por agendamentos realizados.  

Com isso, criamos um relacionamento ganha-ganha, onde quanto mais a plataforma alavanca as vendas dos nossos clientes, mais rentável e sustentável ela se torna. 

---
## 2. Objetivo do Projeto
Baseado no projeto original do meu relatório técnico do curso de pós graduação em arquitetura de soluções, resolvi elevar o nível do projeto e aplicar a proposta da arquitetura hexagonal nele e conceitos de DDD(Domain Driven Design) para garantir a utilização de uma arquitetura evolutiva

Código do projeto original disponível em:
```
 https://github.com/RodrigoTopan/appointify-api
```


<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary><h2 style="display: inline-block">Sumário</h2></summary>
  <ol>
    <li><a href="#tech">Tecnologias Utilizadas</a></li>
    <li><a href="#design-pattern"> Padrões e boas práticas adotadas</a></li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#docker-installation">Instalação com Docker</a></li>
        <li><a href="#prerequisites">Pre-requisitos</a></li>
        <li><a href="#contact">Contato</a></li>
      </ul>
    </li>
  </ol>
</details>



<div id="tech"></div>

## ⚙️ Tecnologias Utilizadas

* Java 17
* [Spring](https://spring.io/)
* [PostgreSQL](https://www.postgresql.org/)


<div id="design-pattern"></div>

## Padrões e boas práticas adotadas

Esse projeto foi desenvolvido seguindo a Arquitetura Hexagonal: Uma Abordagem Modular e Flexível para Desenvolvimento de Software

A Arquitetura Hexagonal, também conhecida como Arquitetura de Portas e Adaptadores, é uma estrutura robusta para o desenvolvimento de software que promove a clareza de design, facilita a manutenção e permite a adaptação a mudanças sem comprometer a estabilidade do sistema.

<b>Por que a Arquitetura Hexagonal é Importante?</b>

Separação Clara de Preocupações: A divisão em camadas distintas, cada uma com sua responsabilidade definida, torna mais fácil entender e modificar o sistema sem afetar outras partes.

Independência Tecnológica: A camada de domínio é isolada de detalhes de implementação externos, o que permite trocar frameworks ou bibliotecas sem impactar a lógica de negócios.

Testabilidade Aprimorada: A separação das camadas facilita a escrita de testes unitários e de integração, tornando o processo de teste mais eficiente e confiável.

<b>Componentes Principais da Arquitetura Hexagonal</b>

Camada de Domínio (Nesse projeto chamei o módulo de core): Aqui reside o coração da aplicação, onde são definidos os modelos de dados, regras de negócios e serviços essenciais. Esta camada é agnóstica em relação a detalhes de implementação externos.

Camada de Aplicação (Nesse projeto chamei o módulo de Application): Atua como um intermediário entre a camada de domínio e as interfaces externas, coordenando as interações e implementando os casos de uso específicos da aplicação.

Camada de Adaptadores(Nesse projeto chamei o módulo de infrastructure): Esta camada encapsula as interfaces com o mundo exterior à aplicação, como interfaces de usuário e APIs. Ela permite que a aplicação se comunique com outros sistemas de forma eficiente e flexível.

<b>Benefícios da Arquitetura Hexagonal</b>

Modularidade: A separação de preocupações facilita a adição, remoção ou modificação de funcionalidades sem afetar outras partes do sistema.

Flexibilidade: A independência tecnológica permite adaptar-se a mudanças nos requisitos ou nas tecnologias sem grandes esforços de reestruturação.

Manutenibilidade: A clareza de design e a organização modular tornam mais fácil entender e manter o código ao longo do tempo.


<div id="getting-started"></div>

## Getting Started

Para instalar na sua máquina e rodar a aplicação siga os passos abaixo


<div id="docker-installation"></div>

### 🐋 Instalação e uso com Docker

1. (No terminal) Clone o repositório
   ```sh
   git clone https://github.com/RodrigoTopan/appointify-hexagonal-architecture
   ```

2. (No terminal) Vá até a pasta do projeto e execute. Esse comando irá subir a aplicação e o banco de dados PostgreSQL
   ```sh
   docker-compose up
   ```

3. Aguarde um pouco e pronto! O projeto está rodando por padrão em http://localhost:8080/ e disponibiliza a documentação SWAGGER em: http://localhost:8080/swagger-ui.html

4. (No terminal) Caso queira subir apenas o banco de dados e rodar a aplicação manualmente
   ```sh
   docker-compose -f ./docker-compose-only-db.yml up
   ```

6. Disponibilizei na pasta "raiz" do projeto, o arquivo dump do Insomnia para você poder importá-lo na sua máquina

<div id="prerequisites"></div>

### 🛠️ Pré-requisitos (Instalação Manual)

* Instalar o Java 17 (Se você usa linux: sudo apt-get install openjdk-11-jdk)

* Possuir um servidor postgresql rodando localmente, por padrão o projeto irá se conectar em jdbc:postgresql://localhost:5432/appointify (pode ser alterado no arquivo, application.yml)

* Caso queira rodar a aplicação, o entrypoint principal é a classe AppointifyApplication.java dentro do módulo infrastructure
```
mvn -pl infrastructure spring-boot:run -Dspring-boot.run.main-class=com.example.infrastructure.AppointifyApplication
```

<div id="contact"></div>

## 🧑‍💼 Contato

Rodrigo Garcia Topan Moreira - [@linkedin](https://www.linkedin.com/in/rodrigotopan)

Email: rodrigo.topan.ti@gmail.com
