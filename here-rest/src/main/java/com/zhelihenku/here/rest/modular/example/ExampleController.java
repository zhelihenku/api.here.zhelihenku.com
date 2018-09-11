package com.zhelihenku.here.rest.modular.example;

import com.zhelihenku.here.rest.common.SimpleObject;
import com.zhelihenku.here.rest.common.SimpleObject;
import com.zhelihenku.here.rest.common.util.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 常规控制器
 *
 * @author PhilWang
 * @date 2017-08-23 16:02
 */
@Controller
@RequestMapping("/hello")
public class ExampleController {

    @RequestMapping("")
    public Object hello() {
        Result result = new Result();
        return result;
    }
}
