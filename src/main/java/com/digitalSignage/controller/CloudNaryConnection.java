package com.digitalSignage.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.Singleton;
import com.cloudinary.utils.ObjectUtils;

public class CloudNaryConnection {

    Cloudinary cloudinary=new Cloudinary(ObjectUtils.asMap("cloud_name","helpful-innovative-solution",
            "api_key","155499114945194",
            "api_secret","qVc8eKR-Gim5yBUPs56a1Wg_Gok"));


}
