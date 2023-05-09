package io.github.natanaeldepaulo.api.domain.services;

import io.github.natanaeldepaulo.api.application.models.infraInterfaces.IUploadService;
import io.github.natanaeldepaulo.api.domain.entities.User;
import io.github.natanaeldepaulo.api.application.models.infraInterfaces.IAwsProvider;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@Service
public class UploadServiceImpl implements IUploadService {
    private IAwsProvider _awsProvider;

    @Override
    public String upload(MultipartFile file){
        var user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        var fileName = user.getId() + "." + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);

        var imagePath = "";

        try {
            imagePath = _awsProvider.upload(file, fileName);
        } catch (Exception e){

        }

        return imagePath;
    }
}
