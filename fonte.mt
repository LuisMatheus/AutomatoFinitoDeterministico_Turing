@INICIAR MAQUINA
fita 1,1,1,1
states qi,q1,q2,qf
init qi
final qf

@[ORIGEM,VALOR_TRANSICAO,DESTINO,ESCREVER,ACAO]
qi,1,q1,0,>
q1,1,q2,*,>
q2,1,qf,0,>