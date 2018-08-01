package com.cainiao.exclusive.ftp;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;
import java.net.SocketException;
import java.util.regex.Matcher;

/**
 * Ftp工具类
 * 
 * @author liujian
 */
public class FtpUtil {

	/**
	 * 上传文件到指定目录
	 * 
	 * @param ip
	 * @param port
	 * @param username
	 * @param userpwd
	 * @param serverpath
	 * @param file
	 * @return
	 */
	public static boolean uploadFile(String ip, int port, String username, String userpwd, String serverpath,
			String file) {
		System.out.println("method name : uploadFile");
		InputStream input = null;
		FTPClient ftp = new FTPClient();
		ftp.setControlEncoding("UTF-8");
		try {
			int reply = 0;
			ftp.connect(ip, port);
			boolean flag = ftp.login(username, userpwd);
			if (!flag) {
				System.out.println("登录Ftp失败 , ip:" + ip + "->port:" + port + "->username:" + username + "->userpwd:" + userpwd);
				return false;
			}
			// 生产环境有防火墙 用该方法才能远程取文件
			// FTPClient为被动传输模式即可解决线程挂起问题。
			ftp.enterLocalPassiveMode();
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				return false;
			}
			serverpath = gbkToIso8859(serverpath);
			ftp.changeWorkingDirectory(iso8859ToGbk(serverpath));
            

			if (!dirExits(ftp, iso8859ToGbk(serverpath))) {
				System.out.println("Create Directory failed:" + serverpath);
				return false;
			}

			file = gbkToIso8859(file);
			input = new FileInputStream(iso8859ToGbk(file));

			file = iso8859ToGbk(file);

			String fileAddr = iso8859ToGbk(serverpath) + "/" + iso8859ToGbk(getFilename(file));
			if (ftp.storeFile(fileAddr + ".ing", input)) {
				System.out.println("开始重命名" + file + ".ing to " + file);
				ftp.rename(fileAddr + ".ing", fileAddr);
				return true;
			} else {
				System.out.println("上传失败");
			}
		} catch (SocketException e) {
			System.out.println("SocketException:" + e);
		} catch (IOException e) {
			System.out.println("IOException:" + e);
		} finally {
			try {
				if (null != input) {
					input.close();
				}
				if (null != ftp && ftp.isConnected()) {
					ftp.logout();
				}
			} catch (IOException e) {
				System.out.println("IOException:" + e);
			}
		}
		return false;
	}

	/**
	 * 上传文件到指定目录
	 * 
	 * @param ip
	 * @param port
	 * @param username
	 * @param userpwd
	 * @param serverpath
	 * @return
	 */
	public static boolean uploadLocalFile(String ip, int port, String username, String userpwd, String serverpath,
			String fileName, String localAddr) {
		System.out.println("method name : uploadFile");
		System.out.println("上传文件到Ftp指定目录 , ip:" + ip + "->port:" + port);
		InputStream input = null;
		FTPClient ftp = new FTPClient();
		ftp.setControlEncoding("UTF-8");
		try {
			int reply = 0;
			ftp.setConnectTimeout(50000);
			ftp.connect(ip, port);
			boolean flag = ftp.login(username, userpwd);
			if (!flag) {
				System.out.println("登录Ftp失败 , ip:" + ip + "->port:" + port + "->username:" + username + "->userpwd:" + userpwd);
				return false;
			}
			// 生产环境有防火墙 用该方法才能远程取文件
			// FTPClient为被动传输模式即可解决线程挂起问题。
			ftp.enterLocalPassiveMode();
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				return false;
			}
			serverpath = gbkToIso8859(serverpath);
			ftp.changeWorkingDirectory(iso8859ToGbk(serverpath));
			if (!dirExits(ftp, iso8859ToGbk(serverpath))) {
				System.out.println("Create Directory failed:" + serverpath);
				return false;
			}

			String file = gbkToIso8859(localAddr + "/" + fileName);
			input = new FileInputStream(iso8859ToGbk(file));

//			file = iso8859ToGbk(file);

			String fileAddr = iso8859ToGbk(serverpath) + "/" + iso8859ToGbk(getFilename(fileName));
			if (ftp.storeFile(fileAddr + ".ing", input)) {
				System.out.println("开始重命名" + fileName + ".ing to " + fileName);
				ftp.rename(fileAddr + ".ing", fileAddr);
				return true;
			} else {
				System.out.println("上传失败");
			}
		} catch (SocketException e) {
			System.out.println(e.getMessage() + "登录失败~~");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (null != input) {
					input.close();
				}
				if (null != ftp && ftp.isConnected()) {
					ftp.logout();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		return false;
	}
    /**
     * 上传文件到指定目录（编码问题）
     * @param ip
     * @param port
     * @param username
     * @param userpwd
     * @param serverpath
     * @return
     */
    public static boolean uploadLocalFile2(String ip, int port, String username, String userpwd, String serverpath,
            String fileName, String localAddr) {
    	
        System.out.println("method name : uploadFile");
        System.out.println("上传文件到Ftp指定目录 , ip:" + ip + "->port:" + port);
        InputStream input = null;
        FTPClient ftp = new FTPClient();
      
        try {
            int reply = 0;
            ftp.connect(ip, port);
            boolean flag = ftp.login(username, userpwd);
            if (!flag) {
                System.out.println("登录Ftp失败 , ip:" + ip + "->port:" + port + "->username:" + username + "->userpwd:" + userpwd);
                return false;
            }
            // 生产环境有防火墙 用该方法才能远程取文件
            // FTPClient为被动传输模式即可解决线程挂起问题。
            
            ftp.enterLocalPassiveMode();
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return false;
            }
            
            ftp.changeWorkingDirectory(serverpath);
            if (!dirExits(ftp, serverpath)) {
                System.out.println("Create Directory failed:" + serverpath);
                return false;
            }
            
            
                String files[] = ftp.listNames(serverpath); 
                if (files == null || files.length == 0){ 
                }else { 
                	for (int i = 0; i < files.length; i++) { 
                        //匹配要求
                		if (files[i].indexOf(fileName)>0){
                			//ftp.deleteFile(fileName);
                			System.out.println(">>>>请通知基金公司删除已经存在月解冻文件：" + fileName + "=================>>>>>>");
                			return false;
                		}
                    } 
                }
                
            String file = localAddr + "/" + fileName;
            input = new FileInputStream(file);

            
            String fileAddr = serverpath + "/" + getFilename(fileName);
            if (ftp.storeFile(fileAddr + ".ing", input)) {
                System.out.println("开始重命名" + fileName + ".ing to " + fileName);
                ftp.rename(fileAddr + ".ing", fileAddr);
                return true;
            } else {
                System.out.println("上传失败");
            }
        } catch (SocketException e) {
        } catch (IOException e) {
        	System.out.println(e.getMessage());
        } finally {
            try {
                if (null != input) {
                    input.close();
                }
                if (null != ftp && ftp.isConnected()) {
                    ftp.logout();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }

		/**
	     * 从指定FTP服务器查询某文件是否存在
	     * @param ip
	     * @param username
	     * @param password
	     * @param serverpath
	     * @param fileName
	     * @return
	     */
	    public static FTPFile checkFile(String ip, int port, String username, String password, String serverpath,
	            String fileName) {
	       
	        FTPFile ftpFile = null;
	        FTPClient ftp = new FTPClient();
	        ftp.setControlEncoding("UTF-8");

	        try {
	            int reply;
	            ftp.connect(ip, port);
	            ftp.login(username, password);
	            ftp.enterLocalPassiveMode();
	            reply = ftp.getReplyCode();
	            if (!FTPReply.isPositiveCompletion(reply)) {
	                ftp.disconnect();
	                return ftpFile;
	            }
	            
	            serverpath = gbkToIso8859(serverpath);
	            ftp.changeWorkingDirectory(iso8859ToGbk(serverpath));         
	            fileName = gbkToIso8859(fileName);            
	            FTPFile[] fs;
	            if (fileName.indexOf("009_RECHARGE.BALANCE")>=0){
	            	fs =ftp.listFiles("ac");  
	            	  for (FTPFile f : fs) {
	            		  if (f.getName().matches(".*"+fileName+".*")){            		   
	             			 ftpFile=f;
	                 		 break;             			 
	             		 }
	            	  }       	
	            	
	            }else{
	                fs =ftp.listFiles(fileName);
	                if (fs!=null&&fs.length==1){
	                    ftpFile=fs[0];
	                }
	            	
	             };
	            
	            ftp.logout();
	        } catch (SocketException e) {
	        	System.out.println("SocketException:" + e);
	        } catch (IOException e) {
	        	System.out.println("IOException:" + e);
	        } finally {
	            if (ftp.isConnected()) {
	                try {
	                    ftp.disconnect();
	                } catch (IOException ioe) {
	                }
	            }
	        }
	        return ftpFile;
	    }

    /**
     * 获取单个文件
     * @param ip ftp服务器host
     * @param port ftp服务器端口
     * @param username 登录ftp服务器用户名
     * @param password 登录ftp服务器密码
     * @param serverpath 访问ftp路径
     * @param fileName 需要下载文件的文件名
     * @param localPath 保存的本地路径
     * @return
     */
    public static String downFileById(String ip, int port, String username, String password, String serverpath,
            String fileName, String localPath) {
        FTPClient ftp = new FTPClient();
        ftp.setControlEncoding("UTF-8");
        OutputStream is = null;
        try {
            int reply;
            ftp.setConnectTimeout(50000);
            ftp.connect(ip, port);
            ftp.login(username, password);
            // 生产环境有防火墙 用该方法才能远程取文件
            // FTPClient为被动传输模式即可解决线程挂起问题。
            ftp.enterLocalPassiveMode();
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return "getconnect";
            }
            serverpath = gbkToIso8859(serverpath);
            ftp.changeWorkingDirectory(iso8859ToGbk(serverpath));

            fileName = gbkToIso8859(fileName);
            localPath = gbkToIso8859(localPath);

            File localFile = new File(iso8859ToGbk(localPath) + File.separatorChar + System.currentTimeMillis()+"_"+fileName);
            File localFileDir = new File(iso8859ToGbk(localPath));
            if (!localFileDir.exists()) {
                System.out.println(localFileDir.getAbsolutePath() + "创建成功!");
                localFileDir.mkdirs();
            }
            is = new FileOutputStream(localFile);
            if (ftp.retrieveFile(fileName, is)) {
                System.out.println("本地文件路径：" + localFile.getAbsolutePath());
                return "fileDowmSucess";
            } else {
                if (localFile.exists()) {
                    is.close();
                    is = null;
                    localFile.deleteOnExit();
                    if (localFile.exists()) {
                        localFile.delete();
                    }
                }
                return "fileDowmfail";
            }
        } catch (SocketException e) {
        	System.out.println("SocketException:"+e+"========1");
        } catch (IOException e) {
        	System.out.println("IOException:"+e+"==========2");
        } finally {
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                	System.out.println("IOException:"+e+"===========3");
                }
            }
            if (null != ftp) {
                try {
                    ftp.logout();
                } catch (IOException e) {
                	System.out.println("IOException:"+e+"=============4");
                }
            }
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return "fail";
    }
    /**
     * 获取单个文件
     * @param ip ftp服务器host
     * @param port ftp服务器端口
     * @param username 登录ftp服务器用户名
     * @param password 登录ftp服务器密码
     * @param serverpath 访问ftp路径
     * @param fileName 需要下载文件的文件名
     * @param localPath 保存的本地路径
     * @return
     */
    
    public static boolean downFileById2(String ip, int port, String username, String password, String serverpath,
            String fileName, String localPath) {
    	
        boolean success = false;
        FTPClient ftp = new FTPClient();
      
       OutputStream is = null;
        try {
            int reply;
            ftp.connect(ip, port);
            ftp.login(username, password);
            // 生产环境有防火墙 用该方法才能远程取文件
            // FTPClient为被动传输模式即可解决线程挂起问题。
            
            ftp.enterLocalPassiveMode();
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            reply = ftp.getReplyCode();
            
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return success;
            }
            
            ftp.changeWorkingDirectory(serverpath);

            File localFile = new File(localPath + File.separatorChar + fileName);
            File localFileDir = new File(localPath);
            if (!localFileDir.exists()) {
                System.out.println(localFileDir.getAbsolutePath() + "创建成功!");
                localFileDir.mkdirs();
            }
            is = new FileOutputStream(localFile);
            if (ftp.retrieveFile(fileName, is)) {
                System.out.println("本地文件路径：" + localFile.getAbsolutePath());
                return true;
            } else {
                if (localFile.exists()) {
                    is.close();
                    is = null;
                    localFile.deleteOnExit();
                    if (localFile.exists()) {
                        localFile.delete();
                    }
                }
                return false;
            }
        } catch (SocketException e) {
        	System.out.println("SocketException:"+e);
        } catch (IOException e) {
        	System.out.println("IOException:"+e);
        } finally {
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                	System.out.println("IOException:"+e);
                }
            }
            if (null != ftp) {
                try {
                    ftp.logout();
                } catch (IOException e) {
                	System.out.println("IOException:"+e);
                }
            }
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return false;
    }
    /**
     * 获取单个文件
     * @param ip ftp服务器host
     * @param port ftp服务器端口
     * @param username 登录ftp服务器用户名
     * @param password 登录ftp服务器密码
     * @param serverpath 访问ftp路径
     * @param fileName 需要下载文件的文件名
     * @param localPath 保存的本地路径
     * @param fjFlag 福建计费现金充值对账文件下载完后，更改对方ftp上的对账文件名(加上".OK"后缀)
     * @return
     */
    public static boolean downFileById(String ip, int port, String username, String password, String serverpath,
            String fileName, String localPath, boolean fjFlag) {
        boolean success = false;
        FTPClient ftp = new FTPClient();
        ftp.setControlEncoding("UTF-8");
        OutputStream is = null;
        try {
            int reply;
            ftp.connect(ip, port);
            ftp.login(username, password);
            // 生产环境有防火墙 用该方法才能远程取文件
            // FTPClient为被动传输模式即可解决线程挂起问题。
            ftp.enterLocalPassiveMode();
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return success;
            }
            serverpath = gbkToIso8859(serverpath);
            ftp.changeWorkingDirectory(iso8859ToGbk(serverpath));

            fileName = gbkToIso8859(fileName);
            localPath = gbkToIso8859(localPath);

            File localFile = new File(iso8859ToGbk(localPath) + "/" + fileName);
            File localFileDir = new File(iso8859ToGbk(localPath));
            if (!localFileDir.exists()) {
                System.out.println(localFileDir.getAbsolutePath() + "创建成功!");
                localFileDir.mkdirs();
            }
            is = new FileOutputStream(localFile);
            if (ftp.retrieveFile(fileName, is)) {
                System.out.println("本地文件路径：" + localFile.getAbsolutePath());
                ftp.rename(fileName, fileName+".OK");
                return true;
            } else {
                if (localFile.exists()) {
                    is.close();
                    is = null;
                    localFile.deleteOnExit();
                    if (localFile.exists()) {
                        localFile.delete();
                    }
                }
                return false;
            }
        } catch (SocketException e) {
        	System.out.println("SocketException:"+e);
        } catch (IOException e) {
        	System.out.println("IOException:"+e);
        } finally {
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                	System.out.println("IOException:"+e);
                }
            }
            if (null != ftp) {
                try {
                    ftp.logout();
                } catch (IOException e) {
                	System.out.println("IOException:"+e);
                }
            }
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return false;
    }
    private static String getFilename(String file) {
        String filename = "";
        if (file != null && !file.equals("")) {
            file = file.replaceAll(Matcher.quoteReplacement("//"), "/");
            String[] strs = file.split("/");
            filename = strs[strs.length - 1];
        }
        filename = gbkToIso8859(filename);
        return filename;
    }

    private static String gbkToIso8859(Object obj) {
        try {
            if (obj == null) {
                return "";
            } else {
                return new String(obj.toString().getBytes("GBK"), "iso-8859-1");
            }
        } catch (Exception e) {
            return "";
        }
    }
    private static String iso8859ToGbk(Object obj) {
        try {
            if (obj == null) {
                return "";
            } else {
                return new String(obj.toString().getBytes("iso-8859-1"), "GBK");
            }
        } catch (Exception e) {
            return "";
        }
    }

    public static boolean dirExits(FTPClient ftp, String serverPath) {
        try {
            if (serverPath.startsWith("/")) {
                ftp.changeWorkingDirectory("/");
                if (!serverPath.endsWith("/")) {
                    serverPath += "/";
                }
                int start = 1;
                int end = serverPath.indexOf("/", start);
                boolean flag = true;
                while (flag && start < end) {
                    String subDirectory = new String(serverPath.substring(start, end).getBytes("GBK"), "iso-8859-1");
                    if (!ftp.changeWorkingDirectory(subDirectory)) {
                        if (ftp.makeDirectory(subDirectory)) {
                            ftp.changeWorkingDirectory(subDirectory);
                            System.out.println("Create Directory (" + subDirectory + ") success!");
                        }
                    }
                    start = end + 1;
                    end = serverPath.indexOf("/", start);
                }
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
        	System.out.println("IOException:"+e);
        }
        return false;
    }
    /**
     * 获取单个文件
     * @param ip ftp服务器host
     * @param port ftp服务器端口
     * @param username 登录ftp服务器用户名
     * @param password 登录ftp服务器密码
     * @param serverpath 访问ftp路径
     * @param fileName 需要下载文件的文件名
     * @param localPath 保存的本地路径
     * @return 0 ftp连不上  1下载文件成功  -1 ftp上不存在该文件
     */
    public static int downFileAndReason(String ip, int port, String username, String password, String serverpath,
            String fileName, String localPath) {
        FTPClient ftp = new FTPClient();
        ftp.setControlEncoding("UTF-8");
        OutputStream is = null;
        try {
            int reply;
            ftp.connect(ip, port);
            ftp.login(username, password);
            // 生产环境有防火墙 用该方法才能远程取文件
            // FTPClient为被动传输模式即可解决线程挂起问题。
            ftp.enterLocalPassiveMode();
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return 0;
            }
            serverpath = gbkToIso8859(serverpath);
            ftp.changeWorkingDirectory(iso8859ToGbk(serverpath));

            fileName = gbkToIso8859(fileName);
            localPath = gbkToIso8859(localPath);

            File localFile = new File(iso8859ToGbk(localPath) + "/" + fileName);
            File localFileDir = new File(iso8859ToGbk(localPath));
            if (!localFileDir.exists()) {
                System.out.println(localFileDir.getAbsolutePath() + "创建成功!");
                localFileDir.mkdirs();
            }
            is = new FileOutputStream(localFile);
            if (ftp.retrieveFile(fileName, is)) {
                System.out.println("本地文件路径：" + localFile.getAbsolutePath());
                return 1;
            } else {
                if (localFile.exists()) {
                    is.close();
                    is = null;
                    localFile.deleteOnExit();
                    if (localFile.exists()) {
                        localFile.delete();
                    }
                }
                return -1;
            }
        } catch (SocketException e) {
        	System.out.println("SocketException:"+e);
        } catch (IOException e) {
        	System.out.println("IOException:"+e);
        } finally {
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                	System.out.println("IOException:"+e);
                }
            }
            if (null != ftp) {
                try {
                    ftp.logout();
                } catch (IOException e) {
                	System.out.println("IOException:"+e);
                }
            }
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                	System.out.println("IOException:"+ioe);
                }
            }
        }
        return 0;
    }

	private static boolean downFileAndDelete(String ip, int port, String username, String password, String serverpath,
            String fileName, String localPath) {
        boolean success = false;
        FTPClient ftp = new FTPClient();
        ftp.setControlEncoding("UTF-8");
        OutputStream is = null;
        try {
            int reply;
            ftp.setConnectTimeout(50000);
            ftp.connect(ip, port);
            ftp.login(username, password);
            // 生产环境有防火墙 用该方法才能远程取文件
            // FTPClient为被动传输模式即可解决线程挂起问题。
            ftp.enterLocalPassiveMode();
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return success;
            }
            serverpath = gbkToIso8859(serverpath);
            ftp.changeWorkingDirectory(iso8859ToGbk(serverpath));

            fileName = gbkToIso8859(fileName);
            localPath = gbkToIso8859(localPath);

            File localFile = new File(iso8859ToGbk(localPath) + File.separatorChar + fileName);
            File localFileDir = new File(iso8859ToGbk(localPath));
            if (!localFileDir.exists()) {
                System.out.println(localFileDir.getAbsolutePath() + "创建成功!");
                localFileDir.mkdirs();
            }
            is = new FileOutputStream(localFile);
            if (ftp.retrieveFile(fileName, is)) {
                System.out.println("本地文件路径：" + localFile.getAbsolutePath());
                System.out.println("删除文件名为" + fileName + "的数据");
                ftp.deleteFile(fileName);
                return true;
            } else {
                if (localFile.exists()) {
                    is.close();
                    is = null;
                    localFile.deleteOnExit();
                    if (localFile.exists()) {
                        localFile.delete();
                    }
                }
                return false;
            }
        } catch (SocketException e) {
        	System.out.println("SocketException:"+e);
        } catch (IOException e) {
        	System.out.println("IOException:"+e);
        } finally {
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                	System.out.println("IOException:"+e);
                }
            }
            if (null != ftp) {
                try {
                    ftp.logout();
                } catch (IOException e) {
                	System.out.println("IOException:"+e);
                }
            }
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return false;
    }
}
