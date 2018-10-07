package com.migo.seo.utils;

import java.util.HashMap;

/**
 * @author chintald
 *This class is Like Enum to store File Types needed for authentication.
 */
public class ApacheTikaFileType {
    private static final HashMap<String, String> apacheTikaFileTypes;
    static {
        apacheTikaFileTypes = new HashMap<String, String>();
        apacheTikaFileTypes.put("jpeg", "image/jpeg");
        apacheTikaFileTypes.put("jpg", "image/jpeg");
        apacheTikaFileTypes.put("png", "image/png");
    }
    public boolean isValidFileType(String fileExtension, String fileType){
        if(apacheTikaFileTypes.containsKey(fileExtension)
                && apacheTikaFileTypes.get(fileExtension).contains(fileType)){
            return true;
        }
        return false;
    }

};
