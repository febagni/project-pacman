# Diário de Bordo   

## Introdução   

A ideia desse arquivo é documentar as reuniões feitas pelos integrantes do grupo e especificar o que foi feito em cada e por quem. A ideia é usar a técnica do "Dojo" para programação.   

Assim, nos conectamos em um servidor da plataforma Discord, pela qual todos os integrantes se comunicam por meio de um canal de voz e texto. Em cada sessão dois dos quatro integrantes compartilham a tela (para facilitar a documentação, a pessoa que compartilha a tela será chamada de Streamer), um seguido do outro e ambos com limite de tempo definido, enquanto os outros sugerem o que deve ser feito no desenvolvimento de projeto.

## 12/05/2020   

As observações iniciais foram a respeito da organização das sessões de Dojo e as resoluções estão supracitadas.   
O primeiro Streamer foi o @AleMarquis e durante esse "round" foram criadas as classes: MapReader, na qual fazemos a leitura de um arquivo .txt que contém o mapa do jogo e guardamos o conteúdo; WrongMapFormatException, para tratar das excessões de fomrato inválido do mapa, ou seja, sem consistência no tamanho das linhas.

O segundo Stramer foi o @GabrielKishida, nesse "round" foi feita a classe MapBuilder, que abstrai a criação do mapa do jogo a partir do MapReader. Também foi feita a interface GameObject, que representa os elementos do jogo. A classe abstrata MapObject implementa a interface GameObject e suas subclasses são elementos estáticos para compor o mapa.   