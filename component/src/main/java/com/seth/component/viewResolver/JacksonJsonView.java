package com.seth.component.viewResolver;

import com.seth.component.bean.base.BaseView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import java.util.Iterator;
import java.util.Map;

/**
 * @author  xunbo.xu
 * @desc    JSON视图解析器
 * @date 18/9/28
 */
public class JacksonJsonView extends MappingJackson2JsonView {

    public JacksonJsonView() {
    }

    @Override
    public String getContentType() {
        return "application/json";
    }

    @Override
    protected Object filterModel(Map<String, Object> model) {
        Object result = null;
        Iterator var3 = model.values().iterator();

        while(var3.hasNext()) {
            //只能解析指定格式(APIResult子类)下的对象为JSON展示（避免使用其他错误码进行返回）
            Object obj = var3.next();
            if (BaseView.class.isAssignableFrom(obj.getClass())) {
                result = obj;
                break;
            }
        }

        return result;
    }
}