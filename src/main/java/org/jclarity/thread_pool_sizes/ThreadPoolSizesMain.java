package org.jclarity.thread_pool_sizes;

import org.eclipse.jetty.server.Server;
import org.jclarity.thread_pool_sizes.service.TimepointHandler;

public class ThreadPoolSizesMain {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        server.setHandler(new TimepointHandler());

        server.start();
        server.join();
    }

}
