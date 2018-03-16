/*
 * Copyright (c) Tarek Hosni El Alaoui 2017
 */

package de.dytanic.cloudnetcore.util;

import de.dytanic.cloudnet.lib.utility.document.Document;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Tareko on 20.08.2017.
 */
public class MessageConfig {

    private Path path = Paths.get("local/ingame_messages.json");

    public MessageConfig()
    {
        if (!Files.exists(path))
        {
            new Document()
                    .append("prefix", "§bCloud §8|§7 ")
                    .append("----------------------------------------------------------------------------", "-")
                    .append("kick-maintenance", "§cThe network is currently in maintenance mode")
                    .append("full-join", "§cThe Network is full! You can join with a higher permissions!")
                    .append("hubCommandNoServerFound", "§cNo server was found, please wait")
                    .append("joinpower-deny", "You don't have any permissions to enter this server")
                    .append("server-group-maintenance-kick", "§cThis group is currently in maintenance mode!")
                    .append("mob-selector-maintenance-message", "§cThis group is currently in maintenance mode, please wait, before you can play!")
                    .append("notify-message-server-add", "§cThe server %server% is starting now...")
                    .append("notify-message-server-remove", "§cThe server %server% is now stopping!")
                    .append("hub-already", "§cYou are already connected to a hub server")
                    .append("server-kick-proxy-disallow", "§cYou have to connect from a internal proxy server!")
                    .append("information-sent", "The information was sent to the cloud")
                    .append("----------------------------------------------------------------------------", "-")
                    .append("#Allgemein", " ")
                    .append("server-no-exist", "The server doesn't exist.")
                    .append("group-no-exist", "The group doesn't exist.")
                    .append("----------------------------------------------------------------------------", "-")
                    .append("#Cloudbefehle", " ")
                    .append("autoslot-state", "The autoslot state was updated.")
                    .append("maintenance-state", "The maintenance state was updated.")
                    .append("wrapper-copy-directory", "The wrapper tried to copy the directory...")
                    .append("log-delete", "The log is dynamic and will be deleted on 10 minutes")
                    .append("log-see", "You can review the log at: ")
                    .append("setmaxplayer", "The maximum onlinecount was updated.")
                    .append("setmaxplayerfail", "§7The second argument is not a number.")
                    .append("----------------------------------------------------------------------------", "-")
                    .append("#PermissionSystem", " ")
                    .append("permission-group-no-exit", "The specified permission group doesn't exist")
                    .append("player-no-registered", "The player isn't registered in permissions database")
                    .append("permission-group-exists", "The permission group already exists")
                    .append("following-permissiongroups-registered", "The following permission groups are registered:")
                    .append("----------------------------------------------------------------------------", "-")
                    .append("#cdevbefehl", " ")
                    .append("server-startup", "The server will start up now...")
                    .append("template-no-exist", "The template doesn't exist")
                    .append("----------------------------------------------------------------------------", "-")
                    .append("#CloudServerbefehl", " ")
                    .append("mob-create", "The mob will be created, please wait...")
                    .append("mob-remove", "The mob has been removed")
                    .append("sign-create", "The sign was successfully created!")
                    .append("sign-remove", "The sign has been removed")
                    .append("sign-already-exists", "The sign already exists!")
                    .append("mob-group-no-exist", "The Mob doesn't exist on this group")
                    .saveAsConfig(path);
        }
    }

    public Document load()
    {

        boolean resave = false;
        Document document = Document.loadDocument(path);

        if(!document.contains("server-kick-proxy-disallow"))
        {
            document.append("server-kick-proxy-disallow", "§cYou have to connect from a internal proxy server!");
            resave = true;
        }

        if(resave) document.saveAsConfig(path);

        return document;
    }
}