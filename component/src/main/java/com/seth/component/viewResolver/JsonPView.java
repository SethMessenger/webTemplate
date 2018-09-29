package com.seth.component.viewResolver;

import com.fasterxml.jackson.core.JsonGenerator;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author  xunbo.xu
 * @desc    JSONP 视图解析器
 * @date 18/9/28
 */
public class JsonPView extends MappingJackson2JsonView {

    private String jsonPrefix;
    private Boolean needNote = false;
    private String jsonpfname = "jsonpfname";

    public JsonPView() {
    }

    public String getJsonpfname() {
        return this.jsonpfname;
    }

    public void setJsonpfname(String jsonpfname) {
        this.jsonpfname = jsonpfname;
    }

    @Override
    public void setJsonPrefix(String jsonPrefix) {
        this.jsonPrefix = jsonPrefix;
    }

    @Override
    public String getContentType() {
        return "application/javascript";
    }

    @Override
    protected void writePrefix(JsonGenerator generator, Object object) throws IOException {
        if (this.jsonPrefix != null) {
            generator.writeRaw(this.jsonPrefix);
        }

        String jsonpFunction = null;
        if (object instanceof MappingJacksonValue) {
            jsonpFunction = ((MappingJacksonValue)object).getJsonpFunction();
        }

        if (jsonpFunction != null) {
            if (this.needNote.booleanValue()) {
                generator.writeRaw("/*" + jsonpFunction + "*/");
            }

            generator.writeRaw(jsonpFunction + "(");
        }

    }

    @Override
    protected void writeSuffix(JsonGenerator generator, Object object) throws IOException {
        String jsonpFunction = null;
        if (object instanceof MappingJacksonValue) {
            jsonpFunction = ((MappingJacksonValue)object).getJsonpFunction();
        }

        if (jsonpFunction != null) {
            generator.writeRaw(");");
        }

    }

    @Override
    protected Object filterAndWrapModel(Map<String, Object> model, HttpServletRequest request) {
        Object value = super.filterAndWrapModel(model, request);
        String jsonpParameterValue = this.getJsonpParameterValue(request);
        if (jsonpParameterValue != null) {
            if (value instanceof MappingJacksonValue) {
                ((MappingJacksonValue)value).setJsonpFunction(jsonpParameterValue);
            } else {
                MappingJacksonValue container = new MappingJacksonValue(value);
                container.setJsonpFunction(jsonpParameterValue);
                value = container;
            }
        }

        return value;
    }

    @Override
    protected void setResponseContentType(HttpServletRequest request, HttpServletResponse response) {
        if (this.getJsonpParameterValue(request) != null) {
            response.setContentType("application/javascript");
        } else {
            super.setResponseContentType(request, response);
        }

    }

    private String getJsonpParameterValue(HttpServletRequest request) {
        String func = request.getParameter("jsonpfname");
        if (StringUtils.isEmpty(func)) {
            String path = request.getServletPath();
            String[] split = path.split("/");
            String route = split[split.length - 1];
            String[] split2 = route.split("\\.");
            String value = split2[0];
            if (StringUtils.isEmpty(value)) {
                return null;
            } else if (!this.isValidJsonpQueryParam(value)) {
                if (this.logger.isDebugEnabled()) {
                    this.logger.debug("Ignoring invalid jsonp parameter value: " + value);
                }

                return value;
            } else {
                return value;
            }
        } else {
            return func;
        }
    }
}