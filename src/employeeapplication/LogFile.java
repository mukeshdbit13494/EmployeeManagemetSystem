/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeeapplication;

import com.sun.istack.internal.logging.*;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author user
 */
public class LogFile {
    private static final Logger logger=Logger.getLogger("MyLog");
    public static Logger logger()
    {
        try {
            FileHandler fh=new FileHandler("C://EMSLog.xml",true);
            logger.addHandler(fh);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
        return logger;
    }
    
}
