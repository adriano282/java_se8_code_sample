import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Student {
	private Map<String, Integer> marksObtained = new HashMap<String, Integer>();
	private ReadWriteLock lock = new ReentrantReadWriteLock();

	public void setMarksInSubject(String subject, Integer marks) {
		lock.writeLock().lock();
		try {
			marksObtained.put(subject, marks);
		} finally {
			lock.writeLock().unlock();
		}
	}

	public double getAverageMarks() {
		lock.readLock().lock();
		double sum = 0.0;
		try {
			for (Integer mark : marksObtained.values()) {
				sum = sum + mark;
			}
			return sum/marksObtained.size();
		} finally {
			lock.readLock().unlock();
		}
	}

	public static void main(String...args) {
		final Student s = new Student();

		for (int i = 0; i < 3; i++) {
			new Thread() {
				public void run() {
					int x = 0;
					while (true) {
						int m = ThreadLocalRandom.current().nextInt(0, 100);
						s.setMarksInSubject("Sub " + x, m);
						x++;
					}
				}
			}.start();	
		}	
		

		for (int i = 0; i < 8; i++) {
			new Thread() {
				public void run() {
					while(true) {
						double av = s.getAverageMarks();
						System.out.println(av);
					}
				}
			}.start();
		}
	}
}