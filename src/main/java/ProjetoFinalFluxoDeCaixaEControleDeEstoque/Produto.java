package ProjetoFinalFluxoDeCaixaEControleDeEstoque;

public class Produto {

    private String nomeDoProduto;

    private double valorDoProduto;

    private int códigoDoProduto;

    public Produto(){}

    public Produto(String nomeDoProduto, double valorDoProduto, int códigoDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
        this.valorDoProduto = valorDoProduto;
        this.códigoDoProduto = códigoDoProduto;
    }


    public void setCodigoDoProduto(int códigoDoProduto) {
        this.códigoDoProduto = códigoDoProduto;
    }

    public void setNomeDoProduto(String nomeDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
    }

    public void setValorDoProduto(double valorDoProduto) {
        this.valorDoProduto = valorDoProduto;
    }

    public String getNomeDoProduto() {
        return nomeDoProduto;
    }

    public double getValorDoProduto() {
        return valorDoProduto;
    }

    public int getCodigoDoProduto() {
        return códigoDoProduto;
    }

    @Override
    public String toString() {
        return  nomeDoProduto + " custa R$ " + String.format("%.2f",valorDoProduto);
    }
}