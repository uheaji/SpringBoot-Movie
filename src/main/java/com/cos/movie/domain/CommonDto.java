package com.cos.movie.domain;

import lombok.Data;

@Data
public class CommonDto<T>{
	private int statusCode;
	private T msg;
	
	public CommonDto(int statusCode) {
		super();
		this.statusCode = statusCode;
	}
	
	public CommonDto(int statusCode, T msg) {
		super();
		this.statusCode = statusCode;
		this.msg = msg;
	}
	
}
