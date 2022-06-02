package com.example.demo.auth;

import com.example.demo.dto.TestDTO;
import com.example.demo.entity.User;

import javax.servlet.http.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CustomHttpSessionListner implements HttpSessionListener, HttpSessionAttributeListener {

    private static Map<Long, HttpSession> map = Collections.synchronizedMap(new HashMap<>());

    public static boolean isAlreadyLogedIn(Long userId, String sessionId) {
        HttpSession session = map.get(userId);

        if(session.getId().equals(sessionId)){
            return true;
        }

        return false;
    }

    public static HttpSession getSession(Long userId){
        return map.get(userId);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();

        try{  
            Attribute attribute = (Attribute) session.getAttribute(Attribute.KEY);
            User user = attribute.getUser();

            map.remove(user.getId());
        }catch(Exception ex){
            // 로그인 된 session 은 user를 포함한 attribute 를 가짐
        }
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        HttpSession session = se.getSession();

        try{
            Attribute attribute = (Attribute) session.getAttribute(Attribute.KEY);
            User user = attribute.getUser();

            map.put(user.getId(), session);
        }catch(Exception ex){
            // 로그인 된 session 은 user를 포함한 attribute 를 가짐
        }
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // do nothing.
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        // do nothing.
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        // do nothing.
    }

}