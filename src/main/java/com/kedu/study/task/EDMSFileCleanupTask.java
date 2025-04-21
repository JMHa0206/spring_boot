package com.kedu.study.task;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.kedu.study.dao.EDMS.EDMSFileDAO;

@Component
public class EDMSFileCleanupTask {

    private static final String UPLOAD_DIR = "C:/edms_uploads"; // 실제 저장 경로

    private final EDMSFileDAO edmsFileDAO;

    public EDMSFileCleanupTask(EDMSFileDAO edmsFileDAO) {
        this.edmsFileDAO = edmsFileDAO;
    }

    // 매 30분마다 실행 (초, 분, 시, 일, 월, 요일)
    @Scheduled(cron = "0 */30 * * * *")
    public void cleanOrphanedFiles() {
        System.out.println("🧹 파일 정리 작업 시작됨");

        // DB에 등록된 파일명 목록
        List<String> dbFileNames = edmsFileDAO.getAllSysFileNames(); // edmsSysName만 리스트로 가져옴
        Set<String> dbFileSet = new HashSet<>(dbFileNames);

        // 실제 디렉터리 파일 목록
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists() || !uploadDir.isDirectory()) {
            System.out.println("🚫 업로드 디렉터리가 존재하지 않음");
            return;
        }

        File[] files = uploadDir.listFiles();
        if (files == null) return;

        int deletedCount = 0;

        for (File file : files) {
            if (!dbFileSet.contains(file.getName())) {
                boolean deleted = file.delete();
                if (deleted) {
                    System.out.println("🗑️ 고아 파일 삭제됨: " + file.getName());
                    deletedCount++;
                } else {
                    System.out.println("⚠️ 삭제 실패: " + file.getName());
                }
            }
        }

        System.out.println("✅ 정리 완료, 삭제된 파일 수: " + deletedCount);
    }
}
