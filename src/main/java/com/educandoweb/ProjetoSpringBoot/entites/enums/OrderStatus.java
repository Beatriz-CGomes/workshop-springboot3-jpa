package com.educandoweb.ProjetoSpringBoot.entites.enums;

public enum OrderStatus {

	WAITING_PAYMENT(1), PAID(2), SHIPPED(3), DELIVERED(4), CANCELED(5);

	private int code;

	private OrderStatus(int code) {
		this.code = code;
	}

	// metado para pegar o codigo fora da enum
	public int getCode() {
		return code;
	}

	// Converter o valor numero em um valor enumerado
	public static OrderStatus valueOf(int code) {
		//percorrendo todo o valor 
		for (OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}

}
