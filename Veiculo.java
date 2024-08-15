package concessionaria;

public class Veiculo {
    private String placa;
    private int ano;
    private String marca;
    private String modelo;
    private String cor;
    private String proprietario;
    private double preco;
    
    public Veiculo(String placa, int ano, String marca, String modelo, String cor, String proprietario, double preco) {
        this.placa = placa;
        this.ano = ano;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.proprietario = proprietario;
        this.preco = preco;
    }

    // Gets e sets para acessar as informações do veículo
    public String getPlaca() {
        return placa;
    }
    public int getAno() {
        return ano;
    }
    public String getMarca() {
        return marca;
    }
    public String getModelo() {
        return modelo;
    }
    public String getCor() {
        return cor;
    }
    public String getProprietario() {
        return proprietario;
    }
    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

    //para representar a classe "veículo" como uma string e facilitar o acesso na classe principal
    @Override
    public String toString() {
        return "Placa: " + placa + ", Ano: " + ano + ", Marca: " + marca + ", Modelo: " + modelo + 
               ", Cor: " + cor + ", Proprietário: " + proprietario + ", Preço: " + preco;
    }
}