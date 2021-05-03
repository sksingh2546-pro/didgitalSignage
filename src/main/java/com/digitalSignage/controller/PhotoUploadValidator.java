package com.digitalSignage.controller;


import com.cloudinary.Cloudinary;
import com.cloudinary.Singleton;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PhotoUploadValidator implements Validator {
    public boolean supports(Class clazz) {
        return PhotoUpload.class.equals(clazz);
    }

    public void validate(Object obj, Errors e) {
        ValidationUtils.rejectIfEmpty(e, "title", "title.empty");
        PhotoUpload pu = (PhotoUpload) obj;

            if (!pu.validSignature()) {
                e.rejectValue("signature", "signature.mismatch");

        }
    }

}
