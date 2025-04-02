package com.kedu.study.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** EDMS_form: 결재양식 DTO */
@Data
@NoArgsConstructor
@AllArgsConstructor
class EdmsFormDTO {
    private Long form_id;
    private String form_name;        // 양식명
    private String form_content;     // 양식 내용
}