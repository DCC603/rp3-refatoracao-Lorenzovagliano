import java.util.ArrayList;
import java.util.List;

public class Conta {

    private Cliente cliente;

    private DadosConta dadosConta;

    private double saldo;

    private List<Operacao> operacoes;

    public Conta(String nomeCliente, String cpfCliente, String telefoneCliente,
                 int numAgencia, int numConta, String gerente, double valorInicial) {

        this.cliente = new Cliente(nomeCliente, cpfCliente, telefoneCliente);
        this.dadosConta = new DadosConta(numAgencia, numConta, gerente);
        this.saldo = valorInicial;
        this.operacoes = new ArrayList<>();
    }

    public Conta() {
        this(null, null, null, 0, 0, null, 0.0);
    }

    public void realizarOperacao(char tipo, int valor) {
        if (TipoOperacao.DEPOSITO.getCodigo() == tipo) {
            depositar(valor);
        } else if (TipoOperacao.SAQUE.getCodigo() == tipo) {
            sacar(valor);
        } else {
            throw new IllegalArgumentException("Tipo de operação inválido: " + tipo);
        }
    }

    private void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de depósito deve ser positivo.");
        }

        Operacao op = new Operacao(TipoOperacao.DEPOSITO, valor);
        registrarOperacao(op);
        this.saldo += valor;
    }

    private void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de saque deve ser positivo.");
        }

        Operacao op = new Operacao(TipoOperacao.SAQUE, valor);
        registrarOperacao(op);
        this.saldo -= valor;
    }

    private void registrarOperacao(Operacao op) {
        this.operacoes.add(op);
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public DadosConta getDadosConta() {
        return dadosConta;
    }

    public List<Operacao> getOperacoes() {
        return new ArrayList<>(operacoes);
    }

    @Override
    public String toString() {
        String dadosCliente = this.cliente.toString();
        String dadosConta = this.dadosConta.formatarComSaldo(this.saldo);
        String dadosExtrato = Extrato.formatar(this.operacoes);

        return "-----CLIENTE-----\n" +
                dadosCliente +
                "\n\n" +
                "-----CONTA-----\n" +
                dadosConta +
                "\n\n" +
                "-----EXTRATO-----\n" +
                dadosExtrato +
                "\n";
    }
}
