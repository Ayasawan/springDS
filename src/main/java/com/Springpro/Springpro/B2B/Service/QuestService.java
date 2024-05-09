package com.Springpro.Springpro.B2B.Service;

import com.Springpro.Springpro.B2B.Entity.Quest;
import com.Springpro.Springpro.B2B.Repository.QuestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestService {
    @Autowired
    private QuestRepo questRepository;

    public Quest saveQuest(Quest quest) {
        return questRepository.save(quest);
    }

    public List<Quest> getAllQuests() {
        return questRepository.findAll();
    }

    public Optional<Quest> getQuestById(Long questId) {
        return questRepository.findById(questId);
    }

    public void deleteQuest(Long questId) {
        questRepository.deleteById(questId);
    }

    public List<Quest> getQuestsByCompanyId(Long companyId) {
        return questRepository.findByCompanyId(companyId);
    }
}