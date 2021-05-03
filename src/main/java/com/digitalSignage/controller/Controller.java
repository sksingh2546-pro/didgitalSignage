package com.digitalSignage.controller;

import com.cloudinary.Singleton;
import com.cloudinary.utils.ObjectUtils;
import com.google.appengine.api.datastore.*;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.cloudinary.Cloudinary;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;


public class Controller {

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/direct_unsigned_upload_form", method = RequestMethod.GET)
    public String directUnsignedUploadPhotoForm(ModelMap model) throws Exception {
        model.addAttribute("photoUpload", new PhotoUpload());
        model.addAttribute("unsigned", true);
        Cloudinary cld = Singleton.getCloudinary();
        String preset = "sample_" + cld.apiSignRequest(ObjectUtils.asMap("api_key", cld.config.apiKey), cld.config.apiSecret).substring(0, 10);
        model.addAttribute("preset", preset);
        try {
            Singleton.getCloudinary().api().createUploadPreset(ObjectUtils.asMap(
                    "name", preset,
                    "unsigned", true,
                    "folder", "preset_folder"));
        } catch (Exception e) {
        }
        return "direct_upload_form";
    }






}