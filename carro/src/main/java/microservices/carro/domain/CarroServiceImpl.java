package microservices.carro.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
class CarroServiceImpl implements CarroService {

    @Override
    public String buscarPorId(Long id) {
        return "GOL";
    }
}
