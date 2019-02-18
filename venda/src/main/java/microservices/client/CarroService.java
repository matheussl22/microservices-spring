package microservices.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "carro-server")
public interface CarroService {

    @GetMapping(value = "/carros/{id}")
    String buscarCarro(@PathVariable("id") Long id);

}
