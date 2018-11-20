package microservices.venda.domain.venda;

import microservices.client.CarroService;
import microservices.domain.venda.VendaService;
import microservices.venda.VendaServerTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

public class VendaServiceTest extends VendaServerTest {

    @Autowired
    private VendaService vendaService;

    @MockBean
    private CarroService carroService;

    @Test
    public void testVender() {
        given(carroService.buscarCarro(any())).willReturn("Maria");
        assertEquals(Double.valueOf("500"), vendaService.vender());
    }
}
