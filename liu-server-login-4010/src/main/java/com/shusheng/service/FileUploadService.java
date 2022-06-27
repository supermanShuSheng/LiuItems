package com.shusheng.service;

import com.shusheng.commons.R;
import com.shusheng.domain.Dto.UploadFileDto;
import com.shusheng.entity.FileEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author 刘闯
 * @date 2021/9/15.
 */
public interface FileUploadService {
    /**
     * 文件进行上传
     * @param files
     * @param uploadFileDto
     * @return
     */
    R getUserById(MultipartFile[] files, UploadFileDto uploadFileDto);

    /**
     * 文件进行删除通过路径名称
     * @param filePath
     * @param fileName
     * @return
     */
    R removeFile(String filePath, String fileName);

    /**
     * 获取文件信息
     * @param uploadFileDto
     * @return
     */
    R<List<FileEntity>> getFileInfo(UploadFileDto uploadFileDto);

    ResponseEntity<byte[]> fileExport(String filePath);
}
