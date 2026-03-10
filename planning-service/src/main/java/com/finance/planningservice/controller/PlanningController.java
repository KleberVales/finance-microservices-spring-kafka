package com.finance.planningservice.controller;

import com.finance.planningservice.dto.RequestDTO;
import com.finance.planningservice.service.PlanningService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/planning")
public class PlanningController {

    private final PlanningService service;

    public PlanningController(PlanningService service){
        this.service = service;

    }

    @PostMapping("/libetation")
    public void creditLibetation(@RequestBody RequestDTO requestDTO){

        service.creditLiberation(requestDTO);
    }

}
