package com.shusheng.domain.Dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author 刘闯
 * @date 2021/9/15.
 */
@Data
@ApiModel(description = "文件上传参数信息")
public class UploadFileDto {

    @ApiModelProperty(value = "文件夹名称")
    @NotBlank(message = "上传电影文件夹不能为空！")
    private String movieName;

    @ApiModelProperty(value = "电影类型（淘票票，猫眼）")
    private String movieType;

    @ApiModelProperty(value = "用户名称")
    @NotBlank(message = "用户名称不能为空！")
    private String userName;

    @ApiModelProperty(value = "用户ID")
    private String userId;
}
