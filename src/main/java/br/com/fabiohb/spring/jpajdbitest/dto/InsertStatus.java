package br.com.fabiohb.spring.jpajdbitest.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class InsertStatus {

	@NonNull
	private Long totalTime;

	@NonNull
	private Integer count;

	private Float timeAvg;

	public InsertStatus() {
		super();
	}

	public InsertStatus(@NonNull Long totalTime, @NonNull Integer count) {
		super();
		this.totalTime = totalTime;
		this.count = count;
		this.timeAvg = ((float) totalTime / count);
	}
	
	
}
