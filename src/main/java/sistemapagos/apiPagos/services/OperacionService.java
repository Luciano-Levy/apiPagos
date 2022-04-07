package sistemapagos.apiPagos.services;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class OperacionService {
    float porcentaje;
    public float obtenerTasa(String marca){
        // esta dando mal
        LocalDate now = LocalDate.now();
        int year = now.getYear() % 100;
        int month = now.getMonthValue();
        int dayofMonth = now.getDayOfMonth();
        
        if (marca.equals("VISA")){
            // month > 0
            porcentaje = year / month;
        } else if(marca.equals("NARA")){
            porcentaje = (float) (dayofMonth * 0.5);
        } else if (marca.equals("AMEX")){
            porcentaje = (float) (month*0.1);
        }

        return porcentaje;
    }
    public void esValida(int valor) {
        if(valor < 1000 && valor > 0){
           return;
        }else{
            throw new ArithmeticException("El monto debe ser menor a 1000");
        }
    }

    public float importeFinal(int valor){
        float result = (porcentaje * valor) / 100;
        float importe = valor + result;

        return importe;
    }
}
