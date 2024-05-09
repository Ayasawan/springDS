package com.Springpro.Springpro.B2B.Controller;

import com.Springpro.Springpro.B2B.Entity.Quest;
import com.Springpro.Springpro.B2B.Entity.ProdOrdd;
import com.Springpro.Springpro.B2B.Repository.ProdOrddRepo;
import com.Springpro.Springpro.B2B.Service.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/quests")
public class QuestController {
    @Autowired
    private QuestService questService;

    @Autowired
    private ProdOrddRepo prodOrddRepository;

    @PostMapping("/add")
    public String addQuest(@RequestBody Quest quest) {
        double totalPrice = 0.0;

        // استرداد الكمية والسعر من الجدول الوسيط ProdOrd
        List<ProdOrdd> prodOrds = prodOrddRepository.findByOrderId(quest.getId());

        for (ProdOrdd prodOrd : prodOrds) {
            double quantity = quest.getQuantity();
            double price = prodOrd.getProductt().getPrice();

            totalPrice += quantity * price;
        }

        quest.setTotalPrice(totalPrice);

        Quest savedQuest = questService.saveQuest(quest);

        return "تمت إضافة الطلبية بنجاح. السعر الإجمالي: " + savedQuest.getTotalPrice();
    }

    @GetMapping("/all")
    public List<Quest> getAllQuests() {
        return questService.getAllQuests();
    }

    @GetMapping("/{id}")
    public Optional<Quest> getQuestById(@PathVariable("id") Long questId) {
        return questService.getQuestById(questId);
    }

    @DeleteMapping("/{id}")
    public void deleteQuest(@PathVariable("id") Long questId) {
        questService.deleteQuest(questId);
    }

    @GetMapping("/company/{companyId}")
    public List<Quest> getQuestsByCompanyId(@PathVariable("companyId") Long companyId) {
        return questService.getQuestsByCompanyId(companyId);
    }
}