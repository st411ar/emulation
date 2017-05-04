public class Main {
	public static void main(String[] args) {
		System.out.println("the program is started");
		long limitedSeconds = 60L * 60L;
		long millCounter = count(limitedSeconds, false);
		long nanoCounter = count(limitedSeconds, true);
		System.out.println("counter in millis: " + millCounter);
		System.out.println("counter in nanos: " + nanoCounter);
		double ratio = 1.0d * millCounter;
		ratio /= nanoCounter;
		System.out.println("ratio: " + ratio);
		System.out.println("the program is finished");
	}

	private static long count(long limitedSeconds, boolean isNano) {
		long counter = 0L;
		long timeLimit = limitedSeconds * 1000L;
		if (isNano) {
			timeLimit *= 1000000L;
		}
		long start = getTime(isNano);
		while (getTime(isNano) - start < timeLimit) {
			counter++;
		}
		return counter;
	}

	private static long getTime(boolean isNano) {
		return isNano ? System.nanoTime() : System.currentTimeMillis();
	}
}