/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgaconnect.backend;

import java.awt.Font;
import java.io.InputStream;

/**
 *
 * @author josephs12
 */
public class Fonts {
    
    Font body;
    Font mainHeading;
    Font subHeading;
    
    public Fonts() {
        try {
            InputStream mainHeadingFontStream = getClass().getResourceAsStream("sgaconnect/resources/fonts/opensans.ttf");
            mainHeading = Font.createFont(Font.TRUETYPE_FONT, mainHeadingFontStream);
            mainHeading = mainHeading.deriveFont(Font.BOLD,80);
            mainHeadingFontStream.close();
            
            InputStream subHeadingFontStream = getClass().getResourceAsStream("sgaconnect/resources/fonts/printclearly.ttf");
            subHeading = Font.createFont(Font.TRUETYPE_FONT,subHeadingFontStream);
            subHeading = subHeading.deriveFont(Font.PLAIN,28);
            subHeadingFontStream.close();
            
            InputStream bodyFontStream = getClass().getResourceAsStream("sgaconnect/resources/fonts/opensans.ttf");
            body = Font.createFont(Font.TRUETYPE_FONT,bodyFontStream);
            body = body.deriveFont(Font.PLAIN,12);
            bodyFontStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Font getHeadingFont() {
        return mainHeading;
    }
    
    public Font getSubHeadingFont() {
        return subHeading;
    }
    
    public Font getBodyFont() {
        return body;
    }
    
}
