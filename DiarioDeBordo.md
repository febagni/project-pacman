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

O primeiro streamer foi o @GabrielKishida, em que utilizamos de algumas técnicas de debug para encontrar onde a matriz estava sendo transposta, o bug foi encontrado e resolvido. Nesse "round" nós também formatamos as classes já existentes.

O segundo streamer foi o @AleMarquis, durante esse "round" foram feitos os desenhos dos sprites, a inserção dos mesmos no JFrame para o mapa. Também procuramos formas de indicar o path das imagens no código, colocando as imagens dentro de umapasta, mas não encontramos um jeito que funcionou de acordo com nossos interesses. 

Uma observação final é que o FPS da JFrame caiu consideravelmente, pois estamos renderizando cada imagem continuamente na JFrame. Isso ainda precisa ser resolvido. 
