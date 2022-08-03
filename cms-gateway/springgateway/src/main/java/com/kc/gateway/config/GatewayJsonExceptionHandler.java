package com.kc.gateway.config;
 
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.DefaultErrorWebExceptionHandler;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
 
import java.util.HashMap;
import java.util.Map;
 
public class GatewayJsonExceptionHandler extends DefaultErrorWebExceptionHandler {
 
    public GatewayJsonExceptionHandler(ErrorAttributes errorAttributes, ResourceProperties resourceProperties,
                                       ErrorProperties errorProperties, ApplicationContext applicationContext) {
        super(errorAttributes, resourceProperties, errorProperties, applicationContext);
    }


    @Override
    protected Map<String, Object> getErrorAttributes(ServerRequest request, boolean includeStackTrace) {
        int status = 500;
        String code = "";
        String errorMessage = "系统异常";
        Throwable error = super.getError(request);
        System.out.println(error);
        if (error instanceof org.springframework.cloud.gateway.support.NotFoundException) {
            code = "404";
        }
        Map<String, Object> map = new HashMap<>();
        map.put("code",code);
        map.put("msg","服务异常");
        map.put("data","null");
        return map;
    }
 
 
    @Override
    protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
        return RouterFunctions.route(RequestPredicates.all(), this::renderErrorResponse);
    }
 
 
//    @Override
//    protected RouterFunction<ServerResponse> getRoutingFunction(
//            ErrorAttributes errorAttributes) {
//        return RouterFunctions.route(acceptsTextHtml(), this::renderErrorView)
//                .andRoute(RequestPredicates.all(), this::renderErrorResponse);
//    }
    @Override
    protected HttpStatus getHttpStatus(Map<String, Object> errorAttributes) {
        return HttpStatus.valueOf((int)errorAttributes.get("code"));
    }
}