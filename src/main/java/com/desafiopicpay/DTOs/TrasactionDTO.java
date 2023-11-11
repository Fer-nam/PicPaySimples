package com.desafiopicpay.DTOs;

import java.math.BigDecimal;

public record TrasactionDTO(BigDecimal value, Long senderId, Long reciverId) {
}
