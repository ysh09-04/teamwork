package com.ssm.promotion.core.util;
import com.netease.vcloud.auth.BasicCredentials;
import com.netease.vcloud.auth.Credentials;
import com.netease.vcloud.client.VcloudClient;
import com.netease.vcloud.upload.param.QueryVideoIDorWatermarkIDParam;
import com.netease.vcloud.util.FileUtil;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;


/**
 * <p>Title: UploadVideoDemo</p>
 * <p>Description: 绠?鍗曠殑瑙嗛涓婁紶鐨凞emo</p>
 * <p>Company: com.netease.vcloud</p>
 *
 * @date 2016-6-22
 */
public class UploadVideoDemo {


    public static String upload(String path,String videoName) {
        String appKey = "6797e6a05f06cc1491118c290b91ab4d";
        String appSecret = "268a68674ead";

        Credentials credentials;
        credentials = new BasicCredentials(appKey, appSecret);
        VcloudClient vclient = new VcloudClient(credentials);
        try {
            String filePath = path;
            Map<String, Object> initParamMap = new HashMap<String, Object>();
            initParamMap.put("originFileName", FileUtil.getFileName(filePath));
            QueryVideoIDorWatermarkIDParam queryVideoIDParam = vclient.uploadVideo(filePath, initParamMap);
            if (null != queryVideoIDParam) {
                System.out.println("[UploadDemo] upload video successfully and the vid is " + queryVideoIDParam.getRet().getList().get(0).getVid());
                System.out.println("[UploadDemo] upload video successfully and the imgid is " + queryVideoIDParam.getRet().getList().get(0).getImgId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String uploadpath=InitUploadVideoDemo.upload(videoName);
        return uploadpath;
    }
}
