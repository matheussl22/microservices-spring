package microservices.domain.venda;

import microservices.client.CarroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
class VendaServiceImpl implements VendaService {

    private CarroService carroService;

    @Autowired
    public VendaServiceImpl(CarroService carroService) {
        this.carroService = carroService;
    }

    @Override
    public String vender() {
        String carro = carroService.buscarCarro(1L);
        log.info(carro);
        return carro;
    }
}
