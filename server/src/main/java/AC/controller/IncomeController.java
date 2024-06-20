package AC.controller;

import AC.dto.create.CreateIncome;
import AC.service.IncomeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class IncomeController {


    private final IncomeService incomeService;

    @PostMapping("/income")
    public ResponseEntity<CreateIncome.Response> createIncome(
            @Valid @RequestBody CreateIncome.Request request) {

        return ResponseEntity.ok(CreateIncome.Response.from(
                incomeService.createIncome(request)));
    }


}
