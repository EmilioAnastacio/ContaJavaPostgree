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

        if (numeros == null || numeros.size() <20){
            throw new IllegalArgumentException("A lista de números deve conter pelo menos 20 elementos.");
        }

        Recebido recebido = new Recebido(media(numeros), desvioPadrao(numeros), qntRecebido(numeros), mediana(numeros));

        return recebido;
    }

    public double media(final List<Double> numeros){

        double soma = 0;
        for (Double numero : numeros){
            soma += numero;
        }
        double media = soma / numeros.size();

        return media;
    }

    public double mediana(final List<Double> numeros){

        Collections.sort(numeros);
        double mediana;
        if(numeros.size() % 2 == 0){
            mediana = (numeros.get(numeros.size() / 2 - 1) + numeros.get(numeros.size() / 2)) /2;
        } else {
            mediana = numeros.get(numeros.size() /2);
        }

        return mediana;
    }

    public double desvioPadrao(final List<Double> numeros){

        double somaDiferencaQuadradado = 0;
        for(Double numero : numeros){
            somaDiferencaQuadradado += Math.pow(numero - media(numeros), 2);
        }
        double desvioPadrao = Math.sqrt(somaDiferencaQuadradado / numeros.size());

        return  desvioPadrao;
    }

    public double qntRecebido(final List<Double> numeros){

        return numeros.size();
    }

    public double minimo(final List<Double> numeros){
        Collections.sort(numeros);
        return numeros.get(0);
    }

    public double maximo(final List<Double> numeros){
        Collections.sort(numeros);
        return numeros.get(numeros.size()-1);
    }

    public double somaValores(final List<Double> numeros){
        Double soma = 0.0;

        for (Double numero : numeros){
            soma+= numero;
        }

        return soma;
    }

}
