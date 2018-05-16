package com.enation.app.shop.component.goodscore;

import org.springframework.stereotype.Component;

import com.enation.app.base.core.service.solution.IInstaller;
import com.enation.framework.component.IComponent;
import com.enation.framework.context.spring.SpringContextHolder;

@Component
public class GoodsCoreComponent implements IComponent {

	@Override
	public void install() {
		IInstaller installer  = SpringContextHolder.getBean("warningSettingInstaller");
		
		installer.install("inventory", null);	 /*2018-05-16 08:18:24  Comphoner */
	}

	@Override
	public void unInstall() {
		 

	}

}
