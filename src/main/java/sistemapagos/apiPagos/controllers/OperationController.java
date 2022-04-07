package sistemapagos.apiPagos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import sistemapagos.apiPagos.models.Operacion;
import sistemapagos.apiPagos.services.OperacionService;

@RestController
public class OperationController {
    
    @Autowired
    OperacionService operacionService;
    
    
    @PostMapping("/operacion")
	public Operacion respuesta(@RequestBody Operacion operacion) {
        Operacion operacionResponse = null;
		try {
            
            operacionService.esValida(operacion.valor);
            float tasa = operacionService.obtenerTasa(operacion.marca);
            operacionResponse = new Operacion(operacion.valor, operacion.marca,tasa,operacionService.importeFinal(operacion.valor));
        
        }catch (ArithmeticException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Operacion no valida", e);
        }
        
        return operacionResponse;
	}

}
