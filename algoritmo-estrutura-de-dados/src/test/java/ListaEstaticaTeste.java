import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.listaEstatica.ListaEstaticaGenerica;

public class ListaEstaticaTeste {
    private ListaEstaticaGenerica lista;

    @BeforeEach
    public void setUp() {
        lista = new ListaEstaticaGenerica();
    }

    @Test
    public void testInverterPar() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        lista.inverter();
        
        assertEquals("20,15,10,5", lista.toString());
    }

    @Test
    public void testInverterImpar() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.inserir(25);
        
        lista.inverter();
        
        assertEquals("25,20,15,10,5", lista.toString());
    }
}
