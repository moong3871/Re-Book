package com.necessafy.rebook.Service;

import com.necessafy.rebook.model.CommonResult;
import com.necessafy.rebook.model.ListResult;
import com.necessafy.rebook.model.SingleResult;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
@Service
public class ResponseService {
    public <T> CommonResult getResult(T data){
        if(data instanceof Collection){
            return getListResult((List)data);
        }
        System.out.println(data + " hello");
        return getSingleResult(data);
    }

    private <T> SingleResult<T> getSingleResult(T data){
        SingleResult<T> result = new SingleResult<>();
        result.setCode("single success");
        result.setSuccess(true);
        result.setMsg("single data를 가져왔어요");
        result.setData(data);
        return result;
    }
    private <T> ListResult<T> getListResult(List<T> list) {
        ListResult<T> listResult = new ListResult<>();
        listResult.setCode("list success");
        listResult.setSuccess(true);
        listResult.setMsg("list data를 가져왔어요");
        listResult.setList(list);
        return listResult;
    }
}
