# Já chegou

Projeto básico para prática do gitflow

## Como contribuir?

### 1) Escolha um card no Kanban
- KANBAN: https://github.com/GabrieRabelo/ja-chegou/projects/1
- Exemplo: ```4. Implementar lista de moradores```

### 2) Crie uma branch nova com a seguinte nomenclatura

```fature-nrocard/nome```
- Exemplo: ```feature-01/envia-email```

#### Tipos de branchs:
Feature: Utilizada para adicionar uma nova funcionalidade.\
Bugfix: Utilizada para corrigir uma funcionalidade defeituosa.

```
git checkout development
git pull
git checkout -b feature-01/envia-email
```

### 3) Faça os commits necessários seguindo nomenclatura:```numero_do_card/@nome_contribuinte @nome_contribuinte: o que o commit faz```&nbsp;
- Exemplo: ```01/ @Maria @Joao: Adiciona o CSS para o botão de envio de email```
- Exemplo: ```01/ @Maria @Joao: Adciona o layout do botão de envio de email```
```
git commit -m "01/ @Maria @Joao: Adiciona o CSS para o botão de envio de email"
```

### 5) Realize o push do branch
- ```git push --set-upstream origin <NOME DA BRANCH>```

### 6) Abra um Pull Request no GitHub com o Branch
- PR: https://github.com/GabrieRabelo/ja-chegou/pulls
- Informe o pull request no zap do grupo para pedir revisões

### 7) Após revisado e testado pode mergear com a master
- O branch precisa estar revisado e aprovado
- O branch não pode ter conflitos

## Tecnologias

  - [Java 8](https://www.oracle.com/br/java/technologies/javase/javase-jdk8-downloads.html)
