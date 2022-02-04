package io.inboxmsgapplication.controllers;

import io.inboxmsgapplication.inbox.folders.Folder;
import io.inboxmsgapplication.inbox.folders.FolderRepository;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class InboxController {

    @Autowired
    private FolderRepository folderRepository;

    @GetMapping(value = "/")
    public String homePage(@AuthenticationPrincipal OAuth2User principal, Model model){
        //model to pass things from controller to template and access it

        // checking if user is logged in - returning as per the user login status
        if(principal == null || !StringUtils.hasText(principal.getAttribute("login")) )
        {
            return "index";
        }

        String userId = principal.getAttribute("login");


        List<Folder> userFolders = folderRepository.findAllById(userId);
        model.addAttribute("userFolders",userFolders);


        return "inbox-page";

    }

}
