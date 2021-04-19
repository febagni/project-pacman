# Project PacMan

<center> 
<img src="https://i.imgur.com/fGu2yGQ.png" width="150" height="150">
</center>

## Introdução:
Esse repositório contém o trabalho e desenvolvimento do grupo "Object-oriented teens" para a disciplina de MAC-0321 - Laboratório de Programação Orientada a Objetos, ministrada aos alunos de graduação do curso de <a href="https://pcs.usp.br/">Engenharia da Computação</a> da <a href="https://www.poli.usp.br">Escola Politécnica da USP.</a>

O grupo fará uma versão do PacMan trazida para o contexto atual. A ideia é ir criando novas features, a partir da branch develop e ir fazendo releases para a master, de acordo com algumas datas de entrega.

A documentação do projeto está sendo feita por relatórios em um diário de bordo. E o desenvolvimento será feito utilizando a técnica do *Dojo* em sessões de vídeochamada com todos os membros do grupo presentes.

Os integrantes do grupo Object-oriented teens:

Nome     | Username 
---------- |-----------
Alexandre Marques Carrer |<a href="https://github.com/alemarquis">@AleMarquis</a>
Felipe Bagni | <a href="https://github.com/febagni">@febagni</a>
Gabriel Yugo Kishida | <a href="https://github.com/gabrielkishida">@GabrielKishida</a>
Gustavo Azevedo Corrêa | <a href="https://github.com/guazco">@guazco</a>

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

## Instruções

### Sobre o mapa

O mapa é feito a partir de um arquivo .txt e a correspondência de seus elementos para os objetos do jogo são:

Caractere    |	Objeto do Jogo	 
----------|-----------
'#'|Parede (Wall)
' '|Chão (Floor)
'.'|Chão com comida (Floor With Food)
'@'|Chão com boost (Floor With Boost)
'%'|Chão com cereja (Floor With Cherry)
'M'|Posição inicial do(s) fantasma(s) (Ghost)
'C'|Posição inicial do PacMan

Algumas condições para o funcionamento do jogo: 
- O mapa deve ser retangular;
- Deve existir somente UM pacman (por enquanto hue);
- Os vértices do retângulo que formam o mapa devem ser paredes.

Cada quadrado do mapa corresponde a 32 pixels.

### Como executar o programa?

Dentro do eclipse, é necessário colocar como argumento da main o path do arquivo txt que contém a representação do mapa.
Para executar o programa, após setar o argumento, basta dar "Run" e se divertir! ;)
OBS: a função main está dentro de *Game.java*.

### Movimentação do PacMan

Para movimentar o PacMan no jogo, basta utilizar as setas do teclado para o sentido correspondente à própria tecla.

### Sobre o Look & Feel

Temos 5 diferentes Looks & Feels para o nosso jogo atualmente.
Para alternar, em tempo real, entre um e outro durante a partida, basta apertar a tecla correspondente ao Look & Feel desejado, seguindo a tabela:

Tecla    |	Look & Feel | Descrição
----------|-----------|-----------
'1'|Classic| Visual padrão do jogo: voltando aos anos 80!
'2'|Deep Space| Visual de espaço sideral: polícia e ladrão intergaláctico!
'3'|Wild West| Visual do velho oeste: dê a volta por cima nos caras pálidas!
'4'|Under The Sea| Visual subnáutico: tente sobreviver no fundo do mar!
'5'|Covid Market| Visual em tempos de pandemia: combatendo o coronavírus!

## Primeira entrega

A primeira entrega corresponde a Fase 01, ou seja, aos requisitos 01 e 02 supracitados.
O código da primeira entrega se encontra na branch *master*.
**Cada um dos arquivos *.java* que compõem o projeto possuem comentários explicando detalhadamente o que foi feito.**
Dentro do [diário de bordo](./DiarioDeBordo.md), pode ser encontrado o que foi feito dentro de cada sessão de "Dojo" realizada, explicando detalhada e progressivamente o trabalho feito.

## Segunda Entrega

A segunda entrega corresponde à Fase 02, ou seja, aos requisitos 03 e 04; em outras palavras, usamos o padrão Strategy para implementar diferentes estratégias de movimentação para os fantasmas do jogo, cujos sprites mudam de acordo com a estratégia:

Estratégia    |	Descrição
----------|-----------
DumbFollowMovement| O fantasma segue o PacMan comparando suas posições
RandomMovement| O fantasma muda de direção aleatoriamente
GetAwayMovement| O fantasma foge do PacMan comparando suas posições

Ademais, temos também um fantasma que se comporta de maneira "mista", alternando entre o DumbFollowMovement e o RandomMovement. Pretendemos mudar a dificuldade do jogo alterando a proporção entre as duas estratégias que ele utiliza.

Utilizamos o padrão Fábrica Abstrata, com o auxílio do padrão Prototype, para implementar diferentes aparências (Looks & Feels) do jogo. Assim, o jogador pode alternar entre as aparências facilmente ao selecionar a tecla correspondente à aparência desejada (vide tabela na seção de Instruções / Sobre o Look & Feel). Dessa forma, todos os elementos gráficos do jogo se redesenham imediatamente com o clicar do botão.

Mais uma vez, o código se encontra na branch *master*.

**Cada um dos arquivos *.java* que compõem o projeto possuem comentários explicando detalhadamente o que foi feito.**
**Todos as imagens foram produzidas pelos membros da equipe, e pertencem a mesma**

Dentro do [diário de bordo](./DiarioDeBordo.md), pode ser encontrado o que foi feito dentro de cada sessão de "Dojo" realizada, explicando detalhada e progressivamente o trabalho feito.

## Terceira Entrega

A terceira entrega corresponde à Fase 03, ou seja, à entrega final do trabalho. O que representa os requisitos 05, 06, 07 e 08.

Em primeiro lugar, usamos o padrão State para implementar diferentes dificuldades para o jogo, de acordo com a fase:

Dificuldade | Categoria 
----------|-----------
01 | Café com Leite 
02 | Fácil
03 | Médio
04 | Difícil
05 | Boss

Característica | Dificuldade 01 | Dificuldade 02 | Dificuldade 03 | Dificuldade 04 | Dificuldade 05
----------|-----------|----------|-----------|----------|-----------
Número de Vidas | Infinitas | 4 | 3 | 2 | 1
Tempo de Boosted (segundos) | 15 | 15 | 10 | 7,5 | 5
Multiplicador de Pontos | x0,5 | x1 | x1 | x2 | x3
Velocidade | 1 | 1 | 1 | 1 | 2
MixedFollow Rate | 10-90 | 30-70 | 50-50 | 70-30 | 90-10

- Numero de vidas representam a quantidade chances que o jogador tem para terminar a fase.
- Tempo de Boosted representa o tempo que os fantasmas fogem do Pacman e que ele pode matar os fantasmas (será melhor explicado abaixo).
- Multiplicador de Pontos representa o número no qual os pontos ganhados naquele estágio serão multiplicados para a pontuação geral.
- Velocidade representa a velocidade das entidades do jogo e modifica o tamanho dos seus passos.
- MixedFollow Rate representa a porcentagem de tempo que a estratégia mista como follow ou como random, respectivamente


Vale observar que cada dificuldade recebe um fileName do mapa, assim podem ter mapas diferentes de acordo com a dificuldade. Porém, optamos em ter o mesmo mapa para todas. 

Para ir para a próxima fase (dificuldade) do jogo, é necessario ganhar a fase atual e o jogo ficar no hiato após a vitória, deve-se apertar a tecla 'N' de "Next".

Abaixo se encontra uma relação de botões que foram implementados.

Botão | Função | Observação
----------|-----------|-----------
'P' | Pausar/Despausar o jogo | É possível pausar o jogo a qualquer momento e a música fica um pouco mais baixa quando pausado, e retorna ao normal ao despausar
'N' | Ir para o próximo nível após vencer o anterior | Só funciona no hiato após a vitória da fase
'E' | Sair do jogo | Só funciona quando está pausado
'R' | Restart da fase | Funciona apenas ao se pausar o jogo ou no hiato após a vitória 
'M' | Mutar/Desmutar o jogo | Efeito sobre todos os áudios do jogo (música e efeitos especiais)
'Z' | Aciona/Desaciona algo :3 | Have fun! #descubra

Em segundo lugar, foi implementado o efeito especial quando o pacman come um "boost". Assim, os fantasmas mudam de sprite e estratégia (para a estratégia de Escape - "GetawayMovement"). Usamos o padrão Decorator para implementar a mecânica de boost no pacman, permitindo ele comer os fantasmas. Ao comer um fantasma, ele reaparece na sua posição setada inicialmente no .txt do mapa com a sua estratégia original.   

Vale ressaltar, que o tempo que o boost fica acionado varia com a dificuldade, como mostrado acima. Ao final do tempo de boost, os sprites dos fantasmas começam a piscar (e ficam no ID "EndOfEscape") para indicar o fim do tempo do boost.   

Também, se o pacman já está no modo Boosted e comer um outro "boost", a rotina de "boosted" é reiniciada.   

Já em relação ao requisito 08, as músicas foram desenvolvidas usando o software "GarageBand" pela própria equipe. As músicas, propriamente ditas, mudam progressivamente de acordo com a dificuldade do jogo, ficando mais agitadas conforme os níveis passam. Também, cada look-and-feel tem um tema de instrumentos diferente, mas mantendo o cerne da música pela dificuldade.   

Para o requisito 09, foram adicionados efeitos sonoros para os eventos de comer uma cherry, um boost ou nas interações dos personagens: pacman mata fantasma ou fantasma mata pacman.   

Mais uma vez, o código se encontra na branch *master*.

- **Cada um dos arquivos *.java* que compõem o projeto possuem comentários explicando detalhadamente o que foi feito.**
- **Todos as imagens foram produzidas pelos membros da equipe, e pertencem a mesma.**
- **Todos os arquivos de áudio foram produzidos pela equipe, e pertencem a mesma (salvo o EasterEgg).**

Dentro do [diário de bordo](./DiarioDeBordo.md), pode ser encontrado o que foi feito dentro de cada sessão de "Dojo" realizada, explicando detalhada e progressivamente o trabalho feito.
