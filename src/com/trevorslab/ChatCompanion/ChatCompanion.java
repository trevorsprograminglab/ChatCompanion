/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trevorslab.ChatCompanion;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jibble.pircbot.*;

/**
 *
 * @author Trevor
 * @version 0.0.2 BETA
 * !time 
 *  Displays The Current Time
 * !aboutbot <version|author>
 *  Displays information about the bot
 * !commands
 *  Displays a list of commands
 * !exit
 *  Closes the application
 */
public class ChatCompanion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Now start our bot up.
        Bot bot = new Bot();
        
        // Enable debugging output.
        bot.setVerbose(true);
        
    }
    
}
