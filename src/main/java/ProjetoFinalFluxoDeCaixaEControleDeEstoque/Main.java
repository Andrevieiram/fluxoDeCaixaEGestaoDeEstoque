package ProjetoFinalFluxoDeCaixaEControleDeEstoque;

import javax.swing.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        HashMap<String,Double> estoqueDeProdutos = new HashMap<String,Double>();


        JOptionPane.showMessageDialog(null,"");

        String[] opcoesDoMenu = {"Gestão de Estoque","FLuxo de Caixa","Sair"};

        int escolhaDasOpcoesDoMenu = JOptionPane.showOptionDialog(null,"Seja bem vindo ao Controle de Estoque e Fluxo de Caixa", "Selecione o que deseja",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,opcoesDoMenu,opcoesDoMenu[0]);


        JOptionPane.showMessageDialog(null,estoqueDeProdutos);


    }
}