package gbaEmu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;

public class Rom {
       byte[] content = new byte[0];
       public byte[] readRom(String filename) {
               try (InputStream inputStream = new FileInputStream(filename)) {
                       content = inputStream.readAllBytes();
               } catch (IOException e) {
                       throw new RuntimeException("Failed to read ROM file: " + filename, e);
               }
               return content;
        }
	public String getTitle() {
		String titleString;
		if (content.length == 0 ) {
			return "NULL";
		} else {
			byte[] title = Arrays.copyOfRange(content, 0x134, 0x143);
			titleString = new String(title, Charset.defaultCharset());
		}
		return titleString;
	}
}
