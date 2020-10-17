package br.com.fabiohb.spring.jpajdbitest.resource;

import static org.springframework.http.HttpStatus.CREATED;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabiohb.spring.jpajdbitest.dto.InsertStatus;
import br.com.fabiohb.spring.jpajdbitest.persistence.JdbiBusinessEntityRepository;

@RestController
@RequestMapping("/jdbc/business-entity")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class JdbiBusinessEntityResource extends GenericResource {

	@Autowired
	private JdbiBusinessEntityRepository repository;

	@PostMapping
	public ResponseEntity<InsertStatus> insert(
		@RequestHeader(name = "count", defaultValue = "1") Integer count) {

		var status = compute(count, (businessEntity) -> {
			repository.save(businessEntity);
		});

		return ResponseEntity.status(CREATED).body(status);
	}

}