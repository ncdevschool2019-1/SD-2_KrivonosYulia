package com.netcracker.projectmanager.services.impl;

import com.netcracker.projectmanager.entity.User;
import com.netcracker.projectmanager.repositories.UserRepository;
import com.netcracker.projectmanager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User save(User user) {

        return userRepository.save(user);
    }

    @Override
    public void delete(Integer id) {
        Optional<User> user = userRepository.findById(id);
        user.ifPresent(user1 -> userRepository.delete(user1));
    }

//    @Override
//    public User uploadUsersImage(MultipartFile image, Integer id) throws IOException {
//        String imageName = image.getOriginalFilename();
//        if (this.userRepository.findById(id).isPresent()) {
//            User user = this.userRepository.findById(id).get();
//            String imageNewName = user.getId().toString() + "_" + user.getLogin() +
//                    imageName.substring(imageName.lastIndexOf('.'));
//            File serverFile = new File("backend/src/images/usersImages/", user.getId().toString());
//            if (serverFile.exists()) {
//                deleteImage(imageNewName);
//            }
//            if (!serverFile.exists()) {
//                serverFile.mkdir();
//            }
//            serverFile = new File(serverFile.getPath() + "/", imageNewName);
//            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
//            stream.write(image.getBytes());
//            stream.close();
//            user.setImagePath(imageNewName);
//            return this.userRepository.save(user);
//        }
//        return null;
//    }





}
