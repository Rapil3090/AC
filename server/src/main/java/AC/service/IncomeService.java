package AC.service;

import AC.domain.Income;
import AC.dto.IncomeDTO;
import AC.dto.create.CreateIncomeDTO;
import AC.dto.get.GetCategoryDTO;
import AC.dto.update.UpdateIncomeDTO;
import AC.type.Category;

import java.util.List;

public interface IncomeService {


    Income createIncome(CreateIncomeDTO.Request request);

    IncomeDTO getIncomeById(Long incomeId);

    Income UpdateIncomeById(UpdateIncomeDTO.Request request);

    void deleteIncomeById(Long incomeId);

    List<IncomeDTO> getUserIdByCategory(GetCategoryDTO request);
}
