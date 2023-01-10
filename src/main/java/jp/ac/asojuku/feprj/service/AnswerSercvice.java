package jp.ac.asojuku.feprj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.ac.asojuku.feprj.entity.AnswerEntity;
import jp.ac.asojuku.feprj.repository.AnswerRepository;

@Service
public class AnswerSercvice {
	@Autowired
	AnswerRepository answerRepository;
	
	public void insert(String name,int score,int questionId) {
		AnswerEntity entity = new AnswerEntity();
		
		entity.setName(name);
		entity.setScore(score);
		entity.setQuestion(questionId);
		
		answerRepository.save(entity);
	}
}
