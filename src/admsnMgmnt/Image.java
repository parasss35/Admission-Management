package admsnMgmnt;

import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;

public class Image {

	public static void main(String[] args) throws IOException {
		int height=200,width=300;
		BufferedImage image=null;
		File f=null;
		try{
			f=new File("B:/Java Projects/AdmsnMgmnt/paras.jpg");
			image=new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
			image=ImageIO.read(f);
			System.out.println("reading complete");
		}
		catch(Exception e){System.out.println(e);}
		
		try{
			
			ImageIO.write(image, "jpg", f);
			System.out.println("Writing complete");
		}
		catch(Exception e){System.out.println(e);}
	}

}
