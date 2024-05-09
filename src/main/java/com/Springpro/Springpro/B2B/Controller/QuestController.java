package com.Springpro.Springpro.B2B.Controller;

import com.Springpro.Springpro.B2B.Entity.Company;
import com.Springpro.Springpro.B2B.Entity.Quest;
import com.Springpro.Springpro.B2B.Entity.ProdOrdd;
import com.Springpro.Springpro.B2B.Entity.Reproducer;
import com.Springpro.Springpro.B2B.Repository.ProdOrddRepo;
import com.Springpro.Springpro.B2B.Service.CompanyService;
import com.Springpro.Springpro.B2B.Service.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/quests")
public class QuestController {
    @Autowired
    private QuestService questService;

    @Autowired
    private ProdOrddRepo prodOrddRepository;
    private CompanyService companyService;
//
//    private ReproducerService reproducerService;
//
//    @PostMapping("/addQuest")
//    public String addQuest(@RequestBody Quest quest, Principal principal) {
//        String loggedInCompany = null;
//        if (principal != null) {
//            loggedInCompany = principal.getName();
//        }
//
//        if (loggedInCompany != null) {
//            Company company = companyService.getCompanyByName(loggedInCompany);
//            if (company != null) {
//                quest.setCompany(company);
//
//                // ابحث عن المنتج بالرقم المطلوب
//                Reproducer reproducer = reproducerService.getReproducerById(quest.getReproducer().getId());
//                if (reproducer != null) {
//                    // قم بتخفيض كمية المنتج بمقدار 1
//                    int quantity = reproducer.getQuantity() - 1;
//                    reproducer.setQuantity(quantity);
//                    reproducerService.saveReproducer(reproducer);
//
//                    if (quantity == 0) {
//                        return "عذرًا، لم يعد هذا المنتج متوفرًا.";
//                    } else {
//                        // قم بإرسال رسالة تم الشراء مع سعر المنتج
//                        double price = reproducer.getPrice();
//                        return "تم الشراء. سعر المنتج: " + price;
//                    }
//                }
//            }
//        }
//
//        return "حدث خطأ في إضافة الطلب.";
//    }


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