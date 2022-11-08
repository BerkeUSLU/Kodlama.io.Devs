package com.kodlamaio.kodlamaio.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kodlamaio.kodlamaio.dataAccess.abstracts.LanguageRepository;
import com.kodlamaio.kodlamaio.entities.Language;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository {

	List<Language> listOfLanguages;

	public InMemoryLanguageRepository() {
		listOfLanguages = new ArrayList<Language>();
		listOfLanguages.add(new Language(0, "Java"));
		listOfLanguages.add(new Language(1, "C++"));
		listOfLanguages.add(new Language(2, "C"));
		listOfLanguages.add(new Language(3, "Python"));
		listOfLanguages.add(new Language(4, "Julia"));
		listOfLanguages.add(new Language(5, "PHP"));
	}

	@Override
	public List<Language> getAll() {
		return listOfLanguages;
	}

	@Override
	public Language getById(int id) throws Exception {
		for(Language language : listOfLanguages){
            if(language.getID() == id){
                return language;
            }
        }
        throw new Exception("Bu ID'ye ait bir kayıt bulunamadı!");
    }
	

	@Override
	public void add(Language language) throws Exception {
		listOfLanguages.add(language);
	}

	@Override
	public void update(Language language, int id) throws Exception {
		Language tempLanguage = getById(language.getID());
		tempLanguage.setName(language.getName());
        
	}

	@Override
	public void remove(int id) throws Exception {
		Language tempLanguage = getById(id);
        listOfLanguages.remove(tempLanguage);
	}
}
