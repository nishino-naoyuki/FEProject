package jp.ac.asojuku.feprj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import jp.ac.asojuku.feprj.entity.AnswerEntity;

public interface AnswerRepository 
	extends JpaSpecificationExecutor<AnswerEntity>, JpaRepository<AnswerEntity, Integer>{

}
