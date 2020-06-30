# DiÃ¡rio de Bordo   

## IntroduÃ§Ã£o   

A ideia desse arquivo Ã© documentar as reuniÃµes feitas pelos integrantes do grupo e especificar o que foi feito em cada e por quem. A ideia Ã© usar a tÃ©cnica do "Dojo" para programaÃ§Ã£o.   

Assim, nos conectamos em um servidor da plataforma Discord, pela qual todos os integrantes se comunicam por meio de um canal de voz e texto. Em cada sessÃ£o dois dos quatro integrantes compartilham a tela (para facilitar a documentaÃ§Ã£o, a pessoa que compartilha a tela serÃ¡ chamada de Streamer), um seguido do outro e ambos com limite de tempo definido, enquanto os outros sugerem o que deve ser feito no desenvolvimento de projeto.

## 12/05/2020   

As observaÃ§Ãµes iniciais foram a respeito da organizaÃ§Ã£o das sessÃµes de Dojo e as resoluÃ§Ãµes estÃ£o supracitadas.   

O primeiro Streamer foi o @AleMarquis e durante esse "round" foram criadas as classes: MapReader, na qual fazemos a leitura de um arquivo .txt que contÃ©m o mapa do jogo e guardamos o conteÃºdo; WrongMapFormatException, para tratar das excessÃµes de fomrato invÃ¡lido do mapa, ou seja, sem consistÃªncia no tamanho das linhas. Commit relacionado: 2f7eafe95323f091a1f19b38a60151007ce79c66     

O segundo Stramer foi o @GabrielKishida, nesse "round" foi feita a classe MapBuilder, que abstrai a criaÃ§Ã£o do mapa do jogo a partir do MapReader. TambÃ©m foi feita a interface GameObject, que representa os elementos do jogo. A classe abstrata MapObject implementa a interface GameObject e suas subclasses sÃ£o elementos estÃ¡ticos para compor o mapa. Commit relacionado: dda3dcaf9ce48a9afde124e1dc24e657576bfb12

## 13/05/2020

As observaÃ§Ãµes iniciais foram a respeito de Hashmap e da forma com o qual o Map e MapObjects serÃ£o organizados.

O primeiro Streamer do dia foi @guazco. Em seu "round", determinamos o enum MapID -- que determina o ID dos objetos que se situarÃ£o no mapa do jogo. ApÃ³s isso, comeÃ§amos a utilizar a classe HashMap para "preencher" uma matriz de MapObjects (a matriz MapObject map ) com os objetos desejados. Commit relacionado: c0c3369001cb92da306ea413de9b8e8673b16f0f

O segundo Streamer do dia foi @febagni. Felipe ficou encarregado de "faxinar" os restos mortais do cÃ³digo de Gustavo, e apÃ³s isso, gerou a classe Game (que contÃ©m o *game loop* pattern). Desenvolvemos tambÃ©m Ã s classes relacionadas Ã  janela (Window), e renderizamos os grÃ¡ficos do MapObjects. No entanto, o mapa estava invertido na janela representada; um bug que serÃ¡ corrigido no prÃ³ximo encontro. Commit relacionado: dde37cd27e689984caa642f12dfbc51f583627d6

## 15/05/2020

As observaÃ§Ãµes iniciais foram a respeito da correÃ§Ã£o dos bugs na impressÃ£o da matriz do mapa, tambÃ©m foram sobre corrigir a formataÃ§Ã£o do cÃ³digo, desenhar sprites para elementos estÃ¡ticos e inserir os sprites no mapa.

O primeiro streamer foi o @GabrielKishida, em que utilizamos de algumas tÃ©cnicas de debug para encontrar onde a matriz estava sendo transposta, o bug foi encontrado e resolvido. Nesse "round" nÃ³s tambÃ©m formatamos as classes jÃ¡ existentes. Commit relacionado: ee39736050c840ae8d2ef181829b87f21f7c3426

O segundo streamer foi o @AleMarquis, durante esse "round" foram feitos os desenhos dos sprites, a inserÃ§Ã£o dos mesmos no JFrame para o mapa. TambÃ©m procuramos formas de indicar o path das imagens no cÃ³digo, colocando as imagens dentro de umapasta, mas nÃ£o encontramos um jeito que funcionou de acordo com nossos interesses. Commit relacionado: 11850c676345d95707660208b5ae7478a52f0d69

Uma observaÃ§Ã£o final Ã© que o FPS da JFrame caiu consideravelmente, pois estamos renderizando cada imagem continuamente na JFrame. Isso ainda precisa ser resolvido. 

## 17/05/2020

As observaÃ§Ãµes iniciais foram a respeito dos caminhos que estÃ¡vamos seguindo. Tendo o mapa do jogo todo sendo renderizado e com o FPS bem baixo, decidimos criar outra branch com a finalidade de estudar e testar o movimento do sprite do pacman em uma JFrame e depois o moviemtno limitado pelos elementos do mapa.

O primeiro streamer foi o @febagni, em que foi feita uma tÃ©cnica para animar o sprite do pacman a partir de uma Ãºnica imagem, e sua correspondÃªncia com a direÃ§Ã£o do sprite. TambÃ©m foi feita a movimentaÃ§Ã£o do player dentro de uma JFrame com os comandos das setas do teclado. Commit relacionado:6b25783a7cfce148321f4f0e6d83e316fd4f0b12

O segundo streamer foi o @guazco, em tal round bugs foram removidos, foi iniciada o import do mapa para a movimentaÃ§Ã£o do pacman limitada aos corredores do labirinto. E tambÃ©m, foi feita uma organizaÃ§Ã£o do trabalho realizado e refatoraÃ§Ã£o do cÃ³digo. Commit relacionado: 52009311f665bcc67befb9d231c2d7bcaf063e49

## 18/05/2020

As observaÃ§Ãµes iniciais foram a respeito de juntar o trabalho realizado na outra branch (feito no dia 17/05/2020) na branch develop. 

O primeiro streamer foi o @AleMarquis, nesse "round" foi feita a adaptaÃ§Ã£o dos cÃ³digos da outra branch para a develop e implementada a movimentaÃ§Ã£o do sprite com passos por posiÃ§Ã£o na matriz de objetos feita a partir do arquivo txt contendo o desenho do mapa. TambÃ©m foi aplicada a tangibilidade, que limita os movimentos do sprite dentro dos corredores do labirinto. Commit relacionado: 3b3b225ae49337b108d3afa0476b20b10f84fc99

O segundo streamer foi o @GabrielKishida, nesse "round" foi feita otimizaÃ§Ã£o da movimentaÃ§Ã£o do pacman, mudando a forma como Ã© feita a renderizaÃ§Ã£o do mapa, que passou a ser feita por completa na primeira iteraÃ§Ã£o, e com o movimento do pacman em blocos que o circundam, voltamos a utlizar as imagens para as paredes e foi feita tambÃ©m uma movimentaÃ§Ã£o mais suave do sprite em campo (tem a movimentaÃ§Ã£o dentro da matriz e a que o jogador vÃª). Commit relacionado: 5e80acfebd67c103c07c9a5a7f0ae35aa5039fbe

## 19/05/2020

As observaÃ§Ãµes iniciais foram sobre arrumar a movimentaÃ§Ã£o do sprite, corrigir erro de pixel perfect, melhorar a jogabilidade e adicionar novos objetos no mapa, como o boost e os fantasmas.

O primeiro streamer foi o @guazco, nesse "round" foi ajustada a movimentaÃ§Ã£o do sprite do pacman nas curvas e melhoramos a jogabilidade para o player, como pixel perfect problems e curvas. Commit relacionado: a9a8f9ae1aa35f9a8b2803b43bc10983e40ece87

O segundo streamer foi o @febagni, nesse "round" foram adicionados os boosts, como MapObject, sua leitura e interaÃ§Ã£o; a contagem de pontos e a classe relacionada aos fantasmas, introduzidos como GameObjects. Commit relacionado: b4ecb22feeb467afe1b012192488eb88ac1b54f9

As observaÃ§Ãµes finais: a questÃ£o do JFrame foi pesquisada e a origem Ã© possivelmente o uso de KeyListeners, o uso de Key Bindings no lugar resolveria o problema. 
  
## 20/05/2020

As observaÃ§Ãµes foram a respeito de fazer o ajuste fino na movimentaÃ§Ã£o do sprite do pacman, correÃ§Ãµes de bugs e tambÃ©m adicionar os ghosts.

O primeiro streamer foi o @AleMarquis, nesse "round" foi feito um ajuste fino na movimentaÃ§Ã£o do pacman, que estava deslocado em alguns pixels. TambÃ©m foi corrigido um bug, que o pacman estava atravessando as paredes em algumas ocasiÃµes. Commit relacionado: e4bdc0614dcaff05402f66996782b84317c8613a

O segundo streamer foi o @GabrielKishida, nesse "round" foram adicionados os Ghosts, partes do cÃ³digo foram refatoradas para a criaÃ§Ã£o da classe Entity, que representa os objetos mÃ³veis do jogo (inclusive o pacman) e as dependÃªncias de tal classe. Commit relacionado: 9e4fa4be7cdea47ce254bde685af9c4b357e4242

ObservaÃ§Ã£o final: ainda hÃ¡ de ser feita a correÃ§Ã£o do JFrame.

## 21/05/2020 e 22/05/2020

A equipe comeÃ§ou a seguir mais a risca o sistema de dojo citado no comeÃ§o do documento, fazendo sessÃµes de 30 minutos por streamer, assim o nÃºmero de commits subiu, mas o progresso continuou relativamente o mesmo. Vale ressaltar tambÃ©m que hoje em especÃ­fico a equipe fez um encontro a tarde e um a noite devido ao feriado e o cancelamento das aulas do dia.

As observaÃ§Ãµes de hoje foram principalmente a respeito de refatorar e comentar o cÃ³digo, com 6 commits relacionados a isso, houve tambem a correÃ§Ãµes de bugs e melhorias de performance do programa no geral, o que acarretou na simplificaÃ§Ã£o do cÃ³digo de renderizaÃ§Ã£o. TambÃÂ©m adicionamos os sprites e animaÃ§Ãµes dos fantasmas e da cereja, praticamente finalizando a jogabilidade base do pacman.

O primeiro streamer foi o @febagni, nesse "round" foi feita a criaÃ§Ã£o de mÃ©todos para atravessar o mapa a sair pela beirada, criando alguns bugs com a sua funcionalidade. Commit relacionado: b02ac650670258e5be175b3acc639c91f4dc0f19

O segundo streamer foi o @guazco, nesse "round" foi feita a correÃ§Ã£o dos bugs de funcionalidade do cÃ³digo criados no ultimo commit, deixando para o prÃ³ximo streamer resolver os bugs grÃ¡ficos relacionados ao render. Commit relacionado: b0634ebe4149c3d1972b5ac8eeab51c538c77b55

O terÃ§eiro streamer foi novamente o @febagni para adicionar os sprites e animaÃ§Ãµes criados para os quatro fantasmas do pacman, alÃ©m de criar mÃ©todos que viriam a corrigir os bugs grÃ¡ficos de atravessar o mapa pelas bordas do jogo.Commit relacionado: ad58b852b293057893f5fa963dafa66f052bea1f

O quarto streamer foi o @gabrielKishida, nesse "round" foram resolvidos os bugs grÃ¡ficos com os mÃ©todos do streamer anterior, com resultados satisfatÃ³rios ao usar um mÃ©todo que renderiza o ultimo lugar que o pacman estava para retirar o sprite que restava na entrada da borda para o outro lado do mapa. TambÃ©m foi construido o comeÃ§o da classe FloorWithCherry. Commit relacionado: 67f3a1a59d80eb45480f148b0a026169eb42af9c

O primeiro streamer do perÃ­odo da noite foi o @AleMarquis, refatorando o renderizador dos arredores do jogador para que possa ser utilizado para solucionar todos os bugs gerados com a nova feature atÃ© entÃ£o, tambÃ©m refatorou o cÃ³digo do MapHandler deixando mais enxuto e simples. AlÃ©m de inserir o sprite da cereja e construir seu render em sua classe. Commit relacionado: 8efb78cd75bc49d492d779886a80324cef89560e

ApÃ³s ficarmos satisfeitos com os requisitos da primeira etapa do trabalho (que estÃ£o no README.md), partimos para a comentar e refatorar o projeto, nÃ£o falarei passo a passo quem fez o que nesta etapa (nos commits abaixo Ã© possÃ­vel ver exatamente quem refatorou o quÃª) e sim farei observaÃ§Ãµes gerais sobre o que fizemos nesse tempo.

ComeÃ§amos refatorando e comentando as classes um a um, percebemos alguns mÃ©todos nÃ£o optimizados que provavelmente geravam o pÃ©ssimo desempenho quando renderizamos continuamente o mapa a cada tick, gerando um framerate baixÃ­ssimo para o jogo, ao tratar desses mÃ©todos percebemos um grande ganho de performance que possibilitou utilizarmos uma estratÃ©gia mais bruta para renderizarmos o mapa e manter uma boa taxa de quadros, simplificando os mÃ©todos mais complexos que utilizavamos para driblar os problemas de performance como o renderChunk. No final colocamos Briefs e comentÃ¡rios em todos os mÃ©todos principais das classes. 

1o Commit relacionado @febagni: 1a6845f17f3d9c385101c48edee90157003e16fc   
2o Commit relacionado @guazco: 650f97adc9a91d602c6ac6ce733baeb47512b910   
3o Commit relacionado @gabrielKishida: ff5ccde13a88831dfb21f4c1c91b0e7c7ac45e90   
4o Commit relacionado @AleMarquis: 9ff85167c47d7cc582cf5571a42b5b006d0ff5c5   
5o Commit relacionado @febagni: adbfd36c7bbe365464efe339480ef219d016d136   
6o Commit relacionado @guazco: 1938db9e7bf6762aef4a314941742f552b0acc11  

## 30/05/2020

A equipe comeÃ§ou organizando os afazeres para essa segunda entrega, construindo o colisor do Pacman com os fantasmas e construindo o sistema de vidas e o suporte para um "Game Over".

O primeiro streamer foi o @gabrielKishida, nesse "round" foi construido o sistema colisÃµes do pacman com outros fantasmas, com mÃ©todos que comparavam a posiÃ§Ã£o do Pacman com as dos fantasmas, tambÃ©m foi criado o comeÃ§o de um sistemas de vida para o jogo. Commit relacionado: 2fc4a305333b6bb49899c2aeb09e15f2ab82518d

O segundo streamer foi o @guazco, nesse "round" foi concluido o sistema de vidas e criado um reset quando o jogador perde todas as vidas e chega uma tela de game over. Commit relacionado: 0a636223c1da4c83a818a79a2bfab42878d2be75

ObservaÃ§Ã£o final: <a href="https://www.youtube.com/watch?v=dQw4w9WgXcQ">Link Relevante</a>

## 02/06/2020

A equipe comeÃ§ou a criar o padrÃ£o strategy para os movimentos dos fantasmas, jÃ¡ criando o padrÃ£o de lÃ³gica aleatÃ³rio para a inteligÃªncia dos fantasmas. Ao implementÃ¡-lo, geramos alguns bugs que serÃ£o resolvidos posteriormente. Commit Relacionado: 6bdad35c85cfea152aa65857b64cd7ac40425dfa

O primeiro streamer foi o @AleMarquis, nesse "round" foi criado a interface de Movimentos para os fantasmas e uma classe que a implementa com o padrÃ£o pseudo-aleatÃ³rio. Commit Relacionado: 6bdad35c85cfea152aa65857b64cd7ac40425dfa

O segundo streamer foi o @febagni, nesse "round" foi implementado uma lÃ³gica para a estratÃ©gia dos fantasmas. Seu movimento pseudo-aleatÃ³rio foi continuado a ser desenvolvido e geramos alguns bugs na detecÃ§Ã£o de paredes. Commit Relacionado: 93172d8a3367c0e41c6b58015991be86d030cb6f

ObservaÃ§Ãµes Finais: 

O bug provavelmente foi relacionado Ã  falta de setar o mapa de objetos para os fantasmas, que ao tentar acessar uma posiÃ§Ã£o no grid, recebem um NullPointerException

<a href="https://www.youtube.com/watch?v=IF7g1mWOpUA">Link Relevante</a>

## 03/06/2020

O primeiro streamer foi o @guazco e nesse "round", o grupo arrumou o bug da movimentaÃ§Ã£o dos fantasmas, fazendo com que eles conseguissem fazer o movimento aleatÃ³ria implementado anteriormente. Commit relacionado: 5c03b5991fc5820af8fc402a287402505275c252

O segundo streamer foi o @GabrielKishida e nesse "round", foi implementada a estratÃ©gia de movimentaÃ§Ã£o DumbFollow, fazendo os fantasmas com essa estratÃ©gia de movimentaÃ§Ã£o seguir o pacman, a DumbFollow Ã© subclasse da classe abstrata FollowMovement, criada para implementar a interface de movimentos dos fantasmas. Foi criada a rotina de reset das posiÃ§Ãµes dos fantasmas. Commit relacionado: d053f25ea2a5d805d341665d72a83c015d7e159f

ObservaÃ§Ãµes finais:   
<a href="https://www.youtube.com/watch?v=O-_gK7rPpcg">Link Relevante</a>

## 04/06/2020

O primeiro streamer foi o @AleMarquis e nesse "round" o grupo criou a movimentaÃ§Ã£o em que o fantasma foge do jogador. Commit relacionado: 18200c2e05954a5401b57f937e4dc3c37d3bd97e 
O segundo streamer foi o @febagni e nesse "round" o grupo adicionou novas cores para  os fantasmas e ferramentas necessÃ¡rias para as estratÃ©gias, criando um problema no FPS em consequÃªncia. Commit relacionado: 86b0b512debe09fa2911e71b2106daab890e4a81

## 05/06/2020

O primeiro streamer foi o @GabrielKishida e nesse "round" o grupo fez a mistura de movimentos do fantasmas para diferentes cores e fantasmas.Commit relacionado: 70bcc7997b8b138610d8f31ad41ab9e9a7d893c7
O segundo streamer foi o @guazco e nesse "round" o grupo continuou com os testes para criaÃ§Ã£o do menu do jogo, foi feito tudo na branch menu. Commit relacionado: b09840d40499aefb935f0761a1020bf9ccdb0192

## 08/06/2020

O primeiro streamer foi o @febagni e nesse "round" o grupo criou uma nova FÃ¡brica Abstrata para os diferentes tipos de mapas. Commit relacionado: 9fe05d2d40a8f18c827510eb0c9aec38c547bc9e
O segundo streamer foi o @AleMarquis e nesse "round" o grupo adicionou um fÃ¡brica abstrata inicial para o "look and feel". Commit relacionado: ea7e4b6e472e62cc08b5aca34df12cf79ac63294

## 09/06/2020

O primeiro streamer foi o @guazco e nesse "round" o grupo criou um jeito de gerenciar os sprites. Commit Relacionado: cd20d4da941aea4d34d4b11fa9329f8471e14f23
O segundo streamer foi o @GabrielKishida e nesse "round" o grupo terminou a fÃ¡brica abstrata para mudar o "look and feel" de acordo com o tema. Commit relacionado: 38c928218dad480570c358a297b981fa93ceebd0

## 10/06/2020

Cada um fez um dos pacotes de sprites para looks and feels diferentes. Utilizando de ferramentas para fazer pixel art. 

## 11/06/2020

O primeiro streamer foi o @AleMarquis e nesse "round" foi feito a primeira parte do refatoraÃ§Ã£o do cÃ³digo. Commit Relacionado: e30e8d4c96159c3717d8e1a0407879b795262654
O segundo streamer foi o @febagni e nesse "round" foi feito a segunda e Ãºltima parte da refatoraÃ§Ã£o do cÃ³digo. Commit Relacionado:2ed0bfc8fbe6943505c2765bc6d89644c20da3cd

ObservaÃ§Ãµes Finais: 
<a href="https://www.youtube.com/watch?v=688OPQ9WFpA"/>Link Relevante</a>

## 16/06/2020   

ApÃ³s a primeira entrega, nÃ³s nos reunimos para reassisitir os vÃ­deos sobe o <a href="https://www.youtube.com/watch?v=Z93dSsQzuCI&list=PLTeQ2u81sjqfsFNWrUCIoqJZBSJrai8M7&index=17"/>padrÃ£o State</a> e nos organizar quanto aos afazeres para essa prÃ³xima entrega, como definir quais fatores seriam alterados com as diferentes dificuldades do jogo, como seria o controle de fase a fase, entre outras coisas.   

## 18/06/2020    

O primeiro streamer foi o @AleMarquis, nesse "round" foi iniciada a implementaÃ§Ã£o do padrÃ£o state: criando as classes das diferentes dificuldades e a classe do GameState. Commit relacionado: 77a505276f868a21006987bdde1c0198d37f6517   
O segundo streamer foi o @guazco e nesse "round" foram implementadas caracterÃ­sticas e mÃ©todos relacionados Ã s dificuldades e tambÃ©m foram feitos testes em relaÃ§Ã£o aos mesmos. Commit relacionado: aeef7a9f326edf8530bef10baf123995272b2f09   

## 19/06/2020   

O primeiro streamer foi o @febagni, nesse "round" foi adicionado um botÃ£o de pausa (tecla 'P') para pausar o jogo, foi encontrado e ajustado um bug relacionado a movimentaÃ§Ã£o do fantasma, quando Ã© cercado de paredes, alÃ©m de dar continuidade a implementaÃ§Ã£o das dificuldades. Commit relacionado: bb7a7d075d59f1465c78104d9733a158752638ba   
O segundo streamer foi o @GabrielKishida, nesse "round" foram implementados os botÃµes de Reset (tecla 'R'), adicionando a funÃ§Ã£o de resetar o jogo quando pausado ou quando o jogo termina; e de "Next Level" (tecla 'N'), adicionando a funÃ§Ã£o de ir para a prÃ³xima fase quando o jogo termina. Commit relacionado: aebee2ba326a27055e910db13542ac274f8e2210   

## 20/06/2020   

O primeiro streamer foi o @AleMarquis, nesse "round" foi adicionado um botÃ£o Exit (tecla 'E'), para poder fechar o jogo quando pausado e quando o jogo termina. TambÃ©m foi feito um mÃ©todo que atualiza algumas caracterÃ­sticas de acordo com o State de dificuldade. Commit relacionado: 05898a7a38c82ed8cd7f08a9795d4ae1a411e377   
O segundo streamer foi o @guazco, nesse "round" foram consertados bugs em relaÃ§Ã£o a cherry, adicionados mÃ©todos para a probabilidade de aparecimento de cherries de acordo com o state de dificuldade . AlÃ©m de dar continuidade a implementaÃ§Ã£o das dificuldades. Commit relacionado: b268cd41a1b3674cef515965991ed28ae01c6ee3 

## 22/06/2020 

O primeiro streamer foi o @GabrielKishida, nesse "round" foi feito as funções do comportamento do Boost, um método para setar todos os fantasmas para escaparem do jogador, um para voltar à estratégia original e um para setar o sprite relacionado ao comportamento dos fantasmas. Commit relacionado: 337b679890a0c625e945111baea75a2ae72e23fb
O segundo streamer foi o @febagni, nesse "round" foi feito um rework no sistema de pontuação e um protótipo do padrão decorator para o PacMan. Commit relacionado: ff97db4dfb36e65c845c059c97e8c7ba60f3242e

## 23/06/2020

O primeiro streamer foi o @guazco, nesse "round" foi criado e implementado uma classe para dirigir as funções relacionados aos efeitos sonoros do jogo. Commit relacionado: 0fda0667cdfee80994f7393f618ea7810caf6fb9
O segundo streamer foi o @AleMarquis, nesse "round" foi criado e organizado pastas para os arquivos de musica, implementamos as músicas dependo da fase e sua dificuldade. Commit relacionado: 53a826257739689570393402c3d52975eee80d47
## 24/06/2020 

O primeiro streamer foi o @febagni, nesse "round" foi feito um debug geral no sistema de som, foi adicionado o controle de volume geral e o multiplicador de pontos do game. Commits Relacionados: 5128d55437c686a036b0cf55e42a01c82c27f995, 385e4a534519aaa718e0c08c999e2fe647c9c403, 6411e3bafabdcba11a2a66078f90a96a391b025f
O segundo streamer foi o @GabrielKishida, nesse "round" reestruturamos parte do código para incluir a arquitetura do decorator. Commit relacionado: ccc807ee663c701b9337f0ab8f423d013a2d7383 

## 25/06/2020   

O primeiro streamer foi o @AleMarquis, nesse "round" foi finalizado a arquitetura do padrão decorator do jogador. Commit relacionado: caa399fdde1d924993180f711f525d4c327b980f
O segundo streamer foi o @guazco, nesse "round" foi introduzido a mecânica do boost ao jogo, ou seja, implementou o padrão decorator ao jogo. Commit relacionado: ce6127b50dd81f1018a09cb1424e087fda51896e

## 26/06/2020   

O primeiro streamer foi o @febagni, nesse "round" foi adicionado o comportamento do estado de transição do final do tempo do boosted, também começou a debugagem dessa mecânica do jogo. Commit Relacionados: 27b2e1b5649149654055955f4240aad400749c58
O segundo streamer foi o @GabrielKishida, nesse "round" foi finalizado a debugagem da mecânica de boost. Commit relacionado: 0415f949e227c3c182103ff3d37e2812bf3dcb52

## 27/06/2020   

O único streamer foi o @guazco, nesse "round" foi implementado parte dos efeitos sonoros do requisito 8 do projeto. Commit relacionado: 7639bafe114a952dbb61cbf1604002b4a0faa962

## 28/06/2020

o primeiro streamer foi o @GabrielKishida, nesse "round" foi consertado o bug de render dos fantasmas enquanto o jogador estava boostado e foi adicionado os sprites restantes para um dos look'n'feel. Commit relacionado: f9aa29cdb209b35e6d239193e1f0fb14dafbf520
o segundo streamer foi o @febagni, nesse "round" foi adicionado algumas músicas e foi feito um sistema de troca de música para cada fase. Commit relacionado: 4a65340627d0b6d649c056ce31944093565b598f
o terceiro streamer foi novamente o @GabrielKishida, nesse "round" foi adicionado o botão de "Mute", que silencia o som do jogo, bem como foi começamos a comentar o código. Commit relacionado: 0ac7d252fd0d1a2392316df1491b4ecd3bbaac91

## 29/06/2020

o primeiro streamer foi o @GabrielKishida, nesse "round" foi feita a refatoração do código, também colocou alguns atributos "public" para "private". Commit relacionado: ac2feb7a2c1639fa7b8433082ed42ddf521da453
o primeiro streamer foi o @guazco, nesse "round" foi feita a refatoração do código, comentamos o código e colocamos header nas classes e nos métodos. Commit relacionado: 6874a6a717dfc7542d475cefe2fa0682f57b2009
o primeiro streamer foi o @febagni, nesse "round" foi adicionado métodos utilizados para a funcionalidade da música do jogo, também foi colocado um "easter egg" no jogo. Commits relacionados: 2f0de11b5c1303b7fd32fefcc65c847b12ec55a3, 885bd78b3ff6c2bd06231e24d295de284d01c1a8