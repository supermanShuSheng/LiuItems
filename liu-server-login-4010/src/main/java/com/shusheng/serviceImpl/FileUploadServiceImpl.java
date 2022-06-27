package com.shusheng.serviceImpl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ZipUtil;
import com.shusheng.commons.R;
import com.shusheng.config.BaseException;
import com.shusheng.domain.Dto.UploadFileDto;
import com.shusheng.entity.FileEntity;
import com.shusheng.mapper.FileUploadMapper;
import com.shusheng.service.FileUploadService;
import com.shusheng.utils.FileTypeUtils;
import com.shusheng.utils.ResultUtils;
import com.shusheng.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author 刘闯
 * @date 2021/9/15.
 */
@Service
public class FileUploadServiceImpl implements FileUploadService {

    @Autowired
    FileUploadMapper fileUploadMapper;

    @Value("${upload.filePath}")
    private String filePath;

    /**
     * 文件进行上传
     * @param files
     * @param uploadFileDto
     * @return
     */
    @Override
    public R getUserById(MultipartFile[] files, UploadFileDto uploadFileDto) {
        // 文件空判断
        filesIsNull(files);
        // 文件路径
        String path = filePath+uploadFileDto.getMovieName()+"\\"+ (StringUtils.isEmpty(uploadFileDto.getMovieType())?"":uploadFileDto.getMovieType()+"\\")
                +uploadFileDto.getUserName()+"\\";
        fileInit(path);
        // 图片进行保存本地
        try {
            for (MultipartFile file : files) {
                FileUtil.writeBytes(file.getBytes(), path + IdUtil.simpleUUID().substring(0,5)+DateUtil.current() + "." +
                        FileTypeUtils.getFileType(Objects.requireNonNull(file.getOriginalFilename())));
            }
        } catch (IOException e) {
            throw new BaseException("文件写入失败！");
        }

        return ResultUtils.success();
    }

    /**
     * 文件进行删除通过路径名称
     * @param filePath
     * @param fileName
     * @return
     */
    @Override
    public R removeFile(String filePath, String fileName) {
        if(FileUtil.del(filePath+"\\"+fileName)){
            return ResultUtils.success();
        }
        return ResultUtils.error();
    }

    /**
     * 获取文件信息
     * @param uploadFileDto
     * @return
     */
    @Override
    public R<List<FileEntity>> getFileInfo(UploadFileDto uploadFileDto) {
        // 文件路径
        String path = filePath+uploadFileDto.getMovieName()+"\\"+
                (StringUtils.isEmpty(uploadFileDto.getMovieType())?"":uploadFileDto.getMovieType()+"\\")
                +uploadFileDto.getUserName()+"\\";
        List<File> files = FileUtil.loopFiles(path);
        List<FileEntity> fileEntities = new ArrayList<>();
        for (File file : files) {
            FileEntity fileEntity = new FileEntity();
            fileEntity.setFileName(file.getName());
            fileEntity.setFileUrl("/user/upload/getFileStream?path="+path+file.getName());
            fileEntity.setFilePath(path);

            fileEntities.add(fileEntity);
        }
        return ResultUtils.success(fileEntities, fileEntities.size());
    }

    @Override
    public ResponseEntity<byte[]> fileExport(String filePath) {
        File file = FileUtil.file(this.filePath+filePath);
        File zip = ZipUtil.zip(file);
        byte[] bytes = FileUtil.readBytes(zip);
        HttpHeaders headers = new HttpHeaders();

        // 设置下载响应头
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE);

        // 如果设置文件名  则会进行文件的下载
        try {
            headers.add(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename="
                    + URLEncoder.encode(filePath+".zip", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(bytes, headers, HttpStatus.OK) ;
    }

    /**
     * 空文件判断
     * @param files
     */
    private void filesIsNull(MultipartFile[] files) {
        // 进行文件判空抉择
        try{
            if (files[0].getSize() == 0){
                throw new BaseException("上传文件不能为空！");
            }
        } catch (RuntimeException e) {
            throw new BaseException("上传文件异常！");
        }
    }

    /**
     * 如果文件不存在 则创建文件夹
     * @param path
     */
    private void fileInit(String path){
        File file = FileUtil.file(path);
        // 如果文件夹不存在则创建文件夹  电影票根目录
        if (file.exists()){
            FileUtil.mkdir(file);
            System.out.println(" 创建父目录成功！ ");
        }
    }
}
