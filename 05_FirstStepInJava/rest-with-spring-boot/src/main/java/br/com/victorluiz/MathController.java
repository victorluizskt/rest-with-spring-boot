package br.com.victorluiz;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.victorluiz.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {
	
	@GetMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo,
			String name
	) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		
		return convertToDouble(numberOne) + convertToDouble(numberTwo);
	}
	
	private boolean isNumeric(String number) {
		if(number == null) return false;
		String numberWithCharacter = number.replaceAll(",", ".");
		return numberWithCharacter.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	
	private Double convertToDouble(String number) {
		if(number == null) return 0D;
		String numberWithCharacter = number.replaceAll(",", ".");
		if(isNumeric(numberWithCharacter)) return Double.parseDouble(numberWithCharacter);
		return 0D;
	}
}
