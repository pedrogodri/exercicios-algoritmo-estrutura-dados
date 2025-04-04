import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.listaEncadeada.ListaEncadeada;

public class ListaEncadeadaTeste {
    private ListaEncadeada<Integer> lista;

    @BeforeEach
    public void setUp() {
        lista = new ListaEncadeada<>();
    }

    @Test
    public void testListaVazia() {
        assertTrue(lista.estaVazia());
    }

    @Test
    public void testListaNaoVazia() {
        lista.inserir(5);
        assertFalse(lista.estaVazia());
    }

    @Test
    public void testInserirNumero() {
        lista.inserir(5);
        assertEquals("5", lista.toString());
    }

    @Test
    public void testInserirTresNumeros() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        assertEquals("15,10,5", lista.toString());
    }

    @Test
    public void testBuscarPrimeiraPosicao() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        assertEquals(20, lista.buscar(20).getInfo());
    }

    @Test
    public void testBuscarMeioLista() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        assertEquals(15, lista.buscar(15).getInfo());
    }

    @Test
    public void testBuscarDadoInexistente() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        assertNull(lista.buscar(50));
    }

    @Test
    public void testExcluirPrimeiroElemento() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.retirar(20);
        assertEquals("15,10,5", lista.toString());
    }

    @Test
    public void testExcluirElementoMeioLista() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.retirar(15);
        assertEquals("20,10,5", lista.toString());
    }

    @Test
    public void testObterNoPosicaoZero() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        assertEquals(20, lista.obterNo(0).getInfo());
    }

    @Test
    public void testObterNoUltimaPosicao() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        assertEquals(5, lista.obterNo(3).getInfo());
    }

    @Test
    public void testObterNoPosicaoInvalida() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        assertThrows(IndexOutOfBoundsException.class, () -> lista.obterNo(10));
    }

    @Test
    public void testObterComprimentoListaVazia() {
        assertEquals(0, lista.obterComprimento());
    }

    @Test
    public void testObterComprimentoListaNaoVazia() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        assertEquals(4, lista.obterComprimento());
    }
}
