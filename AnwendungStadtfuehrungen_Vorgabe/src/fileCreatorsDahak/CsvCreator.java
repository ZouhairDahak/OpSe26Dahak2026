package fileCreatorsDahak;
import java.io.IOException;
public class CsvCreator extends ReaderCreatorDahak{
	@Override
	public ReaderProductDahak factoryMethod() throws IOException{
		return new CsvProduct();
	}
}
