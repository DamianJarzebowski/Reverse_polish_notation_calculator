package calc;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CalculateController {
    private final CalculatorService calculatorService;

    public CalculateController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    /*
    @GetMapping("/")
    String calc(@RequestParam String expr, Model model) {
        double string = calculatorService.evaluate(expr);
        model.addAttribute("expr", expr);
        model.addAttribute("string", string);
        return "index";
    }
     */

    @PostMapping("/calc")
    @ResponseBody
    String calc(@RequestParam String expr) {
        double result = calculatorService.evaluate(expr);
        return "Wynik: " + String.valueOf(result);
    }
}
