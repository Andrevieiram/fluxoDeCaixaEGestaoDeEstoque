package ProjetoFinalFluxoDeCaixaEControleDeEstoque;

import javax.swing.*;
import java.util.*;


public class FluxoDeCaixa {

    public static void adicionarAoCarrinho(HashMap<Integer, Produto> estoqueDeProdutos, HashMap<Integer, Produto> carrinhoDeCompras,Produto produtoParaCompra, int codigoDoProduto){

        boolean verificarSeProdutoParaCompraExiste = Verificacao.verificarSeProdutoExiste(estoqueDeProdutos,codigoDoProduto);


        if (!verificarSeProdutoParaCompraExiste) {
            do {
                JOptionPane.showMessageDialog(null, "Produto não existe no seu estoque, insira um código de produto existente");
                GerenciadorDeEstoque.listarProdutos(estoqueDeProdutos);
                codigoDoProduto = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o código do produto você quer comprar?"));
                verificarSeProdutoParaCompraExiste = Verificacao.verificarSeProdutoExiste(estoqueDeProdutos, codigoDoProduto);

            }while(verificarSeProdutoParaCompraExiste == false);

            produtoParaCompra = estoqueDeProdutos.get(codigoDoProduto);
            carrinhoDeCompras.put(codigoDoProduto, produtoParaCompra);
            JOptionPane.showMessageDialog(null, "Produto adicionado ao carrinho com sucesso");

        } else {
            produtoParaCompra = estoqueDeProdutos.get(codigoDoProduto);
            carrinhoDeCompras.put(codigoDoProduto, produtoParaCompra);
            JOptionPane.showMessageDialog(null, "Produto adicionado ao carrinho com sucesso");

        }

    }


    public static void carrinhoDeCompras( HashMap<Integer, Produto> carrinhoDeCompras){
        String listaDeProdutosParaCompra = "";
        for (Map.Entry<Integer,Produto> listaParaCompra : carrinhoDeCompras.entrySet()){
            listaDeProdutosParaCompra += listaParaCompra.getValue().getCodigoDoProduto() + ". " + listaParaCompra.getValue().getNomeDoProduto() + " R$" + listaParaCompra.getValue().getValorDoProduto() + "\n";
        }
        JOptionPane.showMessageDialog(null,listaDeProdutosParaCompra);
    }


    public static double calcularTotalValorProdutos(Map<Integer, Produto> carrinhoDeCompras) {
        double total = 0.0;
        for (Produto produto : carrinhoDeCompras.values()) {
            total += produto.getValorDoProduto();
        }
        return total;
    }
}




