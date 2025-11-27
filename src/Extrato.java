import java.util.List;

public final class Extrato {

    private Extrato() {
    }

    public static String formatar(List<Operacao> operacoes) {
        StringBuilder dadosExtrato = new StringBuilder();
        for (Operacao op : operacoes) {
            dadosExtrato.append(op.toString()).append("\n");
        }
        return dadosExtrato.toString();
    }
}
