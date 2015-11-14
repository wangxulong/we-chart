package com.wang.action;

import com.wang.util.SignUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by wxl on 2015/11/4.
 */
public class SignController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String signature = req.getParameter("signature");
        String timestamp = req.getParameter("timestamp");
        String nonce = req.getParameter("nonce");
        String echostr = req.getParameter("echostr");
        PrintWriter pw = resp.getWriter();
        if(SignUtil.checkSignature(signature,timestamp,nonce)){
            pw.write(echostr);
        }
        pw.close();
        pw = null;
    }
}
