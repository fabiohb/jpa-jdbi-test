package br.com.fabiohb.spring.jpajdbitest.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name = "business_entity")
public class BusinessEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Date dateValue;

	private Integer intValue;

	private Long longValue;

	private Float floatValue;

	private Double doubleValue;

	private String stringValue;

	public BusinessEntity() {
		var doubleRand = Math.random();
		var longRand = Math.round(doubleRand * 1000);

		dateValue = new Date();
		longValue = longRand;
		intValue = longValue.intValue();
		doubleValue = doubleRand;
		floatValue = doubleValue.floatValue();
		stringValue = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
				+ "Sed sed scelerisque lectus, ut gravida tortor. "
				+ "Donec pellentesque augue lectus, nec malesuada lorem iaculis non. "
				+ "Quisque ac eleifend metus non.";
	}
}
