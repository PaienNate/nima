package cn.zf233.xcloud.intercept;

import cn.zf233.xcloud.common.Const;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zf233 on 2021/1/17
 */
public class PermissionCheckAdmin implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute(Const.CURRENT_ADMIN);
        if (user != null) {
            return true;
        }

        request.getRequestDispatcher("/admin").forward(request, response);

        return false;
    }
}
