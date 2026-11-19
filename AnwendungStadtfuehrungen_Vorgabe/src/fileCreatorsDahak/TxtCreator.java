package fileCreatorsDahak;

import java.io.IOException;

public class TxtCreator extends ReaderCreatorDahak{
	@Override
	public ReaderProductDahak factoryMethod() throws IOException{
		return new TxtProduct();
	}
}
