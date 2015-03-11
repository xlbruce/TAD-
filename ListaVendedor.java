package javaapplication7;

/**
 *
 * @author Gilson da Silva
 */
public class ListaVendedor {

    Vendedor[] lista;
    int qtde;

    public ListaVendedor(int capacidade) {
        lista = new Vendedor[capacidade];
        this.qtde = 0;
    }

    void iniciaLista() {
        this.qtde = 0;
    }

    boolean verCheia() {
        return this.qtde == lista.length;
    }

    boolean verVazia() {
        return this.qtde == 0;
    }

    int verTamanho() {
        return this.qtde;
    }

    void insereElemento(Vendedor v) throws Exception {
        if (verCheia()) {
            throw new Exception("Lista cheia");
        } else if (this.qtde > 0 && consultaVendedor(v) != -1) {
            throw new Exception("Vendedor já cadastrado");
        }
        lista[qtde] = v;
        qtde++;
    }

    void removeVendedor(int codigo) throws Exception {
        int indice = consultaVendedor(codigo).getCodigo();
        if (this.qtde == 0) {
            throw new Exception("Lista vazia");
        } else if (indice != codigo) {
            throw new Exception("Elemento não está na lista");
        }
        for (int i = indice; i < this.qtde; i++) {
            lista[indice] = lista[indice + 1];
        }

    }

    Vendedor maiorVenda() throws Exception {
        if (verVazia()) {
            throw new Exception("Lista está vazia - impossivel consultar");
        }
        Vendedor v = null;
        double maior = 0;
        for (int i = 0; i < this.qtde; i++) {
            if (lista[i].getValor() > maior) {
                maior = lista[i].getValor();
                v = lista[i];
            }
        }
        return v;
    }
    
    void ordena() {
        int j;
        Vendedor aux;
        for (int i = 1; i < this.qtde; i++) {
            aux = lista[i];
            for (j = i - 1; j >= 0 && aux.getNome().compareTo(lista[j].getNome()) < 0; j--) {
                lista[j + 1] = lista[j];
            }
        lista[j + 1] = aux;
        }
    }

    Vendedor menorVenda() {
        Vendedor v = null;
        double menor = 0;
        for (int i = 1; i <= this.qtde; i++) {
            if (lista[i].getValor() < lista[0].getValor()) {
                menor = lista[i].getValor();
                v = lista[i];
            }
        }
        return v;
    }

    double mediaVendas() throws Exception {
        if (verVazia()) {
            throw new Exception("Lista está vazia - impossivel consultar");
        }
        double media = 0;
        for (int i = 0; i <= this.qtde; i++) {
            media += lista[i].getValor();
        }
        media /= this.qtde;
        return media;
    }

    Vendedor consultaVendedor(int codigo) throws Exception {
        if (verVazia()) {
            throw new Exception("Lista está vazia - impossivel consultar");
        }
        for (int i = 0; i <= this.qtde; i++) {
            if (lista[i].getCodigo() == codigo) {
                return lista[i];
            }
        }
        return null;
    }

    private int consultaVendedor(Vendedor v) throws Exception {
        
        for (int i = 0; i <= this.qtde; i++) {
            if (v.getCodigo() == lista[i].getCodigo()) {
                return i;
            }
        }
        return -1;
    }

    void alteraVendedor(int código, Vendedor novo) throws Exception {
        if (verVazia()) {
            throw new Exception("Lista está vazia - impossivel consultar");
        }
        Vendedor antigo;
        int indice = consultaVendedor(novo);
        if (indice != -1) {
            lista[indice] = novo;
        }
    }

    double somaVendedor() {
        double total = 0;
        for (int i = 0; i < this.qtde; i++) {
            total += lista[i].getValor();            
        }
        return total;
    }

    void mostraLista() throws Exception {
        if (verVazia()) {
            throw new Exception("Lista está vazia - impossivel consultar");
        }
        for (int i = 0; i < this.qtde; i++) {
            lista[i].exibeDados();
            
        }

    }
}
