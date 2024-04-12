package ProjetoFinalFluxoDeCaixaEControleDeEstoque;

import javax.swing.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null,"Seja bem vindo ao Controle de Estoque e Fluxo de Caixa");



        HashMap<Integer,Produto> estoqueDeProdutos = new HashMap<>();
        HashMap<Integer, Produto> carrinhoDeCompras = new HashMap<>();
        Produto produto = new Produto();

        String nomeDoProduto = "";
        double valorDoProduto = 0.0;
        int codigoDoProduto = 0;



        String[] opcoesDoMenuInicial = {"Gestão de Estoque", "Fluxo de Caixa", "Sair"};

        int escolhaDasOpcoesDoMenu = JOptionPane.showOptionDialog(null, "Selecione o que deseja", "Ferramentas", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoesDoMenuInicial, opcoesDoMenuInicial[0]);

        while (escolhaDasOpcoesDoMenu != 2) {
            if (escolhaDasOpcoesDoMenu == Menu.gestaoDeEstoque) {

                String[] opcoesDoMenuDeGestaoDeEstoque = {"Cadastrar novo produto", "Ver lista de produtos", "Remover produto","Editar produto","Voltar ao menu principal"};

                int escolhaDasOpcoesDoMenuDeGestaoDeEstoque = JOptionPane.showOptionDialog(null, "Selecione o que deseja fazer", "Funcionalidades", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoesDoMenuDeGestaoDeEstoque, opcoesDoMenuDeGestaoDeEstoque[0]);

                Menu.menuDeGestaoDeEstoque(estoqueDeProdutos,produto,escolhaDasOpcoesDoMenuDeGestaoDeEstoque,nomeDoProduto,valorDoProduto,codigoDoProduto);


            } else if (escolhaDasOpcoesDoMenu == Menu.fluxoDeCaixa) {

                String[] opcoesDoMenuDeFluxoDeCaixa = {"Adicionar produto", "Carrinho","Finalizar compra", "Voltar"};

                int escolhaDasOpcoesDoMenuDeFluxoDeCaixa = JOptionPane.showOptionDialog(null, "Selecione o que deseja fazer", "Funcionalidades", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoesDoMenuDeFluxoDeCaixa, opcoesDoMenuDeFluxoDeCaixa[0]);

                Menu.menuDeFluxoDeCaixa(estoqueDeProdutos,carrinhoDeCompras,produto,codigoDoProduto,escolhaDasOpcoesDoMenuDeFluxoDeCaixa);
            }
            escolhaDasOpcoesDoMenu = JOptionPane.showOptionDialog(null, "Selecione o que deseja", "Ferramentas", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoesDoMenuInicial, opcoesDoMenuInicial[0]);
        }


        JOptionPane.showMessageDialog(null, "Obrigado por utilizar o nosso sistema!");
    }
}