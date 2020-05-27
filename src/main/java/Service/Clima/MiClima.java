package Service.Clima;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MiClima {
    private AccuWeatherAPI apiClima = new AccuWeatherAPI();
    private List<Map<String, Object>> condicionesClimaticas;
    private LocalDateTime ultimaFechaDePedido;
    private Double temperaturaActual = 0.0;
    public Double getTemperatura ()
    {
        if(fueHaceMasDe12Horas(ultimaFechaDePedido)) {
            this.condicionesClimaticas = this.apiClima.getWeather("Buenos Aires, Argentina");
            HashMap<String, Object> primerTemperaturaObtenida = (HashMap<String, Object>) this.condicionesClimaticas.get(0).get("Temperatura");
            this.temperaturaActual = devuelveTemperaturaActualEnCelsius(primerTemperaturaObtenida);
            this.ultimaFechaDePedido = LocalDateTime.now();
        }
        return this.temperaturaActual;
    }

    private Double devuelveTemperaturaActualEnCelsius(HashMap<String, Object> temperatura){
        if (estaEnFahrenheit(temperatura))
            return convertirDeFahrenheitACelsius((Double) temperatura.get("Value"));
        return (Double) temperatura.get("Value");
    }

    public Boolean estaEnFahrenheit(HashMap<String, Object> primerTemperaturaObtenida){
        return primerTemperaturaObtenida.get("Unit") == "F";
    }

    public Double convertirDeFahrenheitACelsius(Double valor){
        return (valor - 32) * 5 / 9;
    }

    public Boolean fueHaceMasDe12Horas(LocalDateTime ultimaFechaDePedido){
        // Logica si fue hace mas de doce horas
        return true;
    }
}
