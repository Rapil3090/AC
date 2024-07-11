package AC.controller;

import AC.dto.IncomeDTO;
import AC.dto.create.CreateIncomeDTO;
import AC.dto.delete.DeleteDTO;
import AC.dto.get.GetCategoryDTO;
import AC.dto.get.GetUserIdByYearAndMonth;
import AC.dto.update.UpdateIncomeDTO;
import AC.service.IncomeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class IncomeController {


    private final IncomeService incomeService;

    @PostMapping("/income")
    public ResponseEntity<CreateIncomeDTO.Response> createIncome(
            @Valid @RequestBody CreateIncomeDTO.Request request) {

        return ResponseEntity.ok(CreateIncomeDTO.Response.from(
                incomeService.createIncome(request)));
    }


    @GetMapping("/income")
    public ResponseEntity<IncomeDTO> getIncomeById(
            @RequestParam("incomeId") Long incomeId) {

        return ResponseEntity.ok(incomeService.getIncomeById(incomeId));
    }

    @PutMapping("/income")
    public ResponseEntity<UpdateIncomeDTO.Response> updateIncomeById(
            @Valid @RequestBody UpdateIncomeDTO.Request request) {

        return ResponseEntity.ok(UpdateIncomeDTO.Response.from(
                incomeService.UpdateIncomeById(request)));
    }

    @PostMapping("/income/delete")
    public ResponseEntity<DeleteDTO.Response> deleteIncomeById(
            @Valid @RequestBody DeleteDTO.Request request) {

        incomeService.deleteIncomeById(request.getId());

        return ResponseEntity.ok(DeleteDTO.Response.from());
    }

    @GetMapping("/income/category")
    public ResponseEntity<List<IncomeDTO>> getUserIdByCategory(
            @Valid @RequestBody GetCategoryDTO request) {

        return ResponseEntity.ok(incomeService.getUserIdByCategory(request));
    }

    @GetMapping("/income/user")
    public ResponseEntity<List<IncomeDTO>> getUserIdByYearAndMonth(
            @Valid @RequestBody GetUserIdByYearAndMonth request) {

        return ResponseEntity.ok(incomeService.getUserIdByYearAndMonth(request));
    }
}
