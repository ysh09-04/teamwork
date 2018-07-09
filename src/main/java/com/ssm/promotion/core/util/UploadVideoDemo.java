package com.ssm.promotion.core.util;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.netease.vcloud.auth.BasicCredentials;
import com.netease.vcloud.auth.Credentials;
import com.netease.vcloud.client.VcloudClient;
import com.netease.vcloud.upload.param.QueryVideoIDorWatermarkIDParam;
import com.netease.vcloud.util.FileUtil;


/**
 * <p>Title: UploadVideoDemo</p>
 * <p>Description: 绠?鍗曠殑瑙嗛涓婁紶鐨凞emo</p>
 * <p>Company: com.netease.vcloud</p>
 *
 * @date 2016-6-22
 */
public class UploadVideoDemo {


    public static void upload(String path,String videoName,HttpServletRequest request) {
        String appKey = "6797e6a05f06cc1491118c290b91ab4d";
        String appSecret = "268a68674ead";

        Credentials credentials;
        credentials = new BasicCredentials(appKey, appSecret);
        VcloudClient vclient = new VcloudClient(credentials);
        try {
            String filePath = path;
            Map<String, Object> initParamMap = new HashMap<String, Object>();
            initParamMap.put("originFileName", FileUtil.getFileName(filePath));
            QueryVideoIDorWatermarkIDParam queryVideoIDParam = vclient.uploadVideo(filePath, initParamMap,request);
            if (null != queryVideoIDParam) {
                System.out.println("[UploadDemo] upload video successfully and the vid is " + queryVideoIDParam.getRet().getList().get(0).getVid());
                System.out.println("[UploadDemo] upload video successfully and the imgid is " + queryVideoIDParam.getRet().getList().get(0).getImgId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
