package microservices.domain.carro;

import microservices.carro.CarroServerTest;
import microservices.carro.domain.CarroService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class CarroServiceTest extends CarroServerTest {

    @Autowired
    private CarroService carroService;

    @Test
    public void testFindById() {
        assertEquals("João", carroService.buscarPorId(1L));
        assertEquals("Maria", carroService.buscarPorId(2L));
    }
}