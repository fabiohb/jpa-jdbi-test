package br.com.fabiohb.spring.jpajdbitest.persistence;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fabiohb.spring.jpajdbitest.model.BusinessEntity;

@Repository
@Scope(BeanDefinition.SCOPE_SINGLETON)
public interface JpaBusinessEntityRepository extends JpaRepository<BusinessEntity, Long> {

}
