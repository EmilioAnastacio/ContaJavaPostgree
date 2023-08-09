package Conta.main.Service;
import Conta.main.Entity.Recebido;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Service
public class RecebidoService {

    @Transactional(rollbackFor = Exception.class)
    public Recebido calculo(final List<Double> numeros){

        if (numeros == null || numeros.size() < 20) {
            throw new IllegalArgumentException("A lista de números deve conter pelo menos 20 elementos.");
        }

        Recebido recebido = new Recebido();

        double soma = 0;
        for (Double numero : numeros){
            soma += numero;
        }

        double media = soma / numeros.size();
        recebido.setMedia(media);

        Collections.sort(numeros);
        double mediana;
        if(numeros.size() % 2 == 0){
            mediana = (numeros.get(numeros.size() / 2 - 1) + numeros.get(numeros.size() / 2)) /2;
        } else {
            mediana = numeros.get(numeros.size() /2);
        }

        recebido.setMediana(mediana);

        double somaDiferencaQuadradado = 0;
        for(Double numero : numeros){
            somaDiferencaQuadradado += Math.pow(numero - media, 2);
        }
        double desvioPadrao = Math.sqrt(somaDiferencaQuadradado / numeros.size());

        recebido.setDesvioPadrao(desvioPadrao);
        recebido.setQntRecebido(numeros.size());

        return recebido;


    }

}
