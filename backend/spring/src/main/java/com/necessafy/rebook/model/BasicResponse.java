package com.necessafy.rebook.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;


@ApiModel(value = "응답 양식", description = "서버에서 프론트로 반환하는 데이터 양식")
@Builder
public class BasicResponse {
    @ApiModelProperty(value = "status", position = 1)
    public String status;
    @ApiModelProperty(value = "Message",position=2)
    public String message;
    @ApiModelProperty(value = "data", position = 3)
    public String data;
    @ApiModelProperty(value = "object", position = 4)
    public Object object;


}
