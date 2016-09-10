package ftp;

import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;
 
/**
 * This test program illustrates how to utilize the FTPUtil class in order
 * to upload a whole directory to a FTP server.
 * @author www.codejava.net
 *
 */
public class FtpUploder implements Runnable{

	private String server;
	private int port;
	private String user;
	private String pass;
	private String remoteDirPath = "/public_html";
	private String localDirPath;
    
    
 
    public String getRemoteDirPath() {
		return remoteDirPath;
	}



	public void setRemoteDirPath(String remoteDirPath) {
		this.remoteDirPath = remoteDirPath;
	}



	public String getLocalDirPath() {
		return localDirPath;
	}



	public void setLocalDirPath(String localDirPath) {
		this.localDirPath = localDirPath;
	}



	public String getServer() {
		return server;
	}



	public void setServer(String server) {
		this.server = server;
	}



	public int getPort() {
		return port;
	}



	public void setPort(int port) {
		this.port = port;
	}



	public String getUser() {
		return user;
	}



	public void setUser(String user) {
		this.user = user;
	}



	public String getPass() {
		return pass;
	}



	public void setPass(String pass) {
		this.pass = pass;
	}



	public void run() {
        
 
        FTPClient ftpClient = new FTPClient();
 
        try {
            // connect and login to the server
            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
 
            // use local passive mode to pass firewall
            ftpClient.enterLocalPassiveMode();
 
            System.out.println("Connected");
 
            Ftp.uploadDirectory(ftpClient, remoteDirPath, localDirPath, "");

 
            // log out and disconnect from the server
            ftpClient.logout();
            ftpClient.disconnect();
 
            System.out.println("Disconnected");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}