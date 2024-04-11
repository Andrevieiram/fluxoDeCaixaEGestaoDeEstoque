package ProjetoFinalFluxoDeCaixaEControleDeEstoque;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class GerenciadorDeEstoque {


    public GerenciadorDeEstoque(){}


    public static void cadastrarProduto(HashMap<Integer,Produto> estoqueDeProdutos, Produto produtoNovo){
        estoqueDeProdutos.put(produtoNovo.getCodigoDoProduto(),produtoNovo);

    }

    public static void editarNomeDoProduto (HashMap<Integer,Produto> estoqueDeProdutos, Produto nomeDoProdutoModificado,int codigoDoProduto){
        String novoNome = JOptionPane.showInputDialog(null,"Qual vai ser o novo nome desse produto?");
        nomeDoProdutoModificado = estoqueDeProdutos.get(codigoDoProduto);
        nomeDoProdutoModificado.setNomeDoProduto(novoNome);

    }

    public static void editarValorDoProduto (HashMap<Integer,Produto> estoqueDeProdutos, Produto valorDoProdutoModificado, int codigoDoProduto){
        double novoValor = Double.parseDouble(JOptionPane.showInputDialog(null,"Qual vai ser o novo valor desse produto?"));
        valorDoProdutoModificado = estoqueDeProdutos.get(codigoDoProduto);
        valorDoProdutoModificado.setValorDoProduto(novoValor);

    }

    public static void listarProdutos(HashMap<Integer, Produto> estoqueDeProdutos){
        String listaCompleta = "";
        for (Map.Entry<Integer,Produto> produto : estoqueDeProdutos.entrySet()){
            listaCompleta += produto.getValue().getCodigoDoProduto() + ". " + produto.getValue().getNomeDoProduto() + " R$" + produto.getValue().getValorDoProduto() + "\n";
        }
        JOptionPane.showMessageDialog(null,listaCompleta);
    }

    public static void removerProdutoSelecionado(HashMap<Integer, Produto> estoqueDeProdutos, int codigoDoProduto){
        estoqueDeProdutos.remove(codigoDoProduto);


    }

    public static Produto buscarPorCodigo(HashMap<Integer, Produto> estoqueDeProdutos, int codigoDoProduto){
        Produto produtoProcurado = estoqueDeProdutos.get(codigoDoProduto);
        return produtoProcurado;
    }



}
