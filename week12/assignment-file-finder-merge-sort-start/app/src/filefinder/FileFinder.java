package filefinder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileFinder {
	private final File rootDir;

	public FileFinder(String root) throws IOException {
		rootDir = new File(root);
		if (!(rootDir.exists() && rootDir.isDirectory())) {
			throw new IOException(root + " is not a directory");
		}
	}

	public void findFile(String file) {
		find(rootDir, file);
	}

	private void find(File rootDir, String fileName) {
		File[] files = rootDir.listFiles();

		if (files != null) {
			List<Thread> threads = new ArrayList<>();
			for (File file : files) {
				if (file.getName().equals(fileName)) {
					System.out.println("Found at: " + file.getAbsolutePath());
				} else if (file.isDirectory()) {
					Thread thread = new Thread(() -> find(file, fileName));
					thread.start();
					threads.add(thread);
				}
			}

			for (Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			}
		}
	}
}
