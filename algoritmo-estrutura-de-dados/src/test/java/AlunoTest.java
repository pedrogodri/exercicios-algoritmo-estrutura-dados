

import com.example.mapaDispersao.*;
import com.example.mapaDispersao.aluno.Aluno;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class AlunoTest {

    @Test
    public void testInserirEBuscarUmAluno() {
        MapaDispersao<Aluno> mapa = new MapaDispersao<>(53);
        Aluno aluno = new Aluno(12000, "Jean", LocalDate.of(2000, 1, 1));
        mapa.inserir(aluno.getMatricula(), aluno);

        Aluno resultado = mapa.buscar(12000);
        assertSame(aluno, resultado, "Deve retornar a mesma instância de Aluno inserida");
    }

    @Test
    public void testInserirEBuscarVariosAlunos() {
        MapaDispersao<Aluno> mapa = new MapaDispersao<>(53);
        Aluno a1 = new Aluno(12000, "Jean", LocalDate.of(2000, 1, 1));
        Aluno a2 = new Aluno(14000, "Pedro", LocalDate.of(1999, 1, 20));
        Aluno a3 = new Aluno(12500, "Marta", LocalDate.of(2001, 2, 18));
        Aluno a4 = new Aluno(13000, "Lucas", LocalDate.of(1998, 11, 25));

        mapa.inserir(a1.getMatricula(), a1);
        mapa.inserir(a2.getMatricula(), a2);
        mapa.inserir(a3.getMatricula(), a3);
        mapa.inserir(a4.getMatricula(), a4);

        assertSame(a1, mapa.buscar(12000));
        assertSame(a2, mapa.buscar(14000));
        assertSame(a3, mapa.buscar(12500));
        assertSame(a4, mapa.buscar(13000));
    }

    @Test
    public void testInserirEBuscarComColisao() {
        MapaDispersao<Aluno> mapa = new MapaDispersao<>(53);
        Aluno a1 = new Aluno(12000, "Jean", LocalDate.of(2000, 1, 1));
        Aluno a2 = new Aluno(14000, "Pedro", LocalDate.of(1999, 1, 20));
        Aluno a3 = new Aluno(14226, "Marta", LocalDate.of(2001, 2, 18)); // colide com 12000
        Aluno a4 = new Aluno(17180, "Lucas", LocalDate.of(1998, 11, 25)); // colide com 14000

        mapa.inserir(a1.getMatricula(), a1);
        mapa.inserir(a2.getMatricula(), a2);
        mapa.inserir(a3.getMatricula(), a3);
        mapa.inserir(a4.getMatricula(), a4);

        assertSame(a1, mapa.buscar(12000));
        assertSame(a2, mapa.buscar(14000));
        assertSame(a3, mapa.buscar(14226));
        assertSame(a4, mapa.buscar(17180));
    }
}
