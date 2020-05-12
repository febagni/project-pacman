# Project PacMan

<center> 
<img src="https://static.fjcdn.com/gifs/Pacman_7a13e6_1160035.gif">
</center>

## Introdução:
Esse repositório contém o trabalho e desenvolvimento do grupo "Object-oriented teens" para a disciplina de MAC-0321 - Laboratório de Programação Orientada a Objetos, ministrada aos alunos de graduação do curso de <a href="https://pcs.usp.br/">Engenharia da Computação</a> da <a href="https://www.poli.usp.br">Escola Politécnica da USP.</a>

O grupo fará uma versão do PacMan trazida para o contexto atual. A ideia é ir criando novas features, a partir da branch develop e ir fazendo releases para a master, de acordo com algumas datas de entrega.

A documentação do projeto será feita por relatórios em markdown na branch develop. E o desenvolvimento será feito utilizando a técnica do *Dojo* em sessões de vídeochamada com todos os membros do grupo presentes.

Os integrantes do grupo Object-oriented teens:

Nome     |	NUSP	| Username 
---------- |-----------|-----------
Alexandre Marques Carrer |11260547|<a href="https://gitlab.com/alemarquis">@AleMarquis</a>
Felipe Bagni | 11257571| <a href="https://gitlab.com/febagni">@febagni</a>
Gabriel Yugo Kishida | 11257647 | <a href="https://gitlab.com/gabrielkishida">@GabrielKishida</a>
Gustavo Azevedo Corrêa | 11257693 | <a href="https://gitlab.com/guazco">@guazco</a>

## Proposta:

### Projeto 2 - O Pac Man do Século 21.

  
Você deverá implementar uma versão contemporânea do jogo de Pac Man, criando a visão descrita na seguinte matéria: https://cozinhabruta.blogfolha.uol.com.br/2020/04/18/jantar-solitario-e-sequela-permanente-da-covid-19/  
  
Não vou descrever muito sobre como deve ser o jogo de Pac Man, primeiro porque vocês já devem o conhecer e quem não conhece pode facilmente pesquisa na Web. Segundo, porque quero que vocês sejam criativos e façam o melhor jogo de pac man que já viram em suas vidas.  
Vou apenas descrever alguns requisitos obrigatórios; fiquem à vontade para colocar outras melhorias adicionais.  
  
**Requisitos:**  
  
1) O mapa do jogo definindo o leiaute do tabuleiro deve ser definido em um arquivo .txt que seja facilmente editável manualmente por um ser humano. O mapa deverá conter as paredes e todos os elementos iniciais do jogo, i.e., onde ficam os adversários, o jogador e todos os outros elementos que dão pontos ao serem obtidos.  
  
2) Utilizando o teclado, o jogador poderá se movimentar nas várias direções comendo pontinhos e pegando objetos no tabuleiro.  
  
3) Utilize o padrão Strategy para definir diferentes algoritmos para o movimento dos adversários (fantasminhas).  
  
4) Utilizando o padrão Fábrica Abstrata, implemente a possibilidade do jogo ter diferentes aparências (look-and-feel). Assim, facilmente, o jogador poderá escolher se o espaço do jogo terá uma aparência de supermercado em tempos de covid, velho oeste, espaço sideral ou os corredores do IME, por exemplo. Quando o usuário selecionar uma nova aparência, todos os elementos gráficos do jogo devem se redesenhar imediatamente.  
  
5) Utilize o padrão State para representar as diferentes fases do jogo. Cada fase deve ser um pouquinho mais difícil que a anterior.  
  
6) Utilize o padrão Decorator para acrescentar algum comportamento dinâmico em um jogador quando ele pega alguma coisa que lhe dá super-poderes durante alguns segundos (como o Mario do Super Mario Bros quando come o cogumelo e fica grande e ligadão).  
  
7) Implemente uma música de fundo diferente para cada uma das fases.  
  
8) Eventos especiais devem ter efeitos sonoros interessantes e agradáveis (cuidado para não tornar o jogo insuportável).  
  
O projeto deverá ser desenvolvido continuamente ao longo dos próximos 2 meses e terá as seguintes datas de entrega:  

**Fase 0, até 8 de maio**  
 
Criar grupo no gitlab, colocar todos os membros lá e, por último, incluir como Reporter @fabio.kon, @gabriely.pereira e @robson.aleixo.  
  
**Fase 1, até 22/maio**  
  
requisito 1 + requisito 2  
  
**Fase 2, até 12/junho**  
  
requisito 3 + requisito 4  
  
**Fase 3, até 1/julho**  
  
requisito 5 + requisito 6  
  
--------  
  
Itens opcionais que valerão pontos bonus: requisito 7, requisito 8 e qualquer outra melhoria legal que vocês propuserem.  
  
Junto com cada fase, além do código no repositório gitlab, vocês devem apresentar um pequeno relatório (no arquivo README.md na raiz do seu projeto) descrevendo o que vocês fizeram naquela fase e a explicação de como executar o jogo. Sempre que possível, as principais funcionalidades do código devem ser cobertos por testes automatizados.  
  
  
**Dicas e sugestões:**  
  
- Uma série de bons vídeos tutoriais sobre a escrita de Jogos em Java: https://www.youtube.com/playlist?list=PLWms45O3n--6TvZmtFHaCWRZwEqnz2MHa  
  
- Um bom livro gratuito sobre padrões específicos para jogos: http://gameprogrammingpatterns.com/contents.html Em particular, a leitura do padrão game loop é super-importante: http://gameprogrammingpatterns.com/game-loop.html  
  
- Fiquem à vontade para usarem qualquer classe da biblioteca padrão de Java, por exemplo, java.awt.Graphics2D e qualquer biblioteca de software livre disponível na Web.  
  
- É terminantemente proibido a um grupo copiar o código de outro grupo.  
  
- É fundamental que vocês só utilizem material que vocês possam usar legalmente. Portanto, usem apenas material licenciado apropriadamente (p.ex., Creative Commons) ou que vocês mesmo criem. Alguns sites bons para achar esse tipo de asset são:  
https://opengameart.org e https://freesound.org O mesmo vale para sprites, texturas e fontes de texto usadas. Para fontes de texto o Google Fonts é mais do que suficiente.  
  
- O Wiki do grupo de jogos dos alunos do IME: https://uspgamedev.org/wiki/Referências (aliás, se gostarem da experiência e quiserem mais, vocês podem se juntar ao USPGameDev :-)