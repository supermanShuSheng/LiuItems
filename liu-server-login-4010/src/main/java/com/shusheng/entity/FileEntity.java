package com.shusheng.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 刘闯
 * @date 2021/9/15.
 */
@Data
public class FileEntity {

    @ApiModelProperty(value = "文件名称")
    private String fileName;

    @ApiModelProperty(value = "文件路径")
    private String filePath;

    @ApiModelProperty(value = "文件请求地址")
    private String fileUrl;
}
