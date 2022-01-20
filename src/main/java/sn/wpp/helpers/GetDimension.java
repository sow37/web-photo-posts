package sn.wpp.helpers;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.ImageInputStream;

public class GetDimension {
	
	
	public static Map<String, Integer> getImageDimension(File imgFile) throws IOException {
		  Map<String, Integer> dimension = new HashMap<>();
		  int pos = imgFile.getName().lastIndexOf(".");
		  if (pos == -1)
		    throw new IOException("No extension for file: " + imgFile.getAbsolutePath());
		  String suffix = imgFile.getName().substring(pos + 1);
		  Iterator<ImageReader> iter = ImageIO.getImageReadersBySuffix(suffix);
		  while(iter.hasNext()) {
		    ImageReader reader = iter.next();
		    try {
		      ImageInputStream stream = new FileImageInputStream(imgFile);
		      reader.setInput(stream);
		      dimension.put("width", reader.getWidth(reader.getMinIndex()));
		      dimension.put("height", reader.getHeight(reader.getMinIndex()));
		      return dimension;
		    } catch (IOException e) {
		      System.out.print("Error reading: " + imgFile.getAbsolutePath());
		    } finally {
		      reader.dispose();
		    }
		  }

		  throw new IOException("Not a known image file: " + imgFile.getAbsolutePath());
		}

}
