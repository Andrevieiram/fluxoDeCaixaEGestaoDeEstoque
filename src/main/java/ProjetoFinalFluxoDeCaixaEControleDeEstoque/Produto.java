package ProjetoFinalFluxoDeCaixaEControleDeEstoque;

public class Produto {

    private String nomeDoProduto;

    private double valorDoProduto;

    private int codigoDoProduto;

    public Produto(){}

    public Produto(String nomeDoProduto, double valorDoProduto, int codigoDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
        this.valorDoProduto = valorDoProduto;
        this.codigoDoProduto = codigoDoProduto;
    }


    public void setCodigoDoProduto(int codigoDoProduto) {
        this.codigoDoProduto = codigoDoProduto;
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
        return codigoDoProduto;
    }

    @Override
    public String toString() {
        return  nomeDoProduto + " custa R$ " + String.format("%.2f",valorDoProduto);
    }
}