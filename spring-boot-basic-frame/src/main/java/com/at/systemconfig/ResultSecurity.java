package com.at.systemconfig;

import com.at.frame.ResultConfiguation;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/5/16.
 * 对返回的结果进行加密之后再返回
 */
@Component
public class ResultSecurity extends ResultConfiguation{

    @Override
    public Object dataEncrypt(Object data) {
        System.out.println("------dataEncrypt::" + data);
        return data;
    }
}
