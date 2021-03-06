package com.lordjoe.ssh;

import com.jcraft.jsch.Session;
import com.lordjoe.utilities.FileUtilities;

import java.io.File;

/**
 * com.lordjoe.ssh.FTPUtilities
 * User: Steve
 * Date: 1/26/2020
 */
public class FTPUtilities {

    public  static void createFile(String[] args)  {
        ClusterSession  me = new ClusterSession();
        try {
            String command = FileUtilities.readInFile(new File(args[0]));
            me.ftpFileCreate(args[1], command);
            Session session = me.getSession();
            session.disconnect();
            System.out.println("Done");
        } catch (Exception e) {

            throw new RuntimeException(e);

        }
    }

    public  static void downloadFile(String[] args)  {
        ClusterSession  me = new ClusterSession();
        try {
            String local = args[1];
            String remote = args[0];
            me.ftpFileGet(new File(local), remote);
             Session session = me.getSession();
            session.disconnect();
            System.out.println("Done");
        } catch (Exception e) {

            throw new RuntimeException(e);

        }
    }


    public static void main(String[] args) {
        ClusterSession.fixLogging();
       // createFile(args);
        downloadFile(args);
     }

}
