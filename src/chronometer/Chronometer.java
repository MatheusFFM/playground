package chronometer;

public class Chronometer {

    private long timeStart;
    private long timeEnd;
    private long time;

    public Chronometer(){
        time = 0;
    }

    /***
     * Initialize the chronometer by making timeStart equals to actual execution time in nanoseconds
     */
    public void start(){
        timeStart = System.nanoTime();
    }

    /***
     * Stop the chronometer by making timeEnd equals to actual execution time and subtract the chronometer's
     * timeStart, then, the result is returned and saved on time attribute
     *
      * @return the duration between start and end
     */
    public long stop(){
        timeEnd = System.nanoTime();
        time = getTimeEnd() - getTimeStart();
        timeStart = 0;
        return time;
    }

    /***
     * Return the duration from the start to this method's call but don't reset chronometer variables
     *
     * @return the duration between start and now
     */
    public long mark(){
        return System.nanoTime() - timeStart;
    }

    /***
     * Stop the chronometer by making timeEnd equals to actual execution time and subtract the chronometer's
     * timeStart, then, make timeStart equals to actual execution time and timeEnd equals 0 for restart the
     * chronometer's attributes.
     *
     * @return the duration between start and restart
     */
    public long restart(){
        timeEnd = System.nanoTime();
        time = getTimeEnd() - getTimeStart();
        timeStart = System.nanoTime();
        timeEnd = 0;
        return time;
    }

    public long getTimeStart() {
        return timeStart;
    }

    public long getTimeEnd() {
        return timeEnd;
    }

    public long getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Chronometer{" +
                " Started At =" + timeStart +
                ", Ended At =" + timeEnd +
                ", Duration =" + time +
                '}';
    }
}
