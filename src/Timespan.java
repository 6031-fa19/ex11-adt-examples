import java.util.Date;

/**
 * Immutable datatype representing an interval starting from one date/time and
 * ending at a later date/time. The interval includes its endpoints.
 */
public class Timespan {

    private final Date start;
    private final Date end;

    // Rep invariant:
    //   !end.before(start)
    // Abstraction function:
    //   AF(start, end) = the time interval from start to end, including the endpoints 
    // Safety from rep exposure:
    //   All fields are private and immutable. (<=== oops, incorrect! Date is a mutable type,
    //                                          so this safety argument needs to talk about how
    //                                          the Date objects are either not exposed or
    //                                          are defensively copied)

    private void checkRep() {
        assert !end.before(start);
    }
    
    /**
     * Make a Timespan.
     * 
     * @param start starting date/time
     * @param end ending date/time, requires end >= start
     */
    public Timespan(Date start, Date end) {
        if (start.after(end)) {
            throw new IllegalArgumentException("requires start <= end");
        }
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
        checkRep();
    }

    /**
     * @return the starting point of the interval
     */
    public Date getStart() {
        return new Date(start.getTime());
    }

    /**
     * @return the ending point of the interval
     */
    public Date getEnd() {
        return new Date(end.getTime());
    }
    
    // TODO: toString()
    
    // TODO: this immutable type needs equals() and hashCode()

}
