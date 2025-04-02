package com.kedu.study.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** EDMS: 전자결재 본문 DTO */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EDMSDTO {
    private Long edms_id;            // 결재번호
    private Long form_id;            // 전자결재양식코드 (FK)
    private Long edms_c_id;          // 결재종류코드 (FK: category)
    private Long state_code;         // 결재상태코드 (FK: sign_off)
    
    private String edms_title;       // 제목
    private String edms_content;     // 본문 내용
    private Date submit_date;        // 제출일자
    private String ref_dept;         // 참조부서
    private String rejec_reason;     // 반려사유

    // 결재선
    private Integer level1;          // 결재자 1
    private Integer level2;          // 결재자 2
    private Integer level3;          // 결재자 3
    private Integer level4;          // 결재자 4
    private Integer final_level;     // 최종 결재자
}