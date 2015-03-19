/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trevorslab.ChatCompanion;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jibble.pircbot.*;

public class Bot extends PircBot {
    String owner = "trevorslab";
    public Bot() {
        this.setName("ChatCompanion");
        try {
            // Connect to the IRC server."oauth:o8hwfgplpwba3je0upwr6jlkt2ox2e"
            this.connect("irc.freenode.net");
        } catch (IOException ex) {
            Logger.getLogger(ChatCompanion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IrcException ex) {
            Logger.getLogger(ChatCompanion.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setMessageDelay(1);
        // Join the #pircbot channel.
        this.joinChannel("#chatcompanion");
        sendMessage("#chatcompanion", "Hi! Im ChatCompanion, a chat Companion/Bot. My Creator is TrevorsLab. Note I must be given mod to perform tasks.");
    }
    
    @Override
    public void onMessage(String channel, String sender,
                       String login, String hostname, String message) {
        String[] splitMessage = message.split(" ");
        switch(splitMessage[0]){
            case "!time":
                String time = new java.util.Date().toString();
                sendMessage(channel, sender + ": The time is now " + time);
                break;
            case "!aboutbot":
                switch(splitMessage[1]){
                    case "version":
                        sendMessage(channel, "The Curent Version Of "
                                + "ChatCompanion is 0.0.2 BETA");
                        break;
                }
                break;
            case "!commands":
                sendMessage(channel, "The Commands for this channel Are");
                sendMessage(channel, "!time");
                sendMessage(channel, "  Displays The Current Time");
                sendMessage(channel, "!aboutbot");
                sendMessage(channel, "  Displays information About The Bot");
                sendMessage(channel, "!exit");
                sendMessage(channel, "  (Owners Only)Exits Channel And ClosesThe Bot");
                break;
            case "!exit":
                if(sender.equalsIgnoreCase(owner)){
                   sendMessage(channel, "Fine I'll Close");
                   this.partChannel(channel);
                   this.disconnect();
                   System.exit(0);
                }else{
                    sendMessage(channel, "I Dont think you are my owner sender = " + sender + " if(sender.equalsIgnoreCase(" + owner + ")) THIS DOSE NOT COMPUTE");
                }
                break;
            default:
                // Do Nothing
                break;
        }
    }
    @Override
    public void onJoin(String channel, String sender, String login, String hostname) {
        sendMessage(channel, "Welcome" + sender);
    }
    @Override
    public void onPart(String channel, String sender, String login, String hostname) {
        sendMessage(channel, "Goodbye" + sender);
    }
}
