package br.com.fabiohb.spring.jpajdbitest.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.fabiohb.spring.jpajdbitest.model.BusinessEntity;

@Repository
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class JdbcBusinessEntityRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int save(BusinessEntity businessEntity) {
		return jdbcTemplate.update(
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
	}
}