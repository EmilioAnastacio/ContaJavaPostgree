package Conta.main.Controller;

import Conta.main.DTO.RecebidoDTO;
import Conta.main.Entity.Recebido;
import Conta.main.Service.RecebidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/api")
public class RecebidoController {

    @Autowired
    private RecebidoService recebidoService;

    @GetMapping("/recebido")
    public ResponseEntity<?> recebidoCalculo(@RequestBody final RecebidoDTO recebidoDTO){

        Recebido recebido = recebidoService.calculo(recebidoDTO.getNumeros());

        System.out.println("Média: " + recebido.getMedia());
        System.out.println("Mediana: " + recebido.getMediana());
        System.out.println("Desvio Padrão: " + recebido.getDesvioPadrao());
        System.out.println("Quantidade Recebida: " + recebido.getQntRecebido());

        return recebido == null
                ? ResponseEntity.badRequest().body("IXIII DOG")
                : ResponseEntity.ok(recebido);
    }

}
