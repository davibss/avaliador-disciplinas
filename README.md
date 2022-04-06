<h1 align="center">
    🪑 <a href="https://rasgando-cadeiras.vercel.app" alt="site do projeto">Rasgando Cadeiras</a>
</h1>

## **Conteúdos**

* [Sobre o projeto](#bulb-projeto)
* [Integrantes](#busts_in_silhouette-integrantes)
* [Objetivo](#dart-objetivo)
* [Demonstração](#mag_right-demonstração-do-projeto)
* [Funcionalidades](#spiral_notepad-funcionalidades)
* [Layout](#paintbrush-layout)
* [Executando projeto](#arrow_forward-executando-o-projeto)
* [Tecnologias](#hammer_and_wrench-tecnologias)
* [Contribuidores](#handshake-contribuidores)

---

## **:bulb: Projeto**
Este projeto foi desenvolvido para a disciplina Engenharia de Software da Universidade Federal de Campina Grande (UFCG), ministrada por Rohit Gheyi.

---

### **:busts_in_silhouette: Integrantes**
* Adeildo Lucas Guerra Pereira
* Bruno Andrade Fernandes
* Dante De Araujo Costa
* Davi Barbosa Silva Sousa
* Holliver De Oliveira Costa
* João Paulo Alves Dantas
* Lucas Alves Vigolvino
* Lucas Brasileiro Raposo
* Lucas Da Rocha Mina
* Melquisedeque Carvalho Souza
* Pedro Antônio Barboza Ribeiro
* Pedro Donato Coelho Neto
* Rodrigo Torres Meira
* Savio Gusmão Lafrande De Medeiros 

---

### **:dart: Objetivo**
Atualmente na UFCG, alunos de diversos cursos, a cada período de matrículas, enfrentam vários desafios e dificuldades para escolherem quais matérias serão  escolhidas. A partir daí, surge nossa motivação para construção e desenvolvimento desse projeto que no primeiro momento, no escopo da disciplina, é voltado apenas para alunos do curso de computação. Nesse cenário, o intuito do nosso projeto é auxiliar através de informações, que serão disponibilizadas no sistema desenvolvido pelo grupo, fornecidas por alunos de períodos passados.

---

## **:mag_right: Demonstração do projeto**
O website do projeto está disponível no seguinte link:  

[Rasgando Cadeiras](https://rasgando-cadeiras.vercel.app/)

---

## **:spiral_notepad: Funcionalidades**

- Usuário não logado
  - Login de usuário
  - Simular período
  - Ver lista de disciplinas
  - Ver lista de professores
  - Acessar página de uma disciplina
  - Acessar página de um professor
  - Ver métricas gerais de uma disciplina
  - Ver métricas de um período  específico de uma disciplina
- Usuário logado
  - Avaliar uma disciplina
  - Realizar comentário em uma disciplina
  - Reagir a comentários feitos em uma disciplina
  - Denunciar comentário
- Admin
  - Cadastrar professor
  - Cadastrar disciplina
  - Excluir comentários
  - Banir usuários

---

## **:paintbrush: Layout**

O layout da aplicação está disponível no seguinte link:

[Figma](https://www.figma.com/file/RTOZAntafoDgH6UU7C9g09/Avaliador-de-Disciplinas?node-id=75%3A560)

---

## **:arrow_forward: Executando o projeto**
Para executar todos os artefatos do projeto é necessário possuir:
- [Maven](https://maven.apache.org/download.cgi)
- [Git](https://git-scm.com/downloads)
- [Node.js](https://nodejs.org/en/download/)
- [PostgreSQL](https://www.postgresql.org/download/)

### **:arrow_forward: Executando back-end**
```bash
$ git clone https://github.com/davibss/avaliador-disciplinas
$ cd avaliador-disciplinas/AvaliadorDisciplinas.API
$ mvn install
$ mvn spring-boot:run
```

### **:arrow_forward: Executando front-end**
Para utilizar a autenticação do Google implementada no projeto é necessário adicionar uma chave [OAuth](https://developers.google.com/identity/protocols/oauth2) do Google no arquivo `.env` localizado na raiz da pasta `AvaliadorDisciplinas.FRONTEND`.
```bash
$ git clone https://github.com/davibss/avaliador-disciplinas
$ cd avaliador-disciplinas/AvaliadorDisciplinas.FRONTEND
$ npm install
$ npm start
```

---

## **:hammer_and_wrench: Tecnologias**

As seguintes tecnologias foram usadas na construção do projeto:

### **Back-end (Java + Spring-boot)**
- [Maven](https://maven.apache.org/)
- [Spring-boot](https://spring.io/projects/spring-boot)
- [PostgreSQL](https://www.postgresql.org/)
- [JUnit](https://junit.org/junit5/)
- [H2](https://www.h2database.com/html/main.html)

### **Front-end (ReactJS)**
- [npm](https://www.npmjs.com/)
- [ReactJS](https://pt-br.reactjs.org/)
- [Axios](https://axios-http.com/)
- [react-router-dom](https://v5.reactrouter.com/web/guides/quick-start)
- [react-google-login](https://www.npmjs.com/package/react-google-login)
- [React-toastify](https://fkhadra.github.io/react-toastify/introduction/)
- [rc-slider](https://www.npmjs.com/package/rc-slider)
- [rc-dropdown](https://dropdown.react-component.now.sh/)
- [rc-menu](https://menu.react-component.now.sh/)
- [react-loader-spinner](https://mhnpd.github.io/react-loader-spinner/)
- [react-select](https://react-select.com/home)

### **Utilitários**
- Protótipo: [Figma](https://www.figma.com/)
- Ícones: [Svgrepo](https://www.svgrepo.com/)
- Vetores: [Freepik](https://br.freepik.com/)
- Fontes:  [Roboto](https://fonts.google.com/specimen/Roboto)
- IDEs: 
  - [VSCode](https://code.visualstudio.com/)
  - [Eclipse](https://www.eclipse.org/downloads/)
  - [IntelliJ](https://www.jetbrains.com/pt-br/idea/)
- Teste de API: 
  - [Insomnia](https://insomnia.rest/download)
  - [Postman](https://www.postman.com/)
- Deploy: [Vercel](https://vercel.com/)

---

## :handshake: Contribuidores
<table>
  <tr>
    <td align="center"><a href="https://github.com/LucasGuerra26/"><img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/48632885?v=4" width="100px;" alt=""/><br /><sub><b>Adeildo Pereira</b></sub></a><br /><span>(Back-end)</span></td>
    <td align="center"><a href="https://github.com/danteacosta/"><img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/66438227?v=4" width="100px;" alt=""/><br /><sub><b>Dante Costa</b></sub></a><br /><span>(Back-end)</span></td>
    <td align="center"><a href="https://github.com/HolliverCosta/"><img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/51215212?v=4" width="100px;" alt=""/><br /><sub><b>Holliver Costa</b></sub></a><br /><span>(Back-end)</span></td>
    <td align="center"><a href="https://github.com/LucasBrasileiroRaposo/"><img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/55746603?v=4" width="100px;" alt=""/><br /><sub><b>Lucas Brasileiro</b></sub></a><br /><span>(Back-end)</span></td>
    <td align="center"><a href="https://github.com/Juhrer/"><img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/54405118?v=4" width="100px;" alt=""/><br /><sub><b>Lucas Vilgovino</b></sub></a><br /><span>(Back-end)</span></td>
    <td align="center"><a href="https://github.com/Rodrigo-Torres-Meira/"><img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/54250574?v=4" width="100px;" alt=""/><br /><sub><b>Rodrigo Torres</b></sub></a><br /><span>(Back-end)</span></td>
  </tr>
  <tr>
    <td align="center"><a href="https://github.com/Bruno-af/"><img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/52292817?v=4" width="100px;" alt=""/><br /><sub><b>Bruno Fernandes</b></sub></a><br /><span>(Front-end)</span></td>
    <td align="center"><a href="https://github.com/davibss/"><img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/54844612?v=4" width="100px;" alt=""/><br /><sub><b>Davi Barbosa</b></sub></a><br /><span>(Front-end)</span></td>
    <td align="center"><a href="https://github.com/joao-dantas31/"><img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/74259890?v=4" width="100px;" alt=""/><br /><sub><b>João Dantas</b></sub></a><br /><span>(Front-end)</span></td>
    <td align="center"><a href="https://github.com/MelquiSilva/"><img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/48794046?v=4" width="100px;" alt=""/><br /><sub><b>Melquisedeque Carvalho</b></sub></a><br /><span>(Front-end)</span></td>
  </tr>
  <tr>
    <td align="center"><a href="https://github.com/lucasminah/"><img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/51217249?v=4" width="100px;" alt=""/><br /><sub><b>Lucas Miná</b></sub></a><br /><span>(Projeto real)</span></td>
    <td align="center"><a href="https://github.com/PedABR/"><img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/48610012?v=4" width="100px;" alt=""/><br /><sub><b>Pedro Antônio</b></sub></a><br /><span>(Projeto real)</span></td>
    <td align="center"><a href="https://github.com/PedroDCN/"><img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/45217189?v=4" width="100px;" alt=""/><br /><sub><b>Pedro Donato</b></sub></a><br /><span>(Projeto real)</span></td>
    <td align="center"><a href="https://github.com/medeirosavio/"><img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/55745853?v=4" width="100px;" alt=""/><br /><sub><b>Sávio Medeiros</b></sub></a><br /><span>(Projeto real)</span></td>
  </tr>
</table>

