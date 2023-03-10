package cn.zf233.xcloud.intercept;

import cn.zf233.xcloud.common.Const;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zf233 on 2020/11/4
 */
public class PermissionCheck implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute(Const.CURRENT_USER);
        if (user != null) {
            return true;
        }

        request.getRequestDispatcher("/user/browse/jump?jump=index").forward(request, response);

        return false;
    }
}
