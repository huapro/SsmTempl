package com.enation.eop.processor.facade;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enation.eop.IEopProcessor;
import com.enation.eop.sdk.context.EopSetting;
import com.enation.framework.context.webcontext.ThreadContextHolder;
/**
 * 安装处理器，响应/install来的响应
 * @author kingapex
 *2015-3-13
 */

public class InstallProcessor implements IEopProcessor {

	@Override
	public boolean process() throws IOException {
		
		HttpServletResponse httpResponse = ThreadContextHolder.getHttpResponse();
		HttpServletRequest httpRequest = ThreadContextHolder.getHttpRequest();
		String uri = httpRequest.getServletPath();

		if (!uri.startsWith("/install")	&& EopSetting.INSTALL_LOCK.toUpperCase().equals("NO")) {
			httpResponse.sendRedirect(httpRequest.getContextPath() + "/install");  //TODO 2018-05-21  09:05 Charles 重点  ！！！！如果开头不为"/install"且没有install.lock 则
			// todo
			return true;
		}
		
		if (uri.startsWith("/install")) {
			if( EopSetting.INSTALL_LOCK.toUpperCase().equals("NO")){ //单"/install" 进一步根据是否有install.lock判断 是否需要安装 没有则返回false
				return false; //要由chain处理
			}else{
				return true; //拒绝再执行
			}
			 
		}
		
		return true;
	}

	
}
