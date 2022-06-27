package com.shusheng.controller;

import cn.hutool.core.io.FileUtil;
import com.shusheng.commons.R;
import com.shusheng.domain.Dto.UploadFileDto;
import com.shusheng.entity.FileEntity;
import com.shusheng.service.FileUploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

/**
 * @author 刘闯
 * @date 2021/9/13.
 */
@RestController
@RequestMapping("/user/upload")
@Api(tags = "文件上传")
public class FileUploadController {

    @Autowired
    FileUploadService fu;


    @ApiOperation(value = "文件进行上传")
    @PostMapping(value = "/filesInfos")
    public R uploadFiles(@RequestParam(value = "files") MultipartFile[] files,
                         @Valid UploadFileDto uploadFileDto){
        return fu.getUserById(files, uploadFileDto);
    }

    @ApiOperation(value = "文件进行删除通过路径名称")
    @GetMapping(value = "/removeFile")
    public R removeFile(@RequestParam(value = "filePath") String filePath, @RequestParam(value = "fileName") String fileName){
        return fu.removeFile(filePath, fileName);
    }

    @ApiOperation(value = "文件通过路径获取流")
    @GetMapping(value = "/getFileStream", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getFileStream(@RequestParam(value = "path") String path){
        return FileUtil.readBytes(FileUtil.file(path));
    }

    @ApiOperation(value = "获取文件信息")
    @PostMapping(value = "/getFileInfo")
    public R<List<FileEntity>> getFileInfo(@Valid @RequestBody UploadFileDto uploadFileDto){
        return fu.getFileInfo(uploadFileDto);
    }

    @ApiOperation(value = "文件导出")
    @GetMapping(value = "/fileExport")
    public ResponseEntity<byte[]> fileExport(@RequestParam("filePath") String filePath){
        return fu.fileExport(filePath);
    }

}
