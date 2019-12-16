package com.spring.henallux.phD_Garden.dataAccess.util;

import com.spring.henallux.phD_Garden.dataAccess.entity.LanguageEntity;
import com.spring.henallux.phD_Garden.model.Language;
import org.springframework.stereotype.Component;

@Component
public class LanguageConverter {

    public Language languageEntityToLanguageModel(LanguageEntity languageEntity) {
        Language language = new Language();

        language.setId(languageEntity.getId());
        language.setCode(languageEntity.getCode());
        language.setName(languageEntity.getName());

        return language;
    }

    public LanguageEntity languageModelToLanguageEntity(Language language) {
        LanguageEntity languageEntity = new LanguageEntity();

        languageEntity.setId(language.getId());
        languageEntity.setCode(language.getCode());
        languageEntity.setName(language.getName());

        return languageEntity;
    }
}
