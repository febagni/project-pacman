# Diário de Bordo   

## Introdução   

A ideia desse arquivo é documentar as reuniões feitas pelos integrantes do grupo e especificar o que foi feito em cada e por quem. A ideia é usar a técnica do "Dojo" para programação.   

Assim, nos conectamos em um servidor da plataforma Discord, pela qual todos os integrantes se comunicam por meio de um canal de voz e texto. Em cada sessão dois dos quatro integrantes compartilham a tela (para facilitar a documentação, a pessoa que compartilha a tela será chamada de Streamer), um seguido do outro e ambos com limite de tempo definido, enquanto os outros sugerem o que deve ser feito no desenvolvimento de projeto.

## 12/05/2020   

As observações iniciais foram a respeito da organização das sessões de Dojo e as resoluções estão supracitadas.   

O primeiro Streamer foi o @AleMarquis e durante esse "round" foram criadas as classes: MapReader, na qual fazemos a leitura de um arquivo .txt que contém o mapa do jogo e guardamos o conteúdo; WrongMapFormatException, para tratar das excessões de fomrato inválido do mapa, ou seja, sem consistência no tamanho das linhas. Commit relacionado: 2f7eafe95323f091a1f19b38a60151007ce79c66     

O segundo Stramer foi o @GabrielKishida, nesse "round" foi feita a classe MapBuilder, que abstrai a criação do mapa do jogo a partir do MapReader. Também foi feita a interface GameObject, que representa os elementos do jogo. A classe abstrata MapObject implementa a interface GameObject e suas subclasses são elementos estáticos para compor o mapa. Commit relacionado: dda3dcaf9ce48a9afde124e1dc24e657576bfb12

## 13/05/2020

As observações iniciais foram a respeito de Hashmap e da forma com o qual o Map e MapObjects serão organizados.

O primeiro Streamer do dia foi @guazco. Em seu "round", determinamos o enum MapID -- que determina o ID dos objetos que se situarão no mapa do jogo. Após isso, começamos a utilizar a classe HashMap para "preencher" uma matriz de MapObjects (a matriz MapObject map[][] ) com os objetos desejados. Commit relacionado: c0c3369001cb92da306ea413de9b8e8673b16f0f

O segundo Streamer do dia foi @febagni. Felipe ficou encarregado de "faxinar" os restos mortais do código de Gustavo, e após isso, gerou a classe Game (que contém o *game loop* pattern). Desenvolvemos também às classes relacionadas à janela (Window), e renderizamos os gráficos do MapObjects. No entanto, o mapa estava invertido na janela representada; um bug que será corrigido no próximo encontro. Commit relacionado: dde37cd27e689984caa642f12dfbc51f583627d6

## 15/05/2020

As observações iniciais foram a respeito da correção dos bugs na impressão da matriz do mapa, também foram sobre corrigir a formatação do código, desenhar sprites para elementos estáticos e inserir os sprites no mapa.

O primeiro streamer foi o @GabrielKishida, em que utilizamos de algumas técnicas de debug para encontrar onde a matriz estava sendo transposta, o bug foi encontrado e resolvido. Nesse "round" nós também formatamos as classes já existentes. Commit relacionado: ee39736050c840ae8d2ef181829b87f21f7c3426

O segundo streamer foi o @AleMarquis, durante esse "round" foram feitos os desenhos dos sprites, a inserção dos mesmos no JFrame para o mapa. Também procuramos formas de indicar o path das imagens no código, colocando as imagens dentro de umapasta, mas não encontramos um jeito que funcionou de acordo com nossos interesses. Commit relacionado: 11850c676345d95707660208b5ae7478a52f0d69

Uma observação final é que o FPS da JFrame caiu consideravelmente, pois estamos renderizando cada imagem continuamente na JFrame. Isso ainda precisa ser resolvido. 

## 17/05/2020

As observações iniciais foram a respeito dos caminhos que estávamos seguindo. Tendo o mapa do jogo todo sendo renderizado e com o FPS bem baixo, decidimos criar outra branch com a finalidade de estudar e testar o movimento do sprite do pacman em uma JFrame e depois o moviemtno limitado pelos elementos do mapa.

O primeiro streamer foi o @febagni, em que foi feita uma técnica para animar o sprite do pacman a partir de uma única imagem, e sua correspondência com a direção do sprite. Também foi feita a movimentação do player dentro de uma JFrame com os comandos das setas do teclado. Commit relacionado:6b25783a7cfce148321f4f0e6d83e316fd4f0b12

O segundo streamer foi o @guazco, em tal round bugs foram removidos, foi iniciada o import do mapa para a movimentação do pacman limitada aos corredores do labirinto. E também, foi feita uma organização do trabalho realizado e refatoração do código. Commit relacionado: 52009311f665bcc67befb9d231c2d7bcaf063e49

## 18/05/2020

As observações iniciais foram a respeito de juntar o trabalho realizado na outra branch (feito no dia 17/05/2020) na branch develop. 

O primeiro streamer foi o @AleMarquis, nesse "round" foi feita a adaptação dos códigos da outra branch para a develop e implementada a movimentação do sprite com passos por posição na matriz de objetos feita a partir do arquivo txt contendo o desenho do mapa. Também foi aplicada a tangibilidade, que limita os movimentos do sprite dentro dos corredores do labirinto. Commit relacionado: 3b3b225ae49337b108d3afa0476b20b10f84fc99

O segundo streamer foi o @GabrielKishida, nesse "round" foi feita otimização da movimentação do pacman, mudando a forma como é feita a renderização do mapa, que passou a ser feita por completa na primeira iteração, e com o movimento do pacman em blocos que o circundam, voltamos a utlizar as imagens para as paredes e foi feita também uma movimentação mais suave do sprite em campo (tem a movimentação dentro da matriz e a que o jogador vê). Commit relacionado: 5e80acfebd67c103c07c9a5a7f0ae35aa5039fbe

## 19/05/2020

As observações iniciais foram sobre arrumar a movimentação do sprite, corrigir erro de pixel perfect, melhorar a jogabilidade e adicionar novos objetos no mapa, como o boost e os fantasmas.

O primeiro streamer foi o @guazco, nesse "round" foi ajustada a movimentação do sprite do pacman nas curvas e melhoramos a jogabilidade para o player, como pixel perfect problems e curvas. Commit relacionado: a9a8f9ae1aa35f9a8b2803b43bc10983e40ece87

O segundo streamer foi o @febagni, nesse "round" foram adicionados os boosts, como MapObject, sua leitura e interação; a contagem de pontos e a classe relacionada aos fantasmas, introduzidos como GameObjects. Commit relacionado: b4ecb22feeb467afe1b012192488eb88ac1b54f9

As observações finais: a questão do JFrame foi pesquisada e a origem é possivelmente o uso de KeyListeners, o uso de Key Bindings no lugar resolveria o problema. 
  
## 20/05/2020

As observações foram a respeito de fazer o ajuste fino na movimentação do sprite do pacman, correções de bugs e também adicionar os ghosts.

O primeiro streamer foi o @AleMarquis, nesse "round" foi feito um ajuste fino na movimentação do pacman, que estava deslocado em alguns pixels. Também foi corrigido um bug, que o pacman estava atravessando as paredes em algumas ocasiões. Commit relacionado: e4bdc0614dcaff05402f66996782b84317c8613a

O segundo streamer foi o @GabrielKishida, nesse "round" foram adicionados os Ghosts, partes do código foram refatoradas para a criação da classe Entity, que representa os objetos móveis do jogo (inclusive o pacman) e as dependências de tal classe. Commit relacionado: 9e4fa4be7cdea47ce254bde685af9c4b357e4242

Observação final: ainda há de ser feita a correção do JFrame.

## 21/05/2020 e 22/05/2020

A equipe começou a seguir mais a risca o sistema de dojo citado no começo do documento, fazendo sessões de 30 minutos por streamer, assim o número de commits subiu, mas o progresso continuou relativamente o mesmo. Vale ressaltar também que hoje em específico a equipe fez um encontro a tarde e um a noite devido ao feriado e o cancelamento das aulas do dia.

As observações de hoje foram principalmente a respeito de refatorar e comentar o código, com 6 commits relacionados a isso, houve tambem a correções de bugs e melhorias de performance do programa no geral, o que acarretou na simplificação do código de renderização. TambÃ©m adicionamos os sprites e animações dos fantasmas e da cereja, praticamente finalizando a jogabilidade base do pacman.

O primeiro streamer foi o @febagni, nesse "round" foi feita a criação de métodos para atravessar o mapa a sair pela beirada, criando alguns bugs com a sua funcionalidade. Commit relacionado: b02ac650670258e5be175b3acc639c91f4dc0f19

O segundo streamer foi o @guazco, nesse "round" foi feita a correção dos bugs de funcionalidade do código criados no ultimo commit, deixando para o próximo streamer resolver os bugs gráficos relacionados ao render. Commit relacionado: b0634ebe4149c3d1972b5ac8eeab51c538c77b55

O terçeiro streamer foi novamente o @febagni para adicionar os sprites e animações criados para os quatro fantasmas do pacman, além de criar métodos que viriam a corrigir os bugs gráficos de atravessar o mapa pelas bordas do jogo.Commit relacionado: ad58b852b293057893f5fa963dafa66f052bea1f

O quarto streamer foi o @gabrielKishida, nesse "round" foram resolvidos os bugs gráficos com os métodos do streamer anterior, com resultados satisfatórios ao usar um método que renderiza o ultimo lugar que o pacman estava para retirar o sprite que restava na entrada da borda para o outro lado do mapa. Também foi construido o começo da classe FloorWithCherry. Commit relacionado: 67f3a1a59d80eb45480f148b0a026169eb42af9c

O primeiro streamer do período da noite foi o @AleMarquis, refatorando o renderizador dos arredores do jogador para que possa ser utilizado para solucionar todos os bugs gerados com a nova feature até então, também refatorou o código do MapHandler deixando mais enxuto e simples. Além de inserir o sprite da cereja e construir seu render em sua classe. Commit relacionado: 8efb78cd75bc49d492d779886a80324cef89560e

Após ficarmos satisfeitos com os requisitos da primeira etapa do trabalho (que estão no README.md), partimos para a comentar e refatorar o projeto, não falarei passo a passo quem fez o que nesta etapa (nos commits abaixo é possível ver exatamente quem refatorou o quê) e sim farei observações gerais sobre o que fizemos nesse tempo.

Começamos refatorando e comentando as classes um a um, percebemos alguns métodos não optimizados que provavelmente geravam o péssimo desempenho quando renderizamos continuamente o mapa a cada tick, gerando um framerate baixíssimo para o jogo, ao tratar desses métodos percebemos um grande ganho de performance que possibilitou utilizarmos uma estratégia mais bruta para renderizarmos o mapa e manter uma boa taxa de quadros, simplificando os métodos mais complexos que utilizavamos para driblar os problemas de performance como o renderChunk. No final colocamos Briefs e comentários em todos os métodos principais das classes. 

1o Commit relacionado @febagni: 1a6845f17f3d9c385101c48edee90157003e16fc   
2o Commit relacionado @guazco: 650f97adc9a91d602c6ac6ce733baeb47512b910   
3o Commit relacionado @gabrielKishida: ff5ccde13a88831dfb21f4c1c91b0e7c7ac45e90   
4o Commit relacionado @AleMarquis: 9ff85167c47d7cc582cf5571a42b5b006d0ff5c5   
5o Commit relacionado @febagni: adbfd36c7bbe365464efe339480ef219d016d136   
6o Commit relacionado @guazco: 1938db9e7bf6762aef4a314941742f552b0acc11  

## 30/05/2020

A equipe começou organizando os afazeres para essa segunda entrega, construindo o colisor do Pacman com os fantasmas e construindo o sistema de vidas e o suporte para um "Game Over".

O primeiro streamer foi o @gabrielKishida, nesse "round" foi construido o sistema colisões do pacman com outros fantasmas, com métodos que comparavam a posição do Pacman com as dos fantasmas, também foi criado o começo de um sistemas de vida para o jogo. Commit relacionado: 2fc4a305333b6bb49899c2aeb09e15f2ab82518d

O segundo streamer foi o @guazco, nesse "round" foi concluido o sistema de vidas e criado um reset quando o jogador perde todas as vidas e chega uma tela de game over. Commit relacionado: 0a636223c1da4c83a818a79a2bfab42878d2be75

Observação final: <a href="https://www.youtube.com/watch?v=dQw4w9WgXcQ">Link Relevante</a>

## 02/06/2020

A equipe começou a criar o padrão strategy para os movimentos dos fantasmas, já criando o padrão de lógica aleatório para a inteligência dos fantasmas. Ao implementá-lo, geramos alguns bugs que serão resolvidos posteriormente. Commit Relacionado: 6bdad35c85cfea152aa65857b64cd7ac40425dfa

O primeiro streamer foi o @AleMarquis, nesse "round" foi criado a interface de Movimentos para os fantasmas e uma classe que a implementa com o padrão pseudo-aleatório. Commit Relacionado: 6bdad35c85cfea152aa65857b64cd7ac40425dfa

O segundo streamer foi o @febagni, nesse "round" foi implementado uma lógica para a estratégia dos fantasmas. Seu movimento pseudo-aleatório foi continuado a ser desenvolvido e geramos alguns bugs na detecção de paredes. Commit Relacionado: 93172d8a3367c0e41c6b58015991be86d030cb6f

Observações Finais: 

O bug provavelmente foi relacionado à falta de setar o mapa de objetos para os fantasmas, que ao tentar acessar uma posição no grid, recebem um NullPointerException

<a href="https://www.youtube.com/watch?v=IF7g1mWOpUA">Link Relevante</a>

## 03/06/2020

O primeiro streamer foi o @guazco e nesse "round", o grupo arrumou o bug da movimentação dos fantasmas, fazendo com que eles conseguissem fazer o movimento aleatória implementado anteriormente. Commit relacionado: 5c03b5991fc5820af8fc402a287402505275c252

O segundo streamer foi o @GabrielKishida e nesse "round", foi implementada a estratégia de movimentação DumbFollow, fazendo os fantasmas com essa estratégia de movimentação seguir o pacman, a DumbFollow é subclasse da classe abstrata FollowMovement, criada para implementar a interface de movimentos dos fantasmas. Foi criada a rotina de reset das posições dos fantasmas. Commit relacionado: d053f25ea2a5d805d341665d72a83c015d7e159f

Observações finais:   
<a href="https://www.youtube.com/watch?v=O-_gK7rPpcg">Link Relevante</a>

## 04/06/2020

O primeiro streamer foi o @AleMarquis e nesse "round" o grupo criou a movimentação em que o fantasma foge do jogador. Commit relacionado: 18200c2e05954a5401b57f937e4dc3c37d3bd97e 
O segundo streamer foi o @febagni e nesse "round" o grupo adicionou novas cores para  os fantasmas e ferramentas necessárias para as estratégias, criando um problema no FPS em consequência. Commit relacionado: 86b0b512debe09fa2911e71b2106daab890e4a81

## 05/06/2020

O primeiro streamer foi o @GabrielKishida e nesse "round" o grupo fez a mistura de movimentos do fantasmas para diferentes cores e fantasmas.Commit relacionado: 70bcc7997b8b138610d8f31ad41ab9e9a7d893c7
O segundo streamer foi o @guazco e nesse "round" o grupo continuou com os testes para criação do menu do jogo, foi feito tudo na branch menu. Commit relacionado: b09840d40499aefb935f0761a1020bf9ccdb0192

## 08/06/2020

O primeiro streamer foi o @febagni e nesse "round" o grupo criou uma nova Fábrica Abstrata para os diferentes tipos de mapas. Commit relacionado: 9fe05d2d40a8f18c827510eb0c9aec38c547bc9e
O segundo streamer foi o @AleMarquis e nesse "round" o grupo adicionou um fábrica abstrata inicial para o "look and feel". Commit relacionado: ea7e4b6e472e62cc08b5aca34df12cf79ac63294

## 09/06/2020

O primeiro streamer foi o @guazco e nesse "round" o grupo criou um jeito de gerenciar os sprites. Commit Relacionado: cd20d4da941aea4d34d4b11fa9329f8471e14f23
O segundo streamer foi o @GabrielKishida e nesse "round" o grupo terminou a fábrica abstrata para mudar o "look and feel" de acordo com o tema. Commit relacionado: 38c928218dad480570c358a297b981fa93ceebd0

## 10/06/2020

Cada um fez um dos pacotes de sprites para looks and feels diferentes. Utilizando de ferramentas para fazer pixel art. 

## 11/06/2020

O primeiro streamer foi o @AleMarquis e nesse "round" foi feito a primeira parte do refatoração do código. Commit Relacionado: e30e8d4c96159c3717d8e1a0407879b795262654
O segundo streamer foi o @febagni e nesse "round" foi feito a segunda e última parte da refatoração do código. Commit Relacionado:2ed0bfc8fbe6943505c2765bc6d89644c20da3cd

Observações Finais: 
<a href="https://www.youtube.com/watch?v=688OPQ9WFpA"/>Link Relevante</a>