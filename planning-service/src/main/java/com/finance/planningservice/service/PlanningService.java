package com.finance.planningservice.service;


import com.finance.planningservice.domain.Planning;
import com.finance.planningservice.dto.RequestDTO;
import com.finance.planningservice.event.AllowanceApprovedEvent;
import com.finance.planningservice.repository.PlanningRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PlanningService {

    private  PlanningRepository planningRepository;
    private  KafkaTemplate<String, Object> kafkaTemplate;

    public PlanningService(KafkaTemplate<String, Object> kafkaTemplate, PlanningRepository planningRepository) {
        this.kafkaTemplate = kafkaTemplate;
        this.planningRepository = planningRepository;
    }

    public void creditLiberation(RequestDTO requestDTO) {


        kafkaTemplate.send("allowance-Approved-topic",
                new AllowanceApprovedEvent(
                        requestDTO.getId(),
                        requestDTO.getExpenseType(),
                        requestDTO.getAccount_amount()
                )
        );

        Planning planning = planningRepository.findPlanningByExpenseType(requestDTO.getExpenseType());

        planning.setAmount(planning.getAmount().subtract(requestDTO.getAccount_amount()));

        planningRepository.save(planning);

    }


}
