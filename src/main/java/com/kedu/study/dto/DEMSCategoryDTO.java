package com.kedu.study.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** EDMS_category: 결재종류 DTO */
@Data
@NoArgsConstructor
@AllArgsConstructor
class EdmsCategoryDTO {
    private Long edms_c_id;
    private String edms_c_name;      // 결재종류명
}