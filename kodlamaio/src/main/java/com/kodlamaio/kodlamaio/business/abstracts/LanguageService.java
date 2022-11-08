package com.kodlamaio.kodlamaio.business.abstracts;

import java.util.List;

import com.kodlamaio.kodlamaio.entities.Language;

public interface LanguageService {
	List<Language> getAll();
    Language getById(int id) throws Exception;
    void add(Language language) throws Exception;
    void update(Language language, int id) throws Exception;
    void remove(int id) throws Exception;
    
}
