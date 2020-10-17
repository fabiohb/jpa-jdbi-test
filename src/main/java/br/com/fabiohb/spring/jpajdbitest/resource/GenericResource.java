package br.com.fabiohb.spring.jpajdbitest.resource;

import java.util.function.Consumer;

import br.com.fabiohb.spring.jpajdbitest.dto.InsertStatus;
import br.com.fabiohb.spring.jpajdbitest.model.BusinessEntity;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GenericResource {

	protected InsertStatus compute(Integer count, Consumer<BusinessEntity> consumer) {
		var totalTime = System.currentTimeMillis();
		
		for (int i = 0; i < count; i++) {
			BusinessEntity businessEntity = new BusinessEntity();
			consumer.accept(businessEntity);
		}

		totalTime = System.currentTimeMillis() - totalTime;
		InsertStatus insertStatus = new InsertStatus(totalTime, count);
		log.info("{}", insertStatus);
		
		return insertStatus;
	}
}