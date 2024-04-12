package ProjetoFinalFluxoDeCaixaEControleDeEstoque;

import javax.swing.*;
import java.util.HashMap;

public class Menu {

    public static int gestaoDeEstoque = 0;

    public static int fluxoDeCaixa = 1;

    public static int sairDoSistema = 2;



    public static int cadastrarProdutos = 0;
    public static int listarProdutos = 1;
    public static int removerProdutos = 2;
    public static int editarProdutos = 3;
    public static int voltarAoMenuInicial = 4;


    public static void menuDeGestaoDeEstoque(HashMap<Integer, Produto> estoqueDeProdutos, Produto produto, int escolhaDasOpcoesDoMenuDeGestaoDeEstoque, String nomeDoProduto, double valorDoProduto, int codigoDoProduto) {
        while (escolhaDasOpcoesDoMenuDeGestaoDeEstoque != 4)
            if (escolhaDasOpcoesDoMenuDeGestaoDeEstoque == cadastrarProdutos) {

                nomeDoProduto = JOptionPane.showInputDialog(null, "Qual o nome do produto?");
                valorDoProduto = Double.parseDouble(JOptionPane.showInputDialog(null, "Qual o valor desse produto?"));
                codigoDoProduto = codigoDoProduto + 1;


                boolean produtoJaCadastrado = Verificacao.verificarSeProdutoEstaCadastrado(estoqueDeProdutos, nomeDoProduto);


                if (produtoJaCadastrado == true) {
                    do {
                        JOptionPane.showMessageDialog(null, "O produto que será adicionado já foi cadastrado. Por favor, insira um novo produto!");
                        nomeDoProduto = JOptionPane.showInputDialog(null, "Qual o nome do produto?");
                        valorDoProduto = Double.parseDouble(JOptionPane.showInputDialog(null, "Qual o valor desse produto?"));

                        produtoJaCadastrado = Verificacao.verificarSeProdutoEstaCadastrado(estoqueDeProdutos, nomeDoProduto);
                    } while (produtoJaCadastrado == true);

                    produto = new Produto(nomeDoProduto, valorDoProduto, codigoDoProduto);

                    GerenciadorDeEstoque.cadastrarProduto(estoqueDeProdutos, produto);

                    JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");

                } else {
                    produto = new Produto(nomeDoProduto, valorDoProduto, codigoDoProduto);

                    GerenciadorDeEstoque.cadastrarProduto(estoqueDeProdutos, produto);

                    JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
                }


                int adicinarNovoProduto = JOptionPane.showConfirmDialog(null, "Deseja adicionar mais produtos?");

                do {
                    if (adicinarNovoProduto == JOptionPane.YES_OPTION) {

                        nomeDoProduto = JOptionPane.showInputDialog(null, "Qual o nome do produto?");
                        valorDoProduto = Double.parseDouble(JOptionPane.showInputDialog(null, "Qual o valor desse produto?"));
                        codigoDoProduto = codigoDoProduto + 1;

                        produtoJaCadastrado = Verificacao.verificarSeProdutoEstaCadastrado(estoqueDeProdutos, nomeDoProduto);

                        if (produtoJaCadastrado == true) {
                            do {
                                JOptionPane.showMessageDialog(null, "O produto que será adicionado já foi cadastrado. Por favor, insira um novo produto!");
                                nomeDoProduto = JOptionPane.showInputDialog(null, "Qual o nome do produto?");
                                valorDoProduto = Double.parseDouble(JOptionPane.showInputDialog(null, "Qual o valor desse produto?"));

                                produtoJaCadastrado = Verificacao.verificarSeProdutoEstaCadastrado(estoqueDeProdutos, nomeDoProduto);
                            } while (produtoJaCadastrado == true);

                            produto = new Produto(nomeDoProduto, valorDoProduto, codigoDoProduto);

                            GerenciadorDeEstoque.cadastrarProduto(estoqueDeProdutos, produto);

                            JOptionPane.showMessageDialog(null, "Produto novo cadastrado com sucesso!");

                            adicinarNovoProduto = JOptionPane.showConfirmDialog(null, "Deseja adicionar mais produtos?");

                        } else {
                            produto = new Produto(nomeDoProduto, valorDoProduto, codigoDoProduto);

                            GerenciadorDeEstoque.cadastrarProduto(estoqueDeProdutos, produto);

                            JOptionPane.showMessageDialog(null, "Produto novo cadastrado com sucesso!");

                            adicinarNovoProduto = JOptionPane.showConfirmDialog(null, "Deseja adicionar mais produtos?");
                        }


                    } else {
                        JOptionPane.showMessageDialog(null, "Retornando ao menu principal");
                    }
                } while (adicinarNovoProduto == JOptionPane.YES_OPTION);

                String[] opcoesDoMenuDeGestaoDeEstoque = {"Cadastrar novo produto", "Ver lista de produtos", "Remover produto", "Editar produto", "Voltar ao menu principal"};
                escolhaDasOpcoesDoMenuDeGestaoDeEstoque = JOptionPane.showOptionDialog(null, "Selecione o que deseja fazer", "Funcionalidades", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoesDoMenuDeGestaoDeEstoque, opcoesDoMenuDeGestaoDeEstoque[0]);


            } else if (escolhaDasOpcoesDoMenuDeGestaoDeEstoque == listarProdutos) {

                if (estoqueDeProdutos.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Seu estoque está vazio, adicione novos produtos");
                } else {
                    GerenciadorDeEstoque.listarProdutos(estoqueDeProdutos);
                }

                String[] opcoesDoMenuDeGestaoDeEstoque = {"Cadastrar novo produto", "Ver lista de produtos", "Remover produto", "Editar produto", "Voltar ao menu principal"};
                escolhaDasOpcoesDoMenuDeGestaoDeEstoque = JOptionPane.showOptionDialog(null, "Selecione o que deseja fazer", "Funcionalidades", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoesDoMenuDeGestaoDeEstoque, opcoesDoMenuDeGestaoDeEstoque[0]);


            } else if (escolhaDasOpcoesDoMenuDeGestaoDeEstoque == removerProdutos) {

                GerenciadorDeEstoque.listarProdutos(estoqueDeProdutos);
                codigoDoProduto = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o código do produto que você quer remover?"));

                boolean codigoParaRemocaoExiste = estoqueDeProdutos.containsKey(codigoDoProduto);


                if (!codigoParaRemocaoExiste) {

                    do {
                        JOptionPane.showMessageDialog(null, "O código que você inseriu não possui nenhum produto cadastrado nele, insira um novo código");
                        codigoDoProduto = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o código do produto que você quer remover?"));

                        codigoParaRemocaoExiste = estoqueDeProdutos.containsKey(codigoDoProduto);
                    } while (!codigoParaRemocaoExiste);

                    GerenciadorDeEstoque.removerProdutoSelecionado(estoqueDeProdutos, codigoDoProduto);

                } else {
                    GerenciadorDeEstoque.removerProdutoSelecionado(estoqueDeProdutos, codigoDoProduto);
                    JOptionPane.showMessageDialog(null, "Produto removido com sucesso!");
                }


                String[] opcoesDoMenuDeGestaoDeEstoque = {"Cadastrar novo produto", "Ver lista de produtos", "Remover produto", "Editar produto", "Voltar ao menu principal"};
                escolhaDasOpcoesDoMenuDeGestaoDeEstoque = JOptionPane.showOptionDialog(null, "Selecione o que deseja fazer", "Funcionalidades", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoesDoMenuDeGestaoDeEstoque, opcoesDoMenuDeGestaoDeEstoque[0]);


            } else if (escolhaDasOpcoesDoMenuDeGestaoDeEstoque == editarProdutos) {
                codigoDoProduto = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o código do produto você quer editar?"));




                int editarNome = 0;
                int editarValor = 1;
                int voltar = 2;


                boolean codigoParaEdicaoExiste = Verificacao.verificarSeProdutoExiste(estoqueDeProdutos, codigoDoProduto);

                if (!codigoParaEdicaoExiste) {

                    do {
                        JOptionPane.showMessageDialog(null, "O código que você inseriu não possui nenhum produto cadastrado nele, insira um novo código");
                        GerenciadorDeEstoque.listarProdutos(estoqueDeProdutos);
                        codigoDoProduto = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o código do produto que você quer editar?"));

                        codigoParaEdicaoExiste = estoqueDeProdutos.containsKey(codigoDoProduto);
                    } while (!codigoParaEdicaoExiste);


                } else {

                }


                String[] opcoesDoMenuDeEdicao = {"Nome do produto", "Editar valor", "Voltar"};
                int escolhaDeEdição = JOptionPane.showOptionDialog(null, "O que você vai editar?", "Opções para edição", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoesDoMenuDeEdicao, opcoesDoMenuDeEdicao[0]);

                while (escolhaDeEdição != 2) {
                    if (escolhaDeEdição == editarNome) {
                        GerenciadorDeEstoque.editarNomeDoProduto(estoqueDeProdutos, produto, codigoDoProduto);
                        GerenciadorDeEstoque.listarProdutos(estoqueDeProdutos);

                    } else if (escolhaDeEdição == editarValor) {
                        GerenciadorDeEstoque.editarValorDoProduto(estoqueDeProdutos, produto, codigoDoProduto);
                        GerenciadorDeEstoque.listarProdutos(estoqueDeProdutos);

                    }
                    escolhaDeEdição = JOptionPane.showOptionDialog(null, "O que você vai editar?", "Opções para edição", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoesDoMenuDeEdicao, opcoesDoMenuDeEdicao[0]);

                }

                String[] opcoesDoMenuDeGestaoDeEstoque = {"Cadastrar novo produto", "Ver lista de produtos", "Remover produto", "Editar produto", "Voltar ao menu principal"};
                escolhaDasOpcoesDoMenuDeGestaoDeEstoque = JOptionPane.showOptionDialog(null, "Selecione o que deseja fazer", "Funcionalidades", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoesDoMenuDeGestaoDeEstoque, opcoesDoMenuDeGestaoDeEstoque[0]);


            }
    }


    public static int adicionarProdutos = 0;
    public static int listaDeCompras = 1;
    public static int finalizarCompra = 2;
    public static int voltar = 3;

    public static void menuDeFluxoDeCaixa(HashMap<Integer, Produto> estoqueDeProdutos, HashMap<Integer, Produto> carrinhoDeCompras, Produto produtoParaCompra, int codigoDoProduto, int escolhaDasOpcoesDoMenuDeFluxoDeCaixa) {

        while(escolhaDasOpcoesDoMenuDeFluxoDeCaixa != 3) {
            if (escolhaDasOpcoesDoMenuDeFluxoDeCaixa == adicionarProdutos) {

                GerenciadorDeEstoque.listarProdutos(estoqueDeProdutos);

                codigoDoProduto = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o código do produto que deseja comprar?"));

                boolean codigoParaCompraExiste = Verificacao.verificarSeProdutoExiste(estoqueDeProdutos, codigoDoProduto);

                if (!codigoParaCompraExiste) {

                    do {
                        JOptionPane.showMessageDialog(null, "O código que você inseriu não possui nenhum produto cadastrado nele, insira um novo código");
                        GerenciadorDeEstoque.listarProdutos(estoqueDeProdutos);
                        codigoDoProduto = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o código do produto que deseja comprar?"));

                        codigoParaCompraExiste = estoqueDeProdutos.containsKey(codigoDoProduto);
                    } while (!codigoParaCompraExiste);


                } else {

                }


                produtoParaCompra = estoqueDeProdutos.get(codigoDoProduto);

                FluxoDeCaixa.adicionarAoCarrinho(estoqueDeProdutos, carrinhoDeCompras, produtoParaCompra, codigoDoProduto);

                String[] opcoesDoMenuDeFluxoDeCaixa = {"Adicionar produto", "Carrinho","Finalizar compra", "Voltar"};
                escolhaDasOpcoesDoMenuDeFluxoDeCaixa = JOptionPane.showOptionDialog(null, "Selecione o que deseja fazer", "Funcionalidades", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoesDoMenuDeFluxoDeCaixa, opcoesDoMenuDeFluxoDeCaixa[0]);

            } else if (escolhaDasOpcoesDoMenuDeFluxoDeCaixa == listaDeCompras) {

                FluxoDeCaixa.carrinhoDeCompras(carrinhoDeCompras);
                JOptionPane.showMessageDialog(null, "Sua carrinho de compras possui um total de R$" + FluxoDeCaixa.calcularTotalValorProdutos(carrinhoDeCompras));


                String[] opcoesDoMenuDeFluxoDeCaixa = {"Adicionar produto", "Carrinho","Finalizar compra", "Voltar"};
                escolhaDasOpcoesDoMenuDeFluxoDeCaixa = JOptionPane.showOptionDialog(null, "Selecione o que deseja fazer", "Funcionalidades", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoesDoMenuDeFluxoDeCaixa, opcoesDoMenuDeFluxoDeCaixa[0]);

            }else if(escolhaDasOpcoesDoMenuDeFluxoDeCaixa == finalizarCompra){

                FluxoDeCaixa.carrinhoDeCompras(carrinhoDeCompras);

                JOptionPane.showMessageDialog(null, "Sua compra deu um total de R$" + FluxoDeCaixa.calcularTotalValorProdutos(carrinhoDeCompras));

                int confirmarCompra = JOptionPane.showConfirmDialog(null,"Deseja finalizar compra?");

                if(confirmarCompra == JOptionPane.YES_OPTION){
                    JOptionPane.showMessageDialog(null,"Obrigado por comprar conosco!");

                    String[] opcoesDoMenuDeFluxoDeCaixa = {"Adicionar produto", "Carrinho","Finalizar compra", "Voltar"};
                    escolhaDasOpcoesDoMenuDeFluxoDeCaixa = JOptionPane.showOptionDialog(null, "Selecione o que deseja fazer", "Funcionalidades", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoesDoMenuDeFluxoDeCaixa, opcoesDoMenuDeFluxoDeCaixa[0]);

                }else{

                    String[] opcoesDoMenuDeFluxoDeCaixa = {"Adicionar produto", "Carrinho","Finalizar compra", "Voltar"};
                    escolhaDasOpcoesDoMenuDeFluxoDeCaixa = JOptionPane.showOptionDialog(null, "Selecione o que deseja fazer", "Funcionalidades", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoesDoMenuDeFluxoDeCaixa, opcoesDoMenuDeFluxoDeCaixa[0]);
                }
            }



        }




    }


}



