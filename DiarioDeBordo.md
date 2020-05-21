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
