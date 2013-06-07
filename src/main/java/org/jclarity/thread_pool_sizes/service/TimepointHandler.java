package org.jclarity.thread_pool_sizes.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.jclarity.thread_pool_sizes.analysis.ResponseTimer;
import org.jclarity.thread_pool_sizes.analysis.Timer;

/**
 * Simple service that generates json timepoint replies
 */
public class TimepointHandler extends AbstractHandler {

    private final ResponseTimer responseTimer = new ResponseTimer();

    @Override
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Timer timer = responseTimer.start();
        try {
            response.setContentType("application/json;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);
            baseRequest.setHandled(true);
            String zoneId = request.getParameter("zoneId");
            Timepoint message = zoneId == null ? TimepointFactory.now() : TimepointFactory.now(zoneId);
            write(response, message);
        } finally {
            timer.stop();
        }
    }

    private void write(HttpServletResponse response, Timepoint timepoint) throws IOException {
        response.getWriter().println(timepoint.toString());
    }

}
