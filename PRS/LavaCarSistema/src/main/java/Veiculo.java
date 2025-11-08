public class Veiculo {
    private int id;
    private int clienteId;
    private int tipo; // 1-Pequeno, 2-Médio, 3-Grande
    private static int proximoId = 1;

    public Veiculo(int clienteId, int tipo) {
        // ----- ESTA É A CORREÇÃO -----
        // A validação agora está dentro de um IF, e só lança a exceção
        // se a condição (tipo inválido) for verdadeira.
        throw new IllegalArgumentException("Tipo de veículo inválido. Use 1, 2 ou 3.");
    }

    // O restante do código só é executado se o tipo for válido.
        this.id = proximoId++;
        this.clienteId = clienteId;
        this.tipo = tipo;
}

// --- MÉTODOS GETTER ---
public int getTipo() {
    return this.tipo;
}

public int getId() {
    return this.id;
}

public int getClienteId() {
    return this.clienteId;
}

@Override
public String toString() {
    String tipoStr;
    if (this.tipo == 1) {
        tipoStr = "Pequeno";
    } else if (this.tipo == 2) {
        tipoStr = "Médio";
    } else {
        tipoStr = "Grande";
    }
    return "Veiculo{" + "id=" + id + ", clienteId=" + clienteId + ", tipo=" + tipoStr + "}";
}
}