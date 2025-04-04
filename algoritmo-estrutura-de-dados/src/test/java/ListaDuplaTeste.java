import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.listaDuplamenteEncadeada.ListaDupla;
import com.example.listaDuplamenteEncadeada.NoListaDupla;

public class ListaDuplaTeste {
    private ListaDupla<Integer> lista;

    @BeforeEach
    public void setUp() {
        lista = new ListaDupla<>();
    }

    @Test
    public void testInserir() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals("20, 15, 10, 5", lista.toString());

        lista.exibirOrdemInversa(); 
    }

    @Test
    public void testBuscarElementoInicio() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoListaDupla<Integer> resultado = lista.buscar(20);
        assertNotNull(resultado);
        assertEquals(20, resultado.getInfo());
    }

    @Test
    public void testBuscarElementoMeio() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoListaDupla<Integer> resultado = lista.buscar(10);
        assertNotNull(resultado);
        assertEquals(10, resultado.getInfo());
    }

    @Test
    public void testRemoverElementoInicio() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(20);

        assertEquals("15, 10, 5", lista.toString());
    }

    @Test
    public void testRemoverElementoMeio() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(10);

        assertEquals("20, 15, 5", lista.toString());
    }

    @Test
    public void testRemoverElementoFim() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(5);

        assertEquals("20, 15, 10", lista.toString());
    }

    @Test
    public void testLiberar() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.liberar();

        NoListaDupla<Integer> resultado = lista.buscar(5);
        assertNull(resultado);

        NoListaDupla<Integer> primeiro = lista.getPrimeiro();
        assertNull(primeiro);
    }
}
