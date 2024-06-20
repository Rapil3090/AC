package AC.service;

import AC.domain.Income;
import AC.dto.create.CreateIncome;

public interface IncomeService {


    Income createIncome(CreateIncome.Request request);

}
