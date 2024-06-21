package AC.service;

import AC.domain.Income;
import AC.dto.IncomeDTO;
import AC.dto.create.CreateIncomeDTO;
import AC.dto.update.UpdateIncomeDTO;

public interface IncomeService {


    Income createIncome(CreateIncomeDTO.Request request);

    IncomeDTO getIncomeById(Long incomeId);

    Income UpdateIncomeById(UpdateIncomeDTO.Request request);
}
