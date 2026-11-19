package fileCreatorsDahak;
import java.io.IOException;
public abstract class ReaderProductDahak {
	public abstract String[] leseAusDatei() throws IOException;
	public abstract void schliesseDatei() throws IOException;
}
