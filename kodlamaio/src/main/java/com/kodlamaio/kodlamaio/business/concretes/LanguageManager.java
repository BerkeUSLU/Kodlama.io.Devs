package com.kodlamaio.kodlamaio.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.kodlamaio.business.abstracts.LanguageService;
import com.kodlamaio.kodlamaio.dataAccess.abstracts.LanguageRepository;
import com.kodlamaio.kodlamaio.entities.Language;

@Service
public class LanguageManager implements LanguageService {

	private LanguageRepository languageRepository;

	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public List<Language> getAll() {
		return languageRepository.getAll();
	}

	@Override
	public Language getById(int id) throws Exception {
		return languageRepository.getById(id);
	}

	@Override
	public void add(Language language) throws Exception {
		if (language.getName().isEmpty()) {
			throw new Exception("Programlama dili adı boş geçilemez!");
		}
		for (Language tempLanguage : getAll()) {
			if (tempLanguage.getName().equals(language.getName())) {
				throw new Exception("Aynı programlama dili iki defa eklenemez!");
			}
			if (tempLanguage.getID() == language.getID()) {
				throw new Exception("Aynı ID iki defa kullanılamaz!");
			}
		}
		languageRepository.add(language);
	}

	@Override
	public void update(Language language, int id) throws Exception {
		if (languageRepository.getById(id) == null) {
			throw new Exception("Bu programlama dili kayıtlı değil!");
		}
		languageRepository.update(language, id);
	}

	@Override
	public void remove(int id) throws Exception {
			languageRepository.remove(id);
	}
}
