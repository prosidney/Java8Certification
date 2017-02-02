package com.prosidney.nio;

import java.io.IOException;
import java.nio.file.*;

/**
 * Created by admin on 02/02/17.
 */
public class WatchServiceExample {
    public static void main(String[] args) throws IOException {
        try (WatchService service = FileSystems.getDefault().newWatchService()) {
            // Register for events
            Path zooData = Paths.get("/Users/admin/git_repositories/prosidney/Java8Certification/nonjava");
            Path zooLog = Paths.get("/Users/admin/git_repositories/prosidney/Java8Certification/pathtest");

            zooData.register(service, StandardWatchEventKinds.ENTRY_CREATE,
                                      StandardWatchEventKinds.ENTRY_DELETE,
                                      StandardWatchEventKinds.ENTRY_MODIFY);

            zooLog.register(service,StandardWatchEventKinds.ENTRY_MODIFY);

            for(;;) {

                WatchKey key;

                try {
                    /**
                     * Retrieves and removes the next WatchKey, waiting indefinitely if none are present.
                     */
                    key = service.take();
                } catch (InterruptedException x) {
                    break;
                }


                for (WatchEvent<?> event: key.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();
                    if (kind == StandardWatchEventKinds.OVERFLOW) {
                        continue;
                    }
                    // Process event
                    WatchEvent<Path> watchEvent = (WatchEvent<Path>)event;
                    Path path = watchEvent.context();
                    System.out.println("[eventType=" + kind + ", path=" + path.getFileName() + "]");
                }

                // Remember to always reset event key
                if(!key.reset()) {
                    break;
                }
            }
        }
    }
}
