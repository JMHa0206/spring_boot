package com.kedu.study.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** EDMS_file: 첨부파일 DTO */
@Data
@NoArgsConstructor
@AllArgsConstructor
class EdmsFileDTO {
    private Long edms_file_id;
    private Long parent_seq;         // EDMS 결재번호 FK
    private String edms_oriname;     // 원본파일명
    private String edms_sysname;     // 저장된 시스템 파일명
}