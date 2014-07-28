package cn.com.dhcc.cgn.mobins.collector.base;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;

/**
 * This class provide interface to execute command on remote Linux.
 */

public class SSHCommandExecutor {
    private String ipAddress;

    private String username;

    private String password;

    public static final int DEFAULT_SSH_PORT = 22;

    private Vector<String> stdout;

    public SSHCommandExecutor(final String ipAddress, final String username, final String password) {
        this.ipAddress = ipAddress;
        this.username = username;
        this.password = password;
        stdout = new Vector<String>();
    }

    public int execute(final String command) {
    	clearStdout();
        int returnCode = 0;
        JSch jsch = new JSch();
        MyUserInfo userInfo = new MyUserInfo();
        Session session = null;
        Channel channel = null;
        try {
            // Create and connect session.
            session = jsch.getSession(username, ipAddress, DEFAULT_SSH_PORT);
            session.setPassword(password);
            session.setUserInfo(userInfo);
            session.connect();

            // Create and connect channel.
            channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand(command);

            channel.setInputStream(null);
            BufferedReader input = new BufferedReader(new InputStreamReader(channel
                    .getInputStream()));

            channel.connect();
            System.out.println("[" + session.getUserName() + "@" + session.getHost() + " ~]# " + command);

            // Get the output of remote command.
            String line;
            while ((line = input.readLine()) != null) {
                stdout.add(line);
            }
            input.close();

            // Get the return code only after the channel
            if (channel.isClosed()) {
                returnCode = channel.getExitStatus();
            }

        } catch (JSchException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            // Disconnect the channel and session.
        	if(channel!=null)
            channel.disconnect();
        	if(session!=null)
            session.disconnect();
        }
        return returnCode;
    }

    public Vector<String> getStandardOutput() {
        return stdout;
    }
    
    public void clearStdout(){
    	this.stdout.clear();
    }

}
class MyUserInfo implements UserInfo {
    @Override
    public String getPassphrase() {
        System.out.println("MyUserInfo.getPassphrase()");
        return null;
    }

    @Override
    public String getPassword() {
        System.out.println("MyUserInfo.getPassword()");
        return null;
    }

    @Override
    public boolean promptPassphrase(final String arg0) {
        System.out.println("MyUserInfo.promptPassphrase()");
        System.out.println(arg0);
        return false;
    }

    @Override
    public boolean promptPassword(final String arg0) {
        System.out.println("MyUserInfo.promptPassword()");
        System.out.println(arg0);
        return false;
    }

    @Override
    public boolean promptYesNo(final String arg0) {
       /* System.out.println("MyUserInfo.promptYesNo()");
        System.out.println(arg0);
        if (arg0.contains("The authenticity of host")) {
            return true;
        }
        return false;*/
    	return true;
    }

    @Override
    public void showMessage(final String arg0) {
        System.out.println("MyUserInfo.showMessage()");
    }
}