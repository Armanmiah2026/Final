package com.example.bongovpn;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

/** SSH installer. Credentials are held only for the duration of the connection and never persisted. */
public final class ServerInstaller {
    private ServerInstaller() {}
    public static String install(String host,int sshPort,String user,String password,boolean installOpenVpn,boolean installXray,List<Integer> ports) throws Exception {
        JSch jsch=new JSch(); Session session=jsch.getSession(user,host,sshPort); session.setPassword(password);
        session.setConfig("StrictHostKeyChecking","no"); session.connect(15000);
        try {
            StringBuilder cmd=new StringBuilder("set -e; export DEBIAN_FRONTEND=noninteractive; apt-get update -y; apt-get install -y curl ca-certificates openssl iptables");
            if(installOpenVpn) cmd.append(" openvpn");
            if(installXray) cmd.append(" unzip");
            cmd.append("; ");
            if(installXray) cmd.append("if ! command -v xray >/dev/null 2>&1; then curl -fsSL https://github.com/XTLS/Xray-install/raw/main/install-release.sh | bash; fi; ");
            if(!ports.isEmpty()){
                cmd.append("for p in "); for(Integer p:ports)cmd.append(p).append(' '); cmd.append("; do iptables -C INPUT -p tcp --dport $p -j ACCEPT 2>/dev/null || iptables -I INPUT -p tcp --dport $p -j ACCEPT; iptables -C INPUT -p udp --dport $p -j ACCEPT 2>/dev/null || iptables -I INPUT -p udp --dport $p -j ACCEPT; done; ");
            }
            cmd.append("echo SENSEI_INSTALL_OK");
            ChannelExec ch=(ChannelExec)session.openChannel("exec"); ch.setCommand(cmd.toString()); ByteArrayOutputStream out=new ByteArrayOutputStream(); ch.setOutputStream(out); ch.setErrStream(out); ch.connect(10000); while(!ch.isClosed())Thread.sleep(100); int status=ch.getExitStatus(); String result=out.toString(StandardCharsets.UTF_8.name()); ch.disconnect(); if(status!=0)throw new IllegalStateException(result); return "Server install completed\n"+result.trim();
        } finally { session.disconnect(); }
    }
}
