package com.phua.linuxpid;

import java.io.IOException;
import java.io.InputStream;

public class PID {

    public static String getPID() throws IOException, InterruptedException {
        Process proc = Runtime.getRuntime().exec(new String[]{
                "/bin/sh",
                "-c",
                "echo $PPID"
        });

        if (proc.waitFor() == 0) {
            InputStream in = proc.getInputStream();
            int available = in.available();
            byte[] outputBytes = new byte[available];

            in.read(outputBytes);
            String pid = new String(outputBytes);

            in.close();

            return pid;
        }

        proc.destroy();

        return "error";
    }

}
