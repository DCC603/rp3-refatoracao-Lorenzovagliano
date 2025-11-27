public class Operacao {

    private TipoOperacao tipo;
    private double valor;

    public Operacao(TipoOperacao tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public Operacao(char tipo, double valor) {
        this(TipoOperacao.fromCodigo(tipo), valor);
    }

    public String getTipo() {
        return (this.tipo != null) ? this.tipo.getDescricao() : null;
    }

    public TipoOperacao getTipoOperacao() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return this.getTipo() + ":\t" + this.valor;
    }
}
