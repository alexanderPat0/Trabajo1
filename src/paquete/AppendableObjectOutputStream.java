package paquete;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AppendableObjectOutputStream extends ObjectOutputStream {
	protected void writeStreamHeader() throws IOException {

	}

	public AppendableObjectOutputStream() throws IOException ,SecurityException{
		super();
	}

	public AppendableObjectOutputStream(OutputStream out) throws IOException {
		super(out);
	}
}
