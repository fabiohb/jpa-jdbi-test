package br.com.fabiohb.spring.jpajdbitest.persistence;

import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import br.com.fabiohb.spring.jpajdbitest.model.BusinessEntity;

@Repository
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class JdbiBusinessEntityRepository {

	@Autowired
	private Jdbi jdbi;

	public int save(BusinessEntity businessEntity) {
		return jdbi.withHandle(handle -> {
			return handle.execute(
				"INSERT INTO public.business_entity " + 
				"(date_value, int_value, long_value, float_value, double_value, string_value) " + 
				"VALUES(?, ?, ?, ?, ?, ?)", 
				businessEntity.getDateValue(),
				businessEntity.getIntValue(),
				businessEntity.getLongValue(),
				businessEntity.getFloatValue(),
				businessEntity.getDoubleValue(),
				businessEntity.getStringValue()
			);
		});
	}
}