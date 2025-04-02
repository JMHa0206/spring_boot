package com.kedu.study.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** EDMS_sign_off: 결재상태 DTO */
@Data
@NoArgsConstructor
@AllArgsConstructor
class EdmsSignOffDTO {
    private Long state_code;
    private String state_name;
    private String sign_off_name;
}