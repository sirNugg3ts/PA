package sequencias.logica.estados;


import sequencias.logica.Situacao;

public interface IEstado{

   //Transicoes
   IEstado comecar();
   IEstado recolher(int indice);
   IEstado relancar();
   IEstado avaliar();
   IEstado terminar();


   Situacao getSituacaoAtual();
}
