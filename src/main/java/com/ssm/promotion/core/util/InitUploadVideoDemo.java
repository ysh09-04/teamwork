package com.ssm.promotion.core.util;

import com.netease.vcloud.auth.BasicCredentials;
import com.netease.vcloud.auth.Credentials;
import com.netease.vcloud.client.VcloudClient;
import com.netease.vcloud.upload.param.InitUploadVideoParam;

import java.util.HashMap;
import java.util.Map;


public class InitUploadVideoDemo {
	
	public static String upload(String path) {
		String appKey = "6797e6a05f06cc1491118c290b91ab4d";
		String appSecret = "268a68674ead";
		Credentials credentials;
		credentials = new BasicCredentials(appKey, appSecret);
		VcloudClient vclient = new VcloudClient(credentials);
		Map<String, Object> initParamMap = new HashMap<String, Object>();
		initParamMap.put("originFileName", path);
		try {
			InitUploadVideoParam initUploadVideoParam = vclient.initUploadVideo(initParamMap);
			if (initUploadVideoParam.getCode() == 200) {
				String qianzhui="http://jdvoddtuyt8a8.vod.126.net/";
				String videoUrl=qianzhui+initUploadVideoParam.getRet().getBucket()+"/"+initUploadVideoParam.getRet().getObject();
				return videoUrl;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
