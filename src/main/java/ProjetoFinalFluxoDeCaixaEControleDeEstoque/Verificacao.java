package ProjetoFinalFluxoDeCaixaEControleDeEstoque;

import java.util.*;

public class Verificacao {

    public static boolean verificarSeProdutoEstaCadastrado(Map<Integer, Produto> estoqueDeProdutos, String nomeDoProduto) {
        for (Produto produto : estoqueDeProdutos.values()) {
            if (produto.getNomeDoProduto().equalsIgnoreCase(nomeDoProduto)) {
                return true;
            }
        }
        return false;
    }


    public static boolean verificarSeProdutoExiste(Map<Integer, Produto> estoqueDeProdutos, int codigoDoProduto) {
        return estoqueDeProdutos.containsKey(codigoDoProduto);
    }
}

