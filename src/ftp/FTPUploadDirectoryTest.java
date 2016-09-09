package ftp;

import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;
 
/**
 * This test program illustrates how to utilize the FTPUtil class in order
 * to upload a whole directory to a FTP server.
 * @author www.codejava.net
 *
 */
public class FTPUploadDirectoryTest {
 
    public static void main(String[] args) {
        String server = "ftp.alialmandoz.hol.es";
        int port = 21;
        String user = "u326125313";
        String pass = "hostinger159753";
 
        FTPClient ftpClient = new FTPClient();
 
        try {
            // connect and login to the server
            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
 
            // use local passive mode to pass firewall
            ftpClient.enterLocalPassiveMode();
 
            System.out.println("Connected");
 
            String remoteDirPath = "/public_html";
            String localDirPath = "D:/Java/arch";
 
            FtpUploader.uploadDirectory(ftpClient, remoteDirPath, localDirPath, "");
 
            // log out and disconnect from the server
            ftpClient.logout();
            ftpClient.disconnect();
 
            System.out.println("Disconnected");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}