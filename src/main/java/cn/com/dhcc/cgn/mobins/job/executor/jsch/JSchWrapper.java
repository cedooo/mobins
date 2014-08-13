package cn.com.dhcc.cgn.mobins.job.executor.jsch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

import cn.com.dhcc.cgn.mobins.job.executor.result.ExecutorResult;
import cn.com.dhcc.cgn.mobins.po.HostInspectionPoint;

public class JSchWrapper {
	static final private Logger LOG = LoggerFactory.getLogger(JSchWrapper.class.getClass());
	static final private int DEFAULT_INTERN = 3000;
	static final private int DEFAULT_PORT = 22;
	static final private String EXECUTE_VALID_COMMANDS = "date";
	private String ipaddr = null;
	private String user = null;
	private int port = DEFAULT_PORT;
    private JSch jsch = null;
	public String getIpaddr() {
		return ipaddr;
	}
	public void setIpaddr(String ipaddr) {
		this.ipaddr = ipaddr;
	}

	private String passwd = null;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	/**
	 * 
	 * @param ip IP地址
	 * @param user 用户名
	 * @param passwd 密码
	 */
	public JSchWrapper(String ip, String user, String passwd){
		this(ip, user, passwd, DEFAULT_PORT);
	}
	/**
	 * 
	 * @param ip IP地址
	 * @param user 用户名
	 * @param passwd 密码
	 * @param port 端口
	 */
	public JSchWrapper(String ip, String user, String passwd, int port){
		this.ipaddr = ip;
		this.user = user;
		this.passwd = passwd;
		this.port = port;
	}
	
	/**
	 * 验证用户名、密码
	 * @param user 用户名
	 * @param passwd 密码
	 * @return 成功返回true，否则返回false
	 */
	public ConnectResult validate(){
		jsch = new JSch();
		Session session = null;
		ConnectResult result = new ConnectResult();
	    try {
			session=jsch.getSession(user, ipaddr, port);
			session.setPassword(passwd);
			UserInfo ui = new MyUserInfo();
			session.setUserInfo(ui);
			session.connect(DEFAULT_INTERN);
			LOG.info("登录验证：用户" + user + "登录" + ipaddr + ":" + port);
			Channel channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand(EXECUTE_VALID_COMMANDS);
            BufferedReader input = null;
            try{
            	input = new BufferedReader(new InputStreamReader(channel.getInputStream()));
                channel.connect();
                String line;
                StringBuilder strBuild = new StringBuilder();
                while ((line = input.readLine()) != null) {
                	strBuild.append(line);
                }
                LOG.info("登录后验证命令执行结果：" + strBuild );
            }finally{
            	if(input!=null){
            		input.close();
            	}
            }
    		result.setResult("登录成功");
    		result.setSuccess(true);
		} catch (JSchException e) {
			result.setResult("IP、帐号、密码不匹配，连接失败。");
			result.setSuccess(false);
		} catch (IOException e) {
			result.setResult("IP、帐号、密码不匹配，连接失败。");
			result.setSuccess(false);
		} finally{
			if(session!=null){
				session.disconnect();
			}
		}
	    LOG.debug(result.toString());
		return result;
	}
	/**
	 * 执行巡检点命令
	 * @param host 主机信息
	 * @param listPoint 巡检点
	 * @return
	 */
	public  Map<HostInspectionPoint, ExecutorResult> executeCommands(List<HostInspectionPoint> listPoint){
		Map<HostInspectionPoint, ExecutorResult> maps = new HashMap<HostInspectionPoint, ExecutorResult>();
		ConnectResult result = validate();
		if(result.isSuccess()){
			JSch jsch = new JSch();
			Session session = null;
		    try {
				session=jsch.getSession(user, ipaddr, port);
				session.setPassword(passwd);
				UserInfo ui = new MyUserInfo();
				session.setUserInfo(ui);
				session.connect(DEFAULT_INTERN);
				LOG.info("用户" + user + "登录" + ipaddr + ":" + port);
	            BufferedReader input = null;
	            try{
	            	for (HostInspectionPoint hostInspectionPoint : listPoint) {
	    				Channel channel = session.openChannel("exec");
			            ((ChannelExec) channel).setCommand(hostInspectionPoint.getOperCommand());
		            	input = new BufferedReader(new InputStreamReader(channel.getInputStream()));
		                channel.connect();
		                String line;
		                LOG.debug("命令" + hostInspectionPoint.getOperCommand() +  "执行结果");
		                ExecutorResult exeResult = new ExecutorResult();
		                Vector<String> vct = new Vector<String>();
		                while ((line = input.readLine()) != null) {
		                    LOG.info(line);
		                    vct.add(line);
		                }
		                exeResult.setResultVector(vct);
		                exeResult.setExecuteInfo("执行成功");
		                maps.put(hostInspectionPoint, exeResult);
					}
	            } catch (IOException e) {
					e.printStackTrace();
				}finally{
	            	if(input!=null){
	            		try {
							input.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
	            	}
	            }
		    } catch (JSchException e) {
				e.printStackTrace();
			}finally{
		    	if(session!=null){
		    		session.disconnect();
		    	}
		    }
		}else{
			LOG.debug("登录失败");
		}		
		return maps;
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
